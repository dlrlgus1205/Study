package kr.or.ddit.basic;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.LprodVo;

// jdbcTest 프로젝트의 JdbcTest05.java의 기능을 MyBatis 용으로 변환하시오.
// (mapper 파일명 : jdbc-mapper.xml) (namespace 속성값 : jdbc)
public class JdbcToMybatis {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
		// 1. MyBatis의 환경 설정 파일(mybatis-config.xml)을 읽어와서
		//	  처리하여 SqlSessionFactory객체를 생성한다.
		InputStream in = null;
		SqlSessionFactory sqlSessionFactory = null;
		try {
			// 1-1. 환경 설정 파일을 읽어올 스트림 객체 생성
			in = Resources.getResourceAsStream(
					"kr/or/ddit/mybatis/config/mybatis-config.xml");
			
			// 1-2. 환경 설정 파일을 읽어와 환경 설정 작업을 진행한다.
			//		(환경 설정이 완료되면 SqlSessionFactory객체가 생성된다.)
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(in); 
			
		} catch (Exception e) {
			System.out.println("MyBatis 초기화 실패!!");
			e.printStackTrace();
		} finally {
			if(in!=null) try { in.close(); }catch (IOException e) {	}
		}
	*/
		
	//===============================================================	
		
		SqlSession session = null;
		try {
//			session = sqlSessionFactory.openSession();
			session = MybatisUtil.getSqlSession();
			
			int nextId = session.selectOne("jdbc.getNextId");
			
			String gu;
			int count = 0;
			do {
				System.out.print("상품 분류 코드 입력 >> ");
				gu = sc.next();
				
				count = session.selectOne("jdbc.getLprodCount", gu);
				
				if(count>0) {
					System.out.println(gu + "는 이미 등록된 상품 분류 코드 입니다.");
					System.out.println("다시 입력 하세요...");
					System.out.println();
				}
				
			}while(count>0);
			
			System.out.print("상품 분류명 입력 >> ");
			String nm = sc.next();
			
			// 만들어진 데이터들을 VO객체에 저장한다.
			LprodVo lvo = new LprodVo();
			lvo.setLprod_id(nextId);
			lvo.setLprod_gu(gu);
			lvo.setLprod_nm(nm);
			
			int cnt = session.insert("jdbc.insertLprod", lvo);
			
			if(cnt>0) {
				session.commit();
				System.out.println("등록 성공!!!");
			}else {
				System.out.println("등록 실패~~~");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}

	}
}
