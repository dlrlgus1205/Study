package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 문제) 사용자로부터 Lprod_id 값을 입력 받아 입력한 값보다 Lprod_id가 큰 자료들을 출력하시오
public class JdbcTest02 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "LGH96", "java");
			
			System.out.print("Lprod_id 값 입력 >> ");
			int n = sc.nextInt();
			
			String sql = "select lprod_id, lprod_gu, lprod_nm nm from lprod >" + n;
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			System.out.println("== 쿼리문 처리 결과 ==");
			int cnt = 0;
			while(rs.next()) {
				cnt++;
				
				System.out.println("Lprod_id : " + rs.getInt("lprod_id"));
				System.out.println("Lprod_gu : " + rs.getString(2));
				System.out.println("Lpron_nm : " + rs.getString("nm"));
				System.out.println("--------------------------------------------------------------------");
				
				if(cnt == 0) {
					System.out.println("검색 결과가 없습니다");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch(SQLException e) {}
			if(stmt != null) try {stmt.close();} catch(SQLException e) {}
			if(conn != null) try {conn.close();} catch(SQLException e) {}
		}
	}
}
