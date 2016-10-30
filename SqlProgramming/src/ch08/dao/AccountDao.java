package ch08.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ch08.dto.Account;

public class AccountDao {
	private Connection conn;
	
	public void setConn(Connection conn){
		this.conn = conn; // 이미 커넥션이 있다는 가정 하에 시작할 수 있는 역할
	}
	
	public int update(Account account) throws SQLException{
		String sql = "update account set abalance=? where ano=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, account.getAbalance());
		pstmt.setString(2,  account.getAno());
		int rowNo = pstmt.executeUpdate();
		// 실제 update된 행 수를 리턴
		return rowNo;
		/*
		 *  try-catch로 처리하면 안 되는 이유: 여기서 예외를 다 잡으면 어떠한 경우에도 예외가 발생하지 않는 메소드가 됨
		 *  예외가 발생했을 때 dao를 사용하는 곳에서 rollback 작업 등을 처리해야하는데 예외가 발생하지 않아서 작업 불가능
		 *  
		 *  &
		 *  
		 *  Dao에 커넥션을 연결하는 코드가 들어가면 안 됨 (setter 주입으로 이미 주입받아 사용중)
		 */
	}
}
