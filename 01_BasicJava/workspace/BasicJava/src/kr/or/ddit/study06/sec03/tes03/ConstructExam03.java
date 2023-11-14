package kr.or.ddit.study06.sec03.tes03;

public class ConstructExam03 {
	public static void main(String[] args) {
		Student s1 = new Student("황지훈", 20);
		Student s2 = new Student("박건태", 20);
		Student s3 = new Student("403호", "이명문", 20);
		Student s4 = new Student("일본", "404호", "-", 20);
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
	}
}
