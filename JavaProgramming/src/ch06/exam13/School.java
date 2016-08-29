package ch06.exam13;

public class School {
	//Field
	private static School singleton = new School();	
	
	//Constructor
	private School(){
	}
	
	//Method
	static School getInstance(){
		return singleton;
	}
}
