package kr.or.ddit.study02.sec3;

public class CastExample1 {
	public static void main(String[] args) {
		// cast : 강제형변환
		// cast 연산자 타입 필요
		// short res = (short)100;
		
		byte b1 = 10;
		short s1 = 100;
		
		short res = (short)(s1 + b1);
		
		double d1 = 34.131251;
		d1 = d1 * 10;
		//341.31251
		
		int temp = (int)d1;
		//341
		
		d1 = (double)temp / 10;
		//34.1
		
		System.out.println(d1);
		
		// 소수점 2자리 값을 출력해볼 것.
		double d2 = 2313.1231;
		d2 = d2 * 100;
		
		int i = (int)d2;
		
		d2 = i / 100.0;
		
		System.out.println(d2);
	}
}
