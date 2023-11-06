package kr.or.ddit.study04.sec01;

import java.util.Scanner;

public class SwitchExample02 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		SwitchExample02 obj = new SwitchExample02();
		obj.method1();
	}

	private void method1() {
		/*
		 * 점수를 입력 받아 A ~ F 출력
		 */
		
		System.out.print("점수 입력 : ");
		int score = sc.nextInt();
		
		switch(score / 10) {
			case 10: case 9:
				System.out.println("A");
			break;
			case 8:
				System.out.println("B");				
			break;
			case 7:				
				System.out.println("C");
			break;
			case 6:				
				System.out.println("D");
			break;
			default :
				System.out.println("F");
			break;
		}
	}
}
