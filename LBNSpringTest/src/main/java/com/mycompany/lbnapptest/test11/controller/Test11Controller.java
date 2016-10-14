package com.mycompany.lbnapptest.test11.controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.lbnapptest.test11.dto.Board;
import com.mycompany.lbnapptest.test11.dto.Member;
import com.mycompany.lbnapptest.test11.service.Test11BoardService;
import com.mycompany.lbnapptest.test11.service.Test11MemberService;

@Controller("MemberController")
@RequestMapping("/test11")
public class Test11Controller {
	private static final Logger logger = LoggerFactory.getLogger(Test11Controller.class);
	
	@Autowired
	private Test11MemberService memberService;
	
	@Autowired
	private Test11BoardService boardService;
	
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
	
	
	@RequestMapping(value="/boardWrite", method=RequestMethod.GET)
	public String boardWriteForm(){
		logger.info("boardWriteForm 처리");
		return "/test11/boardWriteForm";
	}
	
	@RequestMapping(value="/boardWrite", method=RequestMethod.POST)
	public String boardWrite(Board board){
		logger.info("boardWrite 처리");
		boardService.write(board);
		return "redirect:/test11/index";
	}
	
	@RequestMapping("/boardList")
	public String boardList(Model model){
		logger.info("boardList 처리");
		List<Board> list = boardService.getList();
		model.addAttribute("boardlist", list);
		return "/test11/boardList";
	}
	
	@RequestMapping("/boardView")
	public String boardView(int bno, Model model){
		logger.info("boardview 처리");
		Board board = boardService.getBoard(bno);
		model.addAttribute("board", board);
		return "test11/boardView";
	}
	
	@RequestMapping(value = "/boardUpdate", method=RequestMethod.GET)
	public String boardUpdateForm(int bno, Model model){
		logger.info("boardUpdateForm 처리");
		Board board = boardService.getBoard(bno);
		model.addAttribute("board", board);
		return "test11/boardUpdateForm";
	}
	
	@RequestMapping(value = "/boardUpdate", method=RequestMethod.POST)
	public String boardUpdate(Board board){
		logger.info("boardUpdate 처리");
		boardService.updateBoard(board);
		return "redirect:/test11/boardList";
	}
	
	@RequestMapping("/boardDelete")
	public String boardDelete(int bno){
		logger.info("boarddelete 처리");
		boardService.deleteBoard(bno);
		return "redirect:/test11/boardList";
	}
}//Controller
