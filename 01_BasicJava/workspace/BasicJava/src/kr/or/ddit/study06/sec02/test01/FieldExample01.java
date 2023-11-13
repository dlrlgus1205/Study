package kr.or.ddit.study06.sec02.test01;

public class FieldExample01 {
	public static void main(String[] args) {
		
		System.out.println(Student.rm);
		
		Student s1 = new Student();
		s1.name = "황지훈";
		s1.age = 20;
		Student s2 = new Student();
		s2.name = "박건태";
		s2.age = 20;
		s1.rm = "401호";
		
		System.out.println(s1.rm + ", " + s1);
		System.out.println(s2.rm + ", " + s2);
	}
}
