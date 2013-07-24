package trafficmaster.core;
/**
 * Represents criteria used to filter <code>Events</code> into interesting
 * and uninsteresting.
 * @author Zielony
 * @version 1.0
 * @see Event
 */
public interface IEventFilter {
	/**
	 * Checks if the event matches the filtering criteria or not.
	 * @param event the <code>being filtered</event>
	 * @return <code>true</code> if the <code>event</code> matches
	 * the criteria, <code>false</code> if not.
	 */
	 boolean filter(Event event);
}
