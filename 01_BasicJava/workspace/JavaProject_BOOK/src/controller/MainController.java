package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import service.BookService;
import service.MemberService;
import util.Print;
import util.ScanUtil;
import util.View;
import vo.BookVo;
import vo.Member;

public class MainController extends Print {
	static public Map<String, Object> sessionStorage = new HashMap<>();
	MemberService memService = MemberService.getnInstance();
	BookService bookService = BookService.getnInstance();
	
	public static void main(String[] args) {
		new MainController().start();
	}
	
	private void start() {
		View view = View.HOME;
		
		while (true) {
			switch (view) {
			case HOME:
				view = home();
				break;
			case LOGIN:
				view = login();
				break;
			case MEMBER:
				view = member();
				break;
			case BOOK_BORROW:
				view = bookBorrow();
				break;
			case BOOK_LIST:
				view = bookList();
				break;
			case BOOK_RETURN:
				view = bookBorrow();
				break;
			case BOOK_BORROW_LIST:
				view = bookBorrow();
				break;
			default:
				break;
			}
		}
	}

	private View bookList() {
		System.out.println("--------  책 리스트  --------");
		
		List<Map<String, Object>> bookList = bookService.bookHeldList();
		int i = 1;
		for (Map<String, Object> map : bookList) {
			System.out.print(i++);
			System.out.println(map);
		}
		
		int s = ScanUtil.nextInt("빌릴 책 번호 입력") - 1;
		String bookId = (String) (bookList.get(s)).get("BOOK_ID");
		
		for (Map<String, Object> map : bookList) {
			System.out.print(i++);
			System.out.println(map);
		}
		
		Member member = (Member) sessionStorage.get("login");
		int mem_no = member.getMem_no();
		
		List<Object> param = new ArrayList();
		param.add(bookId);
		param.add(mem_no);
		bookService.bookBorrow(param);

		List<BookVo> b1 =bookService.bookList();
		for (BookVo bookVo : b1) {
			System.out.println(bookVo.getName()+", " + bookVo.getContent());
		}
		
		return null;
//		System.out.println("1. 책 선택");
//		System.out.println("2. 뒤로 가기");
//		
//		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		
//		switch (sel) {
//		case 1:
//			System.out.println("1. 책 이름 검색");
//			System.out.println("2. 상품 번호 선택");
//			
//			sel = ScanUtil.nextInt("메뉴 선택 : ");
//			
//			List<Map<String, Object>> bookHeldList = list;
//			switch (sel) {
//			case 1:
//				break;
//			case 2:
//				break;
//			default:
//				break;
//			}
//			int book_no = ScanUtil.nextInt("책 번호 입력 >>");
//			
//			Map<String, Object> prod = null;
//			for (Map<String, Object> map : bookHeldList) {
//				if((int)map.get("NO") == book_no) {
//					book = map;
//				}
//			}
//			System.out.println(book);
//			sessionStorage.put("book", book);
//			
//			return View.BOOK_LIST;
//		case 2:
//			return View.MEMBER;
//		default:
//			return View.BOOK_BORROW;
//		}
	}

	private View bookBorrow() {
		System.out.println("--------  책 대여  --------");
		
		System.out.println("1. 책 리스트 보기");
		System.out.println("2. 뒤로 가기");
		
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		
		switch (sel) {
		case 1:
			return View.BOOK_LIST;
		case 2:
			return View.MEMBER;
		default:
			return View.BOOK_BORROW;
		}
	}

	private View member() {
		boolean login = sessionStorage.containsKey("login");
		
		if(!login) {
			return View.LOGIN;
		}
		
		System.out.println("1. 책 대여");
		System.out.println("2. 책 반납");
		System.out.println("3. 현재 책 대여 내역");
		System.out.println("4. 로그아웃");
		
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		
		switch (sel) {
		case 1:
			return View.BOOK_BORROW;
		case 2:
			return View.BOOK_RETURN;
		case 3:
			return View.BOOK_BORROW_LIST;
		case 4:
			sessionStorage.remove("login");
			return View.HOME;
		default:
			return View.MEMBER;
		}
	}

	private View login() {
		System.out.println("-------  로그인 페이지  -------");
		
		String id = ScanUtil.nextLine("ID >>");
		String pass = ScanUtil.nextLine("pass >>");
		
		List<Object> list = new ArrayList();
		list.add(id);
		list.add(pass);
	
		boolean login = memService.login(list);
		
		if(!login) {
			System.out.println("1. 다시 로그인");
			System.out.println("2. 회원 가입");
			System.out.println("3. 홈");
			
			int sel = ScanUtil.nextInt("메뉴 선택 : ");
			
			switch (sel) {
			case 1:
				return View.LOGIN;
			case 2:
				return View.SIGNUP;
			case 3:
				return View.HOME;
			default:
				return View.LOGIN;
			}
		}
		Member member = (Member) sessionStorage.get("login");
		System.out.println(member.getName() + "님 환영합니다");
		
		return View.BOOK_BORROW;
	}

	private View home() {
		System.out.println("1. 회원 로그인");
		System.out.println("2. 관리자 메뉴");
		
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		
		switch (sel) {
		case 1:
			return View.LOGIN;
		case 2:
			return View.ADMIN;
		default:
			return View.HOME;
		}
	}
}
