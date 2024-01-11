package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
	Lprod 테이블에 새로운 데이터 추가하기
	
	Lprod_gu와 Lprod_nm은 직접 입력 받아서 처리하고,
	Lprod_id는 현재의 Lprod_id들 중에서 제일 큰 값보다 1 크게 한다.
	
	입력받은 Lprod_gu가 이미 등록돼있으면 다시 입력 받아서 처리한다. 
*/
public class JdbcTest05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "LGH96", "java");
			
			String gu = "";
			
			while(true) {
				System.out.print("LPROD_GU 입력 >>");
				gu = sc.next();
				
//				String sval = "SELECT COUNT(*) CNT FROM LPROD WHERE LPROD_GU = '" + gu + "'";
				String sval = "SELECT COUNT(*) CNT FROM LPROD WHERE LPROD_GU = ?";
				
//				stmt = conn.createStatement();
//				rs = stmt.executeQuery(sval);

				pstmt = conn.prepareStatement(sval);
				pstmt.setString(1, gu);

				rs = pstmt.executeQuery();
				
				
				rs.next();
				String grs = rs.getString("CNT");
				
				if(grs.equals("1")) {
					System.out.println("다시 입력하세요");
				}
				else {
					break;
				}
			}
			
			System.out.print("LPROD_NM 입력 >>");
			String nm = sc.next();
			
			String sql = "INSERT INTO LPROD (LPROD_ID, LPROD_GU, LPROD_NM)\r\n" + 
					" VALUES ((SELECT MAX(LPROD_ID) FROM LPROD) + 1, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, gu);
			pstmt.setString(2, nm);
			
			int cnt = pstmt.executeUpdate();
			
			System.out.println("반환값 : " + cnt);
		} catch (SQLException e) {
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch(SQLException e) {}
			if(stmt != null) try {stmt.close();} catch(SQLException e) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException e) {}
			if(conn != null) try {conn.close();} catch(SQLException e) {}
		}
	}
}
