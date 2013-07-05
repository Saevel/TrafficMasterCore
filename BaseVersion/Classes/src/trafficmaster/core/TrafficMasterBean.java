package trafficmaster.core;
import java.io.Serializable;

import org.json.JSONException;
import org.json.JSONObject;

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
public abstract class TrafficMasterBean extends JSONSerializable implements Serializable {
	/**
	 * The ID of the bean - for database interaction mainly.
	 */
	protected int ID;
	/**
	 * Gets: the ID of the bean.
	 * @return the ID of the bean.
	 */
	int getID(){
		return this.ID;
	}
	/**
	 * Sets: the ID of the bean.
	 * @param ID the ID of the bean.
	 */
	void setID(int ID){
		this.ID = ID;
	}
	/**A special value used to indicate that the ID has not yet been set.*/
	public static int NULL_ID = -1;
	@Override
	protected void deserialize(JSONObject json) throws JSONException {
		setID(json.getInt("ID"));
	}
}
