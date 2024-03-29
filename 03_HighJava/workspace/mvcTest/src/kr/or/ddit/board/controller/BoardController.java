package kr.or.ddit.board.controller;

import java.util.List;
import java.util.Scanner;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVo;

public class BoardController {
	private Scanner sc;
	private IBoardService service;
	
	public BoardController() {
		sc = new Scanner(System.in);
		service = BoardServiceImpl.getInstance();
	}
	
	public static void main(String[] args) {
		new BoardController().startBoard();
	}
	
	private void startBoard() {
		while(true) {
			displayMenu();
			int s = displaySelect();
			switch (s) {
			case 1:
				insertBoard();
				break;
			case 2:
				getBoard();
				break;
			case 3:
				searchBoard();
				break;
			case 0:
				System.out.println("!!! 종료 !!!");
				break;
			default:
				System.out.println("잘못 입력했습니다");
				break;
			}
			if (s == 0) break;
		}
	}

	private void searchBoard() {
		System.out.println("검색 작업");
		System.out.println("==============================================");
		sc.nextLine();
		System.out.print("검색할 제목 입력 >> ");
		String bTitle = sc.nextLine();
		
		if (bTitle == null && bTitle.isEmpty()) {
			displayMenu();
			return;
		}

		List<BoardVo> bVo = service.searchBoard(bTitle);
		
		if(bVo.isEmpty()) {
			System.out.println("검색 결과가 없습니다");
		}
		else {
			for (BoardVo boardVo : bVo) {
				System.out.println(boardVo.getBoard_no() + "\t" + boardVo.getBoard_title() + "\t" + boardVo.getBoard_writer() + "\t" + boardVo.getBoard_cnt());
			}
		}
	}
	
	private void getBoard() {
		System.out.print("조회를 원하는 게시물 번호 입력 >> ");
		int s = sc.nextInt();
		
		BoardVo bVo = service.getBoard(s);
		
		System.out.println("\t\t" + bVo.getBoard_no() + "번글 내용");
		System.out.println("==============================================");
		System.out.println("제  목 : " + bVo.getBoard_title());
		System.out.println("작성자 : " + bVo.getBoard_writer());
		System.out.println("내  용 : " + bVo.getBoard_content());
		System.out.println("작성일 : " + bVo.getBoard_date());
		System.out.println("조회수 : " + bVo.getBoard_cnt());
		getBoardMenu(bVo);
		
	}
	
	private void getBoardMenu(BoardVo bVo) {
		System.out.println("==============================================");
		System.out.println("\t\t\t메뉴");
		System.out.println("1. 수정");
		System.out.println("2. 삭제");
		System.out.println("3. 리스트로 가기");
		System.out.println("==============================================");
		System.out.print("작업 선택 >> ");
		int s = sc.nextInt();
		
		switch (s) {
		case 1:
			updateBoard(bVo);
			break;
		case 2:
			deleteBoard(bVo);
			break;
		case 3:
			startBoard();
			break;
		default:
			System.out.println("잘못 입력했습니다");
			break;
		}
	}
	
	private void updateBoard(BoardVo bVo) {
		System.out.println("수정 작업하기");
		System.out.println("==============================================");
		sc.nextLine();
		System.out.print("제  목 : ");
		String bTitle = sc.nextLine();
		
		System.out.print("내  용 : ");
		String bContent = sc.nextLine();
		
		bVo.setBoard_title(bTitle);
		bVo.setBoard_content(bContent);
		
		int cnt = service.updateBoard(bVo);
		
		if(cnt > 0) {
			System.out.println(">> 수정 완료 <<");
		}
		else {
			System.out.println(">> 수정 실패 <<");
		}
		
	}
	
	private void deleteBoard(BoardVo bVo) {
		System.out.println();
		
		int cnt = service.deleteBoard(bVo);
		
		if(cnt > 0) {
			System.out.println("\t\t" + bVo.getBoard_no() + "번글이 삭제됐습니다");
		}
		else {
			System.out.println(">> 삭제 실패 <<");
		}
	}
	
	private void insertBoard() {
		BoardVo bVo = new BoardVo();

		System.out.println("\t\t\t작성");
		System.out.println("==============================================");

		sc.nextLine();
		System.out.println("제  목");
		String bTitle = sc.nextLine();
				
		System.out.println("작성자");
		String bWriter = sc.nextLine();
		
		System.out.println("내  용");
		String bContent = sc.nextLine();
		
		bVo.setBoard_title(bTitle);
		bVo.setBoard_writer(bWriter);
		bVo.setBoard_content(bContent);
		
		int cnt = service.insertBoard(bVo);
		
		if(cnt > 0) {
			System.out.println(">> 작성 완료 <<");
		}
		else {
			System.out.println(">> 작성 실패 <<");
		}
		
	}
	
	private int displaySelect() {
		System.out.println("==============================================");
		System.out.println("\t\t\t메뉴");
		System.out.println("1. 게시글 작성");
		System.out.println("2. 게시글 조회");
		System.out.println("3. 게시글 검색");
		System.out.println("0. 종료");
		System.out.println("==============================================");
		System.out.print("작업 선택 >> ");
		int s = sc.nextInt();
		return s;
	}
	
	private void displayMenu() {
		List<BoardVo> bList = null;
		System.out.println("==============================================");
		System.out.println("번호\t제목\t작성자\t조회수");
		System.out.println("==============================================");
		bList = service.selectAllBoard();
		
		if(bList == null || bList.size() == 0) {
			System.out.println("\t\t 게시글이 없습니다");
		}
		else {
			for(BoardVo bVo : bList) {
				System.out.println(bVo.getBoard_no() + "\t" + bVo.getBoard_title() + "\t" + bVo.getBoard_writer() + "\t" + bVo.getBoard_cnt());
			}
		}
	}
}