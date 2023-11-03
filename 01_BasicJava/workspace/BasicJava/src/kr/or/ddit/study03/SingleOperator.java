package kr.or.ddit.study03;

import java.util.Scanner;

public class SingleOperator {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		SingleOperator obj = new SingleOperator();
		obj.method1();
		obj.method2();
	}
	public void method1() {
		// 부호 연산자 +-
		int a = 10;
		int b = -a;
		
		System.out.println(b);
	}
	public void method2() {
		// 증감연산자 ++, --
		int a = 10;
		int val = a++;
		
		// val = a;
		// a = a+1;
		
		System.out.println("a : " + a + ", val : " + val);
		
		a = 10;
		val = ++a;
		
		// a = a+1;
		// val = a;
		
		System.out.println("a : " + a + ", val : " + val);
		
		a = 10;
		val = a--;
		
		System.out.println("a : " + a + ", val : " + val);
		
		a = 10;
		val = --a;
		
		System.out.println("a : " + a + ", val : " + val);
	}
}
