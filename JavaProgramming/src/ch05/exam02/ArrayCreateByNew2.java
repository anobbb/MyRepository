package ch05.exam02;

public class ArrayCreateByNew2 {

	public static void main(String[] args) {
		//기본 타입 배열
		int[] arr1 = new int[3];
		arr1[0] = 10;
		arr1[1] = 20;
		arr1[2] = 30;
		for(int i=0; i<arr1.length; i++) {
			System.out.println("arr1[" + i + "] = " + arr1[i]);
		}
		System.out.println(arr1[0] == arr1[1]);
		
		//참조 타입 배열
		String[] arr4 = new String[3];
		arr4[0] = "자바";
		arr4[1] = "자바"; // cf) arr4[1] = new String("자바");
		arr4[2] = "대한민국";
		for(int i=0; i<arr4.length; i++) {
			System.out.println("arr4[" + i + "] = " + arr4[i]);
		}
		System.out.println(arr4[0].equals(arr4[1]));
	}

}
