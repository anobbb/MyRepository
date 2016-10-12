package com.mycompany.lbnapptest.test11.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mycompany.lbnapptest.test11.dto.Member;

@Component
public class Test11MemberDao {
	private static final Logger logger = LoggerFactory.getLogger(Test11MemberDao.class);
	
	public void insert(Member member){
		logger.info("insert 처리");
	}
	
	public Member select(String mid){
		logger.info("select 처리");
		return null;
	}
}
