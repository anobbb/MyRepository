package ch03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Exam06 {
	public static void main(String[] args) {
		Employee emp = getEmployee(1001);
		System.out.println(emp.getEmpno() + ": " + emp.getEname() + ": " + emp.getSal());
		
		List<Department> result = getDepartment("개발");
		for(Department dept : result){
			System.out.println(dept.getDeptno() + ": " + dept.getDname() + ": " + dept.getLoc());
		}
	}// main
	
	//Employee 객체를 리턴 (해당된 행 하나만)
	private static Employee getEmployee(int searchEmpno) {
		Employee emp = null;
		// 변수는 초기화하지 않으면 메모리에 올라가지 않음, 초기화하지 않은 상태에서 변수를 사용하면 초기화 에러남
		// 변수 사용이 안 돼서 try-catch문도 제대로 실행되지 않고 finally에서 nullpointException 발생 
		Connection conn = null;
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", 
						"tester1", "kosa12345");
			
			String sql = "select * from emp where empno=?";
			PreparedStatement pstmp = conn.prepareStatement(sql);
			pstmp.setInt(1, searchEmpno);
			ResultSet rs = pstmp.executeQuery();
			
			while(rs.next()){
				emp = new Employee();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSal(rs.getDouble("sal"));
				emp.setComm(rs.getDouble("comm"));
				emp.setDeptno(rs.getInt("deptno"));
				
			}
			pstmp.close();
			rs.close();
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			try{ conn.close(); } catch(SQLException e){}
		}
		return emp;
	} //getEmployeement
	
	
	//List를 리턴
	private static List<Department> getDepartment(String searchDname) {
		List<Department> list = new ArrayList<>();
		Connection conn = null;
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			
			String sql = "select * from dept where dname like ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  "%" + searchDname + "%");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				Department department = new Department();
				department.setDeptno(rs.getInt(1));
				department.setDname(rs.getString(2));
				department.setLoc(rs.getString(3));
				list.add(department);
			}
			rs.close();
			pstmt.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
			try{ conn.close(); } catch(SQLException e2){}
		}
		return list;
	}

}
