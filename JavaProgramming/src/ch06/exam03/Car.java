package ch06.exam03;

//설계도일 뿐, 객체가 아님
public class Car {
	//Field
	String company = "현대자동차";
	
	//Constructor
	Car(){
		// 설계도 상에서 없는 내용을 설계도를 가지고 객체를 만들 때 결정되는 몇 가지를 생성자에서 한다.
		// Car의 색상 등등
		System.out.println("Car() 실행됨");
		//Integer.parseInt("a");
	}
	
	//Method
	void run(){
		System.out.println("run() 실행됨");
	}
	

}
