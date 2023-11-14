package kr.or.ddit.study06.sec03.tes04;

public class Triangle {
	int x1;
	int y1;
	int x2;
	int y2;
	int x3;
	int y3;
	double area;
	
	public Triangle(Point p1, Point p2, Point p3) {
//		this.x1 = p1.x;
//		this.y1 = p1.y;
//		this.x2 = p2.x;
//		this.y2 = p2.y;
//		this.x3 = p3.x;
//		this.y3 = p3.y;
		this(p1.x, p1.y, p2.x, p2.y, p3.x, p3.y);
	}
	
	public Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.x3 = x3;
		this.y3 = y3;
		this.area = Math.abs((x1 * y2 + x2 * y3 + x3 * y1) - (x1 * y3 + x2 * y1 + x3 * y2)) / 2.0;
	}

	@Override
	public String toString() {
		return "Triangle [x1=" + x1 + ", y1=" + y1 + ", x2=" + x2 + ", y2=" + y2 + ", x3=" + x3 + ", y3=" + y3
				+ ", area=" + area + "]";
	}
	
}
