package ch11.exam14;

import java.util.Random;

public class RandomExample {

	public static void main(String[] args) {
		Random r1 = new Random();
		
		Random r2 = new Random(3);
		Random r3 = new Random(3);
		
		System.out.println(r1.nextInt());
		
		System.out.println(r2.nextInt());
		System.out.println(r3.nextInt());
		
		//주사위 번호
		int num = r1.nextInt(6) + 1; 
		System.out.println(num);
	}

}
