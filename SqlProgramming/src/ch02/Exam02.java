package ch02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Exam02 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		
		/*
		// 직접 oracleDriver를 만들어서 등록한 후 사용하는 방법(잘 안 씀)
		Driver oracleDriver = new OracleDriver();
		DriverManager.registerDriver(oracleDriver);
		Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:orcl", 
				"tester1", "kosa12345" );
		*/
		
		// JDBC 드라이버를 메모리에 로딩
		Class.forName("oracle.jdbc.OracleDriver"); 
		// 연결 객체 생성 후 연결
		Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:orcl", 
				"tester1", "kosa12345" );
		
		// 매개변수화 된 SQL문
		// String sql = "select * from emp where ename sal>=? and sal<=?"; //1, 2
		// String sql = "select * from emp where ename like '%?%'"; 는 안 됨. 문자열의 일부분은 ?처리 불가
		String sql = "select ename, empno, sal from emp where ename like ?"; //like 이후가 진짜 데이터 (가변), 해당 문자열 전체 ? 처리
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "%성%"); // ? 부분 채워넣기
		ResultSet rs = pstmt.executeQuery();
		
		/* 
		* rs = "select * from emp where ename like '%성%'";
		* resultset 제일 처음 커서 전의 위치를 before first, 제일 마지막 행 이후를 after last라고 함. 이들 사이에 data가 있음
		* 커서가 있는 데이터의 행만 읽기 가능
		* next()를 이용하여 커서를 내려서 data가 있으면 true를 리턴, 해당 결과만큼 next함
		* return 값이 false면 데이터가 없음을 의미 
		* 아무 것도 데이터를 안 가져 왔다면 befor fisrt와 after last가 붙어있는 형식, 즉 데이터가 없다는 의미
		*/
		
		/*
		* rs.getXXX(1); sql문 실행 결과(select문)의 컬럼 인덱스
		* rs.getXXX("empno"); 컬럼명, 순서 사용 상관없음
		* 기본적으로 resultset은 next함수 사용 
		* privious, last, first 등을 사용하려면 scroll사용가능한 설정을 별도로 해야 함
		*/		
		
		while(rs.next()){
			int empno = rs.getInt(2); 
			String ename = rs.getString("ename"); //sql문제 해당 컬럼이 있기만하면 됨
			int sal = rs.getInt("sal");
			System.out.println(empno + ": " + ename + ": " + sal);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
	}

}
