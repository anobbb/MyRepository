package ch07.exam06.pack1;

public class B {
	//선언만 가능, 필드선언, 생성자 선언, 메소드 선언
	
	//Field
	A a = new A(); //필드선언과 동시에 초기값 설정은 가능
	
	/*A a; <-선언문
	a = new A(); <-실행문*/
	
	//Constructor
	B(){
		A a = new A(); //local변수
		a.field = 10;
		a.method();
	}
	
	//Method
	void method(){
		A a = new A(); //local변수
		a.field = 10;
		a.method();
	}
}
