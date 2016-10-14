package com.mycompany.lbnapptest.test11.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mycompany.lbnapptest.test11.dto.Board;

@Component
public class Test11BoardDao {
	private static final Logger logger = LoggerFactory.getLogger(Test11BoardDao.class);
	
	public void insert(Board board){
		logger.info("insert 처리");
		logger.info("bwriter: " + board.getBwriter());
		logger.info("btitle: " + board.getBtitle());
		logger.info("bcontent: " + board.getBcontent());
	}
	
	public List<Board> selectList(){
		logger.info("select 처리");
		List<Board> list = new ArrayList<>();
		for(int i=1; i<=10; i++){
			Board board = new Board();
			board.setBtitle("제목" + i);
			board.setBcontent("내용" + i);
			board.setBwriter("글쓴이" + i);
			list.add(board);
		}
		return list;
	}
	
	public Board selectBoard(int bno){
		logger.info("selectBoard 처리");
		Board board = new Board();
		board.setBwriter("슈퍼맨");
		board.setBtitle("하드코딩");
		board.setBcontent("타이핑말구 코딩코딩");
		return board;
	}
	
	public void update(Board board){
		logger.info("update 처리");
	}
	
	public void delete(){
		logger.info("delete 처리");
	}

}
