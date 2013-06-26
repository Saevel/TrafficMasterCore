import java.util.Collection;
/**
 * An event that may occur in city traffic.
 * 
 * @author Zielony
 * @version 1.0
 */
public class Event implements JSONSerializable {
	/**
	 * The name of the event.
	 */
	private String name = null;
	/**
	 * A short description of the event.
	 */
	private String shortDescription = null;
	/**
	 * A long description of the event.
	 */
	private String longDescription = null;
	/**
	 * The type of the event.
	 */
	private EventType type = null;
	/**
	 * The gravity of the event.
	 */
	private EventGravity gravity = null;
	/**
	 * The locations affected by the event.
	 */
	private Collection<Location> affected = null;
	/**
	 * Adds another location to the list of the affected.
	 * @param affectedLocation the new affected location.
	 */
	public void addAffected(Location affectedLocation) {
		affected.add(affectedLocation);
	}
	/**
	 * Removes an affected location from the list if possible.
	 * @param affectedLocation the location to be removed from the affected list.
	 * @return <code>true</code> if the location was on the list or <code>false</code> otherwise.
	 */
	public boolean removeAffected(Location affectedLocation) {
		return affected.remove(affectedLocation);
	}
	/**
	 * Checks if the location is affected by the event.
	 * @param affectedLocation the location checked for being affected.
	 * @return <code>true</code> if the location is affected by the event or <code>false</code> otherwise
	 */
	public boolean isAffected(Location affectedLocation) {
		return affected.contains(affectedLocation);
	}
	/**
	 * Gets: the event name.
	 * @return the event name.
	 */
	public String getName() {
		return name;
	}
	/**
	 * Sets: the event name.
	 * @param name the event name.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Gets : event short description.
	 * @return event short description.
	 */
	public String getShortDescription() {
		return shortDescription;
	}
	/**
	 * sets: event short description.
	 * @param shortDescription event short description.
	 */
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	/**
	 * Gets : event long description.
	 * @return event long description.
	 */
	public String getLongDescription() {
		return longDescription;
	}
	/**
	 * sets: event long description.
	 * @param shortDescription event long description.
	 */
	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}
	/**
	 * Gets: the event type.
	 * @return the event type.
	 */
	public EventType getType() {
		return type;
	}
	/**
	 * Sets: the event type.
	 * @param type the event type.
	 */
	public void setType(EventType type) {
		this.type = type;
	}
	/**
	 * Gets: the event gravity.
	 * @return the event gravity.
	 * @throws CloneNotSupportedException 
	 * @throws ClassCastException 
	 */
	public EventGravity getGravity() {
		return gravity;
	}
	/**
	 * Sets: the event gravity.
	 * @param gravity the event gravity.
	 * @throws CloneNotSupportedException 
	 * @throws ClassCastException 
	 */
	public void setGravity(EventGravity gravity) {
		this.gravity = gravity;
	}
	/**
	 * Gets: the affected locations.
	 * @return the affected locations.
	 */
	public Collection<Location> getAffected() {
		return affected;
	}
	/**
	 * Sets: the affected locations.
	 * @param affected the affected locations.
	 */
	public void setAffected(Collection<Location> affected) {
		this.affected = affected;
	}
}
