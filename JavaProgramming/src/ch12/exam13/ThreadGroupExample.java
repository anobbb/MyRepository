package ch12.exam13;

public class ThreadGroupExample {
	public static void main(String[] args){
		
		Thread thread = Thread.currentThread();
		System.out.println(thread.getName());
		
		for(int i=0; i<10; i++){
			int count = i;
			Thread thread2 = new Thread(){//익명 자식 객체, main이 속한 그룹에 포함
				@Override
				public void run() {
					while(true){
						//익명객체안에서 지역변수는 final특성, but i값이 변경되는 중
						//-> i값을 쓰면 error, count에 저장해서 쓰면 해결
						System.out.println("Thread" + count + ": 실행중^~^"); 
						if(isInterrupted()) break;
					}
					System.out.println("Thread" + count + ": 종료");
				}
			}; 
			thread2.start();
		}
		
		
		ThreadGroup mainGroup = thread.getThreadGroup(); //main이 속한 그룹에 포함
		System.out.println(mainGroup.getName());
		System.out.println(mainGroup.activeCount()); //activeCount: 현재 활성화된 스레드 수
		
		try{ Thread.sleep(1000); } catch(InterruptedException e) {}
		
		mainGroup.interrupt();
	}

}
