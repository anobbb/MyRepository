package ch13.exam02;

public class Box<T> {
	private T item; //명시적으로 선언된 타입으로 자동 변환되어 getter, setter에서 처리됨

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}
}
