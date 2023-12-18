package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import print.Print;
import service.AdminService;
import service.BookService;
import service.MemberService;
import util.ScanUtil;
import util.View;
import vo.AdminVo;
import vo.BookVo;
import vo.MemberVo;

public class MainController extends Print {
	static public Map<String, Object> sessionStorage = new HashMap<>();
	AdminService adService = AdminService.getInstance();
	MemberService memService = MemberService.getInstance();
	BookService bkService = BookService.getInstance();
	
	
	public static void main(String[] args) {
		new MainController().start();
		
	}
	
	private void start() {
		View view = View.LOGIN_PAGE;
		while(true) {
			switch (view) {
			case MAIN:
				view = home();
			case LOGIN_PAGE:
				view = login_Page();
				break;
			case ADMIN_LOGIN:
				view = adminLogin();
				break;
			case MEMBER_LOGIN:
				view = memberLogin();
				break;
			case MEMBER:
				view = member();
				break;
			case ADMIN:
				view = admin();
				break;
			case BOOK_INSERT:
				view = bookInsert();
				break;
			case BOOK_DELETE:
				view = bookDelete();
				break;
			case BOOK_RENT:
				view = bookRent();
				break;
			case BOOK_RETURN:
				view = bookList();
				break;
			case BOOK_RENT_LIST:
				view = bookList();
				break;
			case BOOK_LIST:
				view = bookList();
				break;
			default:
				break;
			}
		}
		
	}
	private View bookRent() {
		List<BookVo> sList =  bkService.bookList();
		printBookList(sList);
		List<Object> param = new ArrayList<Object>();
		int bookno = ScanUtil.nextInt("빌릴 책 번호를 입력해주세요.");
		bkService.bookHeldList(param,bookno);
		return View.MEMBER;
	}

	private View bookDelete() {
		List<BookVo> sList =  bkService.bookList();
		printBookList(sList);
		int no = ScanUtil.nextInt("삭제할 책 번호를 선택하세요.");
		
		List<Object> param = new ArrayList<Object>();
		param.add(no);
		bkService.bookDelete(param);
		
		return View.ADMIN;
	}
		
	private View bookInsert() {
		System.out.println("---------도서 정보 등록---------");
		String name = ScanUtil.nextLine("제목 : ");
		String content = ScanUtil.nextLine("내용 : ");
		String writer = ScanUtil.nextLine("작가 : ");
		
		List<Object> param  = new ArrayList<Object>();
		param.add(name);
		param.add(content);
		param.add(writer);
		bkService.bookInsert(param);
		return View.ADMIN;
	}

	private View login_Page() {
		printLogin();
		int sel = ScanUtil.nextInt("로그인할 유형을 선택해주세요.");
		switch (sel) {
		case 1:
			return View.ADMIN_LOGIN;
		case 2:	
			return View.MEMBER_LOGIN;
		default:
			return View.LOGIN_PAGE;
		}
	}

	private View bookList() {
		List<BookVo> bList = new ArrayList<BookVo>();
		printBookList(bList);
		return View.BOOK_RETURN;
	}

	private View admin() {
		System.out.println("1.도서 정보 등록");
		System.out.println("2.도서 정보 삭제");
		System.out.println("3.홈(로그아웃)");
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		switch (sel) {
		case 1:
			return View.BOOK_INSERT;
		case 2:
			return View.BOOK_DELETE;
		case 3:
			return View.LOGIN_PAGE;
		default:
			return View.ADMIN;
		}
	}

	private View member() {
		System.out.println("1. 도서 대여");
		System.out.println("2. 도서 반납");
		System.out.println("3. 도서 대여 내역");
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		switch (sel) {
		case 1:
			return View.BOOK_RENT;
		case 2:
			return View.BOOK_RETURN;
		case 3:
			return View.BOOK_RENT_LIST;
		default:
			return View.MEMBER;
		}
	}

	private View adminLogin() {
		String id   = ScanUtil.nextLine("ID   >>");
		String pass = ScanUtil.nextLine("PASS >>");
		
		List<Object> param = new ArrayList<Object>();
		param.add(id);
		param.add(pass);
		
		boolean loginChk = adService.adminLogin(param);
		if(!loginChk) {
			System.out.println("1. 다시 로그인");
			System.out.println("2. 회원가입");
			int select = ScanUtil.nextInt("메뉴 선택 >>");
			switch (select) {
			case 1:
				return View.ADMIN_LOGIN;
			
			default:
				return View.ADMIN_LOGIN;
			}
		}
		AdminVo admin = (AdminVo) sessionStorage.get("ADMIN02");
		System.out.println(admin.getName()+"님 환영합니다.");
		return View.ADMIN;
	}
	private View memberLogin() {
		String id   = ScanUtil.nextLine("ID   >>");
		String pass = ScanUtil.nextLine("PASS >>");
		
		List<Object> param = new ArrayList<Object>();
		param.add(id);
		param.add(pass);
		
		boolean loginChk = memService.memberLogin(param);
		if(!loginChk) {
			System.out.println("1. 다시 로그인");
			System.out.println("2. 회원가입");
			int select = ScanUtil.nextInt("메뉴 선택 >>");
			switch (select) {
			case 1:
				return View.MEMBER_LOGIN;
			default:
				return View.MEMBER_LOGIN;
			}
		}
			MemberVo mem = (MemberVo) sessionStorage.get("MEMBER02");
			System.out.println(mem.getName()+"님 환영합니다.");
			return View.MEMBER;
		}
	private View home() {
		
		printHome();		
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		switch (sel) {
		case 1:
			return View.BOOK_INSERT;
		case 2:
			return View.BOOK_DELETE;
		case 3:
			return View.BOOK_RENT;
		case 4:
			return View.BOOK_RETURN;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
		case 5:
			return View.BOOK_RENT_LIST;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
		default:
			return View.MAIN;
		}
	}
}
