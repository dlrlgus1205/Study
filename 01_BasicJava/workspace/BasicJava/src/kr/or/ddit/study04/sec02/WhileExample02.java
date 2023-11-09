package kr.or.ddit.study04.sec02;

import java.util.Scanner;

public class WhileExample02 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		WhileExample02 obj = new WhileExample02();
//		obj.method1();
//		obj.method2();
//		obj.method3();
		obj.method4();
	}

	private void method4() {
		out : while(true){
				System.out.println("바깥쪽 while 문");
			while(true) {
				System.out.println("안쪽 while 문");
				break out;
			}
		}
		System.out.println("모든 와일문이 종료됨");
	}

	private void method3() {
		int sign = 1;
		int sum = 0;
		int i = 1;
		while(sum > -100) {
			sum += i * sign;
			sign = sign * -1;
			i++;
			System.out.println("while 진행 중 : " + sum);
		}
		System.out.println("i 번 실행 됨" + i + " 합 : " + sum);
	}

	private void method2() {
		int i; 
		int sign = 1;
		int sum = 0; 
		 for(i = 1; i < 11; i++) {
			 sum += i * sign;
			 sign = sign * -1;
		 }
		 System.out.println(sum);
	}

	private void method1() {
		// 첫날에 100원,
		// 그 다음날부터 전날의 2배씩 저축을 할 때 최초로 100만원을 넘는 날과
		// 그 날까지 저축한 액수를 구하시오
		
		int s = 0;
		int a = 100;
		int d = 0;
		
		while(s < 1000001) {
			System.out.println(d + "일의 저축액 : " + s);			
			s += a;
			a *= 2;
			d++;
		}
		System.out.println("날짜 수 : " + d);
		System.out.println("저축액 : " + a);
	}
}
