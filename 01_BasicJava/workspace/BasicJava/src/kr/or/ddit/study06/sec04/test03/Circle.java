package kr.or.ddit.study06.sec04.test03;

public class Circle {
	public static void main(String[] args) {
		Circle c1 = new Circle();
		double circumference = c1.circumference(10);
		System.out.println(circumference);
		double area = c1.area(10);
		System.out.println(area);
	}
	
	//원의 둘레 구하는 메소드 작성
	// 2 * PI * 반지름
	public double circumference(int r) {
		return 2 * Math.PI *  r;
	}
	
	//원의 넓이 구하는 메소드 작성
	// PI * 반지름 * 반지름
	public double area(int r) {
		return Math.PI * r * r;
	}
}
