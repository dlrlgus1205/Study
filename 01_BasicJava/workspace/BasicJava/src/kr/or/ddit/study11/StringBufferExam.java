package kr.or.ddit.study11;

import java.util.Date;

public class StringBufferExam {
	public static void main(String[] args) {
//		Date d1 = new Date();
//	
//		System.out.println("string test");
//		stringTest(1000000);
//		
//		System.out.println("stringBuffer test");
//		stringBufferTest(1000000);
//		Date d2 = new Date();
//		long time = d2.getTime() - d1.getTime();
//		System.out.println(time+"ms");
		
		
		/*
		 *  StringBuffer와  StringBuilder는 String과 비슷하나 
		 *  저장된 문자열을 수정할수 있음.
		 * 
		 *  StringBuffer  : 스레드 이용시 발생될수 있는 동기화 문제도 해결된 안전한 사용가능
		 *  StringBuilder : 스레드에 안전하지 않음. 
		 * 
		 *  주요메서드
		 *  .append()          : 저장된 문자열에 추가.
		 *  .delete(int start, int end)       
		 *                     : start ~ end 까지 삭제 
		 *  .deleteCharAt(int idx)
		 *                     : idx 번째 문자 삭제 
		 *  .insert(int offset, 데이터)
		 *                     : offset 위치에 데이터 저장
		 *  .reverse()         : 저장된 문자열의 문자를 역순으로 반환
		 *  .toString()        : 문자열로 반환.
		 * 
		 */
		
		StringBuffer sql = new StringBuffer();
		sql.append(" select * ");
		sql.append(" from member ");
		sql.append(" where id ='test1'");
		
		System.out.println(sql.toString());
		sql.deleteCharAt(8);
		System.out.println(sql.toString());
		sql.insert(8, "*");
		System.out.println(sql.toString());
		
		System.out.println(sql.reverse());
	}
	
	public static void stringTest(int test) {
		String a = "";
		for(int i=0; i<test; i++) {
			a +="a";
		}
	}
	
	public static void stringBufferTest(int test) {
		StringBuffer a = new StringBuffer();
		for(int i=0; i<test; i++) {
			a.append("a");
		}
	}
}
