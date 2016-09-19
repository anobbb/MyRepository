package ch15.exam02;

public class Member {
	private String name;
	private int age;
	
	public Member(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	@Override
	public int hashCode() {
		return name.hashCode() + age;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member){
			Member target = (Member) obj;
			if(name.equals(target.name) && age == target.age){
				return true;
			} else{
				return false;
			}
		} else{
			return false;
		}
	}
}
