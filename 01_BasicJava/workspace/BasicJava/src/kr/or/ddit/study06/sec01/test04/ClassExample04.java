package kr.or.ddit.study06.sec01.test04;

public class ClassExample04 {
	public static void main(String[] args) {
		Menu m1 = new Menu();
		m1.store = "한솥";
		m1.price = 6000;
		m1.name = "메가치킨마요";
		Menu m2 = new Menu();
		m2.store = "한솥";
		m2.price = 7000;
		m2.name = "새치고기고기";
		
		System.out.println(m1);
		System.out.println(m2);
	}
}
