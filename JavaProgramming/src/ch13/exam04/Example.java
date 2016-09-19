package ch13.exam04;

import java.util.Date;

public class Example {
	public static void main(String[] args){
		// cf) 명시적 type을 지정하지 않으면 object type으로 들어감. 
		//but, 제네릭 사용의 의미가 없어짐
		Map<String, Date> map = new HashMap<>(); 
		map.add("입학식", new Date());
		
		Date date = map.get("입학식");
	}
}
