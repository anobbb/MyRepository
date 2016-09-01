package ch09.exam06;

public class A {
	int field1 = 10;
	
	/*C C = new C();
	
	class C{} // 클래스 내에서의 필드나 생성자 등의 선언순서 상관없음
*/	
	public void method(){
		//B b = new B(); // but, method안에서는 실행 순서 중요
		//field1 = 5; <-실행문 불가능
		//int field2 = 5; <-선언과 동시에 실행이니까 가능
		class B {
			void method(){
				field1 = 5;
			}
		}
		B b = new B();
	}
}
