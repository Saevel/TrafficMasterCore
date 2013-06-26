import java.util.Date;

/**
 * A util toolkit for handling additional functions dealing with the<code>Date</code> object
 * @author Zielony
 * @version 1.0
 * @see Date
 */
public class DateUtils {
	/**
	 * Default value for the year part if only time-realted parts are really in use.
	 */
	public static final int DEFAULT_YEAR = 0;
	/**
	 * Default value for the month part if only time-realted parts are really in use.
	 */
	public static final int DEFAULT_MONTH = 0;
	/**
	 * Default value for the day part if only time-realted parts are really in use.
	 */
	public static final int DEFAULT_DAY = 0;
	/**
	 * Private default constructor - so that the util class is non-instantiable
	 */
	private DateUtils() {
		;
	}
	/**
	 * Calculates the time difference between two moments defined as <code>Date</code> objects
	 * @param subtractor the later date
	 * @param subtracted the former date
	 * @return the modulus of the time difference between the two time instances. It is returned as a
	 * <code>Date</code> object with default values for year, month and day, which are herein irrelevant.
	 * @throws NullPointerException if either date is <code>null</code>
	 */
	public static Date getTimeDifference(Date subtractor, Date subtracted) throws NullPointerException {
		
		if(subtractor == null || subtracted == null) {
			throw new NullPointerException("DateUtils|getTimeDifference|either subtracted or subtractor is null");
		}
		
		if(subtractor.after(subtracted)) /*If variables were given in wrong order, swtiching references*/
		{
			Date cache = subtractor;
			subtractor = subtracted;
			subtracted = cache;
		}
		int minuteDifference = subtractor.getMinutes() - subtracted.getMinutes();
		int hourDifference = subtractor.getHours() - subtracted.getHours();
		
		if(minuteDifference<0) { /*Correction using the hour-minutes conversion, if necessary*/
			hourDifference -= 1;
			minuteDifference += 60;
		}
		/*Wrapping the result in a new Date object, with default year, month and day parts*/
		Date result = new Date();
		result.setYear(DateUtils.DEFAULT_YEAR);
		result.setMonth(DEFAULT_MONTH);
		result.setDate(DEFAULT_DAY);
		result.setHours(hourDifference);
		result.setMinutes(minuteDifference);
		
		return result;
	}
}
