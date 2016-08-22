package ch05.exam02;

public class AdvancedFor {
	public static void main(String[] args) {
		int[] scores = { 90, 92, 95 };
		
		int sum = 0;
		for(int i=0; i<scores.length; i++){
			sum += scores[i];
		}
		System.out.println(sum);
		
		sum = 0;
		//score에 대입 : scores = 배열의 항목 수를 앞에서부터 하나씩
		for(int score : scores){
			sum += score;
		}
		System.out.println(sum);

		String[] names = {"자바", "C언어", "파이썬" };
		
		for(int i=0; i<names.length; i++){
			System.out.println(names[i]);
		}
		
		for(String name : names){
			System.out.println(name);
		}
	}
	

}
