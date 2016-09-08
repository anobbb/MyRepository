package ch13.exam04;

//제네릭 인터페이스를 구현한 제네릭 클래스
public class HashMap<K, V> implements Map<K, V>{ 
	private K k; 
	private V v;
	
	@Override
	public void add(K k, V v) {
		this.k = k;
		this.v = v;
		
	}
	
	@Override
	public V get(K k) {
		if(this.k == k){ //같은 객체인지?
			return v;
		}
		return null;
	}

}
