package ch11.exam11;

import java.util.Arrays;

public class ArraySortExample {
	
	public static void main(String[] args){
		Board[] boardArr = {
				new Board(3, "오늘은 화요일"), 
				new Board(1, "다음주는 추석"),
				new Board(5, "과제가 있을까?") //게시물 번호대로 내림차순으로 정렬
		};
		
		//error: 자동 comparable interface create, compareTo() method 재정의 필요
		Arrays.sort(boardArr); 
		System.out.println(Arrays.toString(boardArr)); //배열 항목의 대표 문자들 출력
		
	}//main

}//class
