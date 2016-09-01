package ch09.exam04;

public class A {
	int field;
	//static B b = new B();
	
	/*public A(int field){
		this.field = field;
		B b = new B();
	}*/
	
	public A(){ //생성자가 끝나야 객체 생성이 가능, A블록끝나야 A객체 생성준비가 끝나는 것이 아님.
		B b = new B(); //A 객체 생성 준비가 끝났으므로 B객체 생성 준비 가능
	}
	
	void method(){
		B b = new B();
	}
	
	static void method2(){
		//B b = new B();
	}
	
	public class B {
		int field1;
		void method1(){}	
	}
}
