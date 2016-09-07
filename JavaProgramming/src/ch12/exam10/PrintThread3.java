package ch12.exam10;

public class PrintThread3 extends Thread{
	
	@Override
	public void run() {
		
		while(true){
			System.out.println("실행 중...");
			//if(isInterrupted()){ //instance method
			if(Thread.interrupted()){ //static(정적)method
				break;
			}
		}
		System.out.println("자원 정리");
		System.out.println("실행 종료");
	}
}
