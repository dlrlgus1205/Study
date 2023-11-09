package kr.or.ddit.study03;

import java.util.Scanner;

public class TernaryOperator {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		TernaryOperator obj = new TernaryOperator();
//		obj.method1();
		obj.method2();
	}

	private void method2() {
		int num = sc.nextInt();
		int result = num <10 ? 3+4 : 4+5;
		System.out.println(result);
	}

	private void method1() {
		// 3항연산자
		
		boolean b = 1 == 1 ? true : false;
		System.out.println(b);
		
		int age = sc.nextInt();
		String result = age>=18 ? "성년입니다." : "미성년입니다.";
		System.out.println(result);
	}
}
