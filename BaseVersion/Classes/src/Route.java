import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/**
 * Constituted from a chain of <code>SubRoutes</code>, makes a full route description.
 * @author Zielony
 * @version 1.0
 */
public class Route extends LinkedList<SubRoute> implements IRoute, JSONSerializable {
	/**
	 * Returns the voyage start time according to the schedule.
	 * @return start time according to the schedule.
	 * @throws NullPointerException if the list of <code>SubRoutes</code> is empty.
	 */
	public Time getScheduleStartTime() throws NullPointerException {
		return get(0).getScheduleStartTime();
	}
	
	/**
	 * Returns the voyage end time according to the schedule.
	 * @return end time according to the schedule.
	 * @throw NullPointerException if the list of <code>SubRoutes</code> is empty.
	 */
	public Time getScheduleEndTime() throws NullPointerException {	
		return this.get(size()-1).getScheduleEndTime();
	}
	/**
	 * Returns the start time estimated on the basis of the analysis of real traffic data.
	 * @return the start time estimated on the basis of the analysis of real traffic data.
	 * @throws NullPointerException if there is no data on this type of parameter.
	 */
	public Time getEstimatedStartTime() throws NullPointerException {
		return get(0).getEstimatedStartTime();
	}
	/**
	 * Returns the end time estimated on the basis of the analysis of real traffic data.
	 * @return the end time estimated on the basis of the analysis of real traffic data.
	 * @throws NullPointerException if there is no data on this type of parameter.
	 */
	public Time getEstimatedEndTime() throws NullPointerException {
		return get(size()-1).getEstimatedEndTime();
	}
	/**
	 * Returns the travel time according to schedule data.
	 * @return the travel time according to schedule data.
	 * @throws NullPointerException if there is no data on this type of parameter.
	 */
	public Time getScheduleTravelTime() throws NullPointerException, IllegalStateException {
		return this.getScheduleEndTime().getTimeDifference(getScheduleStartTime());
	}
	/**
	 * Returns the travel time estimated on the basis of the analysis of real traffic data.
	 * @return the travel time estimated on the basis of the analysis of real traffic data.
	 * @throws NullPointerException if there is no data on this type of parameter.
	 */
	public Time getEstimatedTravelTime() throws NullPointerException, IllegalStateException {
		return this.getEstimatedEndTime().getTimeDifference(getEstimatedStartTime());
	}

	@Override
	public List<Course> getCourses() {
		if(isEmpty()) {
			return new LinkedList<Course>();
		}
		else {
			Iterator<SubRoute> iterator = iterator();
			List<Course> courses = new LinkedList<Course>();
			while(iterator.hasNext()) {
				courses.add(iterator.next().getCourse());
			}
			return courses;
		}
	}
}