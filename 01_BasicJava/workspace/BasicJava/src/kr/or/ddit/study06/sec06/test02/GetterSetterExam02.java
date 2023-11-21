package kr.or.ddit.study06.sec06.test02;

import java.util.Scanner;

public class GetterSetterExam02 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		/*
		 * Phone 클래스에
		 * 
		 * 핸드폰 번호
		 * 이름
		 * 그룹
		 * 단축키
		 * 
		 * 1. 전화번호 추가
		 * 2. 전화번호 전체 조회
		 * 3. 전화번호 수정
		 * 4. 전화번호 삭제
		 * 5. 종료
		 */
		GetterSetterExam02 gs = new GetterSetterExam02();
		
		Phone[] arr = new Phone[10];
		int cnt = 0;
		
		
		while(true) {
			
			gs.printMenu();
			int n = sc.nextInt();
			
			if(n == 1) {
				Phone p = gs.inputPhone();
				arr[cnt++] = p;
				System.out.println();
			}
			else if(n == 2) {
				gs.printPhone(arr);
				System.out.println();
			}
			else if(n == 3) {
				gs.modifyPhone(arr);
			}
			else if(n == 4) {
				gs.deletePhone(arr);
			}
			else if(n == 5) {
				System.out.println("종료");
				break;
			}
			else {
				System.out.println("[1, 2, 3, 4, 5] 중 선택");
			}
		}
	}
	
	public void printMenu() {
		System.out.println("---번호 선택---");
		System.out.println("1. 추가");
		System.out.println("2. 조회");
		System.out.println("3. 수정");
		System.out.println("4. 삭제");
		System.out.println("5. 종료");
	}
	
	public Phone inputPhone() {
		
		Phone p = new Phone();
		
		System.out.print("번호 : ");
		p.setNum(sc.next());
		
		System.out.print("이름 : ");
		p.setName(sc.next());
		
		System.out.print("그룹 : ");
		p.setGroup(sc.next());
		
		System.out.print("단축키 : ");
		p.setSn(sc.next());
				
		return p;
	}
	
	public void printPhone(Phone[] arr) {
		int num = 1;
		for (Phone p : arr) {
			if(p == null) continue;
			System.out.println(num + ". " + p);
			num++;
		}
	}
	
	public void modifyPhone(Phone[] arr) {
		
		printPhone(arr);
		
		System.out.println("수정할 번호 선택");
		int s = sc.nextInt() - 1;
		
		Phone p = arr[s];
		
		System.out.print("번호 : ");
		p.setNum(sc.next());
		
		System.out.print("이름 : ");
		p.setName(sc.next());
		
		System.out.print("그룹 : ");
		p.setGroup(sc.next());
		
		System.out.print("단축키 : ");
		p.setSn(sc.next());
		
		System.out.println("수정 완료");
	}
	
	public void deletePhone(Phone[] arr) {
		
		printPhone(arr);
		
		System.out.println("삭제할 번호 선택");
		int n = sc.nextInt();
		
		Phone p = arr[n];
		arr[n] = null;
		
		System.out.println("삭제 완료");
	}
}
