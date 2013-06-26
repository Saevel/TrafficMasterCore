/**
 * Typesafe enumeration class representing the gravity of a certain <code>Event</code>.
 * @author Zielony
 * @version 1.0
 * @see Event
 */
public class EventGravity implements Comparable<EventGravity>, JSONSerializable {
	/**
	 * High gravity.
	 */
	public static final EventGravity HIGH = new EventGravity(100);
	/**
	 * Medium gravity.
	 */
	public static final EventGravity MEDIUM = new EventGravity(50);
	/**
	 * Low gravity.
	 */
	public static final EventGravity LOW = new EventGravity(0);
	/**
	 * 
	 */
	protected int gravity;
	/**
	 * Constructs an object representing a given gravity.
	 * @param gravity the gravity given.
	 */
	EventGravity(int gravity) {
		this.gravity = gravity;
	}
	 /**
	 * Gets: the event gravity.
	 * @return the event gravity.
	 */
	public int getGravity() {
		return gravity;
	}
	
	public String toString() {
		return Integer.toString(gravity);
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
}

