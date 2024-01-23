package kr.or.ddit.util;
/*
	클래스 로딩 ==> static 변수 생성 ==> static 변수가 기본값으로 초기화 ==> static 변수의 명시적 초기화 ==> static 초기화 블럭 실행
	
	객체 생성 시
	==> 인스턴스 변수 생성 ==> 인스턴스 변수의 기본값 초기화 == > 인스턴스 변수의 명시적 초기화 ==> 인스턴스 초기화 블럭 실행 ==> 생성자 실행
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// JDBC 드라이버를 로딩하고 DB에 접속하여 Connection 객체를 반환하는 메서드로 구성된 class 만들기
public class DBUtil {
	// 정적(static) 초기화 블럭
	static {
		b = 300;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			System.out.println("드라이버 로딩 실패 ~~~");
			e.printStackTrace();
		}
	}
	int a = 100;
	static int b = 200;
	//인스턴스 초기화 블럭
	{
		
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "LGH96", "java");
		} catch (SQLException e) {
			System.out.println("DB 연결 실패 ~~~");
			e.printStackTrace();
		}
		return conn;
	}
}
