package kr.or.ddit.study05.sec02;

import java.util.Scanner;

public class ArrayExample08 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayExample08 obj = new ArrayExample08();
		obj.method1();
	}

	private void method1() {
		Student s1 = new Student();
		s1.name = "미연";
		s1.kor = 72;
		s1.eng = 70;
		s1.math = 81;
		s1.sum = s1.kor + s1.eng + s1.math;
		s1.avg = s1.sum / 3.0;
		s1.rank = 1;

		Student s2 = new Student();
		s2.name = "민니";
		s2.kor = 85;
		s2.eng = 92;
		s2.math = 72;
		s2.sum = s2.kor + s2.eng + s2.math;
		s2.avg = s2.sum / 3.0;
		s2.rank = 1;
		
		Student s3 = new Student();
		s3.name = "우기";
		s3.kor = 89;
		s3.eng = 82;
		s3.math = 80;
		s3.sum = s3.kor + s3.eng + s3.math;
		s3.avg = s3.sum / 3.0;
		s3.rank = 1;
		
		Student[] stu = new Student[3];
		stu[0] = s1;
		stu[1] = s2;
		stu[2] = s3;
		
//		for(int i = 0; i < stu.length; i++) {
//			Student s = stu[i];
//			System.out.println(s.name + "\t 수학 : " + s.math);
//		}
//		for(int i = 0; i < stu.length; i++) {
//			Student s = stu[i];
//			System.out.println(s.name + "\t 평균 : " + s.avg);
//		}
		for(Student studens1 : stu) {
			for(Student studens2 : stu) {
				if(studens1.sum < studens2.sum) {
					studens1.rank++;
				}
			}
		}
		for(Student student : stu) {
			System.out.println(student);
		}
		for(int i = 0; i < stu.length - 1; i++){
			for(int j = 0; j < stu.length - 1; j++) {
				if(stu[j].rank > stu[j + 1].rank) {
					Student s = stu[j];
					stu[j] = stu[j + 1];
					stu[j + 1] = s;
				}
			}
		}
		System.out.println("-------------------------------------------------------정렬 후-------------------------------------------------------");
		for(Student student : stu) {
			System.out.println(student);
		}
	}
}

class Student{
	String name;
	int kor;
	int eng; 
	int math;
	int sum;
	double avg;
	int rank;
	@Override
	public String toString() {
		return "Student [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", sum=" + sum + ", avg="
				+ avg + ", rank=" + rank + "]";
	}
}