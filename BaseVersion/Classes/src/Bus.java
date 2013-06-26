/**
 * The bus as a means of transport.
 * @author Zielony
 * @version 1.0
 */
public class Bus implements MeansOfTransport {
	@Override
	public String getName() {
		// KLUDGE: use internationalization later on
		return "Bus";
	}
}
