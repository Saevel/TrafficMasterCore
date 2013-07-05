package trafficmaster.core;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Typesafe enumeration class representing the gravity of a certain <code>Event</code>.
 * @author Zielony
 * @version 1.0
 * @see Event
 * @see Comparable
 * @see JSONSerializable
 * @see JSONFactory
 */
public class EventGravity extends TrafficMasterBean implements Comparable<EventGravity> {
	/**
	 * High gravity.
	 */
	public static final EventGravity HIGH = new EventGravity(100, "High");
	/**
	 * Medium gravity.
	 */
	public static final EventGravity MEDIUM = new EventGravity(50, "Medium");
	/**
	 * Low gravity.
	 */
	public static final EventGravity LOW = new EventGravity(0, "Low");
	/**
	 * The gravity of the <code>Event</code> expressed as an <code>int</code>.
	 */
	protected int gravity;
	
	/***
	 * The name attributed to a certain type of gravity.
	 */
	protected String name;
	/**
	 * Creates an empty object for serialization's sake.
	 */
	protected EventGravity(){
		;
	}
	
	/**
	 * Builds a certain <code>EventGravity</code> object, assigning the gravity marker and a name.
	 * @param gravity The gravity of the <code>Event</code> expressed as an <code>int</code>.
	 * @param name The name attributed to a certain type of gravity.
	 */
	protected EventGravity(int gravity, String name) {
		this.gravity = gravity;
		this.name = name;
	}
	 /**
	 * Gets: the event gravity.
	 * @return the event gravity.
	 */
	public int getGravity() {
		return gravity;
	}
	/**
	 * Gets: the event gravity name.
	 * @return the event gravity name.
	 */
	public String getName() {
		return name;
	}
	
	@Override
	public int compareTo(EventGravity eventGravity) {
		return (this.gravity - eventGravity.gravity);
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof EventGravity) {
			EventGravity eventGravity = (EventGravity)o;
			if(this.gravity == eventGravity.gravity) {
				return true; /*Comparison by gravity*/
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}		
	}

	@Override
	protected void deserialize(JSONObject json) throws JSONException {
		super.deserialize(json);
		this.gravity = json.getInt("gravity");
		this.name = json.getString("name");
	}
}