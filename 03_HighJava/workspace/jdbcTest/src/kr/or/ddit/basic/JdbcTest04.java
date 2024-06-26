package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 계좌번호 정보를 추가하는 예제
public class JdbcTest04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "LGH96", "java");
			
			System.out.println("계좌번호 정보 추가하기");
			System.out.print("계좌번호 >> ");
			String bankNo = sc.next();
			
			System.out.print("은 행 명 >> ");
			String bankName = sc.next();
			
			System.out.print("예금주명 >> ");
			String userName = sc.next();
			
			// Statement 객체 이용한 처리
			/*
			String sql = "INSERT INTO BANKINFO (BANK_NO, BANK_NAME, BANK_USER_NAME, BANK_DATE)\r\n" + 
					" VALUES ('" + bankNo + "', '" + bankName + "', '" + userName + "', SYSDATE)";
			
			stmt = conn.createStatement();
			
			// SQL 문장이 'select' 문일 때는 executeQuery() 메서드를 사용한다.
			
			// SQL 문장이 'insert', 'update', 'delete'문 등 'select'문이 아닐 때는 executeUpdate()메서드를 사용한다.
			// 이 메서드는 작업에 성공한 레코드 수를 반환한다.
			int cnt = stmt.executeUpdate(sql);
			//-------------------------------------------------------------------------------------------------
			*/
			
			// PreparedStatement 객체를 이용한 처리
			
			// SQL 문장에 데이터가 들어갈 자리를 물음표(?)로 표시하여 작성한다.
			String sql = "INSERT INTO BANKINFO (BANK_NO, BANK_NAME, BANK_USER_NAME, BANK_DATE)\r\n" + 
					" VALUES (?, ?, ?, SYSDATE)";
			
			// PreparedStatement 객체 생성 ==> 사용할 SQL 문장을 매개변수에 넘겨준다.
			pstmt = conn.prepareStatement(sql);
			
			// SQL 문장의 물음표(?)자리에 들어갈 데이터를 세팅한다.
			// 형식) pstmt.set자료형이름(물음표번호, 데이터)
			//		물음표 번호는 1부터 시작한다.
			pstmt.setString(1, bankNo);
			pstmt.setString(2, bankName);
			pstmt.setString(3, userName);
			
			// 데이터 세팅이 완료되면 SQL문을 실행한다.
			int cnt = pstmt.executeUpdate();
			
			System.out.println("반환값 : " + cnt);
		} catch (SQLException e) {
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(stmt != null) try {stmt.close();} catch(SQLException e) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException e) {}
			if(conn != null) try {conn.close();} catch(SQLException e) {}
		}
	}
}
