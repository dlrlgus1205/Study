package kr.or.ddit.study05.sec01;

import java.util.Scanner;

public class StringExample {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		StringExample obj = new StringExample();
		obj.method1();
	}

	private void method1() {
		String str1 = "홍길동";
		String str2 = "홍길동";
		String str3 = "강감찬";
		String str4 = new String("홍길동");
		
		System.out.println(str1 == str2);
		System.out.println(str2 == str3);
		System.out.println(str1 == str4);
		System.out.println(str1.equals(str4));
	}
}
