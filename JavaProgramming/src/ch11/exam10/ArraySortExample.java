package ch11.exam10;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArraySortExample {

	public static void main(String[] args) {
		int[] scores = {99, 97, 98};
		Arrays.sort(scores);
		System.out.println(Arrays.toString(scores));
		
		Member2[] members = {
		new Member2("홍길동", 99),
		new Member2("박동수", 97),
		new Member2("김민수", 98)
		};
		Arrays.sort(members);
		System.out.println(Arrays.toString(members));
	}
}

class Member2 implements Comparable{
	String name;
	int score;
	Member2(String name, int score){
		this.name = name;
		this.score = score;
	}
	
	@Override
	public int compareTo(Object o) {
		System.out.println("compareTo");
		Member2 target = (Member2) o;
		/*//return name.compareTo(target.name); 오름차순
		return target.name.compareTo(name); // 내림차순*/
		return score-target.score; //점수 낮은 수 대로 정렬
	}
	
	@Override
	public String toString() {
		return name;
	}
}
