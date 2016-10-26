package com.mycompany.myweb.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dao.MemberDao;
import com.mycompany.myweb.dto.Member;

@Component
public class MemberService {
	public static final int JOIN_SUCCESS = 0;
	public static final int JOIN_FAIL = 1;
	
	public static final int LOGIN_SUCCESS = 0;
	public static final int LOGIN_FAIL_MID = 1;
	public static final int LOGIN_FAIL_MPASSWORD = 2;
	
	public static final int LOGOUT_SUCCESS = 0;
	public static final int LOGOUT_FAIL = 1;
	
	public static final int MODIFY_SUCCESS = 0;
	public static final int MODIFY_FAIL = 1;
	
	public static final int WITHDRAW_SUCCESS = 0;
	public static final int WITHDRAW_FAIL=1;
	
	@Autowired
	private MemberDao memberDao;
	
	// join은 정상실행(1) 또는 가입실패만 발생 
	public int join(Member member){
		memberDao.insert(member);
		return JOIN_SUCCESS; //예외 발생하면 spring에서 자동으로 처리, 여기에서 예외처리를 하면 spring 기능 발생하지 않게 되므로 try-catch작성X
	} // join
	
	public int login(String mid, String mpassword, HttpSession session){
		Member member = memberDao.selectByMid(mid);
		if(member == null) { return LOGIN_FAIL_MID; }
		if(member.getMpassword().equals(mpassword) == false) { return LOGIN_FAIL_MPASSWORD;}
		session.setAttribute("login", mid);
		return LOGIN_SUCCESS;
	} // login
	
	// 세션에 로그인성공 여부 저장
	// but, service에는 독립적으로 메소드만 구성, http 접속 여부는 service에서 되도록이면 구현하지 않는다.
	public int logout(HttpSession session){
		session.removeAttribute("login");
		return LOGOUT_SUCCESS;
	} // logout
	
	public String findMpassword(String mid, String memail){
		Member member = memberDao.selectByMid(mid);
		if(member == null) return null; // db에 mid가 없을 때
		if(member.getMemail().equals(memail)==false) return null;
		return member.getMpassword();
	} // findMpassword
	
	public String findMid(String memail){
		return memberDao.selectByMemail(memail);
	} // findMid
	
	public Member info(String mpassword, HttpSession session){
		String mid = (String) session.getAttribute("login");
		Member member = memberDao.selectByMid(mid);
		if(member.getMpassword().equals(mpassword) == false) { return null };
		return member;
	} // info
	
	public int modify(Member member){
		
	} // modify
	
	public int withdraw(String mpassword, HttpSession session){
		String mid = (String)session.getAttribute("login");
		Member member = memberDao.selectByMid(mid);
		if(member.getMpassword().equals(mpassword) == false) { return WITHDRAW_FAIL; }
		memberDao.delete(mid);
		logout(session);
		return WITHDRAW_SUCCESS;
	} // withdraw
	
	public boolean isMid(String mid){
	} // isMid
}
