package ch09.exam06;

public class A {
	int field1 = 10;
	int field = 10;
	/*C C = new C();
	
	class C{} // 클래스 내에서의 필드나 생성자 등의 선언순서 상관없음
*/	
	public void method(){
		//로컬변수를 로컬클래스에서 쓰려면 final 의미를 갖게 되어서 자바7버전에서는final선언해야함, 값 변경 불가
		final int local = 10; 
		//B b = new B(); // but, method안에서는 실행 순서 중요
		//field1 = 5; <-실행문 불가능
		//int field2 = 5; <-선언과 동시에 실행이니까 가능
		class B {
			//final을 안 붙이면 여기에 B의 필드로 final 변수 복사됨.
			void method(){ 
				//final이 붙으면 컴파일 시에 이 method 안에 int local을 복사해서 갖다 놓음.
				field = 5;
				field1 = 5;
				//local = 5;
				int result = local + field; //정확히 말하면 복사해놓은 final 변수를 씀.
			}
		}
		B b = new B();
	}
}
