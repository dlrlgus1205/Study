package kr.or.ddit.study06.sec04.test04;

import java.util.Arrays;

public class MethodCopy {
	public static void main(String[] args) {
		MethodCopy mc = new MethodCopy();
		int arr[] = {1,2,3};
//		int sum = mc.copy(arr);
//		System.out.println(sum);
//		System.out.println(Arrays.toString(arr));
		arr = mc.copy2(arr);
	}
	
	public int[] copy2(int[] arr) {
		/*
		 * 2배로 증가하기
		 */
		for(int i = 0; i < arr.length; i++) {
			arr[i] *= 2;
		}
		return arr;
	}
	public int copy(int[] arr) {
		/*
		 * 2배로 증가하기
		 */
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			arr[i] *= 2;
			sum += arr[i];
		}
		return sum;
	}
}
