package kr.or.ddit.board.controller;

import java.util.List;
import java.util.Scanner;

import kr.or.ddit.board.service.IJdbcBoardService;
import kr.or.ddit.board.service.JdbcBoardServiceImpl;
import kr.or.ddit.board.vo.BoardVo;

public class JdbcBoardController {
	private IJdbcBoardService service;
	private Scanner scan;
	
	public JdbcBoardController(){
		scan = new Scanner(System.in);
		service = JdbcBoardServiceImpl.getInstance();
	}
	
	public static void main(String[] args) {
		new JdbcBoardController().boardStart();
	}
	
	//시작 메서드
	private void boardStart() {
		String title = null;
		while(true) {
			int choice = displayMenu(title);
			switch (choice) {
			case 1:		// 새글작성
				insertBoard();
				title = null;
				break;
			case 2:		// 게시글 보기
				getBoard();
				title = null;
				break;
			case 3:		// 검색
				title = getSearchBoardList();
				break;
			case 0:		// 종료
				System.out.println("게시판 프로그램 종료..");
				return;
			default:
				System.out.println("잘못 선택 하셨습니다..");
				System.out.println("번호를 다시 입력하여주세요..");
			}
		}
	}
	
	// 제목을 입력받아 List로 가져오는 메서드
	private String getSearchBoardList() {
		scan.nextLine();
		System.out.println();
		System.out.println("검색 작업");
		System.out.println("--------------------------------------------");
		System.out.println("- 검색할 제목 입력 : ");
		String title = scan.nextLine();
		
		return title;
		
	}

	// 번호를 입력받아 글 내용을 보여주는 메서드
	private void getBoard() {
		System.out.println();
		System.out.println("보기를 원하는 게시글 번호 입력 >>");
		int boardNo = scan.nextInt();
		
		BoardVo bvo = service.getBoard(boardNo);
		
		if(bvo==null) {
			System.out.println(boardNo+"번의 게시글이 존재하지 않습니다...");
			return;
		}
		
		System.out.println();
		System.out.println(boardNo+"번 글 내용");
		System.out.println("-----------------------------------");
		System.out.println("- 제   목  :" + bvo.getBoard_title());
		System.out.println("- 작성자  :" + bvo.getBoard_writer());
		System.out.println("- 내   용  :" + bvo.getBoard_content());
		System.out.println("- 작성일  :" + bvo.getBoard_date());
		System.out.println("- 조회수  :" + bvo.getBoard_cnt());
		System.out.println("-----------------------------------");
		System.out.println("메뉴 : 1. 수정	2. 삭제	3. 리스트로 가기");
		System.out.println("작업 선택>>");
		int select = scan.nextInt();
			
		switch (select) {
			case 1:
				updateBoard(boardNo);
				break;
			case 2:
				deleteBoard(boardNo);
				break;
			case 3:
				return;
			}
	}
	
	// 글을 삭제하는 메서드
	private void deleteBoard(int boardNo) {
		System.out.println();
		
		int cnt = service.deleteBoard(boardNo);
		if(cnt>0) {
			System.out.println(boardNo+"번 글이 삭제되었습니다.");
		}else {
			System.out.println(boardNo+"번 글을 삭제하지 못했습니다.");
		}
	}

	// 글을 수정하는 메서드
	private void updateBoard(int boardNo) {
		scan.nextLine();
		System.out.println("수정 작업하기");
		System.out.println("-----------------------------------");
		System.out.println("- 제   목  :");
		String newTitle = scan.nextLine();
		System.out.println("- 내   용   :");
		String newContent = scan.nextLine();
		
		BoardVo bvo = new BoardVo();
		bvo.setBoard_no(boardNo);
		bvo.setBoard_title(newTitle);
		bvo.setBoard_content(newContent);
		
		int cnt = service.updateBoard(bvo);
		
		if(cnt>0) {
			System.out.println(boardNo+"번 글이 수정되었습니다.");
		}else {
			System.out.println(boardNo+"번 글 수정 작업이 실패하였습니다.");
		}
		

	}

	// 새글을 작성하는 메서드
	private void insertBoard() {
		scan.nextLine();		// 버퍼 비우기
		System.out.println();
		System.out.println("새글 작성하기");
		System.out.println("-----------------------------------");
		System.out.println("- 제   목  :");
		String title = scan.nextLine();
		System.out.println("- 작성자  :");
		String writer = scan.nextLine();
		System.out.println("- 내   용   :");
		String content = scan.nextLine();
		
		// 입력값을 VO에 저장하기
		BoardVo boardVo = new BoardVo();
		boardVo.setBoard_title(title);
		boardVo.setBoard_writer(writer);
		boardVo.setBoard_content(content);
		
		int cnt = service.insertBoard(boardVo);
		
		if(cnt>0) {
			System.out.println("새 글이 추가되었습니다.");
		}else {
			System.out.println("새 글 추가에 실패했습니다.");
		}
	}

	// 게시판 목록을 보여주고 메뉴를 나타내며 사용자가 입력한 작업 번호를 입력받아 반환하는 메서드
	private int displayMenu(String title) {
		List<BoardVo> boardList = null;
		System.out.println();
		System.out.println("---------------------------------------------------");
		System.out.println("No\t제목\t  작성자\t조회수");
		System.out.println("---------------------------------------------------");
		if(title==null || title.isEmpty()) {
			boardList = service.getAllBoardList();
		}else {
			boardList = service.getSearchBoardList(title);
		}
		
		
		if(boardList.size()==0 || boardList ==null) {
			System.out.println("게시글이 존재하지않습니다..");
		}else {
			for (BoardVo boardVo : boardList) {
				System.out.println(boardVo.getBoard_no()+"\t"+boardVo.getBoard_title()+"\t"+boardVo.getBoard_writer()+"\t"+boardVo.getBoard_cnt());
			}
		}
		System.out.println("----------------------------------------------------");
		
		System.out.println("메뉴 : 1. 새글작성	2.게시글보기	3.검색	0.작업끝");
		System.out.println("작업 선택>>");
		
		return scan.nextInt();
		
	}
}
