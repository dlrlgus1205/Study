package kr.or.ddit.study06.sec06.test01;

import java.util.Iterator;
import java.util.Scanner;

public class GetterSetterExam01 {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		/*
		 * 멤버에 이름, 나이, 국가, 메일 필드 만들기
		 * 스캐너를 통해 각 데이터 입력 받기
		 * 
		 * 1. 멤버 추가
		 * 2. 멤버 조회 -> 입력된 멤버 정보 출력
		 * 3. 종료
		 */
		GetterSetterExam01 gs = new GetterSetterExam01();
		
		Member[] arr= new Member[10];
		int cnt = 0;
		while(true) {
			System.out.print("선택지(1, 2, 3) 입력 : ");
			int n = gs.sc.nextInt();
			
			if(n == 1) {
				Member m = gs.inputMember();
				arr[cnt++] = m;
			}
			else if(n == 2) {
				gs.printMember(arr);
			}
			else if(n == 3) {
				System.out.println("종료");
				break;
			}
			else {
				System.out.println("1, 2, 3 중에 입력");
			}
		}
	}
	
	public Member inputMember() {
		
		System.out.print("이름 입력 : ");
		String name = sc.next();
		
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
//		if(age < 0) {
//			System.out.println("0보다 작은 수는 입력 불가");
//			age = sc.nextInt();
//		}
		
		System.out.print("국가 입력 : ");
		String state = sc.next();
		
		System.out.print("메일 입력 : ");
		String mail = sc.next();
		System.out.println();
		
		Member m = new Member();
		m.setName(name);
		m.setAge(age);
		m.setState(state);
		m.setMail(mail);
		
		return m;
	}
	
	public void printMember(Member[] arr) {
		for(Member member : arr) {
			if(member == null) break;
			System.out.println(member);
		}
	}
}
