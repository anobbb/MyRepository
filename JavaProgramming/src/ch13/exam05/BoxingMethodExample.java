package ch13.exam05;

import java.util.Date;

public class BoxingMethodExample {
	public static void main(String[] args){
		Box<Integer> box1 = Util.boxing(new Integer(30));
		//static type의 메소드이므로 클래스명.메소드명 으로 접근 가능
		
		Box<Date> box2 = Util.boxing(new Date());
		
		Box<String> box3 = Util.boxing("Tv");
	}

}
