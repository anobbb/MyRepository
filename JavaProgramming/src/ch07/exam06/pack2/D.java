package ch07.exam06.pack2;

import ch07.exam06.pack1.A;

public class D extends A {
	//Field
	//A a = new A();
	
	//Constructor
	D(){
		/*A a = new A(); //상속과 관련없음
		a.field = 5;
		a.method();*/
		super(); // 부모생성자 허용
		field = 5; //상속과 관련있음
		method();
	}
	
	//Method
	void method2(){
		
	}
}
