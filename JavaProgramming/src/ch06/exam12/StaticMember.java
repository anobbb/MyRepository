package ch06.exam12;

public class StaticMember {
	//Static Field
	static String field;
	
	//Static Block
	//메소드 영역에 로딩된 후 클래스가 처음 사용될 때
	//= main에서 StaticMember.field="자바"가 실행될 때
	//static 변수 초기화
	static{
		System.out.println("Static Block 실행");
		field = "자바";
	}
	
	//Static Method
	static void method(){
		
	}
}
