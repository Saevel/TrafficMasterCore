/**
 * Defines a certain type of <code>Event</code> that may appear in the system.
 * @author Zielony
 * @verion 1.0
 */
public class EventType implements JSONSerializable {
	
	protected String type;
	
	protected static final EventType ROADWORKS = new EventType("Roadworks");
	
	protected static final EventType ALTERATION = new EventType("Alteration");
	
	protected static final EventType PUBLIC_EVENT = new EventType("Public Event");
	
	private EventType() {
		;
	}
	
	private EventType(String type) {
		this.type = type;
	}
	
	/**
	 * Returns: The type of event that occurred.
	 * @return the type of event that occurred.
	 */
	public String getType() {
		return type;
	}
	
	public String toString() {
		return type;
	}
}
