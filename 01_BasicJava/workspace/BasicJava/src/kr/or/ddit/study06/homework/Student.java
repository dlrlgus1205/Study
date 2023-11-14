package kr.or.ddit.study06.homework;

public class Student {
	
	String dep;
	int num;
	
	public static void main(String[] args) {
		Student stu = new Student("융합컴퓨터미디어학부", 1551039);
		System.out.println(stu);
	}
	
	public Student(String dep, int num) {
		this.dep = dep;
		this.num = num;
	}

	@Override
	public String toString() {
		return "Student [학과 = " + dep + ", 학번 = " + num + "]";
	}
	
}
