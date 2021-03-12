package Activities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Plane{
	private List<String> Passengers;
	private Date Tookofftime;
	private Date Landingtime;
	private int maxPassengers;

	
	public Plane(int maxPassengers) {
		this.maxPassengers = maxPassengers;
		this.Passengers= new ArrayList<>();
		}
	// adding passengers
	public void onBoard( String Passengers) {
		this.Passengers.add(Passengers);
		
	}
	//takeoff time
	public Date takeOff() {
		this.Tookofftime =new Date();
		return Tookofftime;	
	}
	// set Landing time and clear passengers list
	public void land() {
		this.Landingtime = new Date();
		this.Passengers.clear();
		}
	// to retrieve landing time
	public  Date  lastTimeLanding() {
		return Landingtime;
		
	}
	 public List<String> getPassengers() {
		 return Passengers;  
		 
	 }
}

public class Activity2_2 {

	public static void main(String[] args) throws InterruptedException {
		Plane plane =new Plane(10);
		plane.onBoard("Mounika");
		plane.onBoard("Sundeep");
		plane.onBoard("Sravya");
		
		 System.out.println("Plane took off at: " + plane.takeOff());
	        //Print list of people on board
	        System.out.println("People on the plane: " + plane.getPassengers());
	        //Flying.....
	        Thread.sleep(5000);
	        //Plane has landed
	        plane.land();
	        //Plane lands
	        System.out.println("Plane landed at: " + plane.lastTimeLanding());
	        System.out.println("People on the plane after landing: " + plane.getPassengers());

	}

}