package ch05.exam01;

public class StringEquals {

	public static void main(String[] args) {
		String name1 = "자바";
		String name2 = "자바";
		String name3 = new String("자바");
		
		System.out.println(name1 == name2); //가리키는 객체가 같은지 비교. 번지 비교
		System.out.println(name3 == name1); 
		
		System.out.println(name1.equals(name2)); // 각 객체의 내부 문자열(값, 데이터) 비교 
		System.out.println(name1.equals(name3)); 

	}

}
