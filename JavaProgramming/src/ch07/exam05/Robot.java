package ch07.exam05;

public class Robot extends Machine{
	@Override 
	public void work() {
		System.out.println("Robot-work() 실행");
		super.work();
	}
	/*public final void powerOn(){
	}*/
}
