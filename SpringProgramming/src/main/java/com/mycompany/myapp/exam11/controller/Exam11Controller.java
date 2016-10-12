package com.mycompany.myapp.exam11.controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.myapp.exam11.dto.Board;
import com.mycompany.myapp.exam11.dto.Member;
import com.mycompany.myapp.exam11.service.Exam11BoardService;
import com.mycompany.myapp.exam11.service.Exam11MemberService;


@Controller("MemberController") //컨트롤러 이름 명시적 지정, 원래 default명은 클래스 명의 첫 글자 소문자(exam11Controller)
@RequestMapping("/exam11")
public class Exam11Controller { 

	private static final Logger logger = LoggerFactory.getLogger(Exam11Controller.class);

	@Autowired
	private Exam11MemberService memberService; //필드주입
	
	@Autowired
	private Exam11BoardService boardService;
	
	@RequestMapping("/index")
	public String index(){
		logger.info("index 처리");
		return "exam11/index"; // /WEB-INF/views/exam11/index.jsp -> servlet-context.xml에서 설정
	}
	
	@RequestMapping(value="/memberJoin", method=RequestMethod.GET)
	public String memberJoinForm(){
		logger.info("memberJoin(GET) 처리");
		return "exam11/memberJoinForm";
	}
	
	@RequestMapping(value="/memberJoin", method=RequestMethod.POST)
	public String memberJoin(Member member){ //커멘드 객체: 데이터를 받으려는 목적으로 사용
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
		
		memberService.join(member); //필드주입사용
		
		return "redirect:/exam11/memberLogin";
	}
	
	@RequestMapping(value="/memberLogin", method=RequestMethod.GET)
	public String memberLoginForm(){
		logger.info("memberLogin(GET) 처리");
		return "exam11/memberLoginForm";
	}
	
	@RequestMapping(value="/memberLogin", method=RequestMethod.POST)
	public String memberLogin(String mid, String mpassword){
		logger.info("memberLogin(POST) 처리");
		logger.info("mid: " + mid);
		logger.info("mpassword: " + mpassword);
		
		int result = memberService.login(mid, mpassword);
		
		if(result == Exam11MemberService.LOGIN_SUCCESS){
			return "redirect:/exam11/index";
		} else if(result == Exam11MemberService.LOGIN_FAIL_MID){
			return "redirect:/exam11/memberLogin"; //refresh버튼 눌러도 갱신됨
		} else {
			return "redirect:/exam11/memberLogin"; // 양식 다시 보여주기 //index.jsp의 경로..
		}
		
		/* Get과 Post의 요청경로(value)가 다를 경우 그냥 exam11/memberLogin으로 해도 됨.
		 * <<<Refresh했을 때의 문제>>>
		 * exam11/memberLogin
		 * 뷰이름 , refresh하면 login 처리를 다시 요청, login 폼 요청이 아님
		 * browser의 refresh는 무조건 화면 갱신이 아닌, 바로 직전 처리 내용을 다시 한 번 더 실행
		 * login처리 요청이 아닌 login폼을 요청
		 * return else if(result)...
		 * return "redirect:/exam11/memberLoginForm"; // /myapp/exam11/memberLogin -> /myapp/exam11/memberLoginForm
		 
		 */
	}
	
	@RequestMapping("/memberLogout")
	public String memberLogin(){
		logger.info("memberLogout 처리");
		return "redirect:/exam11/index";
	}
	
	@RequestMapping(value="/boardWrite", method=RequestMethod.GET)
	public String boardWriteForm(){
		logger.info("boardWriteForm 처리");
		return "exam11/boardWriteForm";
	}
	
	@RequestMapping(value="/boardWrite", method=RequestMethod.POST)
	public String boardWrite(Board board){
		logger.info("boardWrite 처리");
		boardService.write(board);
		return "redirect:/exam11/index";
	}
	
	@RequestMapping(value="/boardList")
	public String boardList(Model model){
		logger.info("boardList 처리");
		List<Board> list = boardService.getList();
		model.addAttribute("boardlist", list);
		return "exam11/boardList";
	}
	
}
