package kr.or.ddit.study02.sec3;

public class CastExample2 {
	public static void main(String[] args) {
		/*
		 * 문자형 String 객체
		 * -> 기본형(byte, short, int, long, float
		 *         double, char, boolean)
		 *         
		 *         앞글자 대문자로
		 * 
		 * 기본 타입 Wrapper 클래스
		 * byte -> Byte
		 * 
		 * int -> Integer
		 * char -> Character
		 */
		
//		String val = "16";
//		
//		// Wrapper 클래스.parse 기본 타입 이름(값);
//		int i1 = Integer.parseInt(val) + 3;
//		System.out.println(i1);
//		
//		String s = val + 3;
//		System.out.println(s);
//		
//		String val2 = "16.12313";
//		
//		double d1 = Double.parseDouble(val2);
//		System.out.println(d1);
		
		/*
		 * 기본 타입 변수 선언하고 문자 값 넣어서 변환해볼 것
		 */
		
		byte b1 = Byte.parseByte("11");
		System.out.println(b1);
		
		int i = Integer.parseInt("15");
		System.out.println(i);
		
		short s = Short.parseShort("2");
		System.out.println(s);
		
		double d = Double.parseDouble("3.14159265");
		System.out.println(d);
		
		float f = Float.parseFloat("5.55555");
		System.out.println(f);
		
		long l = Long.parseLong("1234567890");
		System.out.println(l);
		
		char c = Character.valueOf('K');
		System.out.println(c);
		
	}
}
