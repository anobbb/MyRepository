package ch07.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ch07.dto.Board;

public class BoardDao {

	public Board selectByBno(int searchBno) {
		Board board = null;
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			String sql = "";
			sql += "select bno, btitle, bcontent from board where bno=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, searchBno);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
			}
			rs.close();
			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try{ conn.close(); } catch(SQLException e){}
		}
		
		return board;
	} // selectByBno
	
	
	public List<Board> selectAll(){
		List<Board> list = new ArrayList<>();
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			String sql = "";
			sql += "select * from board";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBhitcount(rs.getInt("bhitcount"));
				board.setBdate(rs.getDate("bdate"));
				list.add(board);
			}
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try{ conn.close(); } catch(SQLException e){}
		}
		return list;
	}
	

}// class
