package kr.or.ddit.study02.sec2;

public class ExamFloat {
	public static void main(String[] args) {
		/*
		 * float 4byte
		 * 부호 1bit 지수 8bit 가수 23bit
		 * 
		 * 끝자리에 F 나 f 추가 해야함.
		 * 
		 */
		
		float f1 = 3.141592f;
		
		System.out.println(f1);
		
		int sum = 90 + 86 + 77;
		float avg = sum/3.0f;
		
		System.out.println("점수 총합은 " + sum + ", 평균은 " + avg);

		/*
		 * double 8byte
		 * 부호 1bit 지수 11bit 가수 52bit
		 * 
		 * 끝자리에 D나 d 생략 가능.
		 * 
		 */
		
		double d1 = 3.141592;
		
		double avg_d = sum/3.0;
		System.out.println("점수 총합은 " + sum + ", 평균은 " + avg_d);
		
		if(d1 == f1) {
			System.out.println("같은 값");
		}
		else {
			System.out.println("다른 값");
		}
	}
}
