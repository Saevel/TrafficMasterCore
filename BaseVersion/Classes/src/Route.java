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
	public Date getScheduleStartTime() throws NullPointerException {
		return get(0).getScheduleStartTime();
	}
	
	/**
	 * Returns the voyage end time according to the schedule.
	 * @return end time according to the schedule.
	 * @throw NullPointerException if the list of <code>SubRoutes</code> is empty.
	 */
	public Date getScheduleEndTime() throws NullPointerException {	
		return this.get(size()-1).getScheduleEndTime();
	}
	public Date getEstimatedStartTime() throws NullPointerException {
		return get(0).getEstimatedStartTime();
	}
	
	public Date getEstimatedEndTime() throws NullPointerException {
		return get(size()-1).getEstimatedEndTime();
	}
	
	public Date getScheduleTravelTime() throws NullPointerException, IllegalStateException {
		Date startTime = getScheduleStartTime();
		Date endTime = getScheduleEndTime();
		if(endTime.after(startTime)) {
			throw new IllegalStateException("Route|getScheduleTravelTime|startTime later than endTime");
		}
		return DateUtils.getTimeDifference(endTime, startTime);
	}
	
	public Date getEstimatedTravelTime() throws NullPointerException, IllegalStateException {
		Date startTime = getEstimatedStartTime();
		Date endTime = getEstimatedEndTime();
		if(endTime.after(startTime)) {
			throw new IllegalStateException("Route|getEstimatedTravelTime|startTime later than endTime");
		}
		return DateUtils.getTimeDifference(endTime, startTime);
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
