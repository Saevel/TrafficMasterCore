package trafficmaster.core;
import java.util.Date;

/**
 * Represents time or time interval , with comparison , sorting and difference determination possibilities.
 * @author Zielony
 * @version 1.0
 * @see Date
 */
public final class Time implements TrafficMasterBean {
	/**
	 * The unique object identifier within the class
	 */
	private int ID = NULL_ID;
	/**
	 * A <code>Date</code> object for method delegation and internal formatting
	 */
	private Date date;
	/**
	 * A blinder used as a default value for unused <code>date</code> object fields
	 */
	private static final int DATE_BLINDER = 0;
	/**
	 * Number of seconds per one minute
	 */
	private static final int SECONDS_PER_MINUTE = 60;
	/**
	 * Number of minutes per one hour
	 */
	private static final int MINUTES_PER_HOUR = 60;
	/**
	 * constructing an empty object for serilization's sake.
	 */
	public Time() {
		this(DATE_BLINDER,DATE_BLINDER,DATE_BLINDER);
	}
	/**
	 * Constructing a complete object
	 * @param hours the hour.
	 * @param minutes the minutes.
	 * @param seconds the seconds.
	 */
	public Time(int hours, int minutes, int seconds) {
		date = new Date();
		/*Blining unused fields*/
		date.setYear(DATE_BLINDER);
		date.setMonth(DATE_BLINDER);
		date.setDate(DATE_BLINDER);
		/*Setting the fields in the Date object*/
		setHours(hours);
		setMinutes(minutes);
		setSeconds(seconds);
		
	}
	/**
	 * Converting constructor to retrive data from text representation.
	 * @param time the time data in the text form.
	 */
	public Time(String time) {
		date = new Date(Date.parse(time));
	}
	/**
	 * Sets: the hour.
	 * @param hours the hour.
	 * @throws IllegalArgumentException if <code>hours</code> are not in <0,23>
	 */
	public void setHours(int hours) throws IllegalArgumentException {
		if(hours>23 || hours<0) {
			throw new IllegalArgumentException("Time|setHours|hours parameter not in <0,23>!");
		}
		date.setHours(hours);
	}
	/**
	 * Gets : the hour.
	 * @return the hour.
	 */
	public int getHours() {
		return date.getHours();
	}
	/**
	 * Sets: minutes.
	 * @param minutes minutes.
	 * @throws IllegalArgumentException when the <code>minutes</code> are not in <0, 59>.
	 */
	public void setMinutes(int minutes) {
		if(minutes>59 || minutes<0) {
			throw new IllegalArgumentException("Time|setHours|minutes parameter not in <0,59>!");
		}
		date.setMinutes(minutes);
	}
	/**
	 * Gets: minutes.
	 * @return  minutes.
	 */
	public int getMinutes() {
		return date.getMinutes();
	}
	/**
	 * Sets : seconds.
	 * @param seconds seconds.
	 * @throws IllegalArgumentException if the number of seconds is not in <0,59>.
	 */
	public void setSeconds(int seconds) throws IllegalArgumentException {
		if(seconds>59 || seconds<0) {
			throw new IllegalArgumentException("Time|setHours|seconds parameter not in <0,59>!");
		}
		date.setMinutes(seconds);
	}
	/**
	 * Gets: seconds.
	 * @return seconds.
	 */
	public int getSeconds() {
		return date.getSeconds();
	}
	/**
	 * Calculates the modulus of the time difference between two <code>Time</code> objects and stores
	 * it in another <code>Time</code> instance.
	 * @param time another <code>Time</code> object - to calculate the difference
	 * @return a <code>Time</code> object containing formatted time differences.
	 */
	Time getTimeDifference(Time time) {
		
		int factor=1;
		
		if(date.before(time.date)){
			factor = -1;
		}
		
		Time result = new Time();
		result.setHours((this.getHours() - time.getHours())*factor);
		result.setMinutes((this.getMinutes()-time.getMinutes())*factor);
		result.setSeconds((this.getSeconds()-time.getSeconds())*factor);
		
		if(result.getSeconds()<0) {
			result.setSeconds(result.getSeconds() + SECONDS_PER_MINUTE);
			result.setMinutes(result.getMinutes()-1);
		}
		if(result.getMinutes()<0) {
			result.setMinutes(result.getMinutes() + MINUTES_PER_HOUR);
			result.setHours(result.getHours()-1);
		}
		return result;
		
	}
	/**
	 * Strifies the object.
	 * @return the strigified object.
	 */
	public String toString() {
		return date.toString();
	}
	@Override
	public int getID() {
		return ID;
	}
	@Override
	public void setID(int ID) {
		this.ID = ID;
	}
}