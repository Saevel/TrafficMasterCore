import org.json.JSONException;
import org.json.JSONObject;

/**
 * Defines a parent type for all the means of transport present in the traffic system.
 * @author Zielony
 * @version 1.0
 */
public class MeansOfTransport implements JSONSerializable {
	
	protected final String name;
	
	protected static final MeansOfTransport BUS = new MeansOfTransport("Bus");
	protected static final MeansOfTransport TRAM = new MeansOfTransport("Tram");
	protected static final MeansOfTransport ON_FOOT = new MeansOfTransport("On Foot");
	protected static final MeansOfTransport SUBWAY = new MeansOfTransport("Subway");
	
	public MeansOfTransport() {
		name = null;
	}
	
	public MeansOfTransport(final String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return name;
	}
}
