package ch12.exam01;

import java.awt.Toolkit;

public class BeepPrintExample {

	public static void main(String[] args) throws InterruptedException {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		for(int i=0; i<5; i++){
			toolkit.beep();
			System.out.println(Thread.currentThread().getName());
			Thread.sleep(500);//0.5초 쉬고 다시 for문 반복
		}
		
		for(int i=0; i<5; i++){
			System.out.println("띵");
			System.out.println(Thread.currentThread().getName());
			Thread.sleep(500);//0.5초 쉬고 다시 for문 반복
		}
	}

}
