package trafficmaster.core;
import java.io.NotSerializableException;
import java.util.Date;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
/**
 * Represents a part of a <code>Route</code> traversed only using one <code>Course</code>
 * @author Zielony
 * @version 1.0
 * @see Course
 * @see Stop
 * @see Time
 * 
 */
public class SubRoute extends JSONSerializable {
	/**
	 * The course which the sub route follows
	 */
	private Course course;
	/**
	 * Locations passed on the way.
	 */
	private List<Location> locations;
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
	 * Gets: the traversed locations.
	 * @return the traversed locations.
	 */
	public List<Location> getLocations() {
		return locations;
	}
	/**
	 * Sets: the traversed locations.
	 * @param locations the traversed locations.
	 */
	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}
	@Override
	protected void deserialize(JSONObject json) throws JSONException {
		try {	
			this.course = (Course)JSONFactory.getInstance().deserialize(json.getJSONObject("course").toString(), Course.class);
			this.estimatedEndTime = (Time)JSONFactory.getInstance().deserialize(json.getJSONObject("estimatedEndTime").toString(), Time.class);
			this.estimatedStartTime = (Time)JSONFactory.getInstance().deserialize(json.getJSONObject("estimatedStartTime").toString(), Time.class);
			this.scheduleEndTime = (Time)JSONFactory.getInstance().deserialize(json.getJSONObject("scheduleEndTime").toString(), Time.class);
			this.scheduleStartTime = (Time)JSONFactory.getInstance().deserialize(json.getJSONObject("scheduleStartTime").toString(), Time.class);
		}
		catch(NotSerializableException e) {
			throw new JSONException("SubRoute|deserialize|deserialization failed");
		}
		
	}
}