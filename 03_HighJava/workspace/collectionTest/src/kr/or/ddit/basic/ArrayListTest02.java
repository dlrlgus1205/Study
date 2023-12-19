package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 문제1) 5명의 사람 이름을 입력 받아 ArrayList에 저장한 후에
 * 		이들 중에서 '김'씨 성의 이름을 모두 출력하시오.
 * 		(단, 입력은 Scanner 객체를 이용한다.)
 * 
 * 문제2) 5명의 별명을 입력 받아 ArrayList에 저장하고
 * 		이들 중에서 별명의 길이가 제일 긴 별명을 출력하시오.
 * 		(단, 각 별명의 길이는 모두 다르게 입력한다.)
 * 
 * 문제3) '문제2'에서 입력하는 별명의 길이가 같은 것이 있을 수 있을 때
 * 		결과를 출력하시오
 */

public class ArrayListTest02 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		ArrayListTest02 obj = new ArrayListTest02();
		
		obj.test1();
		obj.test2();
		obj.test3();
	}

	private void test3() {
		ArrayList<String> al = new ArrayList<String>();
		ArrayList<String> maxAL = new ArrayList<String>();
		for(int i = 0; i < 5; i++) {
			String name = sc.next();
			al.add(name);
		}
		
		String max = "";
		
		for (String str : al) {
			if(str.length() > max.length()) {
				maxAL.clear();
				max = str;
				maxAL.add(max);
			}
			else if(str.length() == max.length()) {
				max = str;
				maxAL.add(max);
			}
		}
		System.out.println("제일 긴 별명 : " + maxAL);
	}

	private void test2() {
		ArrayList<String> al = new ArrayList<String>();
		al.add(sc.next());
		al.add(sc.next());
		al.add(sc.next());
		al.add(sc.next());
		al.add(sc.next());
		
		String max = "";
		
		for (String str : al) {
			if(str.length() > max.length()) {
				max = str;
			}
		}
		System.out.println("제일 긴 별명 : " + max);
	}
	
	private void test1() {
		ArrayList<String> al = new ArrayList<String>();
		for(int i = 0; i < 5; i++) {
			String name = sc.next();
			al.add(name);
		}
		
		for (String str : al) {
			if(str.substring(0, 1).contains("김")) {
				System.out.println("'김'씨 성을 가진 사람 : " + str);
			}
		}
		
//		System.out.println();
//		System.out.println("'김'씨 성을 가진 사람들");
//		for(int i = 0; i < al.size(); i++) {
//			1번 풀이
//			if(al.get(i).substring(0, 1).equals("김")) {
//				System.out.println(al.get(i));
//			}
			
//			2번 풀이
//			if(al.get(i).charAt(0) == '김') {
//				System.out.println(al.get(i));
//			}
			
//			3번 풀이
//			if(al.get(i).startsWith("김")) {
//				System.out.println(al.get(i));
//			}
			
//			4번 풀이
//			if(al.get(i).indexOf("김") == 0) {
//				System.out.println(al.get(i));
//			}
//		}
	}
}
