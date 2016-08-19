package ch05.exam02;

public class ArrayCreateByNew {

	public static void main(String[] args) {
		int[] arr1 = new int[5];
		for(int i=0; i<arr1.length; i++) {
			System.out.println("arr1[" + i + "] = " + arr1[i]);
		}
		
		
		double[] arr2 = new double[5];
		for(int i=0; i<arr2.length; i++) {
			System.out.println("arr2[" + i + "] = " + arr2[i]);		
		}
			

		boolean[] arr3 = new boolean[5];
		for(int i=0; i<arr3.length; i++) {
			System.out.println("arr3[" + i + "] = " + arr3[i]);		
		}
		
		String[] arr4 = new String[5];
		for(int i=0; i<arr4.length; i++) {
			System.out.println("arr4[" + i + "] = " + arr4[i]);		
		}
		
	}

}
