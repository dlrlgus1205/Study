package kr.or.ddit.study06.homework;

import java.util.Scanner;

public class Rectangle {
	
	Scanner sc = new Scanner(System.in);
	
	int x1;
	int x2;
	int y1;
	int y2;
	double rectangle1;
	double width1;
	double height1;
	
	int x3;
	int x4;
	int y3;
	int y4;
	double rectangle2;
	double width2;
	double height2;
	
	int x5;
	int x6;
	int y5;
	int y6;
	double rectangle3;
	double width3;
	double height3;
	
	public static void main(String[] args) {
		Rectangle obj = new Rectangle();
		
		System.out.println("첫번째 사각형");
		System.out.print("x좌표 입력 : ");
		int x1 = obj.sc.nextInt();
		System.out.print("y좌표 입력 : ");
		int y1 = obj.sc.nextInt();
		System.out.print("가로 입력 : ");
		int width1 = obj.sc.nextInt();
		System.out.print("세로 입력 : ");
		int height1 = obj.sc.nextInt();
		
		obj.r1(x1, y1, width1, height1);
		System.out.println("--------------------");
		System.out.println();
		
		System.out.println("두번째 사각형");
		System.out.print("x좌표 입력 : ");
		int x3 = obj.sc.nextInt();
		System.out.print("y좌표 입력 : ");
		int y3 = obj.sc.nextInt();
		System.out.print("가로 입력 : ");
		int width2 = obj.sc.nextInt();
		System.out.print("세로 입력 : ");
		int height2 = obj.sc.nextInt();
		
		obj.r2(x3, y3, width2, height2);
		System.out.println("--------------------");
		System.out.println();
		
		System.out.println("세번째 사각형");
		System.out.print("x좌표 입력 : ");
		int x5 = obj.sc.nextInt();
		System.out.print("y좌표 입력 : ");
		int y5 = obj.sc.nextInt();
		System.out.print("가로 입력 : ");
		int width3 = obj.sc.nextInt();
		System.out.print("세로 입력 : ");
		int height3 = obj.sc.nextInt();
		
		obj.r3(x5, y5, width3, height3);
	}
	
	public double r1(int x1, int y1, int width1, int height1) {
		
		this.x1 = x1;
		this.y1 = y1;
		this.width1 = width1;
		this.height1 = height1;
		x2 = x1 + width1;
		this.x2 = x2;
		y2 = y1 + height1;
		this.y2 = y2;
		this.rectangle1 = (width1 * height1); 
		
		System.out.println("(" + x1 + ", " + y1 + ")");
		System.out.println("(" + x2 + ", " + y2 + ")");
		System.out.println("사각형의 넓이 : " + rectangle1);
		
		return rectangle1;
	}
	public double r2(int x3, int y3, int width2, int height2) {
			
			this.x3 = x3;
			this.y3 = y3;
			this.width2 = width2;
			this.height2 = height2;
			x4 = x3 + width2;
			this.x4 = x4;
			y4 = y3 + height2;
			this.y4 = y4;
			this.rectangle2 = (width2 * height2); 
			
			System.out.println("(" + x3 + ", " + y3 + ")");
			System.out.println("(" + x4 + ", " + y4 + ")");
			System.out.println("사각형의 넓이 : " + rectangle2);
			
			return rectangle2;
		}
	public double r3(int x5, int y5, int width3, int height3) {
		
		this.x1 = x1;
		this.y1 = y1;
		this.width3 = width3;
		this.height3 = height3;
		x6 = x5 + width3;
		this.x6 = x6;
		y6 = y5 + height3;
		this.y6 = y6;
		this.rectangle3 = (width3 * height3); 
		
		System.out.println("(" + x5 + ", " + y5 + ")");
		System.out.println("(" + x6 + ", " + y6 + ")");
		System.out.println("사각형의 넓이 : " + rectangle3);
		
		return rectangle3;
	}
}
