import java.util.List;
import java.util.Set;
// TODO : actual implementation of Schedule as a Spring DAO using JdbcTemplate class, with three
// possible instances (typesafe enum) : week, saturday and sunday.
/**
 * Defines the outlook of a schedule.
 * @author Zielony
 * @version 1.0
 * @see Stop
 * @see Line
 */
public interface ISchedule{
	/**
	 * Returns all the <code>Stops</code> a given <code>Line</code> passes through.
	 * @param line the <code>Line</code> for which the <code>Stops</code> are fetched.
	 * @return the <code>List</code> of <code>Stops</code>
	 * @see List
	 */
	List<Stop> getStopsForLine(Line line);
	/**
	 * Returns all the <code>Lines</code> passing through a given <code>Stop</code>.
	 * @param stop the <code>Stop</code> for which the <code>Lines</code> are fetched.
	 * @return a <code>Set</code> of <code>Lines</code> passing through that <code>Stop</code>.
	 * @see Set
	 */
	Set<Line> getLinesForStop(Stop stop);
	/**
	 * Checks if a given <code>Line</code> passes through a given <code>Location</code>.
	 * @param location the <code>Location</code> checked.
	 * @param line the <code>Line</code> checked.
	 * @return <code>true</code> if <code>line</code> passes through <code>stop</code> or <code> false
	 * </code>otherwise.  
	 */
	boolean passesThrough(Location location, Line line);
	/**
	 * 
	 * @param stop
	 * @param line
	 * @return
	 */
	List<Time> getArrivals(Stop stop, Line line);
	
}