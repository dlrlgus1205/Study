package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;

//Statement 객체를 사용하면 SQL injection 해킹에 노출될 수 있는 예제
public class JdbcTest06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			
			System.out.println("계좌 번호 검색하기");
			System.out.print("검색할 계좌 번호 입력 >>");
			String bankNo = sc.nextLine();
			
			/* // Statement 객체 이용하기
			String sql = "SELECT * FROM BANKINFO WHERE BANK_NO = '" + bankNo + "'";
			System.out.println(sql);
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql); */
			
			// PreparedStatement객체 이용하기
			String sql = "SELECT * FROM BANKINFO WHERE BANK_NO = ?";
			System.out.println(sql);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bankNo);
			rs = pstmt.executeQuery();
			
			System.out.println("== 검색 결과 ==");
			System.out.println("계좌번호\t 은행이름\t 예금주명\t 개설날짜");
			System.out.println("-----------------------------------------------------------");
			
			while(rs.next()) {
				String bNo =rs.getString("bank_no");
				String bName =rs.getString("bank_name");
				String uName =rs.getString("bank_user_name");
				String bDate =rs.getString("bank_date");
				System.out.println(bNo + "\t" + bName + "\t" + uName + "\t" + bDate);
			}
			System.out.println("-----------------------------------------------------------");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch(SQLException e) {}
			if(stmt != null) try {stmt.close();} catch(SQLException e) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException e) {}
			if(conn != null) try {conn.close();} catch(SQLException e) {}
		}
	}
}
