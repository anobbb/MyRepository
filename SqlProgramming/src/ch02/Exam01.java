package ch02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Exam01 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		//어떤 JDBC Driver를 사용할 것인가(JDBC Driver 로딩)
		Class.forName("oracle.jdbc.OracleDriver");
		
		//연결 요청을 해서 연결 객체를 얻기
		//Connection은 인터페이스
		Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:orcl", 
				"tester1", "kosa12345"
		);
		
		//SQL문을 보내고 실행시킴
		String sql = "select empno, ename from emp";
		//실행준비완료되면 preparedstatement를 얻을 수 있음 _ sql이 oracle로 전송돼서 sql문 준비시킴
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery(); // ResultSet 리턴
		
		//결과셋에서 한 행씩 읽기
		/* Cursor는 제일 처음에 결과셋의 제일 처음 부분, 즉 attribute를 가리킴,
		 * Cursor를 아래로 내리는 역할을 next메소드가 함, 데이터를 읽는 역할이 아님
		 * 현재 cursor가 있는 행만 읽을 수 있음
		 * 커서 이동했는데 이동한 위치에 data가 있으면 true, 없으면 false 리턴		
		*/
		while(rs.next()){
			String empno = rs.getString("empno") ;
			String ename = rs.getString("ename");
			System.out.println(empno + ": " + ename);
		}
		
		//JDBC 관련 객체 닫기(메모리 리소스 해제)
		rs.close();
		pstmt.close();
		conn.close();
	}
}
