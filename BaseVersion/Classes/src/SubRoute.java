import java.util.Date;
import java.util.List;

public class SubRoute {
	/**
	 * The course which the sub route follows
	 */
	private Course course;
	/**
	 * Stops passed on the way.
	 */
	private List<Stop> stops;
	/**
	 * The start time according to the schedule.
	 */
	private Time scheduleStartTime;
	/**
	 * The end time according to the schedule.
	 */
	private Time scheduleEndTime;
	/**
	 * The start time estimated on the basis of traffic analysis.
	 */
	private Time estimatedStartTime;
	/**
	 * The end time estimated on the basis of traffic analysis.
	 */
	private Time estimatedEndTime;
	/**
	 * Gets: the course realizing the sub route.
	 * @return  the course realizing the sub route.
	 */
	public Course getCourse() {
		return course;
	}
	/**
	 * Sets:  the course realizing the sub route.
	 * @param course  the course realizing the sub route.
	 */
	public void setCourse(Course course) {
		this.course = course;
	}
	/**
	 * Gets: The start time according to the schedule.
	 * @return The start time according to the schedule.
	 */
	public Time getScheduleStartTime() {
		return scheduleStartTime;
	}
	/**
	 * Sets: The start time according to the schedule.
	 * @param scheduleStartTime The start time according to the schedule.
	 */
	public void setScheduleStartTime(Time scheduleStartTime) {
		this.scheduleStartTime = scheduleStartTime;
	}
	/**
	 * Gets: The end time according to the schedule.
	 * @return The end time according to the schedule.
	 */
	public Time getScheduleEndTime() {
		return scheduleEndTime;
	}
	/**
	 * Sets: The end time according to the schedule.
	 * @param scheduleEndTime
	 */
	public void setScheduleEndTime(Time scheduleEndTime) {
		this.scheduleEndTime = scheduleEndTime;
	}
	/**
	 * Gets: The start time estimated on the basis of traffic analysis.
	 * @return The start time estimated on the basis of traffic analysis.
	 */
	public Time getEstimatedStartTime() {
		return estimatedStartTime;
	}
	/**
	 * Sets: The start time estimated on the basis of traffic analysis.
	 * @param estimatedStartTime The start time estimated on the basis of traffic analysis.
	 */
	public void setEstimatedStartTime(Time estimatedStartTime) {
		this.estimatedStartTime = estimatedStartTime;
	}
	/**
	 * Gets: The end time estimated on the basis of traffic analysis.
	 * @return The end time estimated on the basis of traffic analysis.
	 */
	public Time getEstimatedEndTime() {
		return estimatedEndTime;
	}
	/**
	 * Sets: The end time estimated on the basis of traffic analysis.
	 * @param estimatedEndTime The end time estimated on the basis of traffic analysis.
	 */
	public void setEstimatedEndTime(Time estimatedEndTime) {
		this.estimatedEndTime = estimatedEndTime;
	}
	/**
	 * Gets: the traversed stops.
	 * @return the traversed stops.
	 */
	public List<Stop> getStops() {
		return stops;
	}
	/**
	 * Sets: the traversed stops.
	 * @param stops the traversed stops.
	 */
	public void setStops(List<Stop> stops) {
		this.stops = stops;
	}
}