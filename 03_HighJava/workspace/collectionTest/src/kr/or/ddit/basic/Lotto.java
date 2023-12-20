package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Lotto {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		Lotto obj = new Lotto();
		obj.start();
	}

	private void start() {
		while(true) {
			int n = home();
			switch (n) {
			case 1:
				buy();
				break;
			case 2:
				System.out.println("감사합니다");
				break;
			default:
				break;
			}
			if(n == 2) {
				break;
			}
		}
	}

	private void buy() {
		System.out.println("Lotto 구입 시작");
		System.out.println();
		System.out.println("1000원에 로또 한 장입니다");
		System.out.print("금액 입력 : ");
		int money = sc.nextInt();
		if(money < 1000) {
			System.out.println("금액이 부족합니다");
		}
		else if(money > 100000) {
			System.out.println("금액이 너무 많습니다");
		}
		else {
			System.out.println();
			System.out.println("행운의 로또 번호는 아래와 같습니다");
			System.out.println("------------------------------");
			lotto(money);
			System.out.println("------------------------------");
			int change = money % 1000;
			System.out.println();
			System.out.println("받은 금액은 " + money + "원이고 거스름돈은 " + change + "원입니다");
		}
		System.out.println();
	}

	private void lotto(int money) {
		int lotto = money / 1000;
		
		HashSet<Integer> lottoSet = new HashSet<Integer>();
		ArrayList<Integer> lottoList = new ArrayList<Integer>(lottoSet);
		
		for(int i = 1; i < lotto + 1; i++) {
			while(lottoSet.size() < 6) {
				lottoSet.add((int)(Math.random() * (45 - 1 + 1) + 1));
			}
			System.out.println("로또 번호" + i + " : " + lottoSet);
			lottoSet.clear();
		}
	}

	private int home() {
		System.out.println("==============================");
		System.out.println("	Lotto 프로그램");
		System.out.println("------------------------------");
		System.out.println("	1. Lotto 구입");
		System.out.println("	2. 프로그램 종료");
		System.out.println("==============================");
		System.out.print("메뉴 선택 : ");
		int n = sc.nextInt();
		System.out.println();
		return n;
	}

}
