package Activities;

public class Car {
	
	String color;
	String transmission;
	int make;
	int tyres;
	int doors;
	
	// create a construstor
	
	 Car(){
		 tyres=4;
		 doors=4;
		 }
	 public void displayCharacteristics() {
		 System.out.println("color of the car:" +color);
		 System.out.println("Transmission of the car:" +transmission);
		 System.out.println("Car was made in:" + make);
		 System.out.println("Number of tyres for the car:" +tyres);
		 System.out.println("Number of doors for a car:" + doors);
		 }
       
	 public void accelerate() {
		 System.out.println("Car is moving forward.");
	 }
	 
	 public void brake() {
		 System.out.println("Car has stopped.");
	 }
	 
}