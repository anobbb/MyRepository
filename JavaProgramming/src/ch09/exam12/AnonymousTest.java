package ch09.exam12;

public class AnonymousTest {
	//Field
	
	//인터페이스를 이용한 클래스를 구현하여 인터페이스 객체에 넣어 객체를 생성한다.
	//필드의 초기화
	private RemoteControl rc = new RemoteControl(){};
	
	//Constructor
	public AnonymousTest(){
		RemoteControl rc = new RemoteControl(){};
	}
	
	//Method
	public void method1(RemoteControl rc){
		
	}
	
	public void method2(){
		method1(new RemoteControl(){});
	}

}
