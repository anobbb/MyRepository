package ch07.exam03;

public class Robot extends Machine{
	@Override // 이 어노테이션을 메소드에 적용한다.
	//컴파일러가 검사해줌
	public void work() {
		System.out.println("Robot-work() 실행");
	}
}
