package ch11.exam01;

public class Board {
	private int bno;
	private String title;
	private String content;
	
	public Board(int bno, String title, String content) {
		this.bno = bno;
		this.title = title;
		this.content = content;
	}
	
	//ctrl + space
	@Override
	public boolean equals(Object obj) {
		//board 객체가 들어왔는지 검사
		if(obj instanceof Board){
			Board target = (Board)obj; //강제타입변환
			if(bno == target.bno){ //b2의 bno, int와 int의 비교
				return true;
			}
		}
		return false;
	}

}
