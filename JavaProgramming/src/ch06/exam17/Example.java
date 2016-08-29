package ch06.exam17;

public class Example {
	public static void main(String[] args) {
		Member m1 = new Member("angel");
		//System.out.println(m1.mid);
		System.out.println(m1.getMid()); // m1.mid="white" 등의 변경 방지, only read
		
		//m1.height = -100.0;
		m1.setMheight(-100.0);
		
		//값 변경하는 것만 방지하려면 setter 메소드를 안 만들면 됨
	}
}
