import java.io.NotSerializableException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.json.JSONException;
import org.json.JSONObject;
/**
 * A factory/util class for generic bean-to-JSON serialization.
 * @author Zielony
 * @version 1.0
 */
public class JSONFactory {
	
	// FIXME : Implement using the real JSONObject from org.json 
	// FIXME : Write special methods for handling Collections (to arrays and forth) and Objects
	// (iterative JSON serialization)
	
	/**
	 * Serializes the bean into the <code>JSONObject</code> form.
	 * @param bean the bean object to serialized
	 * @return the <code>JSONObject</code> for of the bean object
	 * @throws NotSerializableException 
	 */
	public static JSONObject serialize(final JSONSerializable bean) throws NotSerializableException {
	
		Class beanClass = bean.getClass();/*Getting the bean class*/
		Field[] fields = beanClass.getDeclaredFields(); /*Getting the bean fields*/
		
		JSONObject json = new JSONObject(); /*Creating a JSONObject*/
		/*Iterating over all the fields*/
		
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
				json.put(fields[i].getName(), getter.invoke(bean));
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | JSONException e) {
				throw new NotSerializableException("JSONFactory|serialize|"+beanClass + "|cannot invoke getter");
			}
		}
		return json;
	}
	/**
	 * Deserializes the bean object from the <code>JSONObject</code>
	 * @param jsonObject
	 * @return
	 * @throws NotSerializableException 
	 */
	public static Object deserialize(JSONObject jsonObject, Class beanClass) throws NotSerializableException {
		
		Field[] fields = beanClass.getDeclaredFields(); /*loading the field object for the class*/
		Object beanStub = null;
		
		try {
			beanStub = beanClass.newInstance(); /*Creating an empty bean*/
		} catch (InstantiationException | IllegalAccessException e) {
			 throw new NotSerializableException("JSONFactory|deserialize|" + beanClass + "|cannot create" +
					" an object of the fiven class using default constructor!");
		}
		
		/*Iterating over Field objects*/
		for(int i=fields.length-1; i>=0; i--) {
			System.out.println(fields[i].getName());
			String setterName = JSONFactory.getSetterName(fields[i]); /*Checking the field setter name*/
			Method setter = null;
			
			try {/*Getting the setter Method object*/
				setter = beanClass.getMethod(setterName, fields[i].getType());
			} catch (NoSuchMethodException | SecurityException e) {
				throw new NotSerializableException("JSONFactory|deserialize|" + beanClass +
						"|cannot get the setter method object!");
			}
			
			try {/*Invoking the setter- setting the field to the JSON-given value*/
				setter.invoke(beanStub, jsonObject.get(fields[i].getName()));
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | JSONException e) {
				System.out.println(e.getMessage());
				throw new NotSerializableException("JSONFactory|deserialize|" + beanClass +
							"|cannot invoke the setter!");
					
			}
		}
		
		return beanStub;
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
}