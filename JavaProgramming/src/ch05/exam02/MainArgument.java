package ch05.exam02;

public class MainArgument {

	public static void main(String[] args) {
		//java MainArgument 3 4
		String v1 = args[0]; //"3"
		String v2 = args[1]; //"4"
		
		// parse 메소드를 호출하여 괄호 안의 매개값인 문자열 "3"을 정수로 해석, 변환 후 리턴(대입)
		int intV1 = Integer.parseInt(v1); 
		int intV2 = Integer.parseInt(v2);
		
		int result = intV1 + intV2;
		System.out.println("result = " + result);

	}

}
