package ch04.exam02;

public class WhileExample2 {
	public static void main(String[] args) throws Exception {
		int i = 1;
		while(i<=10){
			System.out.println("반복 실행 중..");
			Thread.sleep(1000); //1초마다 한 번씩 쉼
			i++;
		}
	}

}
