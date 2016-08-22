package ch05.exam02;

public class ArrayInArray2 {
	public static void main(String[] args) {
		int[][] scores = new int[2][];
		
		scores[0] = new int[2];
		scores[1] = new int[3];
		
		System.out.println(scores.length);
		System.out.println(scores[0].length);
		System.out.println(scores[1].length);
		
		for(int i1=0; i1<scores.length; i1++){ 
			for(int i2=0; i2<scores[i1].length; i2++){
				System.out.println(scores[i1][i2]);
			}
		}
		
	}

}
