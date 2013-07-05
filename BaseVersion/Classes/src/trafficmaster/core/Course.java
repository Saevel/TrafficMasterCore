package trafficmaster.core;

import java.io.NotSerializableException;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Represents a single course on a given traffic line.
 * @author Zielony
 * @version 1.0
 * @see Line
 * @see State
 * @see JSONSerializable
 * @see JSONFactory
 */
public class Course extends TrafficMasterBean {
	
	
	/**
	 * The <code>Line</code> this <code>Course</code> is tied to
	 * */
	private Line line;	
	/**
	 * The state this course is currently in
	 */
	private State state;
	/**
	 * Whether the course is already in progress (<code>true</code>) or not (<code>false</code>)
	 */
	private boolean active;
	/**
	 * The order number of the course within the line.
	 */
	private int courseNumber;
	/**
	 * Gets: the <code>Line</code> this <code>Course</code> is tied to.
	 * @return the <code>Line</code> this <code>Course</code> is tied to. 
	 */
	public Line getLine() {
		return line;
	}
	/**
	 * Sets: the <code>Line</code> this <code>Course</code> is tied to.
	 * @param line the <code>Line</code> this <code>Course</code> is tied to.
	 */
	public void setLine(Line line) {
		this.line = line;
	}
	/**
	 * Gets: the ordering number of this course.
	 * @return the ordering number of this course.
	 */
	public int getCourseNumber() {
		return courseNumber;
	}
	/**
	 * Sets: the ordering number of this course.
	 * @param courseNumber the ordering number of this course.
	 */
	public void setCourseNumber(int courseNumber) {
		this.courseNumber = courseNumber;
	}
	/**
	 * Gets: the state the course is currently in.
	 * @return the state the course is currently in.
	 */
	public State getState() {
		return state;
	}
	/**
	 * Sets: the state the course is currently in.
	 * @param state the state the course is currently in.
	 */
	public void setState(State state) {
		this.state = state;
	}
	/**
	 * Gets: Whether the course is currently active.
	 * @return <code>true</code> if the course is active and <code>false</code> if conversely.
	 */
	public boolean getActive() {
		return active;
	}
	/**
	 * Sets: whether the course is currently active.
	 * @param active <code>true</code> if the course is active and <code>false</code> if conversely.
	 */
	public void setActive(boolean active) {
		this.active = active;
	}
	@Override
	public int getID() {
		return ID;
	}
	@Override
	public void setID(int ID) {
		this.ID = ID;
		
	}
	@Override
	protected void deserialize(JSONObject json) throws JSONException {
		super.deserialize(json);
		this.active = json.getBoolean("active");
		this.courseNumber = json.getInt("courseNumber");
		try {
			this.line = (Line) JSONFactory.getInstance().deserialize(json.getJSONObject("line").toString(), Line.class);
		} catch (NotSerializableException e) {
			throw new JSONException("Course|deserialize|could not deserialize the line");
		}
		try {
			this.state = (State)JSONFactory.getInstance().deserialize(json.getJSONObject("state").toString(), State.class);
		} catch (NotSerializableException e) {
			throw new JSONException("Course|deserialize|could not deserialize the state");
		}
		
	}
}