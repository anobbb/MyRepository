package ch13.exam06;

public class CompareMethodExample2 {
	public static void main(String[] args){
		//메소드 호출 방법
		//Util.compare(new Pair<String, String>("name", "홍길동"), new Pair<String, String>("name", "김가을"));
		
		//pair가 제네릭 타입
		Pair<String, String> p1 = new Pair<String, String>("name", "홍길동");
		Pair<String, String> p2 = new Pair<String, String>("name", "김가을");
		boolean result = Util.compare(p1, p2); //max는 무조건 p2를 리턴하게 만들기
				
		Pair<String, Integer> p3 = new Pair<String, Integer>("name", 10);
		Pair<String, Integer> p4 = new Pair<String, Integer>("name", 10);
		Pair<String, Integer> result2 = Util.max(p3, p4);
		System.out.println(result2);
	}

}
