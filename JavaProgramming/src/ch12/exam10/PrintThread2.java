package ch12.exam10;

public class PrintThread2 extends Thread{
	
	@Override
	public void run() {
		try{
			while(true){
				System.out.println("실행 중...");
				Thread.sleep(1); //interrupt 일부러 발생시키기 위한 코드
			}
		} catch(InterruptedException e){
		}
		
		System.out.println("자원 정리");
		System.out.println("실행 종료");
	}
}
