package kr.or.ddit.study07.sec02.test04;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	/*
	 * 상품 클래스
	 * Prod
	 * 이름, 가격
	 * 
	 * 전자제품
	 * ElectroniProd
	 * 이름, 가격 전압, 전력 소비량
	 * 
	 * FoodProd
	 * 이름, 가격, 유통기한
	 */
		Prod prod = null;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1.전자제품");
		System.out.println("2식품");
		
		int s= sc.nextInt();
		if(s == 1) {
			System.out.println("전자제품");
			ElectroniProd ep = new ElectroniProd();
			ep.setName("에어프라이어");
			ep.setPrice(50000);
			ep.setVoltage(220);
			ep.setWh(1000);
			System.out.println(ep);
		}
		if(s == 2) {
			System.out.println("식품");
			FoodProd fp = new FoodProd();
			fp.setName("춘식이 커피 우유");
			fp.setPrice(1850);
			fp.setDate(7);
			System.out.println(fp);
		}
		
	}
}
