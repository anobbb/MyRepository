package ch11.exam12;

public class Member implements Comparable{
	private String name;
	
	public Member(String name){
		this.name = name;
	}
	
	@Override
	public int compareTo(Object o) {
		//타겟이 되는 비교 대상 target 객체
		Member target = (Member) o;
		return name.compareTo(target.name);
	}
}


