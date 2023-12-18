package print;

import java.util.List;

import vo.BookVo;

public class Print {
	
	public void printVar() {
		System.out.println("-----------------------------------");
	}
	
	public void printVar(String s) {
		System.out.println("------------"+s+"-----------");
	}
	
	public void printLn(int n) {
		for(int i=0; i<n; i++)
			System.out.println();
	}
	
	public void printListMenu() {
		System.out.println("1. 다음페이지");
		System.out.println("2. 이전페이지");
		System.out.println("3. 상세 페이지 조회");
		System.out.println("4. 홈");
	}
	
	public void printBookList(List<BookVo> bookList) {
		System.out.println("---------------------도서 전체 정보------------------");
		for (BookVo bookVo : bookList) {
			System.out.println(bookVo);
		}
	}
	
	public void printHome() {
		printVar();
		System.out.println("1. 도서 정보 등록");
		System.out.println("2. 도서 정보 삭제");
		System.out.println("3. 도서 대여");
		System.out.println("4. 도서 반납");
		System.out.println("5. 도서 현재 대여 내역");
		printLn(5);
		printVar();
	}
	
	public void printLogin() {
		printVar();
		System.out.println("1.관리자 로그인");
		System.out.println("2.회원 로그인");
		printLn(5);
		printVar();
		
	}
}
