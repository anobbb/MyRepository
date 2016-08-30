package ch07.exam09;

public class HankookTire extends Tire{
	//Field
	//Constructor
	public HankookTire(String location, int maxRotation){
		super(location, maxRotation);
	}
	//Method
	@Override
	public boolean roll(){
		++accumulatedRotation;
		if(accumulatedRotation<maxRotation){
			System.out.println(location + " HankookTire 수명: " +
					(maxRotation - accumulatedRotation) + "회");
			return true;
		} else {
			System.out.println("*** " + location + " HankookTire 펑크 ***");
			return false;
		}
	}
}
