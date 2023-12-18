package main;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import dao.FreeDao;

public class MainTest {
	
	FreeDao dao = FreeDao.getnInstance();
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		MainTest obj = new MainTest();
		obj.process();
	}
	private void process() {
		/*
		 * 	1. 게시판 작성
		 * 	2. 게시판 조회
		 * 		-> 전체 조회
		 * 		-> 상세 조회
		 * 	3. 게시판 수정
		 * 	4. 게시판 삭제
		 */
		while(true) {
			System.out.println("1. 게시판 작성");
			System.out.println("2. 게시판 전체 조회");
			System.out.println("3. 게시판 수정");
			System.out.println("4. 게시판 삭제");
			int s = sc.nextInt();
			switch (s) {
			case 1:
				writeBoard();
				break;
			case 2:
				listBoard();
				break;
			case 3:
				updateBoard();
				break;
			case 4:
				deleteBoard();
				break;
			default:
				break;
			}
		}
	}
	
	public void writeBoard() {
		System.out.println("-----게시글 작성-----");
		System.out.println("제목");
		String title = sc.next();
		System.out.println("내용");
		String content = sc.next();
		System.out.println("작성자");
		String writer = sc.next();
		
		List<Object> param = new ArrayList();
		param.add(title);
		param.add(content);
		param.add(writer);
		dao.insertFreeBoard(param);
	}
	
	private void printList() {
		List<Map<String, Object>> boardList = dao.listBoard();
		for (Map<String, Object> map : boardList) {
			
			BigDecimal    no = (BigDecimal) map.get("NO");
			String     title = (String) map.get("TITLE");
			String	 content = (String) map.get("CONTENT");
			String	  writer = (String) map.get("WRITER");
			BigDecimal count = (BigDecimal) map.get("COUNT");
			
			System.out.println(no + "\t" + title + "\t" + content + "\t" + writer + "\t" + count);
		}
	}
	
	public void listBoard() {
		
		printList();
		
		System.out.println("1. 상세 조회");
		System.out.println("2. 홈");

		int s = sc.nextInt();
		
		switch (s) {
		case 1:
			System.out.println("게시판 번호 선택");
			int no = sc.nextInt();
			dao.updateBoardCount(no);
			Map<String, Object> board = dao.detailBoard(no);
			
			BigDecimal board_no = (BigDecimal) board.get("NO");
			String        title = (String) board.get("TITLE");
			String	    content = (String) board.get("CONTENT");
			String	     writer = (String) board.get("WRITER");
			BigDecimal    count = (BigDecimal) board.get("COUNT");
			String     reg_date = (String) board.get("REG_DATE");
			System.out.println("게시글 번호\t제목\t작성자\t조회수");
			System.out.println("------------------------------------------------------");
			System.out.println(board_no + "\t" + title  + "\t" + writer  + "\t" + count);
			System.out.println("------------------------------------------------------");
			int length = 40;
			for(int i = 0; i < content.length(); i = i + length) {
				if(i + length > content.length()) {
					System.out.println(content.substring(i, content.length()));
				}
				else {
					System.out.println(content.substring(i, i + length));
				}
			}
			break;
		case 2:
			break;
		default:
			break;
		}
		
	}
	
	public void updateBoard() {
		
		printList();
		
		System.out.println("게시판 번호 입력");
		int n = sc.nextInt();
		
		System.out.println("1. 제목 수정");
		System.out.println("2. 내용 수정");
		System.out.println("3. 작성자 수정");
		
		int s = sc.nextInt();
		
		String column = "";
		String col = "";
		if(s == 1) {
			System.out.println("제목 : ");
			column = "TITLE";
			col = sc.next();
		}
		if(s == 2) {
			System.out.println("내용 : ");
			column = "CONTENT";
			col = sc.next();
		}
		if(s == 3) {
			System.out.println("작성자 : ");
			column = "WRITER";
			col = sc.next();
		}
		
		List<Object> param = new ArrayList();
		param.add(col);
		param.add(n);
		dao.updateBoard(param, column);
	}
	
	public void deleteBoard() {
		printList();
		System.out.println("삭제할 게시판 선택");
		int n = sc.nextInt();
		
		List<Object> param = new ArrayList();
		param.add("Y");
		param.add(n);
		dao.updateBoard(param, "DEL_YN");
		
		printList();
	}
}
