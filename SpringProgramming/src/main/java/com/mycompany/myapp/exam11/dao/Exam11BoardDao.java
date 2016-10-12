package com.mycompany.myapp.exam11.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.exam11.dto.Board;


@Component
public class Exam11BoardDao {
	private static final Logger logger = LoggerFactory.getLogger(Exam11BoardDao.class);
	
	public void insert(Board board){
		logger.info("insert 처리");
		logger.info("bwriter: " + board.getBwriter());
		logger.info("btitle: " + board.getBtitle());
		logger.info("bcontent: " + board.getBcontent());
	}
	
	public List<Board> selectList(){
		List<Board> list = new ArrayList<>();
		for(int i=1; i<=10; i++){
			Board board = new Board();
			board.setBtitle("제목 " + i );
			board.setBcontent("내용 " + i);
			board.setBwriter("글쓴이 " + i);
			list.add(board);
		}
		return list;
	}
}
