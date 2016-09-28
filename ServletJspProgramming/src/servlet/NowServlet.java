package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NowServlet extends HttpServlet {
	//필드
	private String location;
	
	//생성자
	public NowServlet(){
		System.out.println("NowServlet 객체 생성");
	}
	
	//초기화 메소드
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("NowServlet 초기화");
		//web.xml의 value 값 리턴됨
		location = config.getInitParameter("location"); 
	}
	
	//메소드
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");

		// OutputStream os = response.getOutputStream();
		PrintWriter out = response.getWriter();
		out.println(" <html> ");
		out.println(" <head> <meta charset='UTF-8'> </head>");
		out.println(" <body> ");

		out.println(" 현재" + location + " 시간: " + new Date().toString());

		out.println(" </body> ");
		out.println(" </html> ");
	}
}
