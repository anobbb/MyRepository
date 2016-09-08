package ch13.exam09;

public class WhildCardExample {
	public static void registerCourse1(Course<?> course) {}
	public static void registerCourse2(Course<? extends Student> course) {}
	public static void registerCourse3(Course<? super Worker> course) {}

	public static void main(String[] args){
		Course<Person> c1 = new Course<Person>("일반인과정", 5);
		registerCourse1(c1);
		//registerCourse2(c1); (x)
		registerCourse3(c1);
		
		Course<Worker> c2 = new Course<Worker>("직장인과정", 5);
		registerCourse1(c2);
		//registerCourse2(c2); (x)
		registerCourse3(c2);
		
		Course<Student> c3 = new Course<Student>("학생과정", 5);
		registerCourse1(c3);
		registerCourse2(c3);
		//registerCourse3(c3); (x)
		
		Course<HighStudent> c4 = new Course<HighStudent>("고등학생과정", 5);
		registerCourse1(c4);
		registerCourse2(c4);
		//registerCourse3(c4);(x)
	}

}
