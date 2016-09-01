package ch10.exam02;

public class Calculator {
	public static int sum(String x, String y) throws NumberFormatException {

		int v1 = Integer.parseInt(x);
		int v2 = Integer.parseInt(y);
		int result = v1 + v2;
		return result;

	}

}
