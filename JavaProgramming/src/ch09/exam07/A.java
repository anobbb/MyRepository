package ch09.exam07;

public class A {
	int field;
	
	public void method(){
		//this.field = 2;
		class B {
			int field = 10; 
			
			B(){	
				field = 20;
				this.field = 30;
				A.this.field = 40;
			}
		}
		B b = new B();
		System.out.println("B의 필드: " + b.field);
		System.out.println("A의 필드: " + field);
	}
}
