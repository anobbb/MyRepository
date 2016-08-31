package ch08.exam07;

public class Driver {
	//Field
	//Constructor
	//Method
	public void drive(Vehicle vehicle){
		if(vehicle instanceof Bus){
			Bus bus = (Bus)vehicle;
			bus.checkFare();
		}		
		vehicle.run();
	}
}
