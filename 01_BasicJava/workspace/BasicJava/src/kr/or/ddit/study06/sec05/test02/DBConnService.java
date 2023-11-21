package kr.or.ddit.study06.sec05.test02;

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
	}
	
	public void selectAll() {
		conn = DBConn.getConnection();
		try {
			stmt = conn.createStatement();
			String sql = "SELECT * FROM MEMBER";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String id = rs.getString("MEM_ID");
				String pass = rs.getString("MEM_PASS");
				String name = rs.getString("MEM_NAME");
				System.out.printf("%s, %s, %s \n", id, pass, name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			
		}
	}
}
