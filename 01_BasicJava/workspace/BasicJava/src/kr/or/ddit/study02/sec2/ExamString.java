package kr.or.ddit.study02.sec2;

public class ExamString {
	public static void main(String[] args) {
		String name = "홍길동";
		String job = "프로그래머";
		
		System.out.println("이름 : " + name);
		System.out.println("직업 : " + job);
		
		// \t tap의 기능
		System.out.println(name + "\t" + job);
		
		// \n 줄바꿈 기능
		System.out.println(name + "\n" + job);
		
		// \r 줄바꿈 기능
		System.out.println(name + "\r" + job);
		
		// \r\n 줄바꿈 기능
		System.out.println(name + "\r\n" + job);
		
		// \" "표시
		System.out.println("\"" + name + "\"" + job);
		
		// \\ \표시
		System.out.println(name + "\\" + job);
	}
}
