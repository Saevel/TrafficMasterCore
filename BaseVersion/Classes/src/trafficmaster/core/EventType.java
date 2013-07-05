package trafficmaster.core;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Defines a certain type of <code>Event</code> that may appear in the system.
 * @author Zielony
 * @verion 1.0
 * @see Event
 * @see JSONSerializable
 * @see JSONFactory
 */
public class EventType extends TrafficMasterBean {
	/**
	 * The name of the type of an <code>Event</code>
	 */
	protected String type;
	/**
	 * Roadworks event.
	 */
	protected static final EventType ROADWORKS = new EventType("Roadworks");
	/**
	 * Alteration event.
	 */
	protected static final EventType ALTERATION = new EventType("Alteration");
	/**
	 * Public event.
	 */
	protected static final EventType PUBLIC_EVENT = new EventType("Public Event");
	/**
	 * Other or undefined event.
	 */
	protected static final EventType OTHER = new EventType("Other");
	/**
	 * Builds the <code>EventType</code> object representing a given <code>type</code>.
	 * @param type the type of the event.
	 */
	protected EventType(String type) {
		this.type = type;
	}
	/**
	 * Creates an empty object for serilization's sake.
	 */
	protected EventType() {
		;
	}
	
	/**
	 * Returns: The type of event that occurred.
	 * @return the type of event that occurred.
	 */
	public String getType() {
		return type;
	}
	/**
	 * Serializes the event type definition to a string.
	 */
	public String toString() {
		return type;
	}
	
	protected void deserialize(JSONObject json) throws JSONException{
		super.deserialize(json);
	}
}
