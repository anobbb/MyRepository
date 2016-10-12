package com.mycompany.myapp.exam04;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/exam04")
public class Exam04Controller {
	private static final Logger logger = LoggerFactory.getLogger(Exam04Controller.class);
	
	@RequestMapping("/index")
	public String index(){
		logger.info("index 요청 처리");
		return "exam04/index";
	}
	
	/*
	 * GET방식
	 * URL에 파라메터값 보임->보안취약
	 * 문자만 전송가능
	 * browser마다 데이터 양 제한(무한정X)
	 * 실행하고자 하는 내용을 모두 시작행에 넣음(그래서 본문이 잘 없음)
	 * 간단한 내용 전달
	 * 예를들어 회원이 회원가입 하고싶어서 양식 요청할 때, 즉 화면이동(=링크)요청!!
	*/
	
	@RequestMapping(value="/join", method=RequestMethod.GET) 
	public String joinForm(){
		logger.info("joinForm 요청 처리");
		return "exam04/joinform";	
	}
	
	/*
	 * POST방식
	 * URL에 파라메터값 출력안 됨(보안성) 
	 * 데이터 전송량 무한대, 시작행에는 요청경로만 들어가고 실행내용은 본문에 전송
	 * 사용자 입력 내용
	 * 모든 데이터(파일 내용) 입력(본문) 및 전송 가능, 파일업로드 등
	 * 예를 들어 회원이 받은 회원가입 양식으로 작성한 내용을 다시 전송할 때
	*/
	@RequestMapping(value="/join", method=RequestMethod.POST) 
	public String join(Member member){
		logger.info("join 요청 처리");
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
		return "exam04/index";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String writeForm(){
		logger.info("writeForm 요청 처리");
		return "exam04/writeform";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(String btitle, String bcontent){
		logger.info("write 요청 처리");
		logger.info("btitle: " + btitle);
		logger.info("bcontent: " + bcontent);
		return "exam04/index";
	}
	
}
