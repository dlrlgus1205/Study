package kr.or.ddit.study04.homework;

import java.util.Random;
import java.util.Scanner;

public class HomeWork4 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		HomeWork4 obj = new HomeWork4();
//		obj.process1();
		obj.process2();
		
	}

	private void process2() {
		/*
		 * 각 변수에 로또 숫자 6개 넣을 것
		 * 
		 * 중복 되지 않게 넣기
		 */
		int a1 = 0;
		int a2 = 0;
		int a3 = 0;
		int a4 = 0;
		int a5 = 0;
		int a6 = 0;
		
		for(int i = 0; i < 6; i++) {
		int random = new Random().nextInt(45) + 1;
		if(i == 0) a1 = random;
		if(i == 1) a2 = random;
		if(i == 2) a3 = random;
		if(i == 3) a4 = random;
		if(i == 4) a5 = random;
		if(i == 5) a6 = random;
		for(int j = 0; j < i; j++) {
			if(j == 0) {
				if(a1 == random) {
					i--;
					break;
				}
			}
			if(j == 1) {
				if(a2 == random) {
					i--;
					break;
				}
			}
			if(j == 2) {
				if(a3 == random) {
					i--;
					break;
				}
			}
			if(j == 3) {
				if(a4 == random) {
					i--;
					break;
				}
			}
			if(j == 4) {
				if(a5 == random) {
					i--;
					break;
				}
			}
		}
	}
		System.out.printf("%d %d %d %d %d %d", a1, a2, a3, a4, a5, a6);
	}

	private void process1() {
		// 숫자 맞추기 게임을 완성해보자. 
		int random = new Random().nextInt(100);
		
		int j = 0;
		while(true) {			
			System.out.print("숫자 입력 : ");
			int i = sc.nextInt();
			j ++;
			if(i == random) {
				System.out.println("***정답***");
				System.out.println(j + "번 시도");
				break;
			}
			else if(i < random) {
				System.out.println("Up");
			}
			else {
				System.out.println("Down");
			}
		}
	}
}
