package ch09.exam04;

public class Example {

	public static void main(String[] args) {
		A a =  new A();
		A.B b = a.new B();
		b.field1 = 10;
		b.method1();
	}

}
