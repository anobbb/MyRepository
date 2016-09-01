package ch10.exam01;

public class Example4 {

	public static void main(String[] args) {
		try{
		String data1 = args[0];
		String data2 = args[1];
		
		int value1 = Integer.parseInt(data1);
		int value2 = Integer.parseInt(data2);
		}  catch(ArrayIndexOutOfBoundsException | NumberFormatException e){
			System.out.println("입력된 수가 틀리거나 숫자가 아닙니다.");
		}  catch(Exception e){
			System.out.println("예외 처리됨");
		}
	}
}
