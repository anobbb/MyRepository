package com.mycompany.myapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@RequestMapping("/join")
	public String join() {
		logger.info("join 요청 처리");
		return "member/join";
	}
	
	@RequestMapping("/login")
	public String login() {
		logger.info("login 요청 처리");
		return "member/login";
	}
	
	@RequestMapping("/logout")
	public String logout() {
		logger.info("member/logout 요청 처리");
		return "member/logout";
	}
	
	@RequestMapping("/withdraw")
	public String withdraw() {
		logger.info("member/withdraw 요청 처리");
		return "member/withdraw";
	}
}
