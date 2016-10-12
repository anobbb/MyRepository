package com.mycompany.lbnapptest.test11.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.lbnapptest.test11.dao.Test11MemberDao;
import com.mycompany.lbnapptest.test11.dto.Member;

@Component
public class Test11MemberService {
	private static final Logger logger = LoggerFactory.getLogger(Test11MemberService.class);
	
	public static final int LOGIN_SUCCESS = 0;
	public static final int LOGIN_FAIL_MID = 1;
	public static final int LOGIN_FAIL_MPASSWORD = 2;
	
	@Autowired
	private Test11MemberDao memberDao;
	
	public void join(Member member){
		logger.info("join 처리");
		memberDao.insert(member);
	}
	
	public int login(String mid, String mpassword){
		logger.info("login 처리");
		Member member = memberDao.select(mid);
		if(member == null){
			return LOGIN_FAIL_MID;
		} else{
			if(member.getMpassword().equals(mpassword)){
				return LOGIN_SUCCESS;
			} else{
				return LOGIN_FAIL_MPASSWORD;
			}
		}
	}
}
