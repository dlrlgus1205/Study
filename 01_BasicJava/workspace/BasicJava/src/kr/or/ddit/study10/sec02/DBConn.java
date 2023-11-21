package kr.or.ddit.study10.sec02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	private static Connection conn = null;
	
	private DBConn() {
		
	}
	
	public static Connection getConnection() {
		
		String url = "jdbc:oracle:thin:@192.168.142.21:1521:xe";
		String user = "LGH96";
		String password = "java";
		
		if(conn == null) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		
		return conn;
	}
}
