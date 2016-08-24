package ch06.exam04;

public class Person {
	//Field
	String name;
	String sex;
	int age;
	double height;
	boolean married;
	
	//Constructor
	Person(String name, String sex, int age, double height){
		//n의 값을 매개 값으로 넣자
		//필드 값을 초기화		
		
		this.name = name;
		//this없는 좌변의 name은 생성자의 매개변수의 name을 의미함. 
		//가장 가까운 변수를 따라감
		//this.name이라고 쓰면 내가 가지고 있는 field의 name을 가리킴
		
		this.sex = sex;
		this.age = age;
		this.height = height;
	}
	
	//Method
}
