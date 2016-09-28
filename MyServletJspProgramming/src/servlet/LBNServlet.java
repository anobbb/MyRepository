package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LBNServlet extends HttpServlet{
	//필드
	private String myname;
	
	//생성자
	public LBNServlet(){
		System.out.println("LBNServlet 객체 생성");
	}
	
	//초기화 메소드
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("LBNServlet 초기화");
		myname = config.getInitParameter("myname");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.println(" <html> ");
		out.println(" <head> <meta charset='UTF-8' </head>");
		out.println(" <body> ");
		
		out.println(" 나의 이름: " + myname);
		
		out.println(" </body> ");
		out.println(" </html> ");
	}
}
