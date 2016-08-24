package ch06.exam12;

public class Example {

	public static void main(String[] args) {
		//Instance Member 사용
		InstanceMember im = new InstanceMember();
		System.out.println(im.field);
		im.method(); //im 변수가 접근하는 객체 안의 메소드를 호출한다
		
		//Static Member 사용
		//StaticMember.field = "자바";
		
		System.out.println(StaticMember.field);
		StaticMember.method();
		//StaticMember sm = new StaticMember();
		
		//적재되는 기준: StaticMember가 적재돼야 함. 클래스가 사용되어야 함
		//즉, 필드를 사용하거나 생성자 호출, 메소드 호출(실행) 등을 사용하는 시점
	}

}
