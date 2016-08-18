package ch04.homework;
/*
 *주사위 2개를 동시에 100번을 던져서 눈의 합이 10인 경우 
 *주사위의 눈을 (x,y)형태로 출력 
*/
public class HomeWork1 {

	public static void main(String[] args) {
		int dice1 = 0, dice2 = 0; //주사위1, 2 변수선언
		int sum = 0; // 주사위의 눈 합계
		
		for(int i=0; i<100; i++){ //100번던지기
			dice1 = (int)(Math.random()*6) + 1; //주사위 1의 눈
			dice2 = (int)(Math.random()*6) + 1; //주사위 2의 눈
			sum = dice1 + dice2; //주사위 눈의 합
			if(sum == 10){ //합이 10일 경우 출력
				System.out.println("( " + dice1 + ", " + dice2 + " )");
			} // if sum
		} //if cnt
		
	}// main

} //class
