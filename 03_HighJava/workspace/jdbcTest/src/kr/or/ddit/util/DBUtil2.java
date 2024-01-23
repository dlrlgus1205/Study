package kr.or.ddit.util;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.sun.org.apache.bcel.internal.classfile.Field;

// JDBC 드라이버를 로딩하고 DB에 접속하여 Connection 객체를 반환하는 메서드로 구성된 class 만들기
public class DBUtil2 {
	private static Properties prop;
	
	// 정적(static) 초기화 블럭
	static {
		prop = new Properties();
		
		File f = new File("res/kr/or/ddit/config/dbinfo.properties");
		FileInputStream fin = null;
		try {
			fin = new FileInputStream(f);
			prop.load(fin);
			Class.forName(prop.getProperty("driver"));
		} catch (Exception e) {
			System.out.println("드라이버 로딩 실패 ~~~");
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"), prop.getProperty("pass"));
		} catch (SQLException e) {
			System.out.println("DB 연결 실패 ~~~");
			e.printStackTrace();
		}
		return conn;
	}
}
