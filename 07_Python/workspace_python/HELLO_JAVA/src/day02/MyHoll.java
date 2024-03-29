package day02;

import java.util.Scanner;

public class MyHoll {
	public static void main(String[] args) {
		// 홀, 짝을 입력하시오
		// 나 : 홀
		// 컴 : 홀
		// 결과 : 승리
		Scanner sc = new Scanner(System.in);
		
		System.out.print("홀짝 선택 >> ");
		String str = sc.next();
		
		double rnd = Math.random();
		
		if(rnd > 0.5) {
			System.out.println("홀 " + rnd);
			if(str.equals("홀")) {
				System.out.println("승리");
			}
			if(str.equals("짝")) {
				System.out.println("패배");
			}
		}
		else {
			System.out.println("짝 " + rnd);
			if(str.equals("짝")) {
				System.out.println("승리");
			}
			if(str.equals("홀")) {
				System.out.println("패배");
			}
		}
	}
}
