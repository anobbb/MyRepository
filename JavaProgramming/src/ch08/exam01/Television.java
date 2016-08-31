package ch08.exam01;

public class Television implements RemoteControl{
	
	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다.");
	}

	@Override
	public void setVolume(int volume) {
		System.out.println("현재 TV 볼륨: " + volume);
	}
	
}
