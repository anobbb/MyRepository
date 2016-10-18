package ch07.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ch07.dto.Member;

public class MemberDao {
	
	public Member selectByMid(String searchUser){
		Member member = null;
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			String sql = "";
			sql += "select mid, mname from member where mid=?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchUser);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				member = new Member();
				member.setMid(rs.getString("mid"));
				member.setMname(rs.getString("mname"));
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try { conn.close(); } catch(Exception e){}
		}
		return member;
	}
	
	
	public List<Member> selectAll(){
		List<Member> list = new ArrayList<>();
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			String sql = "";
			sql += "select mid, mname from member where mid=?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "searchUser");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				Member member = new Member();
				member.setMid(rs.getString("mid"));
				member.setMname(rs.getString("mname"));
				list.add(member);
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try { conn.close(); } catch(Exception e){}
		}
		return list;		
	}
	
	
}
