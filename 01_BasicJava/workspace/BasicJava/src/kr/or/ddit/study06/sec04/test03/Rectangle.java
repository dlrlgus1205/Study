package kr.or.ddit.study06.sec04.test03;

public class Rectangle {
	public static void main(String[] args) {
		/*
		 * 사각형 넓이를 구하는 메소드 만들어 보기
		 * 파라미터 높이, 너비
		 */
		Rectangle r = new Rectangle();
		int area = r.area(5, 8);
		System.out.println(area);
	}
	
	public int area(int height, int width) {
		return height * width;
	}
}
