package finalsource.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import finalsource.dto.Board;

public class BoardDao {
	private Connection conn;
	
	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public int insert(Board board) throws SQLException{
		String sql = "insert into board(bno, btitle, bcontent, bwriter, bhitcount, bdate) ";
		sql += "values (seq_board_bno.nextval, ?, ?, ?, 0, sysdate)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, board.getBtitle());
		pstmt.setString(2, board.getBcontent());
		pstmt.setString(3, board.getBwriter());
		// bhitcount와 bdate는 default 선언하였으므로 지워야 함
		// pstmt.setInt(5, board.getBhitcount());
		// pstmt.setDate(6, new Date(board.getBdate().getTime()));
		int rowNo = pstmt.executeUpdate();	
		pstmt.close();
		return rowNo;
	} // insert
	
	public Board selectByBno(int bno) throws SQLException{
		Board board = null;
		String sql = "select bno, btitle, bcontent, bwriter, bhitcount, bdate from board ";
		sql += "where bno=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bno);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			board = new Board();
			board.setBno(rs.getInt("bno"));
			board.setBtitle(rs.getString("btitle"));
			board.setBcontent(rs.getString("bcontent"));
			board.setBwriter(rs.getString("bwriter"));
			board.setBhitcount(rs.getInt("bhitcount"));
			board.setBdate(rs.getDate("bdate"));
		}
		rs.close();
		pstmt.close();
		return board; //존재하지 않을 때 0이 아닌 null을 리턴해야 함		
	} // selectByBno
	
	public List<Board> selectByBtitle(String btitle) throws SQLException {
		List<Board> list = new ArrayList<>();
		String sql = "select bno, btitle, bcontent, bwriter, bhitcount, bdate from board ";
		sql += "where btitle like ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "%" + btitle + "%");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			Board board = new Board();
			board.setBno(rs.getInt("bno"));
			board.setBtitle(rs.getString("btitle"));
			board.setBcontent(rs.getString("bcontent"));
			board.setBwriter(rs.getString("bwriter"));
			board.setBhitcount(rs.getInt("bhitcount"));
			board.setBdate(rs.getDate("bdate"));
			list.add(board);
		}
		rs.close();
		pstmt.close();
		return list;
	} // selectByBtitle
	
	public int update(Board board) throws SQLException{
		String sql = "update board set btitle=?, bcontent=?, bwriter=?, bhitcount=?, bdate=? where bno=?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);	
		pstmt.setString(1, board.getBtitle());
		pstmt.setString(2, board.getBcontent());
		pstmt.setString(3, board.getBwriter());
		pstmt.setInt(4, board.getBhitcount());
		pstmt.setDate(5, new Date(board.getBdate().getTime()));
		pstmt.setInt(6, board.getBno());
		int rowNo = pstmt.executeUpdate();
		pstmt.close();
		return rowNo;
	} // update
						
	public int deleteByBno(int bno) throws SQLException{
		String sql = "delete board where bno=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bno);
		int rowNo = pstmt.executeUpdate();
		pstmt.close();
		return rowNo;
	} // deleteByBno
	
	public List<Board> selectByPage(int pageNo, int rowsPerPage) throws SQLException{
		String sql="";
		sql += "select rn, bno, btitle, bcontent, bwriter, bhitcount, bdate ";
		sql += "from ( ";
		sql += "select rownum as rn, bno, btitle, bcontent, bwriter, bhitcount, bdate ";
		sql += "from (select bno, btitle, bcontent, bwriter, bhitcount, bdate from board order by bno desc) ";
		sql += "where rownum<=? ";
		sql += ") ";
		sql += "where rn>=? ";
		List<Board> list = new ArrayList<>();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pageNo*rowsPerPage);
		pstmt.setInt(2,  (pageNo-1)*rowsPerPage+1);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			Board board = new Board();
			board.setBno(rs.getInt("bno"));
			board.setBtitle(rs.getString("btitle"));
			board.setBcontent(rs.getString("bcontent"));
			board.setBwriter(rs.getString("bwriter"));
			board.setBhitcount(rs.getInt("bhitcount"));
			board.setBdate(rs.getDate("bdate"));
			list.add(board);
		}
		rs.close();
		pstmt.close();
		return list;
	} // selectByPage
	
}// class
