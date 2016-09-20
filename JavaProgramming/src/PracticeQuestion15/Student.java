package PracticeQuestion15;

public class Student {
	public int studentNum;
	public String name;
	
	public Student(int studentNum, String name){
		this.studentNum = studentNum;
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		return studentNum; 
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student){
			Student target = (Student)obj;
			if(studentNum == target.studentNum){
				return true;
			} else {
				return false;
			}
		} else{
			return false;
		}
		
	}
}
