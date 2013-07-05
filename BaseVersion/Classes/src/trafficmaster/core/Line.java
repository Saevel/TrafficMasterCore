package trafficmaster.core;
import java.io.NotSerializableException;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Represents a line in the traffic system.
 * @author Zielony
 * @version 1.0
 * @see MeansOfTransport
 * @see Location
 * @see JSONSerializable
 * @see JSONFactory
 */
public class Line extends TrafficMasterBean {
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
	
	@Override
	protected void deserialize(JSONObject json) throws JSONException {
		// FIXME ID deserialization must be done here
		
		//super.deserialize(json);
		this.direction = json.getBoolean("direction");
		// KLUDGE reference to a concrete type
		this.locationsPassed = new LinkedList<Location>();
		JSONArray locationsArray = json.getJSONArray("locationsPassed");
		if(locationsPassed != null) {
			for(int i=0;i<locationsArray.length();i++) {
				try {
					Location location = (Location)JSONFactory.getInstance().deserialize(locationsArray.getJSONObject(i).toString(), Location.class);
					locationsPassed.add(location);
				} catch (NotSerializableException e) {
					throw new JSONException("Line|deserialize|could not deserialize a member location");
				}
			}	
		}
		try {
			this.meansOfTransport = (MeansOfTransport)JSONFactory.getInstance().deserialize(json.getJSONObject("meansOfTransport").toString(), MeansOfTransport.class);
		} catch (NotSerializableException e) {
			throw new JSONException("Line|deserialize|could not deserialize the means of transport");
		}
		this.name = json.getString("name");
		
	}
}