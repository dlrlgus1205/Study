package kr.or.ddit.study05.sec02;

import java.util.Scanner;

public class ArrayExample03 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayExample03 obj = new ArrayExample03();
		obj.method1();
	}

	private void method1() {
		
		int[] arr = {10, 30, 34, 54, 7};
		// max 값 찾기
		// min 값 찾기
		
		int max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		System.out.println(max);
		
		int min = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if(min > arr[i]) {
				min = arr[i];
			}
		}
		System.out.println(min);
	}
}
