package com.mycompany.myweb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.myweb.dto.Member;
import com.mycompany.myweb.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberService memberService;

	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginForm(){
		return "member/loginForm";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(String mid, String mpassword, HttpSession session, Model model){
		int result = memberService.login(mid, mpassword);
		if(result == memberService.LOGIN_FAIL_MPASSWORD){
			model.addAttribute("error", "LOGIN_FAIL_MPASSWORD");
			return "member/loginForm";
		} else if(result == MemberService.LOGIN_FAIL_MID){
			model.addAttribute("error", "LOGIN_FAIL_MID");
			return "member/loginForm";
		} else{
			session.setAttribute("login", mid);
		}
		return "redirect:/";
	}
	
	@RequestMapping(value="/findMid", method=RequestMethod.GET)
	public String findMidForm(){
		return "member/findMidForm";
	}
	
	@RequestMapping(value="/findMid", method=RequestMethod.POST)
	public String findMidForm(String memail, Model model, HttpSession session){
		String mid = memberService.findMid(memail);
		if(mid == null){
			model.addAttribute("error", "이메일이 존재하지 않음");
			return "member/findMidForm";
		}
		/*
		 * 아이디 넘기는 방법
		1) get방식 2) session이용
		*/
		session.setAttribute("findMid", mid);
		return "redirect:/member/login";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String joinForm(){
		return "member/joinForm";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(Member member){
		try{
			int result = memberService.join(member);
			return "redirect:/member/login";
		} catch(Exception e){
			/* spring은 Member를 소문자로 한 이름을 request에 저장, Model을 추가해서 사용하는 효과랑 비슷 
			 * model.addAttribute("member", member);	
			 */
			return "member/joinForm";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		String mid = (String)session.getAttribute("login");
		int result = memberService.logout(mid);
		if(result==memberService.LOGOUT_SUCCESS){
			session.removeAttribute("login");
		}	
		return "redirect:/";
	}
	
	@RequestMapping("/info")
	public String info(String mpassword, HttpSession session, Model model){
		String mid = (String)session.getAttribute("login"); 
		Member member = memberService.info(mid, mpassword);
		model.addAttribute("member", member);
		return "member/info";
	}
	

}
