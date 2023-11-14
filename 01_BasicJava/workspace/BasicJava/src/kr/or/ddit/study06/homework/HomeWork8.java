package kr.or.ddit.study06.homework;

import java.util.Scanner;

public class HomeWork8 {
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		HomeWork8 obj = new HomeWork8();
		
		Student stu = new Student("융합컴퓨터미디어학부", 1551039);
		System.out.println(stu); 
		
		Tv tv = new Tv("삼성", 2023, 80);
		System.out.println(tv);
		
		System.out.println("점수 입력 : ");
		
		int kor = obj.sc.nextInt();
		int sci = obj.sc.nextInt();
		int eng = obj.sc.nextInt();
		
		Grade gr = new Grade(kor, sci, eng);
		System.out.println(gr);
	}
}
