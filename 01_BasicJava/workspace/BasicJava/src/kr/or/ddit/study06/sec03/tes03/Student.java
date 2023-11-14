package kr.or.ddit.study06.sec03.tes03;

public class Student {
	String nation;
	String group;
	String name;
	int age;
	
	public Student(String nation, String group, String name, int age) {
		this.nation = nation;
		this.group = group;
		this.name = name;
		this.age = age;
		System.out.println("파라미터 4개 생성자 호출");
	}

	public Student(String group, String name, int age) {
//		this.nation = "한국";
//		this.group = group;
//		this.name = name;
//		this.age = age;
		this("한국", group, name, age);
		System.out.println("파라미터 3개 생성자 호출");
	}

	public Student(String name, int age) {
//		this.nation = "한국";
//		this.group = "402호";
//		this.name = name;
//		this.age = age;
		this("402", name, age);
		System.out.println("파라미터 2개 생성자 호출");
	}

	@Override
	public String toString() {
		return "Student [nation=" + nation + ", group=" + group + ", name=" + name + ", age=" + age + "]";
	}
}
