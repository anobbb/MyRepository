package com.mycompany.myapp.exam12.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.myapp.exam12.dto.Member;
import com.mycompany.myapp.exam12.service.Exam12Service;

@Controller
@RequestMapping("/exam12/")
public class Exam12Controller {
	private static final Logger logger = LoggerFactory.getLogger(Exam12Controller.class);
	
	@Autowired
	private Exam12Service exam12Service;
	
	@RequestMapping("/index")
	public String index(){
		logger.info("index 처리");
		return "exam12/index";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String joinForm(){
		logger.info("joinForm 처리");
		return "exam12/joinForm";
	}

	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(Member member){
		logger.info("join 처리");
		exam12Service.join(member);
		return "redirect:/exam12/index";
	}
	
	
}
