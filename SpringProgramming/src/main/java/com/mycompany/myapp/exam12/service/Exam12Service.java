package com.mycompany.myapp.exam12.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.exam12.dao.MemberDao;
import com.mycompany.myapp.exam12.dto.Member;


@Component
public class Exam12Service {
	private static final Logger logger = LoggerFactory.getLogger(Exam12Service.class);
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private MemberDao dao; // dao 주입받음
	
	public void join(Member member) {
		Connection conn = null;
		try {
			conn=dataSource.getConnection();
			// 이 서비스에서 공용으로 쓸 것이면 주입을 받는 것이 낫고, 여기에서만 쓸 거면 여기에서 생성해서 씀
			// 보통 서비스나 dao 객체는 주입받아서 씀
			// MemberDao dao = new MemberDao();
			dao.setConn(conn);
			int rowNo = dao.insert(member);
			logger.info(rowNo + "행이 저장됨");
		} catch (Exception e) { 
			e.printStackTrace();
		} finally{
			// conn.close는 연결을 끊는 것이 아니라 반납하는 의미
			try{conn.close();} catch(SQLException e){} 
		} // try
	} // join
} // class
