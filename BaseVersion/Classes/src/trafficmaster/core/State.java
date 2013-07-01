package trafficmaster.core;
/**
 * Represents the state of a particular <code>Course</code> may be at a given <code>Time</code>.
 * @author Zielony
 * @version 1.0
 * @see Time
 * @see Location
 * @see JSONSerializable
 * @see JSONFactory
 * @see Status
 */
public class State implements JSONSerializable, TrafficMasterBean {
	/**
	 * The unique object identifier within the class
	 */
	private int ID = NULL_ID;
	/**
	 * The acceleration of the vehicle.
	 */
	protected float acceleration;
	/**
	 * The velocity of the vehicle at measurement time.
	 */
	protected float currentVelocity;
	/**
	 * The average velocity of the vehicle over a certain period of time.
	 */
	protected float averageVelocity;
	/**
	 * Delay of the course.
	 */
	protected Time delay;
	/**
	 * Current location of the vehicle.
	 */
	protected Location location;
	/**
	 * The nearest-sittuated <code>Stop</code>.
	 */
	protected Stop nearestStop;
	/**
	 * Current <code>Status</code> of the vehicle.
	 */
	protected Status status;
	/**
	 * Gets: the vehicle's acceleration.
	 * @return the vehicle's acceleration.
	 */
	public float getAcceleration() {
		return acceleration;
	}
	/**
	 * Sets: the vehicle's acceleration.
	 * @param acceleration the vehicle's acceleration.
	 */
	public void setAcceleration(float acceleration) {
		this.acceleration = acceleration;
	}
	/**
	 * Gets: the current velocity.
	 * @return the current velocity.
	 */
	public float getCurrentVelocity() {
		return currentVelocity;
	}
	/**
	 * Sets: the current velocity.
	 * @param currentVelocity the current velocity.
	 */
	public void setCurrentVelocity(float currentVelocity) {
		this.currentVelocity = currentVelocity;
	}
	/**
	 * Gets: the average velocity.
	 * @return the average velocity.
	 */
	public float getAverageVelocity() {
		return averageVelocity;
	}
	/**
	 * Sets: the average velocity.
	 * @param averageVelocity the average velocity.
	 */
	public void setAverageVelocity(float averageVelocity) {
		this.averageVelocity = averageVelocity;
	}
	/**
	 * Gets: the current course delay.
	 * @return the current course delay.
	 */
	public Time getDelay() {
		return delay;
	}
	/**
	 * Sets: the current course delay.
	 * @param the current course delay.
	 */
	public void setDelay(Time delay) {
		this.delay = delay;
	}
	/**
	 * Gets: the course location.
	 * @return the course location.
	 */
	public Location getLocation() {
		return location;
	}
	/**
	 * Sets: the course location.
	 * @param location the course location.
	 */
	public void setLocation(Location location) {
		this.location  = location;
	}
	/**
	 * Gets: the nearest stop. 
	 * @return the nearest stop. 
	 */
	public Stop getNearestStop() {
		return nearestStop;
	}
	/**
	 * Sets: the nearest stop. 
	 * @param nearestStop the nearest stop. 
	 */
	public void setNearestStop(Stop nearestStop) {
		this.nearestStop = nearestStop;
	}
	/**
	 * Gets: the current course <code>Status</code>.
	 * @return the current course <code>Status</code>.
	 */
	public Status getStatus() {
		return status;
	}
	/**
	 * Sets: the current course <code>Status</code>.
	 * @param status the current course <code>Status</code>.
	 */
	public void setStatus(Status status) {
		this.status = status;
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