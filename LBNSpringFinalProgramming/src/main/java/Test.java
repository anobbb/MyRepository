import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test {
	public static void main(String[] args) throws Exception {
	
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@106.253.56.123:1521:orcl", "kosauser3", "kosa12345");
		String sql = "insert into photoboard(bno, btitle, bcontent, bwriter, bhitcount, bdate, originalfile, savedfile, mimetype) values(seq_photoboard_bno.nextval, ?, ?, ?, 0, sysdate,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		for(int i=1; i<=170; i++) {
			pstmt.setString(1, "제목"+i);
			pstmt.setString(2, "내용"+i);
			pstmt.setString(3, "user1");
			pstmt.setString(4, "photo"+ (i%17+1) + ".jpg");
			pstmt.setString(5, "photo"+ (i%17+1) + ".jpg");
			pstmt.setString(6, "image/jpeg");
			pstmt.executeUpdate();
		}
		pstmt.close();
		conn.close();
	}
}
