package ch08.service;

import java.util.Date;

import ch08.dao.BoardDao;
import ch08.dto.Board;

public class Exam04 {
	public static void main(String[] args){
		BoardDao dao = new BoardDao();
		
		Board board = new Board();
		board.setBno(7);
		board.setBtitle("제목7");
		board.setBcontent("내용7");
		board.setBwriter("user3");
		board.setBhitcount(1);
		board.setBdate(new Date());
		
		dao.insert(board);
		
	} // main
} // class
