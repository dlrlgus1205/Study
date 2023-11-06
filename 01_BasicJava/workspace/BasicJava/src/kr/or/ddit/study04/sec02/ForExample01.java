package kr.or.ddit.study04.sec02;

import java.util.Scanner;

public class ForExample01 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ForExample01 obj = new ForExample01();
//		obj.method1();
//		obj.method2();
//		obj.method3();
//		obj.method4();
		obj.method5();
	}

	private void method5() {
		int sum = 0;
		for(int i = 2; i < 11; i = i + 2) {
				sum += i;
		}
		System.out.println("1 ~ 10까지 짝수의 합 : " + sum);
	}

	private void method4() {
		/*
		 * 1 ~ 10까지 홀수의 합 구하기
		 */
		int sum = 0;
		for(int i = 1; i < 11; i++) {
			if(i % 2 == 1) {
				sum += i;
			}
		}
		System.out.println("1 ~ 10까지 홀수의 합 : " + sum);
	}

	private void method3() {
		/*
		 * 입력 받은 값으로 구구단 출력해보기
		 */
		System.out.print("숫자 입력 : ");
		int gugu = sc.nextInt();
		
		for(int i = 1; i < 10; i++) {
			int dan = gugu * i;
//			System.out.printf("%d * %d = %d \n", gugu, i, dan);
			System.out.println(gugu + " * " + i + " = " + dan);
		}	
	}

	private void method2() {
		/*
		 * sum에 1 ~ 10까지의 값을 더할 것
		 */
		int sum = 0;
		for(int i = 1; i < 11; i++) {
			sum += i;
		}
		System.out.println("1 ~ 10의 합 : " + sum);
	}

	private void method1() {
		for(int i = 0; i < 10; i++) {
			System.out.println("현재 i 값 : " + i);
		}
	}
}
