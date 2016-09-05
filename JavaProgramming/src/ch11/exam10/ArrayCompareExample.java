package ch11.exam10;

import java.util.Arrays;

public class ArrayCompareExample {

	public static void main(String[] args) {
		int[] arr1 = {1, 2, 3};
		int[] arr2 = {1, 2, 3};
		
		System.out.println(arr1 == arr2);
		System.out.println(Arrays.equals(arr1, arr2));
		
		int[][] arr3 = { {1, 2}, {3, 4}};
		int[][] arr4 = { {1, 2}, {3, 4}};
		
		System.out.println(arr3 == arr4);
		System.out.println(Arrays.equals(arr3, arr4));
		System.out.println(Arrays.deepEquals(arr3, arr4));
	}
}
