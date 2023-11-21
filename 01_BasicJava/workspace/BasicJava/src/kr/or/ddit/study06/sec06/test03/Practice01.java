package kr.or.ddit.study06.sec06.test03;

import java.util.Scanner;

public class Practice01 {
	static Scanner sc = new Scanner(System.in);
	int num = 0;
	public static void main(String[] args) {
		Practice01 pr = new Practice01();
		
		pr.start();
	}
	
	public void start() {
		Prod[] arr = new Prod[10];
		
		while(true) {
			
			storePrint();
			int n = sc.nextInt();
			
			if(n == 1) viewProd(arr);
			else if(n == 2) insertProd(arr);
			else if(n == 3) updateProd(arr);
			else if(n == 4) deleteProd(arr);
			else if(n == 5) {
				System.out.println("종료");
				break;
			}
			else {
				System.out.println("[1, 2, 3, 4, 5] 중 선택");
			}
		}
	}
	
	public void storePrint() {
		/*
		 * 편의점
		 * 1. 상품 조회
		 * 2. 상품 신규 등록
		 * 3. 상품 정보 변경
		 * 4. 상품 삭제
		 */
		System.out.println("--- 편의점 ---");
		System.out.println("1. 상품 조회");
		System.out.println("2. 상품 신규 등록");
		System.out.println("3. 상품 정보 변경");
		System.out.println("4. 상품 삭제");
		System.out.println("5. 종료");
	}
	
	public void viewProd(Prod[] arr) {
		for(Prod p : arr) {
			int n = 1;
			if(p == null) continue;
			System.out.println(p);
			n++;
		}
		System.out.println();
	}
	
	public Prod insertProd(Prod[] arr) {
		
		Prod p = new Prod();
		
		System.out.print("이름 : ");
		p.setName(sc.next());
		System.out.print("가격 : ");
		p.setPrice(sc.next());
		
		arr[num++] = p;
		
		System.out.println();
		return p;
	}
	
	public void updateProd(Prod[] arr) {
		//상품 전체 출력
		viewProd(arr);
		System.out.println("변경할 상품 선택");
		
		//업데이트 될 상품 정보
		Prod sel = null;
		int no = sc.nextInt();
		
		for (Prod p : arr) {
			if(p == null) continue;
			if(p.getNo() == no) {
				sel = p;
			}
		}
		
		System.out.print("이름 : ");
		sel.setName(sc.next());
		System.out.print("가격 : ");
		sel.setPrice(sc.next());
	}
	
	public void deleteProd(Prod[] arr) {
		viewProd(arr);
		System.out.println("삭제할 상품 선택");
		
		int no = sc.nextInt();
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == null) continue;
			if(arr[i].getNo() == no) {
				arr[i] = null;
			}
		}
	}
}
