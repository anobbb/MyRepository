package ch04.exam02;

public class ForExample {

	public static void main(String[] args) {
		int sum = 0;

		for(int i=0; i<3; i++){
			int num = (int)(Math.random()*6) + 1;
			System.out.println(num);
			
			sum += num;
			
		}
		
		System.out.println("총 합: " + sum);
		System.out.println("평균: " + sum / 3.0);
		
		//System.out.println(sum); //만약 for문에 조건식이나 증감식 지정이 안 되면(자동 true로 간주,무한루프) 에러

	}

}
