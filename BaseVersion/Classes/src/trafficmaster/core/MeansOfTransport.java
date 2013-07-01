package trafficmaster.core;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Defines a parent type for all the means of transport present in the traffic system.
 * @author Zielony
 * @version 1.0
 * @see JSONSerializable
 * @see JSONFactory
 */
public class MeansOfTransport implements JSONSerializable, TrafficMasterBean {
	/**
	 * The unique object identifier within the class
	 */
	private int ID = NULL_ID;
	/**
	 * The name of this means of transport.
	 */
	protected String name = null;
	/**
	 * The Bus.
	 */
	protected static final MeansOfTransport BUS = new MeansOfTransport("Bus");
	/**
	 * The tram.
	 */
	protected static final MeansOfTransport TRAM = new MeansOfTransport("Tram");
	/**
	 * Walking on foot
	 */
	protected static final MeansOfTransport ON_FOOT = new MeansOfTransport("On Foot");
	/**
	 * The Subway
	 */
	protected static final MeansOfTransport SUBWAY = new MeansOfTransport("Subway");
	/**
	 * Creates an empty object for serializations sake.
	 */
	public MeansOfTransport() {
		;
	}
	/**
	 * Creates a <code>MeansOfTransport</code> with a specially chosen name
	 * @param name
	 */
	public MeansOfTransport(final String name) {
		this.name = name;
	}
	/**
	 * Gets: the MoT name.
	 * @return the MoT name.
	 */
	public String getName() {
		return name;
	}
	/**
	 * Stringifies the MoT
	 * @return stringified MoT
	 */
	public String toString() {
		return name;
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