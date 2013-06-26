/**
 * Defines a certain type of <code>Event</code> that may appear in the system.
 * @author Zielony
 * @verion 1.0
 */
public abstract class EventType implements JSONSerializable {
	/**
	 * Returns: The type of event that occurred.
	 * @return the type of event that occurred.
	 */
	public abstract String getType();
}
