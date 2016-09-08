package ch13.exam04;

public interface Map<K, V> { //제네릭 인터페이스
	void add(K k, V v);
	V get(K k); //V는 리턴타입
}
 