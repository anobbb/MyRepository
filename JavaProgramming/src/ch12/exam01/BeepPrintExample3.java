package ch12.exam01;
import java.awt.Toolkit;

public class BeepPrintExample3 {

	public static void main(String[] args) throws InterruptedException {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		Thread thread = new Thread(){ //상속할 객체를 ..
			@Override
			public void run() {
				for(int i=0; i<5; i++){
					toolkit.beep();
					System.out.println("소리: " + Thread.currentThread().getName());
					try{Thread.sleep(500);}catch(Exception e){}
				}
			}
		};
		thread.setName("Sound Thread"); //start 전에 이름 바꿔야 함
		thread.start();
		
		for(int i=0; i<5; i++){ 
			System.out.println("띵");
			System.out.println("출럭: " + Thread.currentThread().getName());
			try{Thread.sleep(500);}catch(Exception e){}
		}
	}

}
