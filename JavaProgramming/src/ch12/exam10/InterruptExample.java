package ch12.exam10;

public class InterruptExample {

	public static void main(String[] args) {
		PrintThread2 pt = new PrintThread2();
		pt.start();
		
		try { Thread.sleep(3000); } catch (InterruptedException e) {}
		pt.interrupt();
	}

}
