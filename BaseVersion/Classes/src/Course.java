/**
 * Represents a single course on a given traffic line.
 * @author Zielony
 * @version 1.0
 * @see Line
 */
public class Course implements JSONSerializable {
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
	public boolean isActive() {
		return active;
	}
	/**
	 * Sets: whether the course is currently active.
	 * @param active <code>true</code> if the course is active and <code>false</code> if conversely.
	 */
	public void setActive(boolean active) {
		this.active = active;
	}
}