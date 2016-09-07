package ch12.exam13;

public class ThreadGroupExample2 {

	public static void main(String[] args) {
		Thread thread;
		
		/*class XXX extends Thread{
			public XXX(){
				super("t1"); //부모생성자 선택
			}
		 }
		new XXX();*/ // thread(){} 라면 super();
		//부모 생성자 호출 , main그룹에 t1이 속함
		thread = new Thread("t1") {
			@Override
			public void run() {
				while(true){
					System.out.println(getName() + ": 실행중^~^"); 
					if(isInterrupted()) break;
				}
				System.out.println(getName() + ": 종료");
			}
		}; 
		thread.start();
		
		//main그룹에 속함
		thread = new Thread("t2") {
			@Override
			public void run() {
				while(true){
					System.out.println(getName() + ": 실행중^~^"); 
					if(isInterrupted()) break;
				}
				System.out.println(getName() + ": 종료");
			}
		};
		thread.start();
		
		//in main group
		ThreadGroup sub = new ThreadGroup("sub"); 
		
		thread = new Thread(sub, "t3") {
			@Override
			public void run() {
				while(true){
					System.out.println(getName() + ": 실행중^~^"); 
					if(isInterrupted()) break;
				}
				System.out.println(getName() + ": 종료");
			}
		};
		thread.start();
		
		thread = new Thread(sub, "t4") {
			@Override
			public void run() {
				while(true){
					System.out.println(getName() + ": 실행중^~^"); 
					if(isInterrupted()) break;
				}
				System.out.println(getName() + ": 종료");
			}
		};
		thread.start();
		
		try {Thread.sleep(3000);} catch (InterruptedException e) {}
		
		//sub.interrupt();
		//main thread->all thread -> interrupt ==>전체 thread 종료
		Thread.currentThread().getThreadGroup().interrupt();
	}

}
