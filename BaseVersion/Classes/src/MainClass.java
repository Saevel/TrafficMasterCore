import java.io.NotSerializableException;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONObject;


public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	Stop stop = new Stop();
	stop.setLatitude(100);
	stop.setLongitude(100);
	stop.setName("Zag³oby 21 m 14");
	stop.setStopName("Zag³oby");
		
	Line line = new Line();
	line.setDirection(true);
	line.setLocationsPassed(new LinkedList<Location>());
	line.setName("96");
	line.setMeansOfTransport(MeansOfTransport.BUS);
		
	State state = new State();
	
	Status status = Status.DRIVING;

	Time time = new Time();
	time.setHours(13);
	time.setMinutes(11);
	time.setSeconds(0);
	
	state.setStatus(status);
	state.setDelay(time);
	state.setNearestStop(stop);
	state.setLocation(stop);
	state.setAcceleration(0);
	state.setAverageVelocity(0);
	state.setCurrentVelocity(0);
	
	Course course= new Course();
	course.setActive(true);
	course.setLine(line);
	course.setState(state);
	
	SubRoute subRoute = new SubRoute();
	subRoute.setCourse(course);
	subRoute.setEstimatedEndTime(time);
	subRoute.setEstimatedStartTime(time);
	subRoute.setLocations(new LinkedList<Location>());
	subRoute.setScheduleEndTime(time);
	subRoute.setScheduleStartTime(time);
	
	Route route = new Route();
	route.setSubRoutes(new LinkedList<SubRoute>());
	route.addSubRoute(subRoute);
	
	try {
		JSONObject json = JSONFactory.serialize(route);
		System.out.println(json);
		Route newRoute = (Route)JSONFactory.deserialize(json, Route.class);
		System.out.println(newRoute.getCourses().size());
	} catch (NotSerializableException e) {
		System.out.println(e.getMessage());
	}
	}
}
