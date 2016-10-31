package com.mycompany.myweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dto.Member;

@Component
public class MemberDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insert(Member member){
		String sql = "insert into member(mid, mname, mpassword, maddress, mtel, memail) values(?, ?, ?, ?, ?, ?)";
		int row = jdbcTemplate.update(
				sql,
				member.getMid(),
				member.getMname(),
				member.getMpassword(),
				member.getMaddress(),
				member.getMtel(),
				member.getMemail()
		);
		return row;
	} // insert
	
	public int update(Member member){
		String sql = "update member set mpassword=?, maddress=?, mtel=?, memail=? where mid=?";
		int row = jdbcTemplate.update(
				sql,
				member.getMpassword(),
				member.getMaddress(),
				member.getMtel(),
				member.getMemail(),
				member.getMid()
		);
		return row;
	}
	
	public int delete(String mid){
		String sql = "delete from member where mid=?";
		int row = jdbcTemplate.update(sql, mid);
		return row;
	}
	
	// public void method(Object[] arr){}
	
	public Member selectByMid(String mid){
		/*
		Object[] arr1 = new Object[3];
		Object[] arr2 = {"a", "b", "c" };
		Object[] arr3;
		arr3 = new Object[] {"a", "b", "c"}; 변수가 어떠한 타입의 배열인지 애매모호할 수 있어서 다시 생성해야함
		
		method(new Object[] {"a", "b", "c"});
		*/
		
		
		String sql = "select mid, mname, mpassword, maddress, mtel, memail from member where mid=?";
		List<Member> list = jdbcTemplate.query(sql, new Object[]{mid}, new RowMapper<Member>(){

			@Override
			public Member mapRow(ResultSet rs, int row) throws SQLException {
				Member member = new Member();
				member.setMid(rs.getString("mid"));
				member.setMname(rs.getString("mname"));
				member.setMpassword(rs.getString("mpassword"));
				member.setMaddress(rs.getString("maddress"));
				member.setMtel(rs.getString("mtel"));
				member.setMemail(rs.getString("memail"));
				return member;
			}
		});
		return (list.size()!=0)? list.get(0) : null;
	} // selectByMid
	
	public String selectByMemail(String memail){
		String sql = "select mid from member where memail=?";
		List<String> list = jdbcTemplate.query(sql, new Object[]{memail}, new RowMapper<String>(){
			@Override
			public String mapRow(ResultSet rs, int row) throws SQLException {
				return rs.getString("mid");
			}
		});
		return (list.size()!=0)? list.get(0) : null;
	} // selectByMemail
	
} // class
