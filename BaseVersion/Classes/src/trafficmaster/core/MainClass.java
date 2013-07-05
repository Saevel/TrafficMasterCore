package trafficmaster.core;
import java.io.NotSerializableException;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;


public class MainClass {

	/**
	 * @param args
	 * @throws JSONException 
	 * @throws NotSerializableException 
	 */
	public static void main(String[] args) throws NotSerializableException, JSONException {
		// TODO Auto-generated method stub
		
		Location location = new Location();
		location.setID(-10);
		location.setLatitude(100);
		location.setLongitude(100);
		location.setName("TTT");
	
		String stringLine = JSONFactory.getInstance().serialize(location, Location.class);
		System.out.println(stringLine);
	
		Location mLocation = (Location)JSONFactory.getInstance().deserialize(stringLine, Location.class);
		System.out.println(mLocation.getLatitude());
  }
}
