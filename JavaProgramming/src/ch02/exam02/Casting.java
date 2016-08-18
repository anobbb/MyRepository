package ch02.exam02;

public class Casting {
	public static void main(String[] args){
		long v1 = 300;
		int v2 = (int)v1;
		System.out.println("v2: " + v2);
		
		byte v3 = (byte)v1; // -128~127까지 표현 가능함
		System.out.println("v3: " + v3);
		
		char v5 = '한';
		int v6 = 'A';
		int v7 = '한';
		System.out.println("v5: " + v5);
		System.out.println("v6: " + v6);
		System.out.println("v7: " + v7);
		
		int v8 = 65;
		char v9 = (char)v8; // 문법적으로는 이상이 없지만 char는 약간 예외
		System.out.println("v9: " + v9);
		
		char v10 = 66;
		System.out.println("v10: " + v10);
	}
	
}
