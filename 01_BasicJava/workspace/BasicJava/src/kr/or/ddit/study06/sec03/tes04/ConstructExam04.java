package kr.or.ddit.study06.sec03.tes04;

public class ConstructExam04 {
	public static void main(String[] args) {
		Rectangle r1 = new Rectangle(4, 5, 2, 3);
		System.out.println(r1);
		
		Point p1 = new Point(0, 0);
		Point p2 = new Point(0, 10);
		Point p3 = new Point(10, 0);
		
		Triangle t1 = new Triangle(0, 0, 0, 10, 10, 0);
		Triangle t2 = new Triangle(p1, p2, p3);
		System.out.println(t1);
	}
}
