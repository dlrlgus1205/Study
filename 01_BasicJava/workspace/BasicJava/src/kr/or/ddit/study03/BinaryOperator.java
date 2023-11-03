package kr.or.ddit.study03;

import java.util.Scanner;

public class BinaryOperator {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		BinaryOperator obj = new BinaryOperator();
//		obj.artimeticOper();
//		obj.realation();
		obj.realation2();
	}
	
	public void artimeticOper( ) {
		// 산술 연산 +-*/ %
		
		int a = 7;
		int b = 3;
		System.out.println("a+b \t" + (a + b));
		System.out.println("a-b \t" + (a - b));
		System.out.println("a*b \t" + (a * b));
		System.out.println("a/b \t" + (a / b));
		System.out.println("a%b \t" + (a % b));
		
		System.out.print("숫자를 입력하세요 : ");
		int num = sc.nextInt();
		if(num % 2 == 0) {
			System.out.println("짝수");
		}
		else {
			System.out.println("홀수");
		}
	}
	public void realation() {
		// > < == >= <= !=
		
		int num = sc.nextInt();
		int b = 5;
		
		if(num > b) {
			System.out.println("num 값이 b 값보다 크다");
		}
		if(num < b) {
			System.out.println("num 값이 b 값보다 작다");
		}
		if(num == b) {
			System.out.println("num 값이 b 값과 같다");
		}
		if(num >= b) {
			System.out.println("num 값이 b 값보다 크거나 같다");
		}
		if(num <= b) {
			System.out.println("num 값이 b 값보다 작거나 같다");
		}
		if(num != b) {
			System.out.println("num 값이 b 값과 같지 않다");
		}
	}
	public void realation2() {
		// &&, ||, !
		
		boolean a = true;
		boolean b = true;
		
		if(a && b) {
			System.out.println("둘 다 참");
		}
		if(a || !b) {
			System.out.println("둘 중 하나만 참이여도 참");
		}
	}
}
