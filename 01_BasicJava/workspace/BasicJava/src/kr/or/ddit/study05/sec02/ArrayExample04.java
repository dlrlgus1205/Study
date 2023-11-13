package kr.or.ddit.study05.sec02;

import java.util.Scanner;

public class ArrayExample04 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayExample04 obj = new ArrayExample04();
//		obj.method1();
//		obj.method2();
//		obj.method3();		
		obj.method4();		
	}

	private void method4() {

		int[][] scores = new int[3][3];
		
		for(int i = 0; i < scores.length; i++) {
			System.out.println((i + 1) + "학생의 국어, 영어, 수학 점수 입력 : ");
			int kscore = sc.nextInt();
			int escore = sc.nextInt();
			int mscore = sc.nextInt();
			scores[i][0] = kscore;
			scores[i][1] = escore;
			scores[i][2] = mscore;
		}
	}

	private void method3() {
		/*
		 * 학생 3명의 국어 영어 수학 점수 저장해보기
		 */
		
		int[] s1 = {70, 80, 90, 0};
		int[] s2 = {75, 85, 95, 0};
		int[] s3 = {90, 92, 94, 0};
		
		int[][] scores = new int[3][4];
		scores[0] = s1;
		scores[1] = s2;
		scores[2] = s3;
		
		/*
		 * 첫번째 학생의 영어 점수
		 * 두번째 학생의 영어 수학 점수
		 * 세번째 학생의 국어 점수 각각 출력해보기
		 */
		int s1e = scores[0][1];
		int s2e = scores[1][1];
		int s2m = scores[1][2];
		int s3k = scores[2][0];
		
		System.out.println("첫번째 학생의 영어 점수 : " + s1e);
		System.out.println("두번째 학생의 영어 점수 : " + s2e);
		System.out.println("두번째 학생의 수학 점수 : " + s2m);
		System.out.println("세번째 학생의 국어 점수 : " + s3k);
	}

	private void method2() {
		
		int[] s1 = {70, 80, 90, 0};
		int[] s2 = {75, 85, 95, 0};
		int[] s3 = {90, 92, 94, 0};
		
		/*
		 * 2차원 배열
		 * 
		 * int[][] <- 타입
		 * scores <- 변수명
		 * new <- 객체 생성
		 * int[3] <- 1차월 배열의 수 [4] <- 1차원 배열 길이;
		 */
		
		int[][] scores = new int[3][4];
		scores[0] = s1;
		scores[1] = s2;
		scores[2] = s3;
		
		//총점 구하기
		for(int i = 0; i < scores.length; i++) {
			int sum = 0;
			for(int j = 0; j < scores[i].length; j++) {
				sum += scores[i][j];
			}
			scores[i][3] = sum;
		}
		for(int i = 0; i < scores.length; i++) {
			for(int j = 0; j < scores[i].length - 1; j++) {
				System.out.print(scores[i][j] + "\t");
			}
			System.out.println("평균 : " + scores[i][3] / 3.0);
		}
	}

	private void method1() {
		/*
		 * 학생 3명의 국어 영어 수학 점수 저장해보기
		 * 스캐너 사용 x
		 */
		
		int[] s1 = {70, 80, 90};
		int[] s2 = {75, 85, 95};
		int[] s3 = {90, 92, 94};
		
		int sum1 = 0;
		int sum2 = 0;
		int sum3 = 0;
		
		double avg1 = 0;
		double avg2 = 0;
		double avg3 = 0;
		
		for(int i = 0; i < s1.length; i++) {
			sum1 += s1[i];
		}
		for(int i = 0; i < s2.length; i++) {
			sum2 += s2[i];
		}
		for(int i = 0; i < s3.length; i++) {
			sum3 += s3[i];
		}
		
		avg1 = sum1 / s1.length;
		avg2 = sum2 / s2.length;
		avg3 = sum3 / s3.length;
		
		for(int i = 0; i < s1.length; i++) {
			System.out.print(s1[i] + "\t");
		}
		System.out.println("총점 : " + sum1 + "\t평균 : " + avg1);
		for(int i = 0; i < s2.length; i++) {
			System.out.print(s2[i] + "\t");
		}
		System.out.println("총점 : " + sum2 + "\t평균 : " + avg2);
		for(int i = 0; i < s3.length; i++) {
			System.out.print(s3[i] + "\t");
		}
		System.out.println("총점 : " + sum3 + "\t평균 : " + avg3);
		
	}
}
