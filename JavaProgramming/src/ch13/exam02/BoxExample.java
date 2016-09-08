package ch13.exam02;

import java.util.Date;

public class BoxExample {
	public static void main(String[] args){
		Box<String> box1 = new Box<>(); //앞의 타입을 보고 자동으로 타입 결정, 다이아몬드 연산자
		box1.setItem("홍길동");
		String name = box1.getItem();
		
		Box<Integer> box2 = new Box<>(); //구체적 타입선언 안 하면 컴파일러는 object타입으로 저장
		box2.setItem(10);
		int value = box2.getItem(); 
				
		Box<Date> box3 = new Box<>();
		box3.setItem(new Date());
		Date now = box3.getItem(); 
	}
}
