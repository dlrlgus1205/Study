package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import print.Print;
import service.FreeBoardService;
import service.MemberService;
import util.ScanUtil;
import util.View;
import vo.FreeBoard;
import vo.MemberVo;

public class MainController extends Print {
	static public Map<String, Object> sessionStorage = new HashMap<>();
	FreeBoardService freeService = FreeBoardService.getnInstance();
	MemberService memService = MemberService.getnInstance();
	
	public static void main(String[] args) {
		sessionStorage.put("page_no", 1);
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
			case FREE_UPDATE:
				view = freeUpdate();
				break;
			case FREE_DELETE:
				view = freeDelete();
				break;
			case LOGIN:
				view = login();
				break;
			case ADMIN:
				view = home();
				break;
			default:
				break;
			}
		}
	}


	private View login() {
		String id = ScanUtil.nextLine("ID >>");
		String pass = ScanUtil.nextLine("PASS >>");
		
		List<Object> param = new ArrayList();
		param.add(id);
		param.add(pass);
		
		boolean loginChk = memService.login(param);
		if(!loginChk) {
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
		View view = (View) sessionStorage.get("View");
		if(view == null) return View.MAIN;
		
		return view;
	}

	private View freeDelete() {
		MemberVo mem = (MemberVo) sessionStorage.get("member");
		
		if(mem == null) {
			sessionStorage.put("View", View.FREE_DELETE);
			return View.LOGIN;
		}
		
		int board_no = (int) sessionStorage.get("board_no");
		FreeBoard fb = freeService.freeDetail(board_no);
		if(fb.getMem_no() != mem.getMem_no()) {
			System.out.println("해당 게시글 작성자가 아닙니다");
			return View.FREE_DETAIL;
		}
		freeService.freeDelete(board_no);
		
		return View.FREE_LIST;
	}

	private View freeUpdate() {
		MemberVo mem = (MemberVo) sessionStorage.get("member");
		
		if(mem == null) {
			sessionStorage.put("View", View.FREE_UPDATE);
			return View.LOGIN;
		}
		
		int board_no = (int) sessionStorage.get("board_no");
		FreeBoard fb = freeService.freeDetail(board_no);
		if(fb.getMem_no() != mem.getMem_no()) {
			System.out.println("해당 게시글 작성자가 아닙니다");
			return View.FREE_DETAIL;
		}
		
		freeService.freeUpdate(board_no);
		
		return View.FREE_LIST;
	}

	private View freeDetail() {
		/*
		 * 상세 페이지 출력
		 * 
		 * 메뉴 문구
		 * 1. 게시판 수정(로그인 진행 내 게시판 아니라면 수정 불가)
		 * 2. 게시판 삭제(로그인 진행 내 게시판 아니라면 수정 불가)
		 */
		int board_no = (int) sessionStorage.get("board_no");
		FreeBoard fb = freeService.freeDetail(board_no);
		System.out.println(fb);
		
		System.out.println("1. 게시판 수정");
		System.out.println("2. 게시판 삭제");
		int sel = ScanUtil.nextInt("메뉴 선택 >>");
		switch (sel) {
		case 1:
			return View.FREE_UPDATE;
		case 2:
			return View.FREE_DELETE;
		default:
			return View.FREE_DETAIL;
		}
	}

	private View freeList() {
		/*
		 * 전체 게시판 조회
		 */
		List<Object> param = new ArrayList();
		int page_no = (int) sessionStorage.get("page_no");
		int start_no = 1 + 5 * (page_no - 1);
		int end_no = 5 + 5 * (page_no - 1);
		param.add(start_no);
		param.add(end_no);
		
		List<FreeBoard> freeList = freeService.freeList(param);
		printList(freeList);
		printListMenu();
		
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		switch (sel) {
		case 1:
			page_no++;
			sessionStorage.put("page_no", page_no);
			return View.FREE_LIST;
		case 2:
			page_no--;
			sessionStorage.put("page_no", page_no);
			return View.FREE_LIST;
		case 3:
			int board_no = ScanUtil.nextInt("게시판 번호 선택 : ");
			sessionStorage.put("board_no", board_no);
			return View.FREE_DETAIL;
		default:
			return View.MAIN;
		}
	}

	private View home() {
		printHome();
		
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		switch (sel) {
		case 1:
			return View.FREE_LIST;
		case 2:
			return View.ADMIN;
		default:
			return View.MAIN;
		}
	}
}
