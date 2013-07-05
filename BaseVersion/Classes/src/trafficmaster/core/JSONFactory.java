package trafficmaster.core;
import java.io.NotSerializableException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

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
	public String serialize(final JSONSerializable bean, Class  beanClass) throws NotSerializableException, JSONException {
		
		if(beanClass == Object.class) {
			return (new JSONObject()).toString();
		}
		
		Field[] fields = beanClass.getDeclaredFields();
		JSONObject json = new JSONObject();
		Method getter;
		Object value = null;
		Class superclass = beanClass.getSuperclass();
		 
		JSONObject superJSON = new JSONObject(serialize(bean, superclass));
		json = merge(json, superJSON);
		
		for(int i=0;i<fields.length;i++) {
			
			if(Modifier.isStatic(fields[i].getModifiers())) {
				continue;
			}
			
			try {
				getter = beanClass.getDeclaredMethod(getGetterName(fields[i]));
			}
			catch(Exception e) {
				throw new NotSerializableException("JSONFactory|serialize|cannot get the getter method" + " CLASS: " + beanClass + " FIELD: " + fields[i].getName());
			}
			try {
				value = getter.invoke(bean);
			}
			catch (Exception e) {
				throw new NotSerializableException("JSONFactory|serialize|cannotv invoke the getter");
			}
			
			
			if(fields[i].getType().isPrimitive() || value instanceof String) {
				json.put(fields[i].getName(),value);
			}
			else if(value instanceof JSONSerializable) {
				JSONObject newJSON  = new JSONObject(serialize((JSONSerializable)value, fields[i].getType()));
				json.put(fields[i].getName(), newJSON);
			}
			else {
				json.put(fields[i].getName(), (JSONObject)JSONObject.wrap(value));
			}
		}
		
		return json.toString();
	}
	
	@Override
	public JSONSerializable deserialize(String input, Class<? extends JSONSerializable> objectClass) throws NotSerializableException, JSONException {

		Method deserializer = null;
		JSONObject json;
		JSONSerializable newInstance;
		
		json = new JSONObject(input);
		
		try {
			
			deserializer = objectClass.getDeclaredMethod("deserialize", JSONObject.class);
			deserializer.setAccessible(true);
		} catch (NoSuchMethodException | SecurityException e) {
			throw new NotSerializableException("Cannot access the deserializing method from the class");
		}
		
		try {
			newInstance = (JSONSerializable)objectClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new NotSerializableException("Cannot create a new instance of the class. Default constructor missing?");
		}
		
		try {
			deserializer.invoke(newInstance, json);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			System.out.println(e.getCause());
			throw new NotSerializableException("Cannot invoke the deserializer method");
		}
		
		return newInstance;	
	}
	
	/*private JSONObject deserialize(Object object, Class objectClass) {
		Field[] fields = objectClass.getDeclaredFields();
	}*/
	
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
	 * @param string the field in question.
	 * @return the getter name.
	 */
	private static String getGetterName(Field field) {
		String fieldName = field.getName();
		String getterName = Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
		getterName = "get" + getterName;
		return getterName;
	}
	/*
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
	}*/
	
	private JSONObject serializeSuperclass(Object castObject, Class superclass) throws JSONException {
		/*Checking the superclass of the superclass recursively*/
		Class superSuperClass = superclass.getSuperclass();
		// FIXME
		//System.out.println(superSuperClass.getName());
		JSONObject json = new JSONObject();
		/*If there is a superclass, storing the result of its serialization*/
		if(superSuperClass != null) {
			System.out.println("PRZED");
			json = serializeSuperclass(castObject,superSuperClass);
			/*Casting the serialized object to the superclass*/
			Object superClassObject  = superclass.cast(castObject);
			/*Merging the wraps of : the object as current supper class and the results from higher above
			 * in the class hierarchy - recursively*/
			json = merge(json, ( (JSONObject)JSONObject.wrap(superClassObject) ) );
			System.out.println(json.toString());
		}/*Returning the JSON merged up to current class level*/
		return json;
	}
	
	private JSONObject merge(JSONObject first, JSONObject second) throws JSONException {
		JSONObject result = new JSONObject();
		String[] firstNames = JSONObject.getNames(first);
		String[] secondNames = JSONObject.getNames(second);
		if(firstNames!=null) {
			for(int i=0;i<firstNames.length;i++) {
				result.put(firstNames[i], first.get(firstNames[i]));
			}
		}
		if(secondNames!=null) {
			for(int i=0;i<secondNames.length;i++) {
				result.put(secondNames[i], second.get(secondNames[i]));
			}
		}
		
		return result;
	}

	@Override
	public JSONSerializable deserialize(Location location,
			Class<? extends JSONSerializable> objectClass)
			throws NotSerializableException {
		// TODO Auto-generated method stub
		return null;
	}
	
}