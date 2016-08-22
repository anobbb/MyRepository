package ch05.exam02;

public class ArrayReferenceCompare {

	public static void main(String[] args) {
		String[] names = new String[3];
		names[0] = "홍길동";
		names[1] = "홍길동";
		names[2] = new String("홍길동");
		
		//객체 비교
		
		System.out.println(names[0] == names[1]);
		System.out.println(names[0] == names[2]);
		
		//문자열 비교
		System.out.println(names[0].equals(names[1]));
		System.out.println(names[0].equals(names[2]));
	}

}
