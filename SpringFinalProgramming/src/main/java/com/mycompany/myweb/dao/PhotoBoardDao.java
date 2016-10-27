package com.mycompany.myweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dto.PhotoBoard;

@Component
public class PhotoBoardDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insert(PhotoBoard photoBoard){
		String sql = "insert into photoboard(bno, btitle, bcontent, bwriter, bhitcount, bdate, originalfile, savedfile, mimetype) values(seq_photoboard_bno.nextval, ?, ?, ?, 0, sysdate, ?, ?, ?)";
		int row = jdbcTemplate.update(
				sql,
				photoBoard.getBtitle(),
				photoBoard.getBcontent(),
				photoBoard.getBwriter(),
				photoBoard.getOriginalfile(),
				photoBoard.getSavedfile(),
				photoBoard.getMimetype()
		);
		return row;
	} // insert
	
	public int update(PhotoBoard photoBoard){
		String sql = "update photoboard set btitle=?, bcontent=?, bhitcount=?, originalfile=?, savedfile=?, mimetype=? where bno=?";
		int row = jdbcTemplate.update(
				sql,
				photoBoard.getBtitle(),
				photoBoard.getBcontent(),
				photoBoard.getBhitcount(),
				photoBoard.getOriginalfile(),
				photoBoard.getSavedfile(),
				photoBoard.getMimetype(),
				photoBoard.getBno()
		);
		return row;
	} // update
	
	public int delete(int bno){
		String sql = "delete from photoboard where bno=?";
		int row = jdbcTemplate.update(sql, bno);
		return row;
	} // delete
	
	public PhotoBoard selectByBno(int bno){
		String sql = "select bno, btitle, bcontent, bwriter, bhitcount, bdate, originalfile, savedfile, mimetype from photoboard where bno=?";
		List<PhotoBoard> list = jdbcTemplate.query(sql, new Object[]{bno}, new RowMapper<PhotoBoard>(){
			@Override
			public PhotoBoard mapRow(ResultSet rs, int row) throws SQLException {
				PhotoBoard photoBoard = new PhotoBoard();
				photoBoard.setBno(rs.getInt("bno"));
				photoBoard.setBtitle(rs.getString("btitle"));
				photoBoard.setBcontent(rs.getString("bcontent"));
				photoBoard.setBwriter(rs.getString("bwriter"));
				photoBoard.setBhitcount(rs.getInt("bhitcount"));
				photoBoard.setBdate(rs.getDate("bdate"));
				photoBoard.setOriginalfile(rs.getString("originalfile"));
				photoBoard.setSavedfile(rs.getString("savedfile"));
				photoBoard.setMimetype(rs.getString("mimetype"));
				return photoBoard;
			}
		});
		return (list.size() != 0)? list.get(0) : null;
	} // selectByBno
	
	public List<PhotoBoard> selectByPage(int pageNo, int rowsPerPage){
		String sql="";
		sql += "select rn, bno, btitle, bhitcount, savedfile ";
		sql += "from ( ";
		sql += "select rownum as rn, bno, btitle, bhitcount, savedfile ";
		sql += "from (select bno, btitle, bhitcount, savedfile from photoboard order by bno desc) ";
		sql += "where rownum<=? ";
		sql += ") ";
		sql += "where rn>=? ";
		List<PhotoBoard> list = jdbcTemplate.query(
				sql, 
				new Object[]{(pageNo*rowsPerPage), ((pageNo-1)*rowsPerPage+1)},
				new RowMapper<PhotoBoard>(){
					@Override
					public PhotoBoard mapRow(ResultSet rs, int row) throws SQLException {
						PhotoBoard photoBoard = new PhotoBoard();
						photoBoard.setBno(rs.getInt("bno"));
						photoBoard.setBtitle(rs.getString("btitle"));
						photoBoard.setBhitcount(rs.getInt("bhitcount"));
						photoBoard.setSavedfile(rs.getString("savedfile"));
						return photoBoard;
					}
				}
		);
		return list;
	} // selectByPage
	
	
	public int count(){
		// 페이지 수를 알려면 전체 행의 수의 정보를 알아야 함
		String sql = "select count(*) from photoboard";
		//queryForObject: 하나의 객체를 리턴(sql 결과로 하나의 행이나 값이 *반드시* 나와야 사용 가능)
		// Integer.class: 어떤 객체타입(Integer)의 객체를 언박싱해서 리턴할 것인지 명시
		int count = jdbcTemplate.queryForObject(sql, Integer.class);
		return count;
	} // count
}
