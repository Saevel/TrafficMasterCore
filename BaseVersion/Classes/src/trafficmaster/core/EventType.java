package trafficmaster.core;
/**
 * Defines a certain type of <code>Event</code> that may appear in the system.
 * @author Zielony
 * @verion 1.0
 * @see Event
 * @see JSONSerializable
 * @see JSONFactory
 */
public class EventType implements JSONSerializable, TrafficMasterBean {
	/**
	 * The unique object identifier within the class
	 */
	private int ID = NULL_ID;
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
	@Override
	public int getID() {
		return ID;
	}
	@Override
	public void setID(int ID) {
		this.ID = ID;
	}
}
