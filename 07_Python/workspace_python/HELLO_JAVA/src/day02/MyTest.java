package day02;

import java.util.Scanner;

public class MyTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫번째 숫자 >> ");
		int n1 = sc.nextInt();
		System.out.print("두번째 숫자 >> ");
		int n2 = sc.nextInt();
		System.out.println("두 수의 합 >> " + (n1 + n2));
	}
}
