package com.mycompany.lbnapptest.test01;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/test01")
public class Test01Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(Test01Controller.class);
	
	@RequestMapping("/index")
	public String home() {
		logger.info("index 요청 처리");
		return "test01/index";
	}
	
	@RequestMapping("/join")
	public String join(){
		logger.info("join 요청 처리");
		return "test01/join";
	}
}
