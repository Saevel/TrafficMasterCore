import java.io.NotSerializableException;

import org.json.JSONObject;


public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Location location = new Location();
		location.setLatitude(90);
		location.setLongitude(90);
		location.setName("myLocation");
		
		JSONObject json = null;
		
		try {
			json = JSONFactory.serialize(location);
			System.out.println(json);
		} catch (NotSerializableException e) {
			System.err.println(e.getMessage());
		}
		
		try {
			Location newLocation = (Location)JSONFactory.deserialize(json, Location.class);
			System.out.println(newLocation.getName());
		} catch (NotSerializableException e) {
			System.err.println(e.getMessage());
		}
		
		
		
	}

}
