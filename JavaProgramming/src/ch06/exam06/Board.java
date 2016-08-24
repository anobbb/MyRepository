package ch06.exam06;

public class Board {
	//Field
	int bno;
	String title;
	String content;
	String writer;
	int hitcount;
	
	//Constructor Overloading
	//1. 매개변수의 수가 달라야 한다.
	//2. 매해변수의 타입이 달라야 한다
	Board() {}
	Board(int no){}
	//Board(int hitcount){} 생성자 오버로딩 불가(매개변수의 타입, 수가 같아서)
	Board(int no, String title){}
	Board(String title, int no){}
	Board(int no, String title, String content){}
	Board(int no, String title, String content, String writter){}
	Board(int no, String title, String content, String writter, int hitcount){}
	
	//Method

}
