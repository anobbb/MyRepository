package ch03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 검색할 이름: ste 사번: 이름 1008: Steven 2000: Masten 검색할 이름: ost 1920:
 * Osten 3001: Taost 검색할 이름:
 */

public class Exam05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.print("검색할 이름: ");
			String inputName = sc.nextLine();
			List<Employee> result = getList(inputName);
			for(Employee emp : result){ //list에서 하나씩 빼내오기
				System.out.println(emp.getEmpno() + ": " + emp.getEname());
			}
		}
	} //main
	
	
	public static List<Employee> getList(String searchName){
		List<Employee> list = new ArrayList<>();
		Connection conn = null;
		try{
			Class.forName("oracle.jdbc.OracleDriver");
				
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			
			//String sql = "select * from emp where lower(first_name) like ?";
			String sql = "select * from emp where ename like ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + searchName + "%");
			ResultSet rs = pstmt.executeQuery();
			/*
			if (rs.next()) {
				do {
					int employee_id = rs.getInt(1);
					String first_name = rs.getString(2);
					System.out.println(employee_id + ": " + first_name);
				} while (rs.next());
			} else {
				System.out.println("해당 이름이 없음");
			}*/
			
			while(rs.next()){ //하나의 행을 list에 각각의 객체로 담기
				Employee emp = new Employee();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSal(rs.getDouble("sal"));
				emp.setComm(rs.getDouble("comm"));
				emp.setDeptno(rs.getInt("deptno"));
				list.add(emp);
			}//while
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch(Exception e){
			e.printStackTrace();
			try{ conn.close(); } catch(SQLException e2){}
		}
		return list;
	}
}//class
