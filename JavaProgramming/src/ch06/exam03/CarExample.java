package ch06.exam03;

public class CarExample {

	public static void main(String[] args) {
		//Car 변수 선언
		//main method안에서 선언되면 변수
		Car myCar = null; // 아직 객체를 참조하고 있지 않다
		//생성자의 블록을 실행, 에러생성하면 객체 만들다가 에러발생하는 것-> 객체 생성 안 됨.
		try {
			myCar = new Car(); //생성자를 이용하여 *Car 객체를 생성*하고 위치 정보 얻기
		} catch(Exception e){}
			//Car 객체가 있는지 조사
		if(myCar != null){
			System.out.println("Car 객체 있음");
		} else{
			System.out.println("Car 객체 없음");
		}
		
		// 객체 내부의 필드값을 읽어보자.
		System.out.println(myCar.company);
		// 객체 내부의 필드값을 변경해보자.
		myCar.company = "KOSA";
		System.out.println(myCar.company);
		
		// 객체 내부의 메소드를 호출해보자.
		myCar.run();
	}

}
