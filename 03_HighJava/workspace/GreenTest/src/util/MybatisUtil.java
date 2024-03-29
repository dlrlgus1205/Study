package util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	private static SqlSessionFactory session;
	
	static {
		InputStream in = null;
		try {
			// 1-1. 환경 설정 파일을 읽어올 스트림 객체 생성
			in = Resources.getResourceAsStream("kr/or/ddit/mybatis/config/mybatis-config.xml");
			
			//1-2. 환경 설정 파일을 읽어와 환경 설정 작업을 진행한다.
			//		(환경 설정이 완료되면 SqlSessionFactory객체가 생성된다.)
			session = new SqlSessionFactoryBuilder().build(in);
			
		} catch (Exception e) {
			System.out.println("Mybatis 초기화 실패!!!");
			e.printStackTrace();
		} finally {
			if(in!=null) try {in.close();} catch(IOException e) {}
		}// static 초기화 블럭 끝...
	}
		public static SqlSession getSqlSession() {
			SqlSession session2 = session.openSession();
			return session2;
	}
}
