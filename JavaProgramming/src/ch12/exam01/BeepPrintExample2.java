package ch12.exam01;

import java.awt.Toolkit;

public class BeepPrintExample2 {

	public static void main(String[] args) throws InterruptedException {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		//매개값으로 runnable로 작업한 객체를 받음, main이 객체는 만들어 줌.작업 thread가 실행
		Thread thread = new Thread(new Runnable(){ 
			@Override
			public void run() { //작업 thread가 실행
				for(int i=0; i<5; i++){
					toolkit.beep();
					System.out.println("소리: " + Thread.currentThread().getName());
					try{Thread.sleep(500);}catch(Exception e){}
				}
			}
		});
		thread.start();
		
		for(int i=0; i<5; i++){//main thread가 실행
			System.out.println("띵");
			System.out.println("출력: " + Thread.currentThread().getName());
			try{Thread.sleep(500);}catch(Exception e){}
		}
	}

}
