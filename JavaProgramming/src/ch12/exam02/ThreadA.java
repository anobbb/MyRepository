package ch12.exam02;

public class ThreadA extends Thread{
	@Override
	public void run() {
		for(int i=1; i<=1000000000; i++){
		}
		System.out.println("ThreadA 종료");
	} //run, thread 종료
}
