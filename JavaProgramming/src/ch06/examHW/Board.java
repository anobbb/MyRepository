package ch06.examHW;

public class Board {
	
	//Field
	int no;
	String title;
	String content;
	String writer;
	int view;
	
	//Constructor
	Board(){
	}
	Board(int no, String title, String content, String writer, int view){
		this.no = no;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.view = view;
	}
	
}
