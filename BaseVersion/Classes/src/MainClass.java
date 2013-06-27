import java.io.NotSerializableException;
import java.util.LinkedList;

import org.json.JSONObject;


public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JSONObject json = null;
		
		State oldState = new State();
		oldState.setAcceleration((float) 9.81);
		oldState.setAverageVelocity(10);
		oldState.setCurrentVelocity(3);
		oldState.setDelay(new Time(1,12,0));
		oldState.setStatus(Status.JAMMED);
		
		try {
			json = JSONFactory.serialize(oldState);
			System.out.println("JSON: " + json);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			State newState =(State)JSONFactory.deserialize(json, State.class);
			System.out.println(newState.getStatus());
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	
	}
}
