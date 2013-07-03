package trafficmaster.core;
import java.io.NotSerializableException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/**
 * A factory/util class for generic bean-to-JSON serialization.
 * @author Zielony
 * @version 1.0
 * @see JSONObject
 * @see Class
 * @see Field
 * @see Method
 * @see JSONSerializable
 * @see IserializableFactory
 */
public class JSONFactory implements ISerializableFactory<JSONSerializable> {
	
	private JSONFactory(boolean mock) {
		;
	}
	
	private static final JSONFactory INSTANCE = new JSONFactory(true);
	
	public static JSONFactory getInstance() {
		return INSTANCE;
	}
	
	@Override
	public String serialize(final JSONSerializable bean) throws NotSerializableException {
		Class beanClass = bean.getClass();/*Getting the bean class*/
		Field[] fields = beanClass.getDeclaredFields(); /*Getting the bean fields*/
		JSONObject json = new JSONObject(); /*Creating a JSONObject*/
		/*WARNING: HERE THE CLASS IS PASSED BY ITS LONGER NAME AS IT ENABLES CONFLICT EVASION IN MANY CASES*/
		try {
			json.put(ISerializableFactory.classFieldName,beanClass.getName());
		} catch (JSONException e2) {
			throw new NotSerializableException("JSONFactory|serialize|cannot create a JSONObject on the basis of the given String");
		}
		
		for(int i=fields.length-1;i>=0;i--) {
			/*Checking getter for every field*/
			String getterName = JSONFactory.getGetterName(fields[i]);
			Method getter = null; 
			
			/*Trying to get a Method object referencing the getter for each field*/
			try {
					getter = beanClass.getMethod(getterName);
				} catch (NoSuchMethodException | SecurityException e1) {
					throw new NotSerializableException("JSONFactory|serialize|" + beanClass + "|cannot get the getter method");
				}
			
			/*Trying to put the value in the JSON using the getter invocation*/
			try {
				
				Object value = getter.invoke(bean);
				if(value == null) { /*Fixing JSONs unreasonable reaction to nulls*/
					value = "null";
				}
				
				json.put(fields[i].getName(),serialize(value); /*Iterative field serialization to JSON*/
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | JSONException e) {
				throw new NotSerializableException("JSONFactory|serialize|"+beanClass + "|cannot invoke getter");
			}
		}
		return json.toString();
	}
	
	@Override
	public JSONSerializable deserialize(String transferred) throws NotSerializableException {
		/*The class of the received ovject*/
		Class beanClass;
		/*The fields of the received object*/
		Field[] fields;
		JSONObject jsonObject ;
		Object beanStub = null;
		try {
			/*Transforming to the JSON format*/
			jsonObject = new JSONObject(transferred);
			/*Reading the object class from the JSON*/
			beanClass = Class.forName(jsonObject.getString(ISerializableFactory.classFieldName));
			fields = beanClass.getDeclaredFields(); /*loading the field object for the class*/
		} catch(Exception e) {
			throw new NotSerializableException("JSONFactory|deserialize|cannot get class name from the JSON");
		}

		try {
			beanStub = beanClass.newInstance(); /*Creating an empty bean*/
		} catch (InstantiationException | IllegalAccessException e) {
			 throw new NotSerializableException("JSONFactory|deserialize|cannot create" +
					" an object of the fiven class using default constructor!");
		}
		
		/*Iterating over Field objects*/
		for(int i=fields.length-1; i>=0; i--) {
			
			String setterName = JSONFactory.getSetterName(fields[i]); /*Checking the field setter name*/
			Method setter = null;
			
			try {/*Getting the setter Method object*/
				setter = beanClass.getMethod(setterName, fields[i].getType());
			} catch (NoSuchMethodException | SecurityException e) {
				throw new NotSerializableException("JSONFactory|deserialize|" + beanClass +
						"|cannot get the setter method object!");
			}
			Object deserializedObject = null;
			try {/*Invoking the setter- setting the field to the JSON-given value*/
				deserializedObject = jsonObject.get(fields[i].getName());
				
				/*Fixing JSONs abnormal behavior in face of nulls*/
				if(deserializedObject instanceof String && deserializedObject.equals("null")) {
					deserializedObject = null;
				}
				else if(deserializedObject instanceof JSONArray) { /*For collections denoted as JSONArrays, a special treatment*/
					deserializedObject = deserializeMultiple(deserializedObject.toString());
				}
				/*Finally , iterative deserialization using setter invocation*/
				setter.invoke(beanStub, deserializedObject);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | JSONException e) {
				System.out.println("BEAN_STUB CLASS: "+ beanStub.getClass().getSimpleName());
				System.out.println("DESERIALIZED OBJECT CLASS: " + deserializedObject.getClass().toString());
				System.out.println("FIELD CLASS: " + fields[i].getType().getSimpleName());
				throw new NotSerializableException("JSONFactory|deserialize|" + beanClass +
							"|cannot invoke the setter!");
			}
		}
		return (JSONSerializable)beanStub;
	}
	/**
	 * Checks the name of a setter for a given field.
	 * @param field the field in question.
	 * @return the setter name.
	 */
	private static String getSetterName(Field field) {
		String fieldName = field.getName();
		String setterName = Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
		setterName = "set" + setterName;
		return setterName;
	}
	/**
	 * Checks the name of a getter for a given field.
	 * @param field the field in question.
	 * @return the getter name.
	 */
	private static String getGetterName(Field field) {
		String fieldName = field.getName();
		String getterName = Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
		getterName = "get" + getterName;
		return getterName;
	}

	@Override
	public String serializeMultiple(Collection<JSONSerializable> inputs)
			throws NotSerializableException {
		Iterator<JSONSerializable> iterator = inputs.iterator();
		JSONArray array = new JSONArray();
		
		while(iterator.hasNext()) {
			array.put(serialize(iterator.next()));
		}
		return array.toString();
	}


	@Override
	public Collection<JSONSerializable> deserializeMultiple(String transferred)
			throws NotSerializableException {
		JSONArray array;
		try {
			array = new JSONArray(transferred);
		} catch (JSONException e) {
			throw new NotSerializableException("JSONFactory|deserializeMultilpe|a JSONArray couldn;t be properly created");
		}
		Collection<JSONSerializable> serializables = new LinkedList<JSONSerializable>();
		for(int i=0;i<array.length();i++) {
			try {
				serializables.add(deserialize(array.get(i).toString()));
			} catch (JSONException e) {
				System.out.println(e.getMessage());
				throw new NotSerializableException("JSONFactory|deserializeMultiple|could not get value from the JSONArray");
			}
		}
		return serializables;
	}
}