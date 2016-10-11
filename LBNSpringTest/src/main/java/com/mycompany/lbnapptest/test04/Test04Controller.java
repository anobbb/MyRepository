package com.mycompany.lbnapptest.test04;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/test04")
public class Test04Controller {
	private static final Logger logger = LoggerFactory.getLogger(Test04Controller.class);
	
	@RequestMapping("/index")
	public String index(){
		logger.info("index 요청 처리");
		return "test04/index";
	}
	
	@RequestMapping(value="/board", method=RequestMethod.GET)
	public String boardform(){
		logger.info("boardForm 요청 처리");
		return "test04/boardform";
	}
	
	@RequestMapping(value="/board", method=RequestMethod.POST)
	public String board(Board board){
		logger.info("board 요청 처리");
		logger.info("btitle: " + board.getBtitle());
		logger.info("btitle: " + board.getBcontent());
		logger.info("btitle: " + board.getBwriter());
		logger.info("btitle: " + board.getBemail());
		return "test04/index";
	}
}
