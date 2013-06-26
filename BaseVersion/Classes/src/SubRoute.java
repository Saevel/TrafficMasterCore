import java.util.Date;
import java.util.List;

public class SubRoute {
	private Course course;
	private List<Stop> stops;
	private Date scheduleStartTime;
	private Date scheduleEndTime;
	private Date estimatedStartTime;
	private Date estimatedEndTime;
	
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Date getScheduleStartTime() {
		return scheduleStartTime;
	}
	public void setScheduleStartTime(Date scheduleStartTime) {
		this.scheduleStartTime = scheduleStartTime;
	}
	public Date getScheduleEndTime() {
		return scheduleEndTime;
	}
	public void setScheduleEndTime(Date scheduleEndTime) {
		this.scheduleEndTime = scheduleEndTime;
	}
	public Date getEstimatedStartTime() {
		return estimatedStartTime;
	}
	public void setEstimatedStartTime(Date estimatedStartTime) {
		this.estimatedStartTime = estimatedStartTime;
	}
	public Date getEstimatedEndTime() {
		return estimatedEndTime;
	}
	public void setEstimatedEndTime(Date estimatedEndTime) {
		this.estimatedEndTime = estimatedEndTime;
	}
	public List<Stop> getStops() {
		return stops;
	}
	public void setStops(List<Stop> stops) {
		this.stops = stops;
	}
}
