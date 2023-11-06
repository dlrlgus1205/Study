package kr.or.ddit.study04.homework;

import java.util.Scanner;

public class HomeWork3 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		HomeWork3 obj = new HomeWork3();
//		obj.method1();
		obj.method2();
//		obj.method3();
		obj.method4();
	}

	private void method1() {
		/*
		 * 3) ***** **** *** ** *
		 */
		for (int w = 5; w > 0; w--) {
			for (int h = 1; h < w + 1; h++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private void method2() {
		/*
		 * 4) ***** **** *** ** *
		 */
		for (int w = 5; w > 0; w--) {
			for (int h = 1; h < w + 1; h++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private void method3() {
		/*
		 * 5) * ** *** **** *****
		 */
		for (int w = 5; w > 0; w--) {
			for (int h = 1; h < w; h++) {
				System.out.print(" ");
			}
			for (int h = 0; h < 6 - w; h++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private void method4() {
		/*
		 * 6) * *** ***** ******* *********
		 */
	}
}
