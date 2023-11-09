package kr.or.ddit.study05.sec02;

import java.util.Scanner;

public class ArrayExample01 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayExample01 obj = new ArrayExample01();
//		obj.method1();
//		obj.method2();
//		obj.method3();
		obj.method4();
	}

	private void method4() {
		/*
		 * 국어 영어 수학 총점 평균
		 */
		
		int s = 0;
		double a = 0;
		int[] n = new int[3];
		
		for (int i = 0; i < n.length; i++) {
			n[i] = sc.nextInt();
		}
		
		for (int i = 0; i < n.length; i++) {
			s += n[i];
		}
		a = s / 3.0;
		System.out.println("총점 : " + s);
		System.out.println("평균 : " + a);
	}

	private void method3() {
		/*
		 * 배열 선언 후 값을 scanner 통해 저장.
		 * 
		 * 전체 배열 출력해보기
		 */
		
		String[] name = new String[3];
		
		for(int i = 0; i<name.length; i++) {
			name[i] = sc.nextLine();
		}
		for(int i = 0; i<name.length; i++) {
			System.out.println(name[i]);
		}
	}

	private void method2() {
		/*
		 * String[] name = new String[2];
		 * 
		 * name[0] = "홍길동";
		 * name[1] = "강감찬";
		 */
		String[] name = {"홍길동", "강감찬"};
		// arr.length 배열 길이
		for(int i = 0; i < name.length; i++) {
			System.out.println(name[i]);
		}
	}

	private void method1() {
		/*
		 * char		 <- 배열 타입
		 * []		 <- 변수 앞이나 뒤에
		 * alpabet 	 <- 변수명
		 * new 		 <- 객체 생성
		 * char		 <- 배열 타입
		 * [26]; 	 <- 생성 숫자
		 */
		char[] alpabet = new char[26];
		for(int i = 0; i < alpabet.length; i++) {
			alpabet[i] = (char)(i+65);
		}
		
		for(int i = 0; i < alpabet.length; i++)
			System.out.println(alpabet[i]);
	}
}
