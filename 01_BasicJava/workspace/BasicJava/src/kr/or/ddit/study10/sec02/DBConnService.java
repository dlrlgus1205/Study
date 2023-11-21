package kr.or.ddit.study10.sec02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnService {
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	public static void main(String[] args) {
		DBConnService dbs = new DBConnService();
		dbs.selectAll();
		System.out.println("프로그램 실행 중");
		System.out.println("프로그램 실행 중");
		System.out.println("프로그램 실행 중");
		System.out.println("프로그램 실행 중");
	}
	
	public void selectAll() {
		conn = DBConn.getConnection();
		try {
			System.out.println("실행 1");
			stmt = conn.createStatement();
			String sql = "SELECT  FROM MEMBER";
			System.out.println("실행 2");
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String id = rs.getString("MEM_ID");
				String pass = rs.getString("MEM_PASS");
				String name = rs.getString("MEM_NAME");
				System.out.printf("%s, %s, %s \n", id, pass, name);
				System.out.println("실행 3");
			}
			System.out.println("실행 4");
		} catch (SQLException e) {
			System.out.println("실행 5");
			e.printStackTrace();
		}
		finally {
			System.out.println("실행 6");
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
