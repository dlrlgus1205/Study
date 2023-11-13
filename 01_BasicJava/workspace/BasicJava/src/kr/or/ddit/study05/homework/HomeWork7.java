package kr.or.ddit.study05.homework;

import java.util.Arrays;
import java.util.Scanner;

public class HomeWork7 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		HomeWork7 obj = new HomeWork7();
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
		
//		for(int i = 0; i < score.length; i++) {
//			System.out.println(Arrays.toString(score[i]));
//		}
		
		/*
		 * 등수 순서대로 출력 해보기
		 */
		
		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < score.length; j++) {
				if (score[i][5] < score[j][5]) {
					int temp = score[i][5];
					score[i][5] = score[j][5];
					score[j][5] = temp;
					
					String tn = name[i];
					name[i] = name[j];
					name[j] = tn;
				}
			}
		}
		
//		for(int i = 0; i<score.length - 1; i++) {
//			for(int j = 0; j<score.length - 1; j++) {
//				if(score[j][5] > score[j + 1][5]) {
//					int[] temp = score[j];
//					score[j] = score[j + 1];
//					score[j + 1] = temp;
//					
//					String tn = name[j];
//					name[j] = name[j + 1];
//					name[j + 1] = tn;
//				}
//			}
//		}
		
		System.out.println("                      [[성적표]]");
		System.out.println("-----------------------------------------------------");
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t석차");
		System.out.println("-----------------------------------------------------");
		
		for (int i = 0; i < score.length; i++) {
			System.out.print(name[i] + " : \t");
			for(int j = 0; j < score[i].length; j++) {
				System.out.print(score[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
