package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//문제) Lprod_id 값을 2개 입력 받아서 두 값 중 작은 값부터 큰 값 사이의 자료들을 출력하시오
public class JdbcTest03 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "LGH96", "java");
			
			System.out.println("숫자 2개 입력");
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			
			if(n1 > n2) {
				int t = n1;
				n1 = n2;
				n2 = t;
			}
			
			/* int min = n1;
			int max = n2;
			if(n1 > n2) {
				max = n1;
				min = n2;
			} */
			
//			int min = Math.min(n1, n2);
//			int max = Math.max(n1, n2);
			
			String sql = "SELECT LPROD_ID, LPROD_GU, LPROD_NM FROM LPROD WHERE LPROD_ID BETWEEN " + n1 + " AND " + n2;
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			int cnt = 0;
			System.out.println("== 쿼리문 처리 결과 ==");
			while(rs.next()) {
				cnt++;
				System.out.println("LPROD_ID : " + rs.getInt("LPROD_ID"));
				System.out.println("LPROD_GU : " + rs.getString("LPROD_GU"));
				System.out.println("LPROD_NM : " + rs.getString("LPROD_NM"));
				System.out.println("--------------------------------------------------------------------");

				if(cnt == 0) {
					System.out.println("검색 결과가 없습니다");
				}
			}
		} catch (SQLException e) {
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch(SQLException e) {}
			if(stmt != null) try {stmt.close();} catch(SQLException e) {}
			if(conn != null) try {conn.close();} catch(SQLException e) {}
		}
	}
}
