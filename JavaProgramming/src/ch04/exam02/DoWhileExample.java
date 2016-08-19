package ch04.exam02;

public class DoWhileExample {

	public static void main(String[] args) throws Exception {
		int num;
		
		do{
			num = System.in.read();
			System.out.println(num);
		} while(num != 113); // 세미콜론 주의

	}

}
