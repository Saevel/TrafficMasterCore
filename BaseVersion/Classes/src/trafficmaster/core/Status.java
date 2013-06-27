package trafficmaster.core;


/**
 * A class that indicates the status of a course at a given <code>Time</code>
 * 
 * @author Zielony
 * @version 1.0
 * @see JSONSerializable
 * @see JSONFactory
 */
public class Status implements JSONSerializable {
	/**
	 * The name assigned to the status.
	 */
	protected String name;
	/**
	 * Creates an empty object for serilization's sake.
	 */
	protected Status() {
		;
	}
	/**
	 * Creates a full object.
	 * @param name the name assigned to the status.
	 */
	protected Status(final String name) {
		this.name = name;
	}
	
	// KLUDGE : Replace with internationalization later on
	/**
	 * The vehicle is driving without problem
	 */
	public static final Status DRIVING = new Status("Driving");
	/**
	 * The vehicle has stopped.
	 */
	public static final Status AT_STOP = new Status("At a stop");
	/**
	 * The vehicle is awaiting departure at the terminus.
	 */
	public static final Status AT_TERMINUS = new Status("At a terminus");
	/**
	 * The vehicle is in a traffic jam.
	 */
	public static final Status JAMMED = new Status("Jammed");
	/**
	 * The vehicle underwent an accident.
	 */
	public static final Status ACCIDENT = new Status("Accident");
	/**
	 * The vehicle is delayed severely.
	 */
	public static final Status DELAYED = new Status("Delayed");
	/**
	 * The actual status of the vehicle is not known.
	 */
	public static final Status UNKNOWN = new Status("Unknown");
	
	/**
	 * Strigifies the object.
	 * @return Strigified Status.
	 */
	public String toString() {
		return name;
	}
	/**
	 * Gets: the name assigned to the status.
	 * @return the name assigned to the status.
	 */
	public String getName() {
		return name;
	}
}
