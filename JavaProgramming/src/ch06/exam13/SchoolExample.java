package ch06.exam13;

public class SchoolExample {

	public static void main(String[] args) {
		/*School s1 = new School();
		School s2 = new School();*/
		School s1 = School.getInstance();
		School s2 = School.getInstance();
		System.out.println(s1 == s2); 
		
		//School.singleton = null;
		School s3 = School.getInstance();
	}

}
