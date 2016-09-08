package ch13.exam05;

//클래스 선언, 선언할 때에는 T 타입이라는 것을 알고 있음.
public class Box<T> {
	private T item; //명시적으로 선언된 타입으로 자동 변환되어 getter, setter에서 처리됨

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}
}
