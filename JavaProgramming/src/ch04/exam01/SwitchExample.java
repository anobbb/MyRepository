package ch04.exam01;

public class SwitchExample {

	public static void main(String[] args) {
		/*double d = Math.random(); // 0.0 <= 임의의 수 < 1.0
		d = d * 6; // 0.0 <= 임의의 수 < 6.0
		int num = (int) d; // 0, 1, 2, 3, 4, 5 
		num = num + 1; //1, 2, 3, 4, 5, 6 */
		
		int num = (int)(Math.random()*6) + 1;
		
		switch(num){
		case 1:
			System.out.println("1번이 나왔습니다.");
		case 2:
			System.out.println("2번이 나왔습니다.");
		case 3:
			System.out.println("3번이 나왔습니다.");
			break;
		case 4:
			System.out.println("4번이 나왔습니다.");
		case 5:
			System.out.println("5번이 나왔습니다.");
		default:
			System.out.println("6번이 나왔습니다.");
		}

	}

}
