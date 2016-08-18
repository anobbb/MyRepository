package ch02.exam02;

public class OperationPromotion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int v1 = 10 + 20;
		System.out.println("v1: " + v1);
		
		byte v2 = 10;
		byte v3 = 20;
		int v4 = v2 + v3;
		//byte v5 = v2 + v3;
		System.out.println("v4: " + v4);
		
		char v6 = 'A';
		//char v7 = v6 + 1; //v6과 1이 모두 int이므로
		// char v7 = (char)(v6 + 1);
		int v7 = v6 + 1;
		char v8 = (char)v7;
		System.out.println("v8: " + v8);

	}

}
