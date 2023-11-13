package kr.or.ddit.study04.sec02;

import java.util.Scanner;

public class WhileExample01 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		WhileExample01 obj = new WhileExample01();
//		obj.method1();
//		obj.method2();
		obj.method3();
	}

	private void method3() {
		while(true) {
			System.out.println("프로그램이 실행 중");
			String str = sc.nextLine();
			
			if(str.equals("exit")) {
				System.out.println("프로그램 종료");
				break;
			}
		}
	}

	private void method2() {
		int i = -1;
		while(i < 0) {
			i = i - 10000;
			System.out.println(i);
		}
	}

	private void method1() {
		int i = 0;
		while(i<10) {
			System.out.println("실행 중");
			i++;
		}
	}
}
