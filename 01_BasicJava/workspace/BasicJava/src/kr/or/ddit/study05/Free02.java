package kr.or.ddit.study05;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Free02 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Free02 obj = new Free02();
		obj.process();
	}
	

	private void process() {
		int w, h, s;
		
		for(h = 0; h < 5; h++) {
			for(s = 0; s < 5 - h; s++) {
				System.out.print(" ");
			}
			for(w = 0; w < h * 2 + 1; w++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
