package kr.or.ddit.study04.homework;

import java.util.Scanner;

public class HomeWork3 {
	Scanner sc = new Scanner(System.in);
	int h, w, s;

	public static void main(String[] args) {
		HomeWork3 obj = new HomeWork3();
//		obj.method1();
//		obj.method2();
//		obj.method3();
//		obj.method4();
	}

	private void method1() {
		/*
		 * 3) 
		 * ***** 
		 * **** 
		 * *** 
		 * ** 
		 * *
		 */
		for(h = 0; h < 5; h++) {
			for(w = 0; w < 5 - h; w++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private void method2() {
		/*
		 * 4) 
		 * *****
		 *  ****
		 *   ***
		 *    **
		 *     *
		 */
		for(h = 0; h < 5; h++) {
			for(s = 0; s < h; s++) {
				System.out.print(" ");
			}
			for(w = 0; w < 5 - h; w++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private void method3() {
		/*
		 * 5) 
		 *     * 
		 *    **
		 *   ***
		 *  ****
		 * *****
		 */
		for(h = 0; h < 5; h++) {
			for(s = 0; s < 4 - h; s++) {
				System.out.print(" ");
			}
			for(w = 0; w < h + 1; w++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private void method4() {
		/*
		 * 6)
		 *     * 
		 *    *** 
		 *   ***** 
		 *  ******* 
		 * *********
		 */
		for(h = 0; h < 5; h++) {
			for(s = 0; s < 5 - h; s++) {
				System.out.print(" ");
			}
			for(w = 0; w < h + 1; w++) {
				System.out.print("*");
			}
			for(w = 0; w < h; w++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
