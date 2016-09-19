package ch15.exam02;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample2 {
	public static void main(String[] args){
		Set<Member> set = new HashSet<>();
		
		//new로 객체 생성했으므로 다른 객체
		Member m1 = new Member("홍길동", 25);
		Member m2 = new Member("홍길동", 25);
		System.out.println(m1 == m2); //번지 비교	
		System.out.println(m1.hashCode() == m2.hashCode());
		System.out.println(m1.equals(m2)); // 오버라이딩하지 않은 object의 equals는 ==과 같음.
		
		set.add(m1);
		set.add(m2);
		System.out.println(set.size());
		
	}
}
