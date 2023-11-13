package kr.or.ddit.study05.sec02;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayExample06 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayExample06 obj = new ArrayExample06();
		obj.method1();
	}

	private void method1() {
		/*
		 * 5명의 국어 영어 수학 점수를
		 * 2차원 배열을 이용해 선언 및 값을 저장 하세요
		 * score <- 
		 * 스캐너 x
		 * 
		 * 5명의 이름을 저장한 배열 선언
		 * name <-
		 */
		
		int[][] score = {{100, 100, 100, 0, 0, 1},
						 {85, 90, 95, 0, 0, 1},
						 {95, 90, 90, 0, 0, 1},
						 {90, 91, 92, 0, 0, 1},
						 {80, 90, 70, 0, 0, 1}};
		String[] name = {"미연", "민니", "소연", "우기", "슈화"};
		
		/*
		 * 총점, 평균, 등수 구하기
		 */
		
		for (int i = 0; i < score.length; i++) {
//			1. 총점 구하기1
//			int[] arr = score[i];
//			int sum = arr[0] + arr[1] + arr[2];
//			arr[3] = sum;
//			
//			2. 총점 구하기2
//			int sum = score[i][0] + score[i][1] + score[i][2];
//			score[i][3] = sum;
//			
//			3. 총점 구하기3
			score[i][3] = score[i][0] + score[i][1] + score[i][2];
//			평균 구하기
			score[i][4] = score[i][3] / 3;
		}
		
		for (int i = 0; i < score.length; i++) {
			for(int j = 0; j < score.length; j++) {
				if(score[i][3] < score[j][3]) score[i][5]++;
			}
		}
		
		for(int i = 0; i < score.length; i++) {
			System.out.println(Arrays.toString(score[i]));
		}
		
		for (int i = 0; i < score.length; i++) {
			System.out.print(name[i] + " : \t");
			for(int j = 0; j < score[i].length; j++) {
				System.out.print(score[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
