package com.mycompany.myapp.exam08;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam08")
public class Exam08Controller {
	private static final Logger logger = LoggerFactory.getLogger(Exam08Controller.class);
	
	@RequestMapping("/index")
	public String index(){
		logger.info("index 처리");
		return "exam08/index"; //뷰이름
	}
	
	@RequestMapping("/join")
	public String join(){
		logger.info("join 처리");
		return "redirect:/exam08/index"; //요청경로, 주소가 바뀌는 이유
	}
	
	@RequestMapping("/write")
	public String write(){
		logger.info("write 처리");
		return "redirect:/exam08/list"; //요청경로
	}
	
	@RequestMapping("/list")
	public String list(){
		logger.info("list 처리");
		return "exam08/list"; //뷰이름
	}
}
