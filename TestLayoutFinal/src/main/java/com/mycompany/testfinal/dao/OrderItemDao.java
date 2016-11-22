package com.mycompany.testfinal.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.testfinal.dto.Menu;
import com.mycompany.testfinal.dto.OrderItem;
//이명진
@Component
public class OrderItemDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	//중요
	//1개 주문에 대한 모든 품목 리스트 찾기
	public List<OrderItem> selectOrderItemsByOgid(int ogid){
		String sql = "select oid,ogid,mid,ordercount from order_item where ogid=?";
		List<OrderItem> orderItems =  jdbcTemplate.query(sql, 
				new Object[]{ogid}, 
				new RowMapper<OrderItem>(){
				  		
			@Override
			public OrderItem mapRow(ResultSet rs, int row) throws SQLException {
				OrderItem orderItem = new OrderItem();
				orderItem.setOid(rs.getInt("oid"));
				orderItem.setOgid(rs.getInt("ogid"));
				orderItem.setMid(rs.getInt("mid"));
				orderItem.setOrdercount(rs.getInt("ordercount"));
				
				return orderItem;
			}			
		});
		return orderItems;
	}
	
	//주문 품목 삽입(1개)
	public int insertOrderItem(OrderItem orderitem){
		String sql = "insert into order_item(oid, ogid, mid, ordercount) values(?,?,?,?)";
		int row = jdbcTemplate.update(
				sql,
				orderitem.getOid(),
				orderitem.getOgid(),
				orderitem.getMid(),
				orderitem.getOrdercount()
		);
		return row;		
	}
	
	//1개 주문 품목 삭제
	public int deleteOrderItem(OrderItem orderitem){
		String sql = "delete from order_item where oid=?";
		int row = jdbcTemplate.update(sql, orderitem.getOid());
		return row;
		
	}
	
	//주문 품목 검색(1개)(oid)
	public OrderItem selectOrderItemByOid(int oid){
		String sql = "select oid,ogid,mid,ordercount from order_item where oid=?";
		List<OrderItem> list = jdbcTemplate.query(sql, new Object[]{oid}, new RowMapper<OrderItem>(){
			@Override
			public OrderItem mapRow(ResultSet rs, int row) throws SQLException {
				OrderItem orderitem = new OrderItem();
				orderitem.setOid(rs.getInt("oid"));
				orderitem.setOgid(rs.getInt("ogid"));
				orderitem.setMid(rs.getInt("mid"));
				orderitem.setOrdercount(rs.getInt("ordercount"));
					
				return orderitem;
			}
				
		});
		return (list.size() != 0)?list.get(0):null;
	}
		
	//------------------------------------------------------------------------------
	
	
	/*//중요
	//1개 주문에 대한 1개 품목 메뉴(mid) 찾기
	public int selectMidByOrid(int orid){
		String sql = "select mid from order_item where orid=?";
		List<Integer> list =  jdbcTemplate.query(sql, 
				new Object[]{orid}, 
				new RowMapper<Integer>(){
					  		
			@Override
			public Integer mapRow(ResultSet rs, int row) throws SQLException {
				Integer mid = new Integer(rs.getInt("mid"));
				
				return mid;
			}			
		});
		return (list.size() != 0)?list.get(0):null;
	}*/
	
}
