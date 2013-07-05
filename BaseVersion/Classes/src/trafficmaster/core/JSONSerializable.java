package trafficmaster.core;

import java.io.Serializable;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * An interface denoting the ability of the bean to be serialized to the JSON format.
 * To be implemented by all the classes exchanged between application packages.
 * @author Zielony
 * @version 1.0
 * @see JSONFactory
 */
public abstract class JSONSerializable implements Serializable {
	protected abstract void deserialize(JSONObject json) throws JSONException;
}
