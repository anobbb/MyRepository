package ch07.exam02;

public class StudentExample {

	public static void main(String[] args) {
		Student student = new Student("슈퍼맨", "123456-1234567", 1);
		System.out.println("name: " + student.name);
		System.out.println("ssn: " + student.ssn);
		System.out.println("studentNo: " + student.studentNo);
	}
}
