import java.util.LinkedList;
import java.util.List;

/**
 * Represents a line in the traffic system.
 * @author Zielony
 * @version 1.0
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
	 * The stops passed by the line. Optional.
	 */
	private List<Stop> stopsPassed;
	/**
	 * No-argument constructor for serialization/deserialization
	 */
	Line() {
		setStopsPassed(new LinkedList<Stop>());
	}
	/**
	 * Parametrized constructor for dependency injection
	 * @param stopsPassed the stops passed by the line.
	 */
	Line(List<Stop> stopsPassed ) {
		this.setStopsPassed(stopsPassed);
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
	 * Gets: all the stops passed by the line.
	 * @return all the stops passed by the line.
	 */
	public List<Stop> getStopsPassed() {
		return stopsPassed;
	}
	/**
	 * Sets: all the stops passed by the line.
	 * @param stopsPassed all the stops passed by the line.
	 */
	public void setStopsPassed(List<Stop> stopsPassed) {
		this.stopsPassed = stopsPassed;
	}
}