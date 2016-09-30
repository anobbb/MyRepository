package com.mycompany.myapp.exam05;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/exam05")
public class Exam05Controller {
	private static final Logger logger = LoggerFactory.getLogger(Exam05Controller.class);
	
	@RequestMapping("/index")
	public String index(){
		logger.info("index 요청 처리");
		return "exam05/index";
	}
	
	@RequestMapping("/index2")
	public ModelAndView index2(){
		logger.info("index2 요청");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("exam05/index");
		return mav;
	}
		
	@RequestMapping("/index3")
	public void index3(HttpServletRequest request, HttpServletResponse response) throws IOException{
		logger.info("index2 요청");
		//void형식이면 myapp/exam05/index3.jsp mapping된 제일 마지막 요청 경로.jsp를 찾음
		//사용하는경우: 이 메소드 안에서 응답을 직접 만들어서 보내고 싶을 때, 즉 jsp로 굳이 안 가도 될 때
		//WEB-INF안에 있는 이미지 접근(resource가 아니므로 일반 url경로로 접근 불가)
		response.setContentType("image/jpeg");
		
		String filePath = request.getServletContext().getRealPath("/WEB-INF/image/photo1.jpg"); //상대경로(동적), web application 루트
		InputStream is = new FileInputStream(filePath); //C든 D드라이브든 상관없이 적용 가능
		OutputStream os = response.getOutputStream(); //출력 결과는 응답http의 본문에 출력됨
		
		byte[] values = new byte[1024];
		int byteNum = -1;
		while((byteNum = is.read(values))!= -1){
			os.write(values, 0, byteNum);			
		}
		os.flush();
		is.close();
		os.close();
	}
}
