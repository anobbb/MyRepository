package ch13.exam06;

public class Util {
	public static <K, V> boolean compare(Pair <K, V> p1, Pair <K, V> p2){
		boolean keyCompare = p1.getKey().equals(p2.getKey());
		boolean valueCompare = p1.getValue().equals(p2.getValue());
		return keyCompare && valueCompare;
	}
	
	//CompareMethodExample2	
	///컴파일러가 제네릭 메소드 타입 언급 해석 / Pair type으로 반환/ 
	public static <K, V> Pair/*<K, V>*/ max(Pair<K, V> p1, Pair<K, V> p2){
								//Pair<String, String> p1, Pair<String, Integer> p2 등등 형식 제약 안 받게 하게 위해
		return p2;
	}
}
