/**
 * Represents a single course on a given traffic line.
 * @author Zielony
 * @version 1.0
 * @see Line
 */
public class Course implements JSONSerializable, Cloneable {
	/**
	 * The <code>Line</code> this <code>Course</code> is tied to
	 * */
	private Line line;	
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
}
