package kr.or.ddit.study06.sec01.test03;

public class ClassExample03 {
	public static void main(String[] args) {
		Pen p1 = new Pen();
		p1.color = "검정";
		p1.reach = 8;
		p1.name = "제트스트림";
		Pen p2 = new Pen();
		p2.color = "파랑";
		p2.reach = 9;
		p2.name = "파인테크";
		Pen p3 = new Pen();
		p3.color = "빨강";
		p3.reach = 9;
		p3.name = "모나미";
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
	}
}
