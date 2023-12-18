package print;

import java.util.List;

import vo.FreeBoard;

public class Print {
	
	public void printVar() {
		System.out.println("-------------------------------------------------------------");
	}
	
	public void printLn(int n) {
		for(int i = 0; i < n; i++) {
			System.out.println();
		}
	}
	
	public void printList(List<FreeBoard> freeList) {
		System.out.println("번호\t제목\t내용\t조회수\t작성자\t작성일");
		for (FreeBoard freeBoard : freeList) {
			System.out.println(freeBoard.getBoard_no() + "\t" + freeBoard.getTitle() + "\t" + freeBoard.getContent() + "\t" + freeBoard.getCount() + "\t" + freeBoard.getSpare1() + "\t" + freeBoard.getWrite_date());
		}
	}
	
	public void printListMenu() {
		System.out.println("1. 다음 페이지");
		System.out.println("2. 이전 페이지");
		System.out.println("3. 상세 페이지 조회");
		System.out.println("4. 홈");
	}
	
	public void printHome() {
		printVar();
		System.out.println("1. 자유게시판 전체 조회");
		System.out.println("2. 로그인");
		printLn(5);
		printVar();
	}
	
}