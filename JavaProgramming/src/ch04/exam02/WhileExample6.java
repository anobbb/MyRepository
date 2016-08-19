package ch04.exam02;
/*
 * -------------------------
 * 1. 예금  | 2. 출금  | 3. 종료
 * -------------------------
 * 선택 : 
 * 1번 입력할 경우 -> 1000원씩 예금액을 증가, 현재 잔액: ***원 출력
 * 2번 입력할 경우 -> 500원씩 예금액을 감소, 현재 잔액: ***원 출력
 * 3번 입력할 경우 -> 프로그램 종료.
 */

public class WhileExample6 {

	public static void main(String[] args) throws Exception {
		boolean run = true;
		int balance = 0;
		int keyCode = 0;
		
		while(run){
			if(keyCode != 13 && keyCode != 10){
				System.out.println("-----------------------------");
				System.out.println("1. 예금  |  2. 출금  |  3. 종료  ");
				System.out.println("-----------------------------");
				System.out.print("선택: ");
			}
			
			keyCode = System.in.read();
			
			if(keyCode==49){
				balance += 1000;
				System.out.println("현재 잔액: " + balance);
			} else if(keyCode==50){
				balance -= 500;
				System.out.println("현재 잔액: " + balance);
			} else if(keyCode==51){
				run = false;
			}
			
		}
		

	}


}
