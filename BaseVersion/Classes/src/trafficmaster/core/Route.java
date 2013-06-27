package trafficmaster.core;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/**
 * Constituted from a chain of <code>SubRoutes</code>, makes a full route description.
 * @author Zielony
 * @version 1.0
 * @see SubRoute
 * @see IRoute
 * @see JSONSerializable
 * @see JSONFactory
 * @see Time
 */
public class Route implements IRoute, JSONSerializable {
	
	private List<SubRoute> subRoutes;
	
	/**
	 * Returns the voyage start time according to the schedule.
	 * @return start time according to the schedule.
	 * @throws NullPointerException if the list of <code>SubRoutes</code> is empty.
	 */
	public Time getScheduleStartTime() throws NullPointerException {
		return subRoutes.get(0).getScheduleStartTime();
	}
	
	/**
	 * Returns the voyage end time according to the schedule.
	 * @return end time according to the schedule.
	 * @throw NullPointerException if the list of <code>SubRoutes</code> is empty.
	 */
	public Time getScheduleEndTime() throws NullPointerException {	
		return subRoutes.get(subRoutes.size()-1).getScheduleEndTime();
	}
	/**
	 * Returns the start time estimated on the basis of the analysis of real traffic data.
	 * @return the start time estimated on the basis of the analysis of real traffic data.
	 * @throws NullPointerException if there is no data on this type of parameter.
	 */
	public Time getEstimatedStartTime() throws NullPointerException {
		return subRoutes.get(0).getEstimatedStartTime();
	}
	/**
	 * Returns the end time estimated on the basis of the analysis of real traffic data.
	 * @return the end time estimated on the basis of the analysis of real traffic data.
	 * @throws NullPointerException if there is no data on this type of parameter.
	 */
	public Time getEstimatedEndTime() throws NullPointerException {
		return subRoutes.get(subRoutes.size()-1).getEstimatedEndTime();
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
		if(subRoutes.isEmpty()) {
			return new LinkedList<Course>();
		}
		else {
			Iterator<SubRoute> iterator = subRoutes.iterator();
			List<Course> courses = new LinkedList<Course>();
			while(iterator.hasNext()) {
				courses.add(iterator.next().getCourse());
			}
			return courses;
		}
	}

	@Override
	public void addSubRoute(SubRoute subRoute) {
		subRoutes.add(subRoute);
	}

	@Override
	public boolean removeSubRoute(SubRoute subRoute) {
		return subRoutes.remove(subRoute);
	}

	@Override
	public boolean containsSubRoute(SubRoute subRoute) {
		return subRoutes.contains(subRoute);
	}
	/**
	 * Gets: the subRoutes.
	 * @return the subRoutes.
	 */
	public List<SubRoute> getSubRoutes() {
		return subRoutes;
	}
	/**
	 * Sets: the subRoutes
	 * @param subRoutes the subroutes.
	 */
	public void setSubRoutes(List<SubRoute> subRoutes) {
		this.subRoutes = subRoutes;
	}
}