package ch12.exam06;

public class JoinExample {

	public static void main(String[] args) {
		SumThread sumThread = new SumThread();
		sumThread.start();
		try {sumThread.join();} catch (InterruptedException e) {}
		//main은 SumThread가 끝날 때까지 대기 상태
		
		System.out.println("1~100 합: " + sumThread.getSum());
		
	}

}
