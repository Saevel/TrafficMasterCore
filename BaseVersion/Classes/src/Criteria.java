import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Aggregates a number of <code>Criterion</code> objects to be used in cooperation
 * @author Zielony
 * @version 1.0
 * @see Criterion
 * @see ICriteria
 */
public class Criteria implements ICriteria{
	
	List<Criterion> criteria;
	
	@Override
	public Double applyCriteria(Route route, Location location) {
		Iterator<Criterion> iterator = criteria.iterator();
		
		Double finalResult = new Double(0.0);
		Double helper;
		
		while(iterator.hasNext()) {
			helper = iterator.next().applyCriterion(route, location);
			if(helper == Criterion.DISQUALIFYING_RESULT) {
				return helper;
			}
			else {
				finalResult += helper;
			}
		}
		return finalResult;
	}
	
	public String toString() {
		return ((List<Criterion>)this).toString();
	}

	@Override
	public void addCriterion(Criterion criterion) {
		criteria.add(criterion);		
	}

	@Override
	public boolean removeCriterion(Criterion criterion) {
		return criteria.remove(criterion);
	}

	@Override
	public boolean containsCriterion(Criterion criterion) {
		return criteria.contains(criterion);
	}
	
	public List<Criterion> getCriteria() {
		return criteria;
	}
	
	public void setCriteria(List<Criterion> criteria) {
		this.criteria = criteria;
	}
}
