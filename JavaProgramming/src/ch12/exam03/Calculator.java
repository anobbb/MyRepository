package ch12.exam03;

public class Calculator {
	private int memory;

	public int getMemory() {
		return memory;
	}

	//임계영역 동기화 메소드 설정
	public synchronized void setMemory(int memory) { 
		this.memory = memory;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {}
		System.out.println(Thread.currentThread().getName() + ": " + this.memory);
	}
	
	/*//동기화 블록 설정
	public void setMemory(int memory) { 
		synchronized(this){
			this.memory = memory;
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {}
			System.out.println(Thread.currentThread().getName() + ": " + this.memory);
		}//end synchronized
	}*/	
}
