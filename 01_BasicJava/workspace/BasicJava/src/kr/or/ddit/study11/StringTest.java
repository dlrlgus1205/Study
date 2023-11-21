package kr.or.ddit.study11;

import java.io.File;
import java.util.Scanner;

public class StringTest {
	public static void main(String[] args) {
		StringTest st = new StringTest();
//		st.method1();
//		st.method2();
//		st.method3();
//		st.method4();
//		st.method5();
//		st.method6();
//		st.method7();
		st.method8();
	}

	private void method8() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("프로그램을 종료 하시겠습니까 (y/n)");
			String input = sc.next();
			if(input.equalsIgnoreCase("y")) {
				break;
			}
		}
	}
	
	public boolean equalsIgnoreCase(String str1, String str2) {
		str1 = str1.toLowerCase().trim();
		str2 = str2.toLowerCase().trim();
		return str1.equals(str2);
	}

	private void method7() {
		String str = "0123456789";
		String start = "";
		if(str.startsWith(start)) {
			System.out.println("'" + start + "'로 시작하는 문자열");
		}
		String end = "";
		if(str.endsWith(end)) {
			System.out.println("'" + end + "'로 끝나는 문자열");
		}
		File src = new File("D:\\D_setting\\A_TeachingMaterial\\Study-main\\01_BasicJava\\workspace\\BasicJava\\src");
		subList(src);
	}
	
	public void subList(File src) {
		for (File f : src.listFiles()) {
			if(f.isDirectory()) {
				subList(f);
			}
			if(f.getName().endsWith(".java")) {
				System.out.println(f);
				System.out.println("자바 파일");
			}
		}
	}

	private void method6() {
		String str = "0123456789";
		str = str.substring(3, 7);
		System.out.println(str);
	}

	private void method5() {
		String str = "바보 멍청이 dddd";
		str = str.replace("바보", "**");
		str = str.replace("멍청이", "***");
		System.out.println(str);
		
		String str2 = "100	100	100	11000	1000";
		str2 = str2.replace("\t", ",");
		System.out.println(str2);
	}

	private void method4() {
		String str = "소인수분해란 어떤 수를 소수들의 곱으로 표현하는 것입니다. 예를 들어 12를 소인수 분해하면 2 * 2 * 3 으로 나타낼 수 있습니다. 따라서 12의 소인수는 2와 3입니다.자연수 n이 매개변수로 주어질 때 n의 소인수를 오름차순으로 담은 배열을 return하도록 solution 함수를 완성해주세요.";
		String str2 = "100	100	100	11000	1000\r\n";
		String str3 = "100, 200, 300, 400";
		String[] lines = str.split(".");
		for(int i = 0; i < lines.length; i++) {
			System.out.println((i + 1) + ". " + lines[i]);
		}
	}

	private void method3() {
		String str = "         aB       cDe                       F \t\r               ";
		System.out.println("------------------------------------------------------");
		System.out.println(str);
		System.out.println("------------------------------------------------------");
		//********************
		str = str.trim();
		System.out.println(str);
		System.out.println("------------------------------------------------------");
	}

	private void method2() {
		String str = "aBcDeF";
		System.out.println(str);
		System.out.println(str.toLowerCase());
		System.out.println(str.toUpperCase());
	}

	private void method1() {
		String str = "문자열 테스트";
		String search = " ";
		if(str.contains(search)) {
			System.out.println("'"+ search + "'문구 포함");
		}
	}
}
