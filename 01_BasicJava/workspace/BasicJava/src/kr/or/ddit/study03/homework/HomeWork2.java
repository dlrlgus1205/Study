package kr.or.ddit.study03.homework;

import java.util.Scanner;

public class HomeWork2 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		HomeWork2 obj = new HomeWork2();
		obj.process();
	}

	public void process() {
		//윤년인지 판단하기.
		
		
		System.out.print("연도를 입력하세요 : ");
		int year = sc.nextInt();
		
		if(year % 100 != 0 && year % 4 == 0 || year % 400 == 0) {
			System.out.println("윤년입니다.");
		}
		else {
			System.out.println("평년입니다.");
		}
	}
	
}
