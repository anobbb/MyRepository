package com.mycompany.myapp.exam02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/exam02")
public class Exam02Controller {
	private static final Logger logger = LoggerFactory.getLogger(Exam02Controller.class);

	@RequestMapping("/index")
	public String index(){
		logger.info("index 요청 처리");
		return "exam02/index";
	}
	
	/*
	@RequestMapping("/join")
	public String join(String mid, String mname, String mage){
		logger.info("join 요청 처리");
		logger.info("mid: " + mid);
		logger.info("mname: " + mname);
		logger.info("mage: " + mage);
		return "exam02/index";
	}
	*/
	
	@RequestMapping("/join")
	public String join(Member member){
		logger.info("join 요청 처리");
		logger.info("mid: " + member.getMid());
		logger.info("mname: " + member.getMname());
		logger.info("mage: " + member.getMage());
		return "exam02/index";
	}
	
	@RequestMapping(value="/login") //value는 기본 속성이라 생략 가능
	public String join(
			@RequestParam(value="id") String mid, 
			@RequestParam("password") String mpassword){
		logger.info("login 요청 처리");
		logger.info("mid: " + mid);
		logger.info("mpassword: " + mpassword);
		return "exam02/index";
	}
	
	@RequestMapping("/order")
	public String order(
			@RequestParam("pid") String id,
			@RequestParam("pname") String name,
			@RequestParam("pprice") String price,
			@RequestParam("pcompany") String company){
		logger.info("order 요청 처리");
		logger.info("pid: " + id);
		logger.info("pname: " + name);
		logger.info("pprice: " + price);
		logger.info("pcompany: " + company);
		return "exam02/index";
	}
	
	@RequestMapping("/write")
	public String writer(@RequestParam(defaultValue="1")int bno, 
			String title, String content, 
			@RequestParam(defaultValue="0")int hitcount){
		logger.info("write 요청 처리");
		logger.info("bno: " + bno);
		logger.info("title: " + title);
		logger.info("content: " + content);
		logger.info("hitcount: " + hitcount);
		return "exam02/index";
	}
	
	@RequestMapping("/update")
	public String update(@RequestParam(defaultValue="1")int bno, 
			String title, String content, 
			@RequestParam(value="count", defaultValue="0")int hitcount){
		logger.info("update 요청 처리");
		logger.info("bno: " + bno);
		logger.info("title: " + title);
		logger.info("content: " + content);
		logger.info("hitcount: " + hitcount);
		return "exam02/index";
	}
	
	@RequestMapping("/send")
	public String update(Board board){
		logger.info("send 요청 처리");
		logger.info("bno: " + board.getBno());
		logger.info("title: " + board.getTitle());
		logger.info("content: " + board.getContent());
		logger.info("hitcount: " + board.getHitcount());
		return "exam02/index";
	}
	
}
