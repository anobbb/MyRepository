package ch13.exam01;

import java.util.Date;

public class BoxExample {
	public static void main(String[] args){
		Box box1 = new Box();
		box1.setItem("홍길동");
		String name = (String)box1.getItem();
		
		Box box2 = new Box();
		box2.setItem(10); //Integer로 자동 박싱
		int value = (Integer)box2.getItem(); 
				
		Box box3 = new Box();
		box3.setItem(new Date());
		String now = (String)box3.getItem(); //class cast exception 발생, String과 date는 관계가 없어서 타입변환X
	}
}
