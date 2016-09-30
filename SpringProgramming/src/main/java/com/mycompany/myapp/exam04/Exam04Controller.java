package com.mycompany.myapp.exam04;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Exam04Controller {
	private static final Logger logger = LoggerFactory.getLogger(Exam04Controller.class);
	
	@RequestMapping("/exam04/index")
	public String index(){
		logger.info("index 요청 처리");
		return "exam04/index";
	}
	
	
}
