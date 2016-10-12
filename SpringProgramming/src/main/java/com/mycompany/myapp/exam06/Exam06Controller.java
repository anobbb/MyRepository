package com.mycompany.myapp.exam06;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam06")
public class Exam06Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(Exam06Controller.class);
	
	@RequestMapping("/index")
	public String index(){
		logger.info("index 요청 처리");
		return "exam06/index";
	}
	
	@RequestMapping("/method1")
							//요청 HTTP에 대한 모든 내용을 얻을 수 있음
	public String method1(HttpServletRequest request){
		logger.info("method1() 요청 처리");
		//클라이언트의 IP 얻기
		logger.info("Web Client IP: " + request.getRemoteAddr());
		//클라이언트의 브라우저 종류
		logger.info("Web Client 종류: " + request.getHeader("User-Agent"));
		if(request.getHeader("User-Agent").contains("Chrome")){
			logger.info("Browser 종류: Chrome" );
		} else if(request.getHeader("User-Agent").contains("Trident/7.0")){
			logger.info("Browser 종류: Internet Explorer 11");
		} else if(request.getHeader("User-Agent").contains("MSIE")){
			logger.info("Browser 종류: Internet Explorer 10 이하");
		}
		//요청 파라미터 값 얻기
			logger.info("mid: " + request.getParameter("mid")); //JSP방식, Spring은 사용 잘 안 함
			logger.info("mname: " + request.getParameter("mname"));
		//쿼리 문자열 얻기
			logger.info("쿼리 문자열: " + request.getQueryString());
			logger.info("요청 URI: " + request.getRequestURI()); //포트넘버제외한주소
			logger.info("요청 URL: " + request.getRequestURL()); //전체주소
			logger.info("요청 방식: " + request.getMethod());
			logger.info("시스템 파일 경로: " + request.getRealPath("/WEB-INF/image/photo1.jpg")); //"상대경로"를 톰캣이 찾아줌
			logger.info("시스템 파일 경로: " + request.getServletContext().getRealPath("/WEB-INF/image/photo1.jpg"));
		return "exam06/index";
	}
	
	@RequestMapping("/method2")
	public void method2(HttpServletRequest request, HttpServletResponse response) throws IOException{
		/*response.setContentType("application/json; charset=UTF-8"); //헤더행에 해당, text/html -> println("<html>..</html>");
		PrintWriter pw = response.getWriter();
		pw.println("{mid:'fall', mname:'한가을'}"); //본문행에 해당, json형태, 문자만 보낼 때 
		pw.flush();//자동으로 됨(응답보내면서 닫히기 때문)
		pw.close(); */
		
		response.setContentType("image/jpeg");
		//파일명 한글일 경우 encoding해서 16진수화 함
		String fileName = "사진2.jpg";
		fileName = URLEncoder.encode(fileName,"UTF-8"); //파일 이름을 UTF-8로 인코딩을 함 
	    response.setHeader("Content-Disposition","attachment; filename=\"" + fileName + "\"");  
		//파일을 다운받게함, \"파일명\" -> 문자인식, 
		OutputStream os = response.getOutputStream();
		
		String filePath = request.getServletContext().getRealPath("/WEB-INF/image/사진2.jpg");
		InputStream is = new FileInputStream(filePath);
		
		byte[] values = new byte[1024];
		int byteNum = -1;
		while((byteNum = is.read(values)) != -1) {
			os.write(values, 0, byteNum);
		}
		os.flush();
		is.close();
		os.close();
	}
	
	@RequestMapping("/method3")
	public String method3(@RequestHeader("User-Agent") String userAgent){
		if(userAgent.contains("Chrome")){
			logger.info("Browser 종류: Chrome" );
		} else if(userAgent.contains("Trident/7.0")){
			logger.info("Browser 종류: Internet Explorer 11");
		} else if(userAgent.contains("MSIE")){
			logger.info("Browser 종류: Internet Explorer 10 이하");
		}
		return "exam06/index";
	}
	
	@RequestMapping("/method4CreateCookie")
	public String method4CreateCookie(HttpServletResponse response) throws UnsupportedEncodingException{
		//쿠키 생성
		Cookie cookie1 = new Cookie("mid", "fall"); //Key, Value
		
		String name = "홍길동";
		name = URLEncoder.encode(name, "UTF-8");
		Cookie cookie2 = new Cookie("mname", name);
		cookie2.setMaxAge(60);
		
		//쿠키 보내기(저장) - 응답 헤더에 쿠키 정보를 저장
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		
		return "exam06/index";
	}
	
	@RequestMapping("/method4ReceiveCookieHow1")
	public String method4ReceiveCookieHow1(HttpServletRequest request) throws UnsupportedEncodingException{
		//방법 1
		//쿠키 받기 - 요청 헤더에 쿠키 정보를 읽기
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for(Cookie cookie : cookies){
				String name = cookie.getName();
				String value = null;
				if(name.equals("mname")){
					value = URLDecoder.decode(cookie.getValue(), "UTF-8");
				} else {
					value = cookie.getValue();
				}
				System.out.println(name + ":" + value);
				//이전에 있던 쿠키들 + cookie1, 2 => 최소 2개 이상의 쿠키 정보 있어야 함
			}
		}
		
		return "exam06/index";
	}
	
	@RequestMapping("/method4ReceiveCookieHow2")
	//변수 이름이랑 쿠키이름이랑 다를 경우는 @CookieValue("mid") 괄호로 명시할 것
	//@CookieValue(defaultValue="") defaultValue를 통해 쿠키가 아무 것도 넘어오지 않을 때 디폴트 값을 지정
	public String method4ReceiveCookieHow2(@CookieValue(defaultValue="") String mid, @CookieValue(defaultValue="") String mname){
		//방법 2
		System.out.println("mid: " + mid);
		System.out.println("mname: " + mname);
		return "exam06/index";
	}
	
	@RequestMapping("/method4DeleteCookie")
	public String method4DeleteCooie(HttpServletResponse response){
		Cookie cookie1 = new Cookie("mid", "");
		cookie1.setMaxAge(0); //쿠키 삭제 효과
		
		Cookie cookie2 = new Cookie("mname", "");
		cookie2.setMaxAge(0);
		
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		
		return "exam06/index";		
	}
	
	@RequestMapping("/method5SetObject")
	public String method5SetObject(HttpSession session){
		//객체 생성
		Member member = new Member("fall", "한가을");
		
		//HttpSession에 객체 저장, 키 이름, 객체이름
		session.setAttribute("member", member);
		
		return "exam06/index";
	}
	
	@RequestMapping("/method5GetObject")
	public String method5GetObject(HttpSession session){
		//HttpSession에서 객체 얻기 , session은 object 타입이므로 member로 형변환
		Member member = (Member) session.getAttribute("member"); //키 이름 주고 객체 얻어오기
		if(member != null){
			System.out.println("mid: " + member.getMid());
			System.out.println("mname: " + member.getMname());
		}
				
		return "exam06/index";
	}
	
	@RequestMapping("/method5RemoveObject")
	public String method5RemoveObject(HttpSession session){
		//HttpSession에서 객체 삭제
		session.removeAttribute("member"); //키 이름 주고 객체 삭제				
		return "exam06/index";
	}
}
