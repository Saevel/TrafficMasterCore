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
public interface ISerializableFactory {
	
	/**
	 * Serialized the <code>input</code> into a <code>String</code>.
	 * @param input the data to be serialized
	 * @return the seriaized data.
	 * @throws NotSerializableException if serialization errors occurred.
	 * @throws JSONException 
	 */
	String serialize(Object input) throws NotSerializableException, JSONException;
	/**
	 * 
	 * @param input
	 * @param objectClass
	 * @return
	 * @throws NotSerializableException
	 * @throws JSONException 
	 */
	Object deserialize(String input) throws NotSerializableException, JSONException;
}