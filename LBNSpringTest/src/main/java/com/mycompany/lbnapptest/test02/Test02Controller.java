package com.mycompany.lbnapptest.test02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/test02")
public class Test02Controller {
	private static final Logger logger = LoggerFactory.getLogger(Test02Controller.class);
	
	@RequestMapping("/index")
	public String index(){
		logger.info("index 요청 처리");
		return "test02/index";
	}
	
	@RequestMapping("/join")
	public String join(Member member){
		logger.info("join 요청 처리");
		logger.info("mid: " + member.getMid());
		logger.info("mpassword: " + member.getMpassword());
		logger.info("mage: " + member.getMage());
		return "test02/index";
	}
	
	@RequestMapping("/login")
	public String login(
			@RequestParam("id") String mid, 
			@RequestParam("password") String mpassword){
		logger.info("login 요청 처리");
		logger.info("mid: " + mid);
		logger.info("mpassword: " + mpassword);
		return "test02/index";
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
		return "test02/index";
	}
	
	
	
	
	
	
	
}
