package ch13.exam09;

public class Course<T> {
	private String name;
	private T[] students; //T타입의 배열타입으로 students 필드 생성, 수강생들을 배열 타입으로 선언
	
	public Course(String name, int capacity){
		this.name = name;
		this.students = (T[]) new Object[capacity]; //타입이 결정이 안 된 타입 파라메터의 배열 타입을 Object에서 T타입으로 변환
	}//constructor Course
	
	public String getName(){ return name; }
	public T[] getStudents() { return students;}
	
	public void add(T t){
		for(int i=0; i<students.length; i++){
			if(students[i] == null){ //배열의 null값을 찾아
				students[i] = t; //그 공간에 객체 저장
				break;
			} //if
		}//for
	}//method add
}//class Course
