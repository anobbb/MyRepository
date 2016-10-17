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
	}
	
	//Employee 객체를 리턴 (해당된 행 하나만)
	private static Employee getEmployee(int searchEmpno) {
		Employee emp = new Employee();
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
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSal(rs.getInt("sal"));
				emp.setComm(rs.getDouble("comm"));
				emp.setDeptno(rs.getInt("deptno"));
			}
			pstmp.close();
			rs.close();
			conn.close();
		} catch(Exception e){
			e.printStackTrace();
			try{ conn.close(); } catch(SQLException e2){}
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
			
		}catch(Exception e){
			e.printStackTrace();
			try{ conn.close(); } catch(SQLException e2){}
		}
		return list;
	}

}
