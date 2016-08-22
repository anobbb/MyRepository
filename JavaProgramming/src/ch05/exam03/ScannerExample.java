package ch05.exam03;

//표준 API
//패키지명.클래스명
import java.util.Scanner;

public class ScannerExample {
/*
 * 	int data = System.in.read(); //입력이 될 때까지 기다림, 한 바이트만 읽음
 *  System.out.println(data);
 */
	
	public static void main(String[] args) throws Exception {
		//참조타입은 모두 객체가 필요
		//스캐너 타입의 변수 스캐너를 선언하고, 참조타입이므로 객체생성 후 번지를 대입
		//즉, 스캐너 객체를 만듦. 그 데이터는 System.in인 키보드로부터 데이터를 읽음.
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("학생 수: ");
		String strNum = scanner.nextLine();
		int num = Integer.parseInt(strNum);
		int scores[] = new int[num];
			
		for(int i = 0; i<scores.length; i++){
			System.out.print("점수: ");
			//스캐너 변수가 참조하는 객체로 접근해서 그 객체가 갖고 있는 메소들르 호출(=실행)
			//그 결과 값을 받아서 value에 리턴
			String data = scanner.nextLine();
			int score = Integer.parseInt(data);
			scores[i] = score;				
		}
		
		int sum = 0;
		for(int s : scores){
			sum += s;
		}
		System.out.println("총합: " + sum);
		System.out.println("평균: " + (double)sum / scores.length);

	}

}
