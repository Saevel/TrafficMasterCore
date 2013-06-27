package trafficmaster.core;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents a line in the traffic system.
 * @author Zielony
 * @version 1.0
 * @see MeansOfTransport
 * @see Location
 * @see JSONSerializable
 * @see JSONFactory
 */
public class Line implements JSONSerializable {
	/**
	 * A name of the line.
	 */
	private String name;
	/**
	 * The direction of the line.
	 */
	private boolean direction;
	/**
	 * The means of transport used by the line.
	 */
	private MeansOfTransport meansOfTransport;
	/**
	 * The list of locations on the line. Optional.
	 */
	private List<Location> locationsPassed;
	/**
	 * No-argument constructor for serialization/deserialization
	 */
	Line() {
		setLocationsPassed(new LinkedList<Location>());
	}
	/**
	 * Parametrized constructor for dependency injection
	 * @param locationsPassed the locationss passed by the line.
	 */
	Line(List<Location> locationsPassed ) {
		this.setLocationsPassed(locationsPassed);
	}
	/**
	 * Gets: the line name.
	 * @return the line name.
	 */
	public String getName() {
		return name;
	}
	/**
	 * Sets: the line name.
	 * @param name the line name.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Gets: the line's means of transport.
	 * @return the line's means of transport.
	 */
	public MeansOfTransport getMeansOfTransport() {
		return meansOfTransport;
	}
	/**
	 * Sets: the line's means of transport.
	 * @param meansOfTransport the line's means of transport.
	 */
	public void setMeansOfTransport(MeansOfTransport meansOfTransport) {
		this.meansOfTransport = meansOfTransport;
	}
	/**
	 * Gets: the line's direction.
	 * @return the line's direction.
	 */
	public boolean getDirection() {
		return direction;
	}
	/**
	 * Sets: the line's direction.
	 * @param direction the line's direction.
	 */
	public void setDirection(boolean direction) {
		this.direction = direction;
	}
	/**
	 * Gets: all the locationss passed by the line.
	 * @return all the locationss passed by the line.
	 */
	public List<Location> getLocationsPassed() {
		return locationsPassed;
	}
	/**
	 * Sets: all the locationss passed by the line.
	 * @param locationsPassed all the locationss passed by the line.
	 */
	public void setLocationsPassed(List<Location> locationssPassed) {
		this.locationsPassed = locationsPassed;
	}
	/**
	 * Gives the information if the <code>locationsPassed</code> are defined or contain anything.
	 * @return <code>true</code> if any information is present, <code>false</code> if not.
	 */
	public boolean hasLocationsPassed() {
		if(locationsPassed == null) {
			return false;
		}
		else {
			return locationsPassed.isEmpty();
		}
	}
	/**
	 * Removes all information about the passed <code>Locations</code>
	 */
	public void removeLocationsPassed() {
		if(locationsPassed != null) {
			locationsPassed.clear();
		}
	}
}