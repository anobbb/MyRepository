package ch05.exam01;

public class ValueReferenceCompare {

	public static void main(String[] args) {
		//값 비교
		int v1 = 100;
		int v2 = 100;
		System.out.println(v1 == v2);
		System.out.println(v1 != v2);
		
		//참조 비교(객체 비교)
		String r1 = new String("자바");
		String r2 = new String("자바"); // 다른 번지
		System.out.println(r1 == r2);
		System.out.println(r1 != r2);
		
		String r3 = "자바"; 
		String r4 = "자바"; // 같은 번지
		System.out.println(r3 == r4);
		System.out.println(r3 != r4);

	}

}
