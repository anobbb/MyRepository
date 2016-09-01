package ch09.exam05;

public class A {
	int field = 10;
	static int field2 = 5;
	
	B b = new B();
	static B b2 = new B();
	
	public A(){
		B b = new B();
	}
	
	static void method(){
		B b = new B();
	}
	
	public static class B {
		void method(){
			//field = 3; //A가 없어도 되는 내용만 들어가야 함
			field2 = 5;
		}
		int field1;
		static int field2;
		void method1(){}
		static void method2(){}
	}
}
