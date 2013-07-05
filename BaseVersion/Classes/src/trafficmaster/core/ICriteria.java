package trafficmaster.core;
import java.util.List;

/**
 * Aggregates a number of <code>Criterion</code> objects to be used in cooperation
 * @author Zielony
 * @version 1.0
 * @see Criterion
 * @see JSONSerializable
 * @see JSONFactory
 * @see Route
 * @see Location
 */
public abstract class ICriteria extends JSONSerializable{
	public abstract Double applyCriteria(Route route, Location location);
	/**
	 * Adds a new criterion to the current set.
	 * @param criterion the new criterion.
	 */
	public abstract void addCriterion(Criterion criterion);
	/**
	 * Removes the criterion from the current set.
	 * @param criterion the criterion to be removed.
	 * @return if successful
	 */
	public abstract boolean removeCriterion(Criterion criterion);
	/**
	 * Checks if the given criterion is already in the set. 
	 * @param criterion the checked criterion.
	 * @return <code>true</code> if it is present <code>false</code> if conversely
	 */
	public abstract boolean containsCriterion(Criterion criterion);
}
