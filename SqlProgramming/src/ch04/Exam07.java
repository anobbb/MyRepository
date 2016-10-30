package ch04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Exam07 {
	public static void main(String[] args){
		List<JobSalary> result = getMethod("사원", 1000);
		for(JobSalary js : result) {
			System.out.println(js.getJob() + ": " + js.getSalary());
		}
	} // main
	
	
	private static List<JobSalary> getMethod(String searchJob, int searchSalary){
		List<JobSalary> list = new ArrayList<>();
		Connection conn = null;
		
		try{
		Class.forName("oracle.jdbc.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
		
		String sql = "";
		sql += "select job, sum(sal) as salary from emp "; 
		sql	+= "where job!=? group by job ";
		sql += "having sum(sal)>=? order by salary";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, searchJob);
		pstmt.setInt(2, searchSalary);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()){
			JobSalary jobSalary = new JobSalary();
			jobSalary.setJob(rs.getString(1));
			jobSalary.setSalary(rs.getInt(2));
			list.add(jobSalary);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		} catch(Exception e){
			e.printStackTrace();
			try{ conn.close(); } catch(SQLException e2){}
		}
		
		return list;		
	}

}// class