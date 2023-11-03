package kr.or.ddit.study03;

import java.util.Scanner;

public class AssignOperator {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		AssignOperator obj = new AssignOperator();
		obj.method1();
	}
	public void method1() {
		// 대입 연산자
		// =, +=, -=, /=, %=
		
		int a = 10;
		int b = 7;

		a += b;
		System.out.println(a);
		
		a -= b;
		System.out.println(a);
		
		a /= b;
		System.out.println(a);
		
		a %= b;
		System.out.println(a);
	}
}
