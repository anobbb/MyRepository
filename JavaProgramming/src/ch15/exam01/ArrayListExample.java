package ch15.exam01;

import java.util.LinkedList;
import java.util.List;

public class ArrayListExample {
	public static void main(String[] args){
		//모든 객체의 타입이 object이므로 모든 객체 상속 가능
		//List<Object> list = new ArrayList<Object>();
		
		//List 계열의 컬렉션 생성
		//List<String> list = new ArrayList<String>();
		//List<String> list = new Vector<>();
		List<String> list = new LinkedList<>();
		
		//객체 저장
		list.add("Java");
		list.add("JDBC");
		list.add("Servlet/JSP");
		list.add(2, "Database");
		list.add("iBatis");
		
		//저장된 객체 수 얻기
		int size = list.size();
		System.out.println("총 객체 수: " + size);
		System.out.println();
				
		//객체 찾기
		String skill = list.get(2);
		System.out.println("2: " + skill);
		System.out.println();
		
		//전체 객체를 일괄 처리
		for(int i = 0; i<list.size(); i++){
			String str = list.get(i);
			System.out.println(i + ": " + str);
		}
		System.out.println();
		
		//저장될 타입의 변수 : 배열, Iterable인터페이스로 구현된 객체들
		for(String str : list ){
			System.out.println(str);
		}
		System.out.println();
		
		//객체 삭제
		list.remove(2);
		list.remove(2);
		list.remove(new String("iBatis"));
		System.out.println(list.size());
	}
}
