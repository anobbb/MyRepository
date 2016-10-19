package ch08.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ch08.dto.Member;

public class MemberDao {
	public void insert(Member member){
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			String sql = "insert into member(mid, mname, mage, mbirth) values(?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMid() );
			pstmt.setString(2, member.getMname());
			pstmt.setInt(3, member.getMage());
			/*
			 * jdbc의 Date는 sql을 import, 나머지는 util import
			 * pstmt.setString(4, "1995.10.5");
			 * sql.Date는 util.Date를 상속받아 사용 -> Date(long date) 라는 생성자 사용
			 * sql의 Date 생성자 new Date(util의 Date.getTime의 long값을 얻음) 
			 * setDate(4, new Date(member.getMbirth().getTime())); //
			 */
			pstmt.setDate(4, new Date(member.getMbirth().getTime()));
			// executeQuery는 select(데이터조회)일 경우에만 사용
			int rowNo = pstmt.executeUpdate();
			/*
			 * insert를 실행했을 때의 두 가지 결과
			 * 1. insert를 성공하여 1을 리턴
			 * 2. 예외가 발생하여 insert 실패
			 */
			if(rowNo==1){
				System.out.println("저장 성공");
			}
			pstmt.close();
		} catch (Exception e) { 
			System.out.println("저장 실패");
			e.printStackTrace();
		} finally{
			try{ conn.close(); } catch(SQLException e){} // JDBC사용하여 발생하는 예외는 대부분 SQLException
		}
	} // insert
	
	
	public void update(Member member){
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			String sql = "update member set mage=?, mbirth=? where mid=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, member.getMage() );
			pstmt.setDate(2, new Date(member.getMbirth().getTime()));
			pstmt.setString(3, member.getMid());
			int rowNo = pstmt.executeUpdate();
			/*
			 * executeUpdate() 결과
			 * 1. 1이상의 값: 1개 이상의 행이 수정됨
			 * 2. 0: 어떤 행도 수정되지 않았음
			 * 3. 예외
			 */
			if(rowNo>=1){
				System.out.println(rowNo + "개의 행이 수정됨");
			} else if(rowNo==0){
				System.out.println("수정된 행이 없음");
			}
			pstmt.close();
		} catch (Exception e) { 
			System.out.println("수정 실패");
			e.printStackTrace();
		} finally{
			try{ conn.close(); } catch(SQLException e){} 
		}
	} //update
	
	
	
	public void deleteByMid(String mid){
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			String sql = "delete member where mid=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid );
			int rowNo = pstmt.executeUpdate();
			if(rowNo>=1){
				System.out.println(rowNo + "개의 행이 삭제됨");
			} else if(rowNo==0){
				System.out.println("삭제된 행이 없음");
			}
			pstmt.close();
		} catch (Exception e) { 
			System.out.println("삭제 실패");
			e.printStackTrace();
		} finally{
			try{ conn.close(); } catch(SQLException e){} 
		}
	} // delete
	
} // class
