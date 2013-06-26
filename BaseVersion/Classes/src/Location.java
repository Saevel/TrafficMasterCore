/**
 * A bean class whose elements represent the physical location on the map correspoding to an entity
 * from real life.
 *
 * @author Zielony
 * @version 1.0
 */
public class Location implements JSONSerializable {
	/**
	 * The latitude of the location.
	 */
	protected double latitude;
	/**
	 * The longitude of the location.
	 */
	protected double longitude;
	/**
	 * The name of the location.
	 */
	protected String name;
	
	
	//TODO : implement the Heaversine Formula
	
	/**
	 * Calculates the distance between the current location and another one specified.
	 * @param otherLocation another location, to which the distance is calculated.
	 * @return the distance between the two locations.
	 */
	public float getDistanceTo(Location otherLocation) {
		return 0;
	}
	/**
	 * Gets: the location's latitude.
	 * @return the location's latitude.
	 */
	public double getLatitude() {
		return latitude;
	}
	/**
	 * Sets: the location's latitude.
	 * @param latitude the location's latitude.
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	/**
	 * Gets: the location's longitude.
	 * @return the location's longitude.
	 */
	public double getLongitude() {
		return longitude;
	}
	/**
	 * Sets: the location's longitude.
	 * @param longitude the location's longitude.
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	/**
	 * Gets: the location's name.
	 * @return the location's name. 
	 */
	public String getName() {
		return name;
	}
	/**
	 * Sets: the location's name.
	 * @param name the location's name.
	 */
	public void setName(String name) {
		this.name = name;
	}
}