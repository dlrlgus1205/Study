package kr.or.ddit.study06.homework;

import java.util.Scanner;

public class Grade {

	Scanner sc = new Scanner(System.in);
	
	int kor;
	int sci;
	int eng;
	int sum;
	double avg;
	
	public Grade(int kor, int sci, int eng) {
		this.kor = kor;
		this.sci = sci;
		this.eng = eng;
		this.sum = kor + sci + eng;
		this.avg = (double)sum / 3.0;
	}



	@Override
	public String toString() {
		return "Grade [국어 = " + kor + ", 과학 = " + sci + ", 영어 = " + eng + ", 합 = " + sum + ", 평균 = " + avg + "]";
	}
	
}
