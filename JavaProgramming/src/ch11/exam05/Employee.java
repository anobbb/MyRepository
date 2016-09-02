package ch11.exam05;

public class Employee {
	private int eno;
	
	public Employee(int eno){
		this.eno = eno;
		System.out.println("Employee(" + eno + ")가 메모리에 생성됨");
	}
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Employee(" + eno + ")가 메모리에 제거됨");
	}
}
