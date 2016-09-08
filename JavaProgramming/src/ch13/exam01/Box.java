package ch13.exam01;

public class Box {
	private Object item; //모든 타입의 객체를 Object저장하겠다!

	public Object getItem() { //Object type으로 리턴
		return item;
	}

	public void setItem(Object item) { //Object type으로 박싱되어서 Integer객체가 가지는 번지 대입
		this.item = item;
	}
	
	
}
