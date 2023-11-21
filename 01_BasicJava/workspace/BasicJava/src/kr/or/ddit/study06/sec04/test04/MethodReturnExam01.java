package kr.or.ddit.study06.sec04.test04;

import java.util.Scanner;

public class MethodReturnExam01 {
	
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		MethodReturnExam01 m = new MethodReturnExam01();
		System.out.print("숫자 입력 : ");
		int num = m.sc.nextInt();
//		m.printTest();
		/*
		 * 1 입력 -> 출력1
		 * 3 입력 -> 출력1, 2, 3
		 */
//		m.printTest2(2);
//		m.printTest2(2);
		m.addNum(num);
	}
	
	public void printTest() {
		System.out.println("출력1");
		if(false) return;
		System.out.println("출력2");
	}
	
	public void printTest2(int num) {
		System.out.println("출력1");
		if(num == 1) {
			return;
		}
		System.out.println("출력2");
		if(num == 2) {
			return;
		}
		System.out.println("출력3");
		if(num == 3) {
			return;
		}
		System.out.println("출력4");
		if(num == 4) {
			return;
		}
	}
	
	public int addNum(int n) {
		/*
		 * 100 1 ~ n 값을 더하다가
		 * 100보다 커지면 현재까지 더해진 값을 리턴
		 * 만약에 100보다 커지지 않으면 n 까지 전체 합을 리턴
		 */
		int sum = 0;
		for(int i = 0; i <= n; i++) {
			sum += i;
			if(sum > 100) {
				System.out.println(sum);
				return sum;
			}
		}
		System.out.println(sum);
		return sum;
	}
}
