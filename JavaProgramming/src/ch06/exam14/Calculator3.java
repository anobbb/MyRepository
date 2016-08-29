package ch06.exam14;

public class Calculator3 {
	//Field
	//instance field
	final int FIELD2; //주민등록번호, 학번, 아이디 등 
	//static field
	
	//Constructor
	Calculator3(int field2){
		this.FIELD2 = field2;
	}
	
	
	//Method
	
	//Main Method
	public static void main(String[] args){
		Calculator3 cal = new Calculator3(5);
		Calculator3 ca2 = new Calculator3(7);
		
	}

}
