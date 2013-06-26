/**
 * Represents a stop of an arbitrary means of communication with its physical location.
 * 
 * @author Zielony
 * @version 1.0
 */
public class Stop extends Location implements JSONSerializable {
	/**
	 * The stop's name.
	 */
	private String stopName;
	/**
	 * 
	 */
	public Stop() {
		;
	}
	/**
	 * Gets: the stop's name
	 * @return the stop's name 
	 */
	public String getStopName() {
		return stopName;
	}
	/**
	 * Sets: the stop's name
	 * @param stopName the stop's name
	 */
	public void setStopName(String stopName) {
		this.stopName = stopName;
	}
}
