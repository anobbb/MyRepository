package finalsource.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import finalsource.dto.Member;

public class MemberDao {
	private Connection conn;
	
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	
	public int insert(Member member) throws SQLException{
		String sql = "insert into member(mid, mname, mage, mbirth) values(?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, member.getMid());
		pstmt.setString(2,  member.getMname());
		pstmt.setInt(3, member.getMage());
		pstmt.setDate(4, new Date(member.getMbirth().getTime()));
		int rowNo = pstmt.executeUpdate();
		pstmt.close();
		return rowNo;
	} // insert
	
	public Member selectByMid(String mid) throws SQLException{
		Member member = null; // 리턴하고자 하는 값을 먼저 선언
		String sql = "select mid, mname, mage, mbirth from member where mid=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, mid);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){ // while이 아닌 if 쓰는 이유: mid는 딱 하나의 값만 유효하므로 if 사용 - 실행이 되든지 안 되든지 둘 중 하나
			member = new Member();
			member.setMid(rs.getString("mid"));
			member.setMname(rs.getString("mname"));
			member.setMage(rs.getInt("mage"));
			member.setMbirth(rs.getDate("mbirth"));
		}
		rs.close();
		pstmt.close();
		return member; 
		//존재하지 않을 때 0이 아닌 null이 리턴됨
	} // selectByMid
	
	public List<Member> selectByMname(String mname) throws SQLException{
		List<Member> list = new ArrayList<>(); // null일 때 비어있는 list를 반환하므로 null이 아닌 arraylist 생성해 둠
		String sql = "select mid, mname, mage, mbirth from member where mname like ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "%" + mname + "%");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			Member member = new Member();
			member.setMid(rs.getString("mid"));
			member.setMname(rs.getString("mname"));
			member.setMage(rs.getInt("mage"));
			member.setMbirth(rs.getDate("mbirth"));
			list.add(member);
		}
		rs.close();
		pstmt.close();
		return list; //존재하지 않을 때 null이 아닌 객체가 비어있는 List를 리턴
	} // selectByMname
	
	public int update(Member member) throws SQLException{
		String sql = "update member set mname=?, mage=?, mbirth=? where mid=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,  member.getMname());
		pstmt.setInt(2, member.getMage());
		pstmt.setDate(3, new Date(member.getMbirth().getTime()));
		pstmt.setString(4, member.getMid());
		int rowNo = pstmt.executeUpdate();
		pstmt.close();
		return rowNo;
	} // update
	
						//pk값, 유일값으로 적용
	public int deleteByMid(String mid) throws SQLException{
		String sql = "delete member where mid=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, mid);
		int rowNo = pstmt.executeUpdate();
		pstmt.close();
		return rowNo;
	} // deleteByMid

} // class
