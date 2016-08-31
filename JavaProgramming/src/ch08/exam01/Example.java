package ch08.exam01;

public class Example {
	public static void powerOn(RemoteControl rc){
		rc.turnOn(); //다형성, 매개변수 rc에 어떤 객체를 넣는 지에 따라 달라짐.
	}
	
	public static void main(String[] args) {
		int max = RemoteControl.MAX_VOLUME;
		int min = RemoteControl.MIN_VOLUME;
		
		//RemoteControl.turnOn();
		//RemoteControl.turnOff();
		//RemoteControl.setVolume(5);
		
		//RemoteControl.setMute(true);
		
		RemoteControl.changeBattery();
		
		//-----------------------------------------
		
		Television tv = new Television();
		tv.turnOn();
		
		RemoteControl rc = tv; //인터페이스 변수에 tv의 번지 저장
		rc.turnOn();
		
		Audio audio = new Audio();
		audio.turnOn();
		
		rc = audio;
		rc.turnOn();
		
		//-----------------------------------------
		powerOn(new Television()); // RemoteControl rc = new Television(); 객체생성하자마자 매개값에 대입
		powerOn(new Audio());
	}

}
