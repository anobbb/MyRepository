package ch05.exam02;

public class ArrayCreateByValueList2 {

	public static void main(String[] args) {
		int[] scores = { 83, 90, 87 };
		
		System.out.println(scores[0]);
		System.out.println(scores[1]);
		System.out.println(scores[2]);
		//System.out.println(scores[3]);
		
		//scores가 가리키는 객체에 접근하여 length라는 필드값을 읽어서 변수에 대입
		int arrayLength = scores.length; 
		System.out.println("배열의 길이: " + arrayLength);
		
		for(int i=0; i<scores.length; i++){
			System.out.println(scores[i]);
		}
		
		int sum = 0;
		for(int i=0; i<scores.length; i++){
			sum += scores[i];
		}
		System.out.println("전체 합: " + sum);	
		double avg = (double)sum / scores.length;
		// double avg = 1.0 * sum / scores.length;
		System.out.println("평균: " + avg);
	} 

}
