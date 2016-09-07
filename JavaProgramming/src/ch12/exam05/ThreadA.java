package ch12.exam05;

public class ThreadA extends Thread{
	public boolean stop; //기본값 안 줘도 false
	public boolean work = true;
			
	@Override
	public void run() {
		while(!stop){
			if(work){
				System.out.println("ThreadA 작업 내용");
			} else{
				Thread.yield();
			}
		}
		System.out.println("ThreadA 종료");
	}
}
