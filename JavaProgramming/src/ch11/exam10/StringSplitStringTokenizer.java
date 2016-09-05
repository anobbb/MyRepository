package ch11.exam10;

import java.util.StringTokenizer;

public class StringSplitStringTokenizer {
	public static void main(String[] args){
		String data = "홍길동,이수홍,박연수,감자바,최명호";
		
		String[] dataArray = data.split(",");
		System.out.println(dataArray.length);
		for(String name : dataArray){
			System.out.println(name);
		}
		
		StringTokenizer st = new StringTokenizer(data, ",");
		System.out.println(st.countTokens());
		while(st.hasMoreTokens()){ //다음토큰이 있냐고 묻는 것이기 때문에 무한루프
			String name = st.nextToken(); //있으면 가져오기, 무한루프 해제됨
			System.out.println(name);
		}
		
		data = "홍길동&이수홍,박연수,감자바-최명호";
		dataArray = data.split("&|,|-");
		System.out.println(dataArray.length);
		for(String name : dataArray){
			System.out.println(name);
		}
	}

}
