package ch11.exam10;

public class StringIndexOfExample {

	public static void main(String[] args) {
		String subject = "자바 프로그래밍";
		
		boolean result1 = subject.contains("자바");
		if(result1){
			System.out.println("자바 관련 책이군요");
		} else{
			System.out.println("자바 관련없는 책이군요");
		}
		
		int result2 = subject.indexOf("프로"); //index 4를 저장
		if(result2 != -1){
			System.out.println("자바 관련 책이군요");
		} else{
			System.out.println("자바 관련없는 책이군요");
		}
		
		/*String token1 = subject.substring(0, 2); //2는 바이트 수 아님, 문자의 수!
		System.out.println(token1);*/
		
		int startIndex = subject.indexOf("자바");
		int endIndex = startIndex + 2;//길이가 아닌 인덱스(시작 인덱스<끝인덱스) 끝인덱스 이전까지 잘라내기, endIndex 비포함
		String token1 = subject.substring(startIndex, endIndex); 
		System.out.println(token1);
		
		/*startIndex = subject.indexOf("프로그래밍");
		endIndex = startIndex + "프로그래밍".length(); // 문자의 개수 (=startIndex + 5)
		String token2 = subject.substring(startIndex, endIndex); 
		System.out.println(token2);*/
		
		/*String find = "프로그래밍";
		startIndex = subject.indexOf(find);
		endIndex = startIndex + find.length(); 
		String token2 = subject.substring(startIndex, endIndex); 
		System.out.println(token2);*/
		
		String find = "프로그래밍";
		startIndex = subject.indexOf(find);
		/*endIndex = startIndex + find.length();
		String token2 = subject.substring(startIndex, endIndex); */
		String token2 = subject.substring(startIndex); 
		System.out.println(token2);
	}
}
