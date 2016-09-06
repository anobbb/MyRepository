package ch12.exam02;

public class ThreadPriorityExample {
	public static void main(String[] args){
		/*Thread ta = new ThreadA();
		ta.setPriority(Thread.MIN_PRIORITY);
		
		Thread tb = new ThreadB();
		tb.setPriority(Thread.MAX_PRIORITY);
		
		ta.start();
		tb.start();*/
		Thread thread = null;
		for(int i=1; i<=100; i++){
			thread = new ThreadC(i);
			if(i!=100){
				thread.setPriority(Thread.MIN_PRIORITY);
			} else{
				thread.setPriority(Thread.MAX_PRIORITY);
			}
			thread.start();
		}
	}
}
