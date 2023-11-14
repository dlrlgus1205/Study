package kr.or.ddit.study05;

import java.util.Scanner;

public class Free02 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
	
		Free02 obj = new Free02();
		
		int[] x = new int[6];
		int[] y = new int[6];
		int[] width = new int[3];
		int[] height = new int[3];
		
		System.out.println("x좌표 입력");
		for(int i = 0; i < x.length; i = i + 2) {
			x[i] = obj.sc.nextInt();
			System.out.println(x[i]);
		}
	}
}
