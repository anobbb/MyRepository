package ch11.exam11;

public class Board implements Comparable {
	private int bno;
	private String title;
	
	public Board(int bno, String title) {
		super();
		this.bno = bno;
		this.title = title;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getTitle() {
		
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public String toString() {
		return bno + ":" + title; 
	}

	@Override
	public int compareTo(Object o) {
		Board target = (Board)o;
		return target.bno - bno; // 현재의 보드 객체는 뒤로 감
	}
	
}//Board
