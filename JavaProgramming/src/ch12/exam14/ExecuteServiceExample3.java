package ch12.exam14;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecuteServiceExample3 {
	public static void main(String[] args){
		//ThreadPool생성
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		
		//작업 생성
		for(int i=1; i<=10; i++){
			int count = i;
			Runnable task = new Runnable(){
				@Override
				public void run() {
					//타입변환( executorService는 현재 풀에 들어간 스레드 개수를 알 수 있는 메소드가 없음)
					ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
					System.out.println("스레드의 총 수: " + threadPoolExecutor.getPoolSize());
					System.out.println("실행(" + count + "): " + Thread.currentThread().getName());	
					int value = Integer.parseInt("aa"); //NumberFormatExcection 발생
				}
			};
			
			//작업 큐에 작업 넣기
			executorService.submit(task);
			//executorService.execute(task); //오버헤드 발생 우려
		}
		
		
		//스레드풀 종류
		executorService.shutdown();
	}

}
