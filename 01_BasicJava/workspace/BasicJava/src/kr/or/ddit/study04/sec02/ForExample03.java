package kr.or.ddit.study04.sec02;

import java.util.Scanner;

public class ForExample03 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ForExample03 obj = new ForExample03();
//		obj.method1();
//		obj.method2();
//		obj.method3();
//		obj.method4();
		obj.method5();
//		obj.method6();
//		obj.method7();
	}

	private void method7() {
		for(int i = 0; i < 10; i++) {
			if(i < 2) {
				continue;
			}
			System.out.println("i 값은 : " + i);
		}
	}

	private void method6() {
		/*
		 * 숫자를 입력 받고 해당 숫자까지의 곱
		 * 
		 * ex 5 -> 1*2*3*4*5
		 */
		
		System.out.print("숫자 입력 : ");
		int n = sc.nextInt();
		int g = 1;
		
		for(int i = 1; i < n + 1; i++) {
			g *= i;
		}
		System.out.println(n + "까지의 곱 : " + g);
	}

	private void method5() {
		/*
		 * 소문자 문자열을 입력 받고 모음 제거
		 * apple -> ppl
		 */
		
		String str = sc.nextLine();
		
		String result = "";
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				continue;
			}
			result += c;
		}
		System.out.println(result);
	}

	private void method4() {
		/*
		 * 스캐너를 통해 숫자를 입력 받고
		 * 홀수라면 1부터 해당 숫자까지 홀수의 합
		 * 짝수라면 2부터 해당 숫자까지 짝수의 합
		 * 
		 * ex) 9 1~9까지 홀수의 합
		 */
		System.out.print("숫자 입력 : ");
		int n = sc.nextInt();
		int s = 0;
		if(n % 2 == 0) {
			System.out.println(n + " = 짝수");
			for(int i = 2; i < n + 1; i = i + 2) {
				s += i;
			}
			System.out.println(n + "까지 짝수의 합 : " + s);
		}
		else {
			System.out.println(n + " = 홀수");
			for(int i = 1; i < n + 1; i = i + 2) {
				s += i;
			}
			System.out.println(n + "까지 홀수의 합 : " + s);
		}
	}

	private void method3() {
		/*
		 * 여러 문자를 입력 받아
		 * 
		 * a -> A 변환
		 * 
		 * A -> a 변환
		 */
		
		String str = sc.nextLine();
		int lc = 'a' - 'A';
		for(int i = 0; i < str.length(); i++) {
			int a = str.charAt(i);
			char c = ' ';
			if('a' <= a && a <= 'z') {
				c = (char)(a - lc);
			}
			if('A' <= a && a <= 'Z') {
				c = (char)(a + lc);
			}
			System.out.print(c);
		}
	}

	private void method2() {
		/*
		 * a -> A 변환
		 * 
		 * A -> a 변환
		 */
		
		int lc = 'a' - 'A';
		char ch = ' ';
		char c = sc.nextLine().charAt(0);
		if('a' <= c && c <= 'z') {
			ch = (char)(c - lc);
			System.out.println(ch);
		}
		if('A' <= c && c <= 'Z') {
			ch = (char)(c + lc);
			System.out.println(ch);
		}
	}

	private void method1() {
		/*
		 * a ~ z까지 출력해주는 프로그램 만들기
		 */
		
		char c = 'a';
		for(int i = 0; i < 26; i++) {
			System.out.println((char)(c+i));
		}
	}
}
