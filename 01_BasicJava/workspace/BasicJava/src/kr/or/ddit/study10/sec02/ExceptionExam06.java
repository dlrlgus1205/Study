package kr.or.ddit.study10.sec02;

import java.util.Scanner;

public class ExceptionExam06 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ExceptionExam06 obj = new ExceptionExam06();
		
		while(true) {
			System.out.println("닉네임 입력 : ");
			String nick = sc.next();
			
			try {
				checkNickName(nick);
				break;
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
	}
	
	public static void checkNickName(String name) {
		if(name.contains("바보")) {
			throw new NickNameException();
		}
		if(name.length() > 10) {
			throw new NickNameException();
		}
	}
}

class NickNameException extends RuntimeException {
	public NickNameException() {
		super("잘못된 닉네임");
	}
}