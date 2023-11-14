package kr.or.ddit.study06.sec03.tes02;

public class ConstructExam02 {
	public static void main(String[] args) {
		Menu m1 = new Menu(6000, "한솥", "메가치킨마요");
		Menu m2 = new Menu(7000, "이토식당", "제육덮밥");
		Menu m3 = new Menu(5900, "서브웨이", "행사메뉴");
		System.out.println(m1);
		System.out.println(m2);
		System.out.println(m3);
	}
}
