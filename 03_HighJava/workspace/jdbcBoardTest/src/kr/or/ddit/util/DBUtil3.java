package kr.or.ddit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

// JDBC드라이버를 로딩하고 DB에 접속하여 Connection객체를
// 반환하는 메서드로 구성된 class 만들기

//클래스 로딩 ==> static 변수 생성 ==> static 변수가 기본값으로 초기화
// ==> static 변수의 명시적 초기화 ==> static 초기화 블럭 실행

// 객체 생성시
// ==> 인스턴스변수 생성 ==> 인스턴스변수의 기본값 초기화 ==> 인스턴스변수의 명시적 초기화 
// ==> 인스턴스 초기화 블럭 실행 ==> 생성자 실행
// (ResourceBundle객체 이용하기)
public class DBUtil3 {
	private static ResourceBundle bundle;
	// 정적 (초기화) 블럭 만들기
	static {
		bundle = ResourceBundle.getBundle("kr.or.ddit.config.dbinfo");
		try {
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName(bundle.getString("driver"));
		} catch (Exception e) {
			System.out.println("드라이버 로딩 실패 ~~~");
			e.printStackTrace();
			
		}
	}
	
	// 인스턴스 초기화 블럭
	{
		
	}
	
	public static Connection getConnection() {

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(
					bundle.getString("url"),
					bundle.getString("user"),
					bundle.getString("pass"));
												
		} catch (Exception e) {
			System.out.println("DB 연결 실패 ~~~");
			e.printStackTrace();
		}
		return conn;
	}
}
