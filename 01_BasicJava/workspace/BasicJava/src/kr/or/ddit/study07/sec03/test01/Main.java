package kr.or.ddit.study07.sec03.test01;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Animal animal = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("1. 고양이");
		System.out.println("2. 강아지");
		int s = sc.nextInt();
		
		if(s == 1) {
			Cat c = new Cat();
			c.sound();
		}
		if(s == 2) {
			animal = new Dog();
		}
		
		animal.cry();
	}
}
