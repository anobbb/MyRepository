package ch11.exam10;

public class StringEqualsExample {

	public static void main(String[] args) {
		String strVar1 = "홍길동"; //코드상에서 값을 줌: literal
		String strVar2 = "홍길동";
		//String strVar2 = new String("홍길동"); new객체생성: == -> false
		
		System.out.println(strVar1 == strVar2); //객체번지비교
		System.out.println(strVar1.equals(strVar2)); //문자열비교
	}

}
