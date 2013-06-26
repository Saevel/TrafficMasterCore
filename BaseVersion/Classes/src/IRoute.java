import java.util.Date;
import java.util.List;
/**
 * Defines a route as a list of <code>SubRoutes</code> with certain capabilities
 * @author Zielony
 * @version 1.0
 */
public interface IRoute extends List<SubRoute>, JSONSerializable {
	/**
	 * Fetches a list of all the <code>Courses</code> taken on the Route.
	 * @return  a list of all the <code>Courses</code> taken on the Route.
	 */
	public List<Course> getCourses();
	/**
	 * Gets: the start time according to the schedule.
	 * @return the start time according to the schedule.
	 */
	public Date getScheduleStartTime();
	/**
	 * Gets: the end time according to the schedule.
	 * @return the end time according to the schedule.
	 */
	public Date getScheduleEndTime();
	/**
	 * Gets: the estimated startTime basing on traffic data analysis.
	 * @return the estimated startTime basing on traffic data analysis.
	 */
	public Date getEstimatedStartTime();
	/**
	 * Gets: the estimated end Time basing on traffic data analysis.
	 * @return the estimated end Time basing on traffic data analysis.
	 */
	public Date getEstimatedEndTime();
	/**
	 * Gets: the overall travel time according to the schedule.
	 * @return the overall travel time according to the schedule.
	 */
	public Date getScheduleTravelTime();
	/**
	 * Gets: the overall travel time estimated on the basis of traffic data analysis.
	 * @return the overall travel time estimated on the basis of traffic data analysis.
	 */
	public Date getEstimatedTravelTime();
}
