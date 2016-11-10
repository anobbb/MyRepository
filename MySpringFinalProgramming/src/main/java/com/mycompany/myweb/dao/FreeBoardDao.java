package com.mycompany.myweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dto.FreeBoard;

@Component
public class FreeBoardDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insert(FreeBoard freeBoard){
		String sql = "insert into freeboard(bno, btitle, bcontent, bwriter, bhitcount, bdate) values(seq_freeboard_bno.nextval, ?, ?, ?, 0, sysdate)";
		int row = jdbcTemplate.update(
				sql,
				freeBoard.getBtitle(),
				freeBoard.getBcontent(),
				freeBoard.getBwriter()
		);
		return row;
	} // insert
	
	public int update(FreeBoard freeBoard){
		String sql = "update freeboard set btitle=?, bcontent=?, bhitcount=? where bno=?";
		int row = jdbcTemplate.update(
				sql,
				freeBoard.getBtitle(),
				freeBoard.getBcontent(),
				freeBoard.getBhitcount(),
				freeBoard.getBno()
		);
		return row;
	} // update
	
	public int delete(int bno){
		String sql = "delete from freeboard where bno=?";
		int row = jdbcTemplate.update(sql, bno);
		return row;
	} // delete
	
	public FreeBoard selectByBno(int bno){
		String sql = "select bno, btitle, bcontent, bwriter, bhitcount, bdate from freeboard where bno=?";
		List<FreeBoard> list = jdbcTemplate.query(sql, new Object[]{bno}, new RowMapper<FreeBoard>(){
			@Override
			public FreeBoard mapRow(ResultSet rs, int row) throws SQLException {
				FreeBoard freeBoard = new FreeBoard();
				freeBoard.setBno(rs.getInt("bno"));
				freeBoard.setBtitle(rs.getString("btitle"));
				freeBoard.setBcontent(rs.getString("bcontent"));
				freeBoard.setBwriter(rs.getString("bwriter"));
				freeBoard.setBhitcount(rs.getInt("bhitcount"));
				freeBoard.setBdate(rs.getDate("bdate"));
				return freeBoard;
			}
		});
		return (list.size() != 0)? list.get(0) : null;
	} // selectByBno
	
	public List<FreeBoard> selectByPage(int pageNo, int rowsPerPage){
		String sql="";
		sql += "select rn, bno, btitle, bwriter, bhitcount, bdate ";
		sql += "from ( ";
		sql += "select rownum as rn, bno, btitle, bwriter, bhitcount, bdate ";
		sql += "from (select bno, btitle, bwriter, bhitcount, bdate from freeboard order by bno desc) ";
		sql += "where rownum<=? ";
		sql += ") ";
		sql += "where rn>=? ";
		List<FreeBoard> list = jdbcTemplate.query(
				sql, 
				new Object[]{(pageNo*rowsPerPage), ((pageNo-1)*rowsPerPage+1)},
				new RowMapper<FreeBoard>(){
					@Override
					public FreeBoard mapRow(ResultSet rs, int row) throws SQLException {
						FreeBoard freeBoard = new FreeBoard();
						freeBoard.setBno(rs.getInt("bno"));
						freeBoard.setBtitle(rs.getString("btitle"));
						freeBoard.setBwriter(rs.getString("bwriter"));
						freeBoard.setBhitcount(rs.getInt("bhitcount"));
						freeBoard.setBdate(rs.getDate("bdate"));
						return freeBoard;
					}
				}
		);
		return list;
	} // selectByPage
	
	
	public int count(){
		// 페이지 수를 알려면 전체 행의 수의 정보를 알아야 함
		String sql = "select count(*) from freeboard";
		//queryForObject: 하나의 객체를 리턴(sql 결과로 하나의 행이나 값이 *반드시* 나와야 사용 가능)
		// Integer.class: 어떤 객체타입(Integer)의 객체를 언박싱해서 리턴할 것인지 명시
		int count = jdbcTemplate.queryForObject(sql, Integer.class);
		return count;
	} // count
}
