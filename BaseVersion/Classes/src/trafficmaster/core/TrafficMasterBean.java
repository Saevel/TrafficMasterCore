package trafficmaster.core;
import java.io.Serializable;

/**
 * A bean fitting the needs of the TrafficMaster application. Apart from implementing this
 * <code>interface</code> it must follow a set of rules : 
 * <br/><ul>
 * <br/>	<li>1/ All fields must either be primitives, <code>Strings</code> or other <code>TrafficMasterBeans</code></li>
 * <br/>    <li>2/ Each field must have a getter and a setter with standard names</li>
 * <br/>    <li>3/ For boolean fields only getBooleanVariable patter for getter is accepted</li>
 * <br/>    <li>4/ All must have a public, default, no-argument constructor</li>
 * <br/></ul> 
 * @author Zielony
 * @version 1.0
 */
public interface TrafficMasterBean extends Serializable, JSONSerializable {
	/**
	 * Gets: the ID of the bean.
	 * @return the ID of the bean.
	 */
	int getID();
	/**
	 * Sets: the ID of the bean.
	 * @param ID the ID of the bean.
	 */
	void setID(int ID);
	/**A special value used to indicate that the ID has not yet been set.*/
	static int NULL_ID = -1;
}
