package ch11.exam13;

public class BoxingUnBoxingExample {
	public static void main(String[] args){
		Integer obj = 100; //Boxing
		
		int value = obj; //Unboxing
		System.out.println(value);
		
		int result = obj + 200;
		System.out.println(value);
		
	}

}
