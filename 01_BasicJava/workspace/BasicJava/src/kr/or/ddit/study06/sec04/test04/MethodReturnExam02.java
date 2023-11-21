package kr.or.ddit.study06.sec04.test04;

public class MethodReturnExam02 {
	public static void main(String[] args) {
		MethodReturnExam02 m = new MethodReturnExam02();
		int[] score = {70, 65, 47};
		int sum = m.test01(score);
		System.out.println(sum);
		double avg = m.test02(score);
		System.out.println(avg);
		double[] arr = m.test03(score);
		System.out.println(arr[0]);
	}
	
	public int test01(int[] score) {
		/*
		 * 총점, 평균 구하고 리턴해보기
		 */
		int sum = 0;
		for(int i = 0; i < score.length; i++) {
			sum += score[i];
		}
		return sum;
	}
	
	public double test02(int[] score) {
		int sum = 0;
		double avg = 0;
		for(int i = 0; i < score.length; i++) {
			sum += score[i];
			avg = (double)(sum / score.length);
		}
		return avg;
	}
	
	public double[] test03(int[] score) {
		int sum = 0;
		double avg = 0;
		
		for(int i : score) {
			sum += i;
		}
		avg = (double)(sum / score.length);
		double arr[] = {sum, avg};
		
		return arr;
	}
}
