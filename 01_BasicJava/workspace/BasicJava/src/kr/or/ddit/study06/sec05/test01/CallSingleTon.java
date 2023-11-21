package kr.or.ddit.study06.sec05.test01;

import java.util.Date;

public class CallSingleTon {
	public static void main(String[] args) {
		// 싱글톤 객체 가져오기
		SingleTon st = SingleTon.getInstance();
		
		System.out.println("싱글톤 호출 시작");
		
		Date d1 = new Date();
		
		BigLoadSingleTon bs = BigLoadSingleTon.getInstance();
		BigLoadSingleTon bs2 = BigLoadSingleTon.getInstance();
		BigLoadSingleTon bs3 = BigLoadSingleTon.getInstance();
		
		System.out.println("싱글톤 호출 끝");
		Date d2 = new Date();
		
		long time = d2.getTime() - d1.getTime();
		System.out.println(time + "ms");
		
		
		System.out.println("객체 직접 호출 시작");
		
		d1 = new Date();
		
		BigLoadSingleTon bs_ = new BigLoadSingleTon();
		BigLoadSingleTon bs2_ = new BigLoadSingleTon();
		BigLoadSingleTon bs3_ = new BigLoadSingleTon();
		
		System.out.println("객체 직접 호출 끝");
		d2 = new Date();
		
		time = d2.getTime() - d1.getTime();
		System.out.println(time + "ms");
		
	}
}
