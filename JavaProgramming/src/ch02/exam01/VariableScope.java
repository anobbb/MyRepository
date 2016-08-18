package ch02.exam01;

public class VariableScope {
	public static void main(String[] args) {
		int var1 = 10;
		System.out.println("var1: " + var1);
		
		if(true) {
			int var2 = 15;
			System.out.println("var1: " + var1);
			System.out.println("var2: " + var2);
			if(true) {
				int var3 = 20;
				System.out.println("var1: " + var1);
				System.out.println("var2: " + var2);
				System.out.println("var3: " + var3);
			}
			System.out.println("var1: " + var1);
			System.out.println("var2: " + var2);
			//System.out.println("var3: " + var3);
		}
		
		System.out.println("var1: " + var1);
		//System.out.println("var2: " + var2);
	}
}
