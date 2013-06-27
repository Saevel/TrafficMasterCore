import org.json.JSONException;
import org.json.JSONObject;

/**
 * Defines a parent type for all the means of transport present in the traffic system.
 * @author Zielony
 * @version 1.0
 */
public class MeansOfTransport implements JSONSerializable {
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
}