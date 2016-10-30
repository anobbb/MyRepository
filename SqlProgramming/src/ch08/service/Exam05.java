package ch08.service;

import ch08.dao.BoardDao;
import ch08.dto.Board;

public class Exam05 {
	public static void main(String[] args){
		BoardDao dao = new BoardDao();
		
		Board board = new Board();
		
		board.setBno(5);
		board.setBtitle("제목5-1");
		board.setBcontent("내용5-1");
		
		dao.update(board);
		
	}

}
