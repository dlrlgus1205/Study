package kr.or.ddit.study04.sec02;

import java.util.Scanner;

public class WhileExample03 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		WhileExample03 obj = new WhileExample03();
		obj.method1();
	}
	private void method1() {
		do {
			System.out.println("최초 1번은 반드시 실행됨");
		}while(false);
	}
}
