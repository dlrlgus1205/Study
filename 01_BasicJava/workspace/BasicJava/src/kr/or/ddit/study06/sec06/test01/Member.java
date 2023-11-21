package kr.or.ddit.study06.sec06.test01;

import java.util.Scanner;

public class Member {
	
	private String name;
	private int age;
	private String state;
	private String mail;
	
	public Member() {
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if(age < 0) {
		System.out.println("0보다 작은 수는 입력 불가");
		Scanner sc = new Scanner(System.in);
		age = sc.nextInt();
	}
		else if(age > 100) {
			System.out.println("100보다 큰 수는 입력 불가");
		}
		this.age = age;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Member(String name, int age, String state, String mail) {
		this.name = name;
		this.age = age;
		this.state = state;
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "[이름 = " + name + ", 나이 = " + age + ", 국가 = " + state + ", 메일 = " + mail + "]";
	}

	
}
