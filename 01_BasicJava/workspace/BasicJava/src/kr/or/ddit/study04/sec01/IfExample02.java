package kr.or.ddit.study04.sec01;

import java.util.Scanner;

public class IfExample02 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		IfExample02 obj = new IfExample02();
		obj.method1();
	}

	private void method1() {
		/*
		 * 수도 요금 계산
		 * 사용량 별 단가
		 * 1 ~ 9 : 200
		 * 10 ~ 19 : 250
		 * 20 ~ 29 : 350
		 * 30 ~ 39 : 500
		 * 그 이상 : 750
		 * 
		 * 하수도 사용량 : 톤 당 150원
		 * 
		 * 수도 요금 = 사용량 별 요금 + 물 이용 분담금(3000) + 하수도 요금
		 * ex) 26톤 사용 시 (200 * 9 + 250 * 10 + 7 * 350) + (3000) + (26 * 150)
		 */
		
		System.out.print("사용량 입력 : ");
		int t = sc.nextInt();
		int p = 3000;
		
		if(t < 10) {
			int s = 200 * t;
			int h = 150 * t;
			p += s + h;
		}
		else if(t < 20) {
			int s = 200 * 9 + 250*(t - 9);
			int h = 150 * t;
			p += s + h;
		}
		else if(t < 30) {
			int s = 200 * 9 + 250 * 10 + 350 * (t - 19);
			int h = 150 * t;
			p += s + h;
		}
		else if(t < 40) {
			int s = 200 * 9 + 250 * 10 + 350 * 10 + 500 * (t - 29);
			int h = 150 * t;
			p += s + h;
		}
		else {
			int s = 200 * 9 + 250 * 10 + 350 * 10 + 500 * 10 + 750 * (t - 39);
			int h = 150 * t;
			p += s + h; 
		}
		System.out.println("사용 요금 : " + p);
	}
}
