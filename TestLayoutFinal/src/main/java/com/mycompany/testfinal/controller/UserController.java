package com.mycompany.testfinal.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.testfinal.dto.User;
import com.mycompany.testfinal.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	//2016-11-14(월)
	/*작성자: 이윤주*/ 
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginForm(){
		return "user/loginForm";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(String user_id, String user_pw, HttpSession session, Model model){
		int result = userService.login(user_id, user_pw);

		if (result == UserService.LOGIN_FAIL_USER_PW) {
			model.addAttribute("error","LOGIN_FAIL_USER_PW");
			return "user/loginForm";
		
		} else if(result == UserService.LOGIN_FAIL_USER_ID) {
			model.addAttribute("error","LOGIN_FAIL_USER_ID");
			return "user/loginForm";
		
		} else {
			logger.info(""+result);
			session.setAttribute("login", user_id);//성공 시 session에 저장			
			return "user/settingForm";
		}
	}
	
	@RequestMapping(value="/findUser_id", method=RequestMethod.GET)
	public String findUser_idForm(){
		
		return "user/findUser_idForm";
	}
	
	@RequestMapping(value="/findUser_id", method=RequestMethod.POST)
	public String findUser_id(String user_email, Model model, HttpSession session){
		String user_id = userService.findUser_id(user_email);
		if (user_id == null) {
			model.addAttribute("error", "이메일이 존재하지 않습니다.");//값을 바로 .jsp에 넘김
			return "user/findUser_idForm";
		}
		session.setAttribute("findUser_id", user_id);
		return "redirect:/user/login";//get방식으로 넘김
	}
	
	@RequestMapping(value="/findUser_pw", method=RequestMethod.GET)
	public String findUser_pwForm(){
		
		return "user/findUser_pwForm";
	}
	
	@RequestMapping(value="/findUser_pw", method=RequestMethod.POST)
	public String findUser_pw(String user_id, String user_email, Model model, HttpSession session){
		String user_pw = userService.findUser_pw(user_id, user_email);
		if (user_pw == null) {
			model.addAttribute("error", "아이디 및 이메일이 존재하지 않습니다.");//값을 바로 .jsp에 넘김
			return "user/findUser_pwForm";
		}
		session.setAttribute("findUser_pw", user_pw);
		return "redirect:/user/login";//get방식으로 넘김
	}
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String joinForm(){
		return "user/joinForm";
	}
	
	@RequestMapping(value="user/join", method=RequestMethod.POST)
	public String join(User user){
		
		try{
			
			int result = userService.join(user);
			return "redirect:/";
		}catch (Exception e) {
			return "user/joinForm";
		}
		
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		String user_id = (String) session.getAttribute("login");//로그인 한 user_id를 session에서 받음
		int result = userService.logout(user_id);
		if (result == UserService.LOGOUT_SUCCESS) {
			session.removeAttribute("login");
		}
		return "user/loginForm";
	}
	
	@RequestMapping("/info")
	public String info(String user_pw, HttpSession session, Model model){
		String user_id = (String) session.getAttribute("login");//로그인한 mid를 session에서 받음
		User user = userService.info(user_id, user_pw);
		model.addAttribute("user", user);
		return "user/info";
	}
	
	@RequestMapping("/dropout")
	public String dropout(HttpSession session){
		return "user/home";
	}

	
}
