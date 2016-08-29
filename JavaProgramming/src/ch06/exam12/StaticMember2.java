package ch06.exam12;

public class StaticMember2 {
	//Static Field
	static String field;
	String field2; //instance field
	
	//Static Block
	static{
		System.out.println("Static Block 실행");
		field = "자바";
		//field2 = "자바"; <- 객체가 없어서 불가능
	}
	
	//Static Method -> 객체없어도 실행가능
	static void method(){
		field = "자바";
		//field2 = "자바"; <- 객체가 없어서 불가능
	}
	void method2(){ //instance method에서는 객체멤버 실행가능
		field = "자바";
		field2 = "자바";
	}
	
	//클래스 멤버에 속하지 않는다. JVM에 의해 호출되는 메소드이기 때문에.
	public static void main(String[] args){
		field = "자바";
		//field2 = "자바"; // <- main method도 static이기 때문에 instance method 실행불가 
		
		method();
		//method2();
		
		//자기 자신의 객체를 만들어 사용할 수 밖에 없음.
		StaticMember2 sm = new StaticMember2();
		sm.field2 = "자바";
		sm.method2();
	}
}
