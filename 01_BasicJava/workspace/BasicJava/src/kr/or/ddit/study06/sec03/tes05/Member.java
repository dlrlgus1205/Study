package kr.or.ddit.study06.sec03.tes05;

public class Member {
	String id;
	String pw;
	String na;
	String mail;
	int age;
	
	public Member(String id, String pw, String na, String mail, int age) {
		this.id = id;
		this.pw = pw;
		this.na = na;
		this.mail = mail;
		this.age = age;		
	}
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", na=" + na + ", mail=" + mail + ", age=" + age + "]";
	}
	
}
