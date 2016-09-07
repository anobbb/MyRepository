package ch12.exam08;

public class ThreadA extends Thread{
	private WorkObject workObject;
	
	public ThreadA(WorkObject workObject){
		this.workObject = workObject; //주입(injection): 외부에서 객체를 받아서 저장
	}
	
	@Override
	public void run() {
		for(int i=0; i<10; i++){
			workObject.methodA();
		}
	}
}
