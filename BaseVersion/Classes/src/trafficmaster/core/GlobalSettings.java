package trafficmaster.core;
/**
 * A utility class representing the settings common across the whole application.
 * @author Zielony
 * @version 1.0
 */
public class GlobalSettings {
	/**
	 * Private default constructor - making the class strictly non-instantiable
	 */
	private GlobalSettings() {
		;
	}
	/**
	 * The distance below which the locations are considered to be equal by the application.
	 * Expressed in meters.
	 */
	public static final float LOCATION_EQUALITY_THRESHOLD_METERS = 10;
	/**
	 * Average walking speed across the human population.
	 */
	public static final float AVERAGE_HUMAN_VELOCITY_METERS_PER_MINUTE = (float)(1.2527 * 60.0);

	
    
	
}
