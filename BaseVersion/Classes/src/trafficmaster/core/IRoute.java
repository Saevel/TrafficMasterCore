package trafficmaster.core;
import java.util.Date;
import java.util.List;
/**
 * Defines a route as a list of <code>SubRoutes</code> with certain capabilities
 * @author Zielony
 * @version 1.0
 * @see SubRoute
 * @see JSONSerializable
 * @see JSONFactory
 * @see Course
 * @see Time
 * 
 */
public interface IRoute extends JSONSerializable {
	/**
	 * Fetches a list of all the <code>Courses</code> taken on the Route.
	 * @return  a list of all the <code>Courses</code> taken on the Route.
	 */
	public List<Course> getCourses();
	/**
	 * Gets: the start time according to the schedule.
	 * @return the start time according to the schedule.
	 */
	public Time getScheduleStartTime();
	/**
	 * Gets: the end time according to the schedule.
	 * @return the end time according to the schedule.
	 */
	public Time getScheduleEndTime();
	/**
	 * Gets: the estimated startTime basing on traffic data analysis.
	 * @return the estimated startTime basing on traffic data analysis.
	 */
	public Time getEstimatedStartTime();
	/**
	 * Gets: the estimated end Time basing on traffic data analysis.
	 * @return the estimated end Time basing on traffic data analysis.
	 */
	public Time getEstimatedEndTime();
	/**
	 * Gets: the overall travel time according to the schedule.
	 * @return the overall travel time according to the schedule.
	 */
	public Time getScheduleTravelTime();
	/**
	 * Gets: the overall travel time estimated on the basis of traffic data analysis.
	 * @return the overall travel time estimated on the basis of traffic data analysis.
	 */
	public Time getEstimatedTravelTime();
	/**
	 * Adds a new subRoute to the route
	 * @param subRoute the new SubRoute
	 */
	public void addSubRoute(SubRoute subRoute);
	/**
	 * Removes the subRoute from the route
	 * @param subRoute the subRoute to remove
	 * @return if there was success
	 */
	public boolean removeSubRoute(SubRoute subRoute);
	/**
	 * Checks if the Route contains this SubRoute
	 * @param subRoute the SubRoute checked.
	 * @return TODO
	 */
	public boolean containsSubRoute(SubRoute subRoute);
}