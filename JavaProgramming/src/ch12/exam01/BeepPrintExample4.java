package ch12.exam01;
import java.awt.Toolkit;

public class BeepPrintExample4 {

	public static void main(String[] args) throws InterruptedException {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
				
		SoundThread thread = new SoundThread();
		thread.start();
		
		for(int i=0; i<5; i++){ 
			System.out.println("띵");
			System.out.println("출럭: " + Thread.currentThread().getName());
			try{Thread.sleep(500);}catch(Exception e){}
		}
	}

}
