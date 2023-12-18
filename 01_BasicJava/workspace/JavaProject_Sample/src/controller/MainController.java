package controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import service.FreeBoardService;
import util.Print;
import util.ScanUtil;
import util.View;

public class MainController extends Print {
	static public Map<String, Object> sessionStorage = new HashMap<>();
	FreeBoardService boardService = FreeBoardService.getnInstance();
	
	public static void main(String[] args) {
		new MainController().start();
	}
	
	private void start() {
		View view = View.MAIN;
		
		while (true) {
			switch (view) {
			case MAIN:
				view = home();
				break;
			case FREE_LIST:
				view = freeList();
				break;
			case FREE_DETAIL:
				view = freeDetail();
				break;
			case FREE_WRITE:
				view = freeWrite();
				break;
			case FREE_UPDATE:
				view = freeUpdate();
				break;
			case FREE_DELETE:
				view = freeDelete();
				break;
			case LOGIN:
				view = login();
				break;
			default:
				break;
			}
		}
	}

	private View login() {
		System.out.println("-------  로그인 페이지  -------");
		
		String id = ScanUtil.nextLine("ID >>");
		String pass = ScanUtil.nextLine("pass >>");
		
		/*
		 * 로그인 진행
		 */
		
		boolean login = true;
		
		if(!login) {
			System.out.println("1. 다시 로그인");
			System.out.println("2. 회원가입");
			System.out.println("3. 홈");
			
			int sel = ScanUtil.nextInt("메뉴 선택 : ");
			
			switch (sel) {
			case 1:
				return View.LOGIN;
			case 2:
				return View.SIGNUP;
			case 3:
				return View.MAIN;
			default:
				return View.LOGIN;
			}
		}
		return View.MAIN;
	}

	private View freeDelete() {
		System.out.println("-------  게시판 삭제  -------");
		
		boolean login = true;
		
		if(!login) {
			return View.LOGIN;
		}
		
		
		String delete = ScanUtil.nextLine("정말 삭제하시겠습니까?(Y/N)");
		
		if(delete.equalsIgnoreCase("Y")) {
			/*
			 * 삭제 진행
			 */
			int no = (int) sessionStorage.get("board_no");
			List<Object> param = new ArrayList();
			
			param.add("Y");
			param.add(no);
			
			boardService.delete(param, "DEL_YN");
			
			return View.FREE_LIST;
		}
		else {
			return View.FREE_DETAIL;
		}
	}

	private View freeUpdate() {
		System.out.println("-------  게시판 수정  -------");
		
		boolean login = true;
		
		if(!login) {
			return View.LOGIN;
		}
		
		int no = (int) sessionStorage.get("board_no");
		
		System.out.println("1. 제목 수정");
		System.out.println("2. 내용 수정");
		
		int select = ScanUtil.nextInt("메뉴 선택");
		String colum = "";
		String col = null;
		
		if(select == 1) {
			colum = "TITLE";
			col = ScanUtil.nextLine("제목 >>");
		}
		if(select == 2) {
			colum = "CONTENT";
			col = ScanUtil.nextLine("내용 >>");
		}
		List<Object> param = new ArrayList();
		
		boardService.updateBoard(param, colum);
		param.add(col);
		param.add(no);
		
		return View.FREE_DETAIL;
	}

	private View freeWrite() {
		System.out.println("-------  게시판 작성  -------");
		
		boolean login = true;
		
		if(!login) {
			return View.LOGIN;
		}
			
		String title = ScanUtil.nextLine("제목 >>");
		String content = ScanUtil.nextLine("내용 >>");
		String writer = ScanUtil.nextLine("작성자 >>");
		/*
		 * 제목, 이름 입력 받기
		 */
		
		
		List<Object> param = new ArrayList();
		param.add(title);
		param.add(content);
		param.add(writer);
		boardService.writeBoard(param);
		
		return View.FREE_LIST;
	}

	private View freeDetail() {
		System.out.println("-------  자유게시판 상세 조회  -------");
		
		/*
		 * 상세 조회 출력
		 */
		
		int no = (int) sessionStorage.get("board_no");
		
		Map<String, Object> board = boardService.freeDetail(no);
		
		System.out.println("1. 자유게시판 리스트 이동");
		System.out.println("3. 자유게시판 수정");
		System.out.println("4. 자유게시판 삭제");
		
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		
		switch (sel) {
		case 1:
			return View.FREE_LIST;
		case 2:
			return View.FREE_UPDATE;
		case 3:
			return View.FREE_DELETE;
		default:
			return View.FREE_DETAIL;
		}
//		boolean login = true;
//		if(!login) {
//			return View.LOGIN;
//		}
//			
//		String title = ScanUtil.nextLine("제목 >>");
//		String content = ScanUtil.nextLine("내용 >>");
//		/*
//		 * 제목, 이름 입력 받기
//		 */
//		
//		return View.FREE_LIST;
	}

	private View freeList() {
		System.out.println("-------  자유게시판 리스트  -------");
		
		/*
		 *  자유게시판 전체 리스트 출력 추가
		 */
		
		List<Map<String, Object>> list = boardService.freeList();
		
		for (Map<String, Object> board : list) {
			int		   board_no = (int) board.get("NO");
			String        title = (String) board.get("TITLE");
			String	    content = (String) board.get("CONTENT");
			String	     writer = (String) board.get("WRITER");
			int    		  count = (int) board.get("COUNT");
			String	   reg_date = (String) board.get("REG_DATE");
			System.out.println("게시글 번호\t제목\t작성자\t조회수");
			System.out.println(board_no + "\t" + title  + "\t" + writer  + "\t" + count);
			int length = 40;
			for(int i = 0; i < content.length(); i = i + length) {
				if(i + length > content.length()) {
					System.out.println(content.substring(i, content.length()));
				}
				else {
					System.out.println(content.substring(i, i + length));
				}
			}
		}
		
		System.out.println("1. 자유게시판 상세 조회");
		System.out.println("2. 자유게시판 작성");
		System.out.println("3. 자유게시판 수정");
		System.out.println("4. 자유게시판 삭제");
		System.out.println("5. 홈");
		
		int no;
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		
		switch (sel) {
		case 1:
			no = ScanUtil.nextInt("게시판 번호 선택");
			sessionStorage.put("board_no", no);
			return View.FREE_DETAIL;
		case 2:
			return View.FREE_WRITE;
		case 3:
			no = ScanUtil.nextInt("게시판 번호 선택");
			sessionStorage.put("board_no", no);
			return View.FREE_UPDATE;
		case 4:
			no = ScanUtil.nextInt("게시판 번호 선택");
			sessionStorage.put("board_no", no);
			return View.FREE_DELETE;
		case 5:
			return View.MAIN;
		default:
			return View.FREE_LIST;
		}
	}

	private View home() {
		System.out.println("1. 자유게시판 전체 조회");
		System.out.println("2. 로그인");
		
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		
		switch (sel) {
		case 1:
			return View.FREE_LIST;
		case 2:
			return View.LOGIN;
		default:
			return View.MAIN;
		}
	}
}
