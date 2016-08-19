package ch04.exam03;

//주사위의 눈이 6이 나오면 프로그램을 종료하세요.
public class BreakExample {
	public static void main(String[] args) {
		
		while(true){
			/*
			double num = Math.random(); //0.0 <= num < 1.0
			num = num * 6; // 0.0 <= num < 6
			int value = (int)num + 1; // 0, 1, 2, 3, 4, 5
			value += 1; // 1, 2, 3, 4, 5, 6
			*/	
			
			int value = (int)(Math.random() * 6) + 1;
			System.out.println(value);

			if(value == 6){
				break;
			}
		}
	}

}
