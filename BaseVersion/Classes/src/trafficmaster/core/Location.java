package trafficmaster.core;
/**
 * A bean class whose elements represent the physical location on the map correspoding to an entity
 * from real life.
 *
 * @author Zielony
 * @version 1.0
 * @see JSONSerializable
 * @see JSONFactory
 */
public class Location implements JSONSerializable, TrafficMasterBean {
	/**
	 * The unique object identifier within the class
	 */
	private int ID = NULL_ID;
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
	/**
	 * Earth's radius expressed in meters.
	 */
	private static final float EARTH_RADIUS = 6371000;
	
	/**
	 * Calculates the distance between the current location and another one specified(in meters).
	 * @param otherLocation another location, to which the distance is calculated.
	 * @return the distance between the two locations(in meters).
	 */
	public float getDistanceTo(Location otherLocation) {
		/*Separating and simply calculating the factors in the equation*/
		double firstFactor = Math.sin((latitude-otherLocation.latitude)/2);
		firstFactor *= firstFactor;
		
		double secondFactor = Math.cos(latitude)*Math.cos(otherLocation.latitude);
		
		double thirdFactor = Math.sin((longitude-otherLocation.longitude)/2);
		thirdFactor *= thirdFactor;
		/*Obtaining the final result*/
		return (float)(2*EARTH_RADIUS*Math.asin(Math.sqrt(firstFactor)+secondFactor*thirdFactor));
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
	@Override
	public int getID() {
		return ID;
	}
	@Override
	public void setID(int ID) {
		this.ID = ID;
		
	}
}