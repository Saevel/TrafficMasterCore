/**
 * An object representing possible criteria to group and apply to choose the route.
 * @author Zielony
 * @version 1.0
 */
public abstract class Criterion implements JSONSerializable {
	
	
	
	/**
	 * Creating an empty object- for serialization's sake
	 */
	protected Criterion() {
		;
	}
	
	public abstract ICriterionResult applyCriterion(final Route route,final Location suggestedLocation);
	
	// TODO dalsze obiekty CHANGE_CRITERION oraz WALKING_CRITERION
	
	public static final Criterion TIME_CRITERION = new Criterion() {

		// TODO funkcja (zadeklarowana przez interfejs) wielu zmiennych.
		
		// TODO lista parametrów funkcji np. graniczna liczba przesiadek czy wspó³czynnik wyk³adnika.
		
		@Override
		public ICriterionResult applyCriterion(Route route,
				Location suggestedLocation) {
			// TODO Auto-generated method stub
			return null;
		}
		
	};
	
}
