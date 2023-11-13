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
		String[] subject = {"국어", "영어", "수학", "총점", "평균", "석차"};
		String[] name = {"미연", "민니", "소연", "우기", "슈화"};
		
		// [국어][영어][수학][총점][평균][석차]
		int[][] scores = {{10, 20, 30, 0, 0, 0},
						  {15, 25, 35, 0, 0, 0},
						  {20, 30, 40, 0, 0, 0},
						  {30, 40, 50, 0, 0, 0},
						  {25, 35, 45, 0, 0, 0}};
		int scoresSz = scores.length;
		// 총점 
		for(int i = 0; i < scores.length; i++) {
			for(int j = 0; j < subject.length; j++) {
				scores[i][3] += scores[i][j];
			}
		}
		
		// 평균 
		for(int i = 0; i < scores.length; i++) {
			scores[i][4] = (int)(scores[i][3] / subject.length);
		}
		
		int num = 1;
		// 등수 구하기 - 총점 높은 순서대로
		for(int i = 0; i < scores.length; i++) {
			for(int j = 0; j < scores.length-1; j++) {
				if(scores[j][3] < scores[j+1][3]) {
					int[] temp = scores[j];
					scores[j] = scores[j+1];
					scores[j+1] = temp;
				}
			}
		}
		// 등수 매기기 
		for(int i = 0; i < scores.length; i++) {
			scores[i][5] = i+1;
		}
		// 등수 구하기 - 선생님
//		for(int i = 0; i < scores.length; i++) {
//			for(int j = 0; j < scores.length; j++) {
//				if(scores[i][3] > scores[j][3]) scores[i][5]++; 
//			}
//		}
		System.out.println("                     [성적표]");
		System.out.println("---------------------------------------------------");
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t석차");
		System.out.println("---------------------------------------------------");
		for(int i = 0; i < scores.length; i++) {
			System.out.print(name[i] + "\t");
			for(int j = 0; j < scores[i].length; j++) {
				System.out.print(scores[i][j] + "\t");
			}
			System.out.println("");
		}
	}
}
