package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import service.MemberService;
import service.ProdService;
import util.Print;
import util.ScanUtil;
import util.View;

public class MainController extends Print {
	static public Map<String, Object> sessionStorage = new HashMap<>();
	MemberService memService = MemberService.getnInstance();
	ProdService prodService = ProdService.getnInstance();
	
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
			case MEMBER:
				view = member();
				break;
			case PROD_LIST:
				view = prodList();
				break;
			case PROD_DETAIL:
				view = prodDetail();
				break;
			case PROD_SALE:
				view = prodSale();
				break;
			case ADMIN:
				view = home();
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
		System.out.println("--------  로그인  --------");
		
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
		Map<String, Object> member = (Map<String, Object>) sessionStorage.get("login");
		System.out.println(member.get("NAME") + "님 환영합니다");
		
		return View.MEMBER;
	}

	private View prodSale() {
		System.out.println("--------  상품 구매  --------");
		
		Map<String, Object> prod = (Map<String, Object>) sessionStorage.get("prod");
		
		int no = (int) prod.get("NO");
		
		int count = ScanUtil.nextInt("구매하실 수량 >>");
		int price = (int) prod.get("price");
		
		System.out.println("총 구매 가격은 : " + (count * price));
		String yn = ScanUtil.nextLine("구매 하시겠습니까(Y/N)");
		
		if(yn.equalsIgnoreCase("Y")) {
			List<Object> param = new ArrayList();
			param.add(count);
			param.add(no);
			param.add(no);
			
			prodService.prodSale(param);
		}
		
		return View.PROD_LIST;
	}

	private View prodDetail() {
		System.out.println("--------  상품 상세 조회  --------");
		/*
		 * 상품 상세 내용 출력
		 */
		
		Map<String, Object> prod = (Map<String, Object>) sessionStorage.get("prod");
		System.out.println(prod);
		
		System.out.println("1. 상품 리스트");
		System.out.println("2. 상품 구매");
		
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		
		switch (sel) {
		case 1:
			return View.PROD_LIST;
		case 2:
			return View.PROD_SALE;
		default:
			return View.PROD_DETAIL;
		}
	}

	private View prodList() {
		System.out.println("--------  상품 리스트  --------");
		
		List<Map<String, Object>> list = prodService.prodList();
		System.out.println("상품번호\t상품이름\t내용\t가격\t수량\t타입");
		for (Map<String, Object> map : list) {
			int prod_num = (int) map.get("NO");
			String prod_name = (String) map.get("NAME");
			String content = (String) map.get("CONTENT");
			int price = (int) map.get("PRICE");
			int count = (int) map.get("COUNT");
			String prod_type = (String) map.get("TYPE");
			
			System.out.println(prod_num + "\t" + prod_name + "\t" + content + "\t" + price + "\t" + count + "\t" + prod_type);
		}
		
		System.out.println("1. 상품 선택");
		System.out.println("2. 상품 홈");
		
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		
		switch (sel) {
		case 1:
			System.out.println("1. 상품 종류 검색");
			System.out.println("2. 상품 이름 검색");
			System.out.println("3. 상품 번호 선택");
			
			sel = ScanUtil.nextInt("메뉴 선택 : ");
			
			List<Map<String, Object>> prodList = list;
			
			switch (sel) {
			case 1:
				String type = ScanUtil.nextLine("상품 타입 입력 >>");
				prodList = prodService.prodTypeSearch(type);
				for (Map<String, Object> map : list) {
					int prod_num = (int) map.get("NO");
					String prod_name = (String) map.get("NAME");
					String content = (String) map.get("CONTENT");
					int price = (int) map.get("PRICE");
					int count = (int) map.get("COUNT");
					String prod_type = (String) map.get("TYPE");
					
					System.out.println(prod_num + "\t" + prod_name + "\t" + content + "\t" + price + "\t" + count + "\t" + prod_type);
				}
				break;
			case 2:
				String name = ScanUtil.nextLine("상품 이름 입력 >>");
				prodList = prodService.prodNameSearch(name);
				for (Map<String, Object> map : list) {
					int prod_num = (int) map.get("NO");
					String prod_name = (String) map.get("NAME");
					String content = (String) map.get("CONTENT");
					int price = (int) map.get("PRICE");
					int count = (int) map.get("COUNT");
					String prod_type = (String) map.get("TYPE");
					
					System.out.println(prod_num + "\t" + prod_name + "\t" + content + "\t" + price + "\t" + count + "\t" + prod_type);
				}
				break;
			case 3:
				break;
			default:
			}
			
			int prod_no = ScanUtil.nextInt("상품 번호 입력 >>");
			
			Map<String, Object> prod = null;
			for (Map<String, Object> map : prodList) {
				if((int)map.get("NO") == prod_no) {
					prod = map;
				}
			}
			System.out.println(prod);
			sessionStorage.put("prod", prod);
			
			return View.PROD_DETAIL;
		case 2:
			return View.HOME;
		default:
			return View.PROD_LIST;
		}
		
	}

	private View member() {
		boolean login = sessionStorage.containsKey("login");
		
		if(!login) {
			return View.LOGIN;
		}
		
		System.out.println("1. 상품 조회");
		System.out.println("2. 홈(로그아웃)");
		
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		
		switch (sel) {
		case 1:
			return View.PROD_LIST;
		case 2:
			sessionStorage.remove("login");
			return View.HOME;
		default:
			return View.MEMBER;
		}
	}

	private View home() {
		System.out.println("1. 일반 회원");
		System.out.println("2. 관리자");
		
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		
		switch (sel) {
		case 1:
			return View.MEMBER;
		case 2:
			return View.ADMIN;
		default:
			return View.HOME;
		}
	}
}
