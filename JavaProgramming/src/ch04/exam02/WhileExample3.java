package ch04.exam02;

public class WhileExample3 {

	public static void main(String[] args) throws Exception {
		while(true){
			int num = System.in.read();
			
			if(num != 13 && num != 10){
				System.out.println(num);
			}			
			/*if(num != 13){
			if(num != 10){
				System.out.println(num);
				//enter key number : 13, 10 (two number) 케리지 리턴(13), 리턴피드(10)
			}*/
			
		}
	}
		

}
