package ch11.exam10;

public class StringValueOfExample {

	public static void main(String[] args) {
		String str1 = "" + 10; //문자열 결합연산자 -> 문자열 10
		String str2 = String.valueOf(10);
		
		int value = Integer.parseInt(str2);
		
	}

}
