package com.mycompany.lbnapptest.test11.controller;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.lbnapptest.test11.dto.Member;
import com.mycompany.lbnapptest.test11.service.Test11MemberService;

@Controller("MemberController")
@RequestMapping("/test11")
public class Test11Controller {
	private static final Logger logger = LoggerFactory.getLogger(Test11Controller.class);
	
	@Autowired
	private Test11MemberService memberService;
	
	@RequestMapping("/index")
	public String index(){
		logger.info("index 처리");
		return "test11/index";
	}
	
	@RequestMapping(value="/memberJoin", method=RequestMethod.GET)
	public String memberJoinForm(){
		logger.info("memberJoin(GET) 처리");
		return "test11/memberJoinForm";
	}
	
	@RequestMapping(value="/memberJoin", method=RequestMethod.POST)
	public String memberJoin(Member member){
		
		logger.info("memberJoin(POST) 처리");
		
		logger.info("mid: " + member.getMid());
		logger.info("mname: " + member.getMname());
		logger.info("mpassword: " + member.getMpassword());
		logger.info("memail: " + member.getMemail());
		logger.info("mtel: " + member.getMtel());
		logger.info("mjob: " + member.getMjob());
		logger.info("mskill: " + Arrays.toString(member.getMskill()));
		logger.info("maddress1: " + member.getMaddress1());
		logger.info("maddress2: " + member.getMaddress2());
		logger.info("mbirth: " + member.getMbirth());
		
		memberService.join(member);
		
		return "redirect:/test11/memberLogin";
	}
	
	@RequestMapping(value="/memberLogin", method=RequestMethod.GET)
	public String memberLoginForm(){
		logger.info("memberLogin(GET) 처리");
		return "test11/memberLoginForm";
	}
	
	@RequestMapping(value="/memberLogin", method=RequestMethod.POST)
	public String memberLogin(String mid, String mpassword){
		
		logger.info("memberLogin(POST) 처리");
		logger.info("mid: " + mid);
		logger.info("mpassword: " + mpassword);
		
		int result = memberService.login(mid, mpassword);
		
		if(result == Test11MemberService.LOGIN_SUCCESS){
			return "redirect:/test11/index";
		} else if(result == Test11MemberService.LOGIN_FAIL_MID){
			return "redirect:/test11/memberLogin";
		} else{
			return "redirect:/test11/memberLogin";
		}
		
	}
	
	@RequestMapping("/memberLogout")
	public String memberLogout(){
		logger.info("memberLogout 처리");
		return "redirect:/test11/index";
	}
	
}//Controller
