package ch07.exam12;

public class Example {
	public static void main(String[] args) {
		Theater cgv = new Theater();
		
		Adult a =new Adult();
		a.ssn="123456-1234567";
		Student s =new Student();
		s.sno="2016030105";
		
		cgv.check(a);
		cgv.check(s);
	}

}
