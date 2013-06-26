import java.io.NotSerializableException;
import java.util.LinkedList;

import org.json.JSONObject;


public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Event event = new Event();
		event.setGravity(EventGravity.HIGH);
		event.setType(EventType.ROADWORKS);
		event.setAffected(new LinkedList<Location>());
		
		JSONObject json = null;
		
		try {
			json = JSONFactory.serialize(event);
			System.out.println(json);
		} catch (NotSerializableException e) {
			System.err.println(e.getMessage());
		}
		
		try {
			Event newEvent = (Event)JSONFactory.deserialize(json, Event.class);
			System.out.println(event.getGravity());
		} catch (NotSerializableException e) {
			System.err.println(e.getMessage());
		}
		
		
		
	}

}
