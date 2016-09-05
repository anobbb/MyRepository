package ch11.exam10;

public class StringReplaceExample {

	public static void main(String[] args) {
		String oldStr = "자바는 객체지향언어 입니다. 자바는 풍부한 API를 지원합니다.";
		String newStr = oldStr.replace("자바", "Java"); //string은 한 번 값을 입력받으면 내부의 값을 바꿀 수 없다, 새 객체 생성
		System.out.println(oldStr);
		System.out.println(newStr);
		System.out.println(oldStr == newStr);
	}

}
