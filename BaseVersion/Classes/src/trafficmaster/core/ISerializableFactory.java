package trafficmaster.core;

import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Collection;

import javax.naming.OperationNotSupportedException;

import org.json.JSONException;
/**
 * Defines a generic type of a factory class for automatic RTTI serialization/deserialization 
 * of predesignated objects. Its future implementation may produce simple yet efficient serializers/
 * deserializers. Its implementations may use various serialization standards , such as JSON, XML-RPC
 * or SOAP. This class does not force, but strongly encourages its descendants to take form of a singleton
 * in order to facilitate their uses and enforce utility nature. 
 * @author Zielony
 * @version 1.0 
 * @param <InputType> the specific interface declaring objects serializable using this factory, inherently
 * bound to each implementation. NOTE: it is derived from <code>Serializable</code> so that the factory may
 * also be imeplemented to work with native Java serialization / deserialization.
 */
public interface ISerializableFactory<InputType extends Serializable> {
	/**
	 * A fixed name that is bound to class definition for RTTI invocation on deserialization. 
	 */
	static final String classFieldName = "class";
	/**
	 * Serialized the <code>input</code> into a <code>String</code>.
	 * @param input the data to be serialized
	 * @return the seriaized data.
	 * @throws NotSerializableException if serialization errors occurred.
	 * @throws JSONException 
	 */
	String serialize(InputType input, Class beanClass) throws NotSerializableException, JSONException;
	/**
	 * 
	 * @param input
	 * @param objectClass
	 * @return
	 * @throws NotSerializableException
	 * @throws JSONException 
	 */
	InputType deserialize(String input, Class<? extends InputType> objectClass) throws NotSerializableException, JSONException;
	JSONSerializable deserialize(Location location,
			Class<? extends JSONSerializable> objectClass)
			throws NotSerializableException;
	
}