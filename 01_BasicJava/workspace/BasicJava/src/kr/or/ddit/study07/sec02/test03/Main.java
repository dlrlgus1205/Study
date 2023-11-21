package kr.or.ddit.study07.sec02.test03;

public class Main {
	public static void main(String[] args) {
		// 클래스 3개
		// Pen, FountainPen, BallPen
		FountainPen fp = new FountainPen();
		fp.length = 10;
		fp.bold = 1;
		fp.color = "Black";
		fp.ink = 100;
		
		BallPen bp = new BallPen();
		bp.length = 12;
		bp.bold = 1;
		bp.color = "Blue";
		bp.ink = 86;
	}
}
