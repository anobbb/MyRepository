package ch02.exam02;

//자동타입변환
public class Promotion {
	public static void main(String[] args){
		byte v1 = 100;
		int v2 = v1;
		long v3 = v2;
		System.out.println("v3: " + v3);
				
		float v4 = v3;
		double v5 = v3;
		System.out.println("v4: " + v4);
	}

}
