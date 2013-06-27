package trafficmaster.core;
import java.util.List;
/**
 * The class representing the invocation of a simple exponential function of a fomula
 * y = A*exp(K*x) with two paramters: 
 * <br/>1/ A : the <code>exponent</code> 
 * <br/>2/ K : the <code>multiplier</code>
 * <br/>where y is the output and x is the input. 
 * @author Zielony
 * @version 1.0
 * @see Math
 * @see IFunction
 */
public class ExponentialFunction implements IFunction<Double,List<Double>,Double>{

	/**
	 * The attentuation coefficient in the exponential formula
	 */
	private Double exponent;
	/**
	 * The mutliplier constant in the exponential formula
	 */
	private Double multiplier;
	
	@Override
	public Double function(Double input) {
		if(isInDomain(input)) {
			return (multiplier*Math.exp(exponent*input));
		}
		else {
			return null;
		}
	}
	
	@Override
	public void setParameters(final List<Double> parameters) {
		if(parameters == null || parameters.size()<2) {
			throw new IllegalArgumentException("ExponentialFunction|setParameters|parameter list null or too small!");
		}
		else {
			Double first = parameters.get(0);
			Double second = parameters.get(1);
			
			if(first == null || second == null) {
				throw new IllegalArgumentException("ExponentialFunction|setParamerters|one of the parameters null!");
			}
			
			exponent = first;
			multiplier = second;
		}
	}
	
	@Override
	public boolean isInDomain(Double sample) {
		if(sample == null) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public Double getExponent() {
		return this.exponent;
	}
	
	public void setExponent(Double exponent) {
		this.exponent = exponent;
	}
	
	public Double getMultiplier() {
		return this.multiplier;
	}
	
	public void setMultiplier(Double multiplier) {
		this.multiplier = multiplier;
	}
	
}
