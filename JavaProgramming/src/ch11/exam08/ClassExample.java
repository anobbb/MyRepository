package ch11.exam08;

public class ClassExample {
	public static void main(String[] args) throws ClassNotFoundException{
		//Class classCar = Car.class;
		                  //Class의 정적 메소드
		//Class classCar = Class.forName("ch11.exam08.Car");//로딩안돼도 상관없음
		
		Car car = new Car();
		Class classCar = car.getClass();
		
		System.out.println(classCar.getName());
		System.out.println(classCar);
		System.out.println(classCar.getPackage()); //package 객체
		System.out.println(classCar.getPackage().getName()); //package 객체의 메소드
	}

}
