package trafficmaster.core;
import java.util.List;

/**
 * Represents an arbitrary function, with input type,variable parameters and output type specified.
 * @author Zielony
 * @version 1.0
 * @see JSONSerializable
 * @see JSONFactory
 */
public interface IFunction<inputType, parameterType, outputType> extends JSONSerializable {
	/**
	 * A general function as defined in set theory.
	 * @param input the input paramter(s) of the function.
	 * @return an output parameter of the function.
	 */
	outputType function(inputType input);
	/**
	 * Sets the parameters for the function. 
	 * @param parameters the parameters of the function.
	 */
	void setParameters(parameterType parameters);
	/**
	 * Determines whether a specific input lies within the function domain.
	 * @param sample the sample input for determination.
	 * @return <code>true</code> if the input lies in the domain, <code>false</code> otherwise.
	 */
	boolean isInDomain(inputType sample);
}