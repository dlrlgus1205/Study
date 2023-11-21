package kr.or.ddit.study06.sec06.test04;

import java.util.Scanner;

public class Practice02 {
	static Scanner sc = new Scanner(System.in);
	int num = 0;
	
	public static void main(String[] args) {
		Practice02 pr = new Practice02();
		
		pr.start();
	}
	
	public void start() {
		/*
		 * 책
		 * 1. 전체 조회
		 * 2. 신규 책 등록
		 * 3. 책 정보 변경
		 * 4. 책 정보 삭제
		 * 5. 종료
		 */
		/*
		 * 심화 과제
		 * 1. 초기 배열 5개
		 *    5개보다 증가한다면
		 *    5개 추가
		 * 2. 책 정보 삭제 시
		 *    빈 공간 앞으로 당겨오기
		 *    ex) b1 b2 b3 b4 null
		 *        1. b2 삭제
		 *        2. b1 null b3 b4 null
		 *        3. b1 b3 b4 null null
		 */
		int cnt = 0;
		Book[] arr = new Book[5];
		for(int i = 0; i < arr.length; i++) {
			if(arr.length == (5 * i)) {
				Book[] na = new Book[5 * (i + 1)];
				System.arraycopy(arr, 0, na, 0, (5 * (i + 1)));
			}
		}
	
		while(true) {
			printMenu();
			int n = sc.nextInt();
			
			if(n == 1) printBook(arr);
			else if(n == 2) insertBook(arr);
			else if(n == 3) updateBook(arr);
			else if(n == 4) deleteBook(arr);
			else if(n == 5) {
				System.out.println("종료");
				break;
				}
			else {
				System.out.println("잘못 입력하셨습니다.");
			}
		}
	}
	
	public void printMenu() {
		System.out.println("--- 서점 ---");
		System.out.println("* 1. 전체 조회");
		System.out.println("* 2. 신규 책 등록");
		System.out.println("* 3. 책 정보 변경");
		System.out.println("* 4. 책 정보 삭제");
		System.out.println("* 5. 전체 조회");
	}
	
	public void printBook(Book[] arr) {
		System.out.println("조회");
		
		int n = 0;
		for (Book b : arr) {
			if(b == null)continue;
			n++;
			System.out.println(n + ". " + b);
		}
		
		System.out.println();
	}
	
	public Book insertBook(Book[] arr) {
		System.out.println("신규 등록");
		System.out.println();
		
		Book b = new Book();
		System.out.print("책 이름 : ");
		b.setName(sc.next());
		System.out.print("가격 : ");
		b.setPrice(sc.nextInt());
		System.out.print("작가 : ");
		b.setWriter(sc.next());
		
		arr[num++] = b;
		
		System.out.println("등록 완료");
		System.out.println();
		
		return b;
	}
	
	public void updateBook(Book[] arr) {
		printBook(arr);

		System.out.println("변경할 책 선택");
		System.out.println();
		
		int n = sc.nextInt() - 1;
		Book b = arr[n];
		
		System.out.print("책 이름 : ");
		b.setName(sc.next());
		System.out.print("가격 : ");
		b.setPrice(sc.nextInt());
		System.out.print("작가 : ");
		b.setWriter(sc.next());
		
		System.out.println("변경 완료");
	}
	
	public void deleteBook(Book[] arr) {
		printBook(arr);
		
		System.out.println("삭제할 책 선택");
		int n = sc.nextInt() - 1;
		
		Book b = arr[n];
		arr[n] = null;
		
		System.out.println("삭제 완료");
	}
}
