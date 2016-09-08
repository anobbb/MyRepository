package ch13.exam05;

import java.util.Date;

public class Util {
	//클래스 선언이 아닌 Box클래스가 T타입을 리턴한다는 의미
	//사용할 때에는 구체적 타입 명시를 해야하기 때문에 Box앞에 명확하게 타입<T>를 써야 함
	//제네릭 타입의 파라메터를 쓰겠다고 인식, 컴파일러가 따로 T를 안 찾아도 되게끔 Box 앞에 씀
	public static <T> Box<T> boxing(T t){
		Box<T> box = new Box<T>();
		box.setItem(t);
		return box;
	}
	
	/*public static Box<String> boxing(String t){
		Box<String> box = new Box<String>();
		box.setItem(t);
		return box;
	}
	
	public static Box<Date> boxing(Date t){
		Box<Date> box = new Box<Date>();
		box.setItem(t);
		return box;
	}
	
	public static Box<Integer> boxing(Integer t){
		Box<Integer> box = new Box<Integer>();
		box.setItem(t);
		return box;
	}*/
}
