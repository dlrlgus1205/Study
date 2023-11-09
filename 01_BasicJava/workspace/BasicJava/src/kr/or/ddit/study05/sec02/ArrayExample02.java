package kr.or.ddit.study05.sec02;

import java.util.Random;
import java.util.Scanner;

public class ArrayExample02 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayExample02 obj = new ArrayExample02();
//		obj.method1();
//		obj.method2();
//		obj.method3();
		obj.method4();
	}

	private void method4() {
		/*
		 * 잔돈 반환 프로그램
		 * 
		 * 10만 500원
		 * 
		 * 10000원 10개 500원 1개
		 */
		int[] coin = {10000, 5000, 1000, 500, 100, 10};
		int amt = sc.nextInt();
		
		for (int i = 0; i < coin.length; i++) {
			// 10000원으로 나누었을 때 값이 있는지 없는지
			if(amt / coin[i] != 0) {
				System.out.println(coin[i] + " : " + amt / coin[i] + "개");
			}
			// 10000원에 나머지 값을 amt에 저장
			amt = amt % coin[i];			
		}
	}

	private void method3() {
		
		int[] lotto = new int[6];

		for (int i = 0; i < lotto.length; i++) {
			int random = new Random().nextInt(45) + 1;
			lotto[i] = random;
			for (int j = 0; j < i; j++) {
				if(lotto[j] == random) {
					i--;
					break;
				}
			}
		}
		for (int i = 0; i < lotto.length; i++) {
			System.out.println(lotto[i]);
		}
	}

	private void method2() {
		String[] na = {"홍길동", "이순신", "강감찬", "이성계", "세종"};
		int[] n = {30, 85, 70, 95, 55};
		
		for (int i = 0; i < n.length - 1; i++) {
			for (int j = 0; j < n.length - 1; j++) {
				if(n[j] > n[j + 1]) {
					
					int t = n[j];
					n[j] = n[j + 1];
					n[j + 1] = t;
					
					String tna = na[j];
					na[j] = na[j + 1];
					na[j + 1] = tna;
				}
			}
		}
		for (int i = 0; i < n.length; i++) {
			System.out.println(n[i] + " " + na[i]);
			
		}
	}

	private void method1() {
		/*
		 * 30, 85, 70, 95, 55 값을 배열에 저장
		 */
		
		int[] n = {30, 85, 70, 95, 55};
		
		/*
		 * 버블 정렬
		 */
		
//		for (int i = 0; i < n.length - 1; i++) {
//			for (int j = 0; j < n.length - 1; j++) {
//				if(n[j] > n[j + 1]) {
//					int t = n[j];
//					n[j] = n[j + 1];
//					n[j + 1] = t;
//				}
//			}
//		}
		
		/*
		 * 선택 정렬
		 */
		
		for (int i = 0; i < n.length - 1; i++) {
			for (int j = i + 1; j < n.length; j++) {
				if(n[i] > n[j]) {
					int t = n[i];
					n[i] = n[j];
					n[j] = t;
				}
			}
		}
		
		for (int i = 0; i < n.length; i++) {
			System.out.println(n[i]);
		}
		
	}
}
