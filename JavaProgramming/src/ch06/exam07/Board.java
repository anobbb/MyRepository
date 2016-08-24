package ch06.exam07;

public class Board {
	//Field
	int bno;
	String title;
	String content;
	String writter;
	int hitcount;
	
	Board() {}
	Board(int no){
		//this는 객체 자신
		//마지막 생성자 호출
		
		//int b = 10; 불가능
		
		//초기화 코드 중복을 방지하기 위해서 사용
		//제일 첫 줄에 작성
		this(no, null, null, null, 0); 
		int b = 10; //생성자 호출 후 다른 코드 생성 가능
	}
	Board(int no, String title){
		this(no, title, null, null, 0);
	}
	Board(String title, int no){
		this(no, title, null, null, 0);
	}
	Board(int no, String title, String content){
		this(no, title, content, null, 0);
	}
	Board(int no, String title, String content, String writter){
		this(no, title, content, writter, 0);
	}
	Board(int no, String title, String content, String writter, int hitcount){
		this.bno = no;
		this.title = title;
		this.content = content;
		this.writter = writter;
		this.hitcount = hitcount;
	}
	
	//Method

}
