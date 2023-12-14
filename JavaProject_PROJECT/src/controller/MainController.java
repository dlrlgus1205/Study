package controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import print.Print;
import service.AdminService;
import service.ItemService;
import service.MemberService;
import service.NoticeService;
import service.SugService;
import util.ScanUtil;
import util.View;
import vo.AdminVo;
import vo.InvenVo;
import vo.ItemDetailspaceVo;
import vo.ItemListVo;
import vo.ItemSpaceVo;
import vo.ItemUgVo;
import vo.MemberVo;
import vo.NoticeVo;
import vo.SugVo;


public class MainController extends Print{
	static public Map<String, Object> sessionStorage = new HashMap<>();
	static public Map<String, Object> itemStorage = new HashMap<>();
	AdminService adService = AdminService.getInstance();
	MemberService memService = MemberService.getInstance();
	ItemService itemService = ItemService.getInstance();
	SugService sugService = SugService.getInstance();
	NoticeService noService = NoticeService.getInstance();
	
	public static void main(String[] args) {
		new MainController().start();
	}
	
	private void start() {
		View view = View.LOGIN_PAGE;
		while (true) {
			switch (view) {
			case LOGIN_PAGE:
				view = login_Page();
				break;
			case ADMIN_LOGIN:
				view = adminLogin();
				break;
			case MEMBER_LOGIN:
				view = memberLogin();
				break;
			case ADMIN:
				view = admin();
				break;
			case MEMBER:
				view = member();
				break;
			case INVENTORY:
				view = inventory();
				break;
			case ITEM_SELECT:
				view = itemSelect();
				break;
			case ITEM_UPGRADE:
				view = itemUpgradeSystem();
				break;
			case ITEM_DROP:
				view = itemDrop();
				break;
			case ITEMSTORE:
				view = itemStore();
				break;
			case ITEM_SEARCH:
				view = itemSearch();
				break;
			case ITEM_BUY:
				view = itemBuy();
				break;
			case ITEM_SALE:
				view = itemSale();
				break;
			case CASHSTORE:
				view = cashStore();
				break;
			case PURCHASE:
				view = cashPurchase();
				break;
			case CHANGE:
				view = cashChange();
				break;
			case M_COMMUNITY:
				view = memberCommunity();
				break;
			case M_NOTICE:
				view = memberNotice();
				break;
			case SUGGESTION:
				view = suggestion();
				break;
			case A_NOTICE:
				view = adminNotice();
				break;
			case MODIFY:
				view = adminModify();
				break;
			case A_NOTICE_LIST:
				view = noticeList();
				break;
			case A_NOTICE_INSERT:
				view = noticeInsert();
				break;
			case A_NOTICE_UPDATE:
				view = noticeUpdate();
				break;
			case A_NOTICE_DELETE:
				view = noticeDelete();
				break;
			case SUGGESTION_LIST:
				view = suggestionList();
				break;
			case SUGGESTION_INSERT:
				view = suggestionInsert();
				break;
			case SUGGESTION_UPDATE:
				view = suggestionUpdate();
				break;
			case SUGGESTION_DELETE:
				view = suggestionDelete();
				break;
			case BLACKLIST:
				view = blacklist();
				break;
			case ADMIN_ITEMMENU_UPDATE:
				view = adminItemmenuUpdate();
				break;
			case ADMIN_UPGRADE_UPDATE:
				view = adminUpgradeUpdate();
				break;
			case ADMIN_ITEM_LIST:
				view = adminItemList();
				break;
			case ADMIN_ITEM_INSERT:
				view = adminItemInsert();
				break;
			case ADMIN_ITEM_UPDATE:
				view = adminItemUpdate();
				break;
			default:
				break;
			}
		}
	}



	private View adminItemList() {
		printVar("전체 아이템 리스트");
		List<ItemListVo> item = itemService.itemAllList();
		for (ItemListVo itemListVo : item) {
			System.out.println(itemListVo.getItm_no()+"\t"+itemListVo.getItm_name()+"\t"
								+itemListVo.getItm_con()+"\t"+itemListVo.getItm_cls()+"\t"
								+itemListVo.getItm_type()+"\t"+itemListVo.getItm_price());
		}
		return View.ADMIN_ITEMMENU_UPDATE;
	}

	private View adminItemUpdate() {
		printVar("기존 아이템 수정하기");
		List<Object> param = new ArrayList<Object>();
		
		return null;
	}

	private View adminItemInsert() {
		printVar("신규 아이템 추가하기");
		List<Object> param = new ArrayList<Object>();
		String name = ScanUtil.nextLine("신규 아이템 이름>>");
		String con = ScanUtil.nextLine("신규 아이템 내용 >>");
		String cls = ScanUtil.nextLine("신규 아이템 등급>>");
		String type = ScanUtil.nextLine("신규 아이템 타입>>");
		int price = ScanUtil.nextInt("신규 아이템 가격>>");
		
		param.add(name);
		param.add(con);
		param.add(cls);
		param.add(type);
		param.add(price);
		adService.adminItInsert(param);
		return View.ADMIN_ITEMMENU_UPDATE;
	}

	private View adminUpgradeUpdate() {
		printVar("강화 수치 수정하기");
		List<Object> param = new ArrayList<Object>();
		int no = ScanUtil.nextInt("변경할 강화 수치를 선택해주세요");
		int suc = ScanUtil.nextInt("변경할 강화 확률을 입력해주세요");
		int fail = ScanUtil.nextInt("변경할 실패확률을 입력해주세요");
		
		param.add(suc);
		param.add(fail);
		param.add(no);
		
		adService.adminUpgradeChange(param);
		 
		return View.ADMIN_ITEMMENU_UPDATE;
	}

	private View adminItemmenuUpdate() {
		printVar("관리자 수정 메뉴");
		
		System.out.println("1.전체 아이템 보기");
		System.out.println("2.신규아이템 추가");
		System.out.println("3.기존아이템 수정");
		System.out.println("4.뒤로가기");
		int sel = ScanUtil.nextInt("수정/추가할 메뉴를 선택해주세요");
		switch (sel) {
		case 1:
			return View.ADMIN_ITEM_LIST;
		case 2:
			return View.ADMIN_ITEM_INSERT;
		case 3:
			return View.ADMIN_ITEM_UPDATE;
		case 4:
			return View.MODIFY;
		default:
			return View.ADMIN_ITEMMENU_UPDATE;
		}
	}

	private View suggestionDelete() {
		printVar("글삭제");
		
		List<SugVo> sugList = new ArrayList<SugVo>();
		sugList = sugService.suggestionAllList();
	
	    printsugAllList(sugList);
	    
		MemberVo mem = (MemberVo) sessionStorage.get("MEMBER");
		String id = mem.getMem_id();
		List<Object> param = new ArrayList<Object>();
		int sel = ScanUtil.nextInt("삭제할 글 번호를 선택해주세요");
		param.add(id);
		param.add(sel);
		sugService.suggestionDelete(param);
		return View.SUGGESTION;
	}

	private View suggestionUpdate() {
		printVar("글수정");
		
		MemberVo mem = (MemberVo) sessionStorage.get("MEMBER");
		String id = mem.getMem_id();
		sugService.suggestionDetail(id);
		
		List<Object> param = new ArrayList<Object>();
		
		String title = ScanUtil.nextLine("제목 수정 >>");
		String con = ScanUtil.nextLine("내용 수정 >>");
		param.add(title);
		param.add(con);
		param.add(id);
		sugService.suggestionUpdate(param);
		return View.SUGGESTION;
	}

	private View suggestionInsert() {
		printVar("글작성");
		
		List<Object> param = new ArrayList<Object>();
		String title = ScanUtil.nextLine("제목 : ");
		String con = ScanUtil.nextLine("내용 : ");
		MemberVo mem = (MemberVo) sessionStorage.get("MEMBER");
		String id = mem.getMem_id();
		param.add(title);
		param.add(con);
		param.add(id);
		sugService.suggestionInsert(param);

		return View.SUGGESTION;
	}

	private View suggestionList() {
		List<SugVo> sugList = sugService.suggestionAllList();
		
		printsugAllList(sugList);
		printsuggestionList();
		
		int no = ScanUtil.nextInt("메뉴를 선택해주세요");
		switch (no) {
		case 1:
			String title = ScanUtil.nextLine("제목검색 >>");
			sugList = sugService.suggestionTitleSearch(title);
				for (SugVo sugVo : sugList) {
					System.out.println(sugVo.getSug_no()+"\t"+sugVo.getSug_title()+"\t"+sugVo.getSug_con()+"\t"+sugVo.getMem_id()+"\t"+sugVo.getSug_date()+"\t"+sugVo.getSug_view());
				}
			return View.SUGGESTION_LIST;
		case 2:
			String con = ScanUtil.nextLine("내용검색 >>");
			sugList = sugService.suggestionConSearch(con);
				for (SugVo sugVo : sugList) {
					System.out.println(sugVo.getSug_no()+"\t"+sugVo.getSug_title()+"\t"+sugVo.getSug_con()+"\t"+sugVo.getMem_id()+"\t"+sugVo.getSug_date()+"\t"+sugVo.getSug_view());
				}
			return View.SUGGESTION_LIST;
		case 3:
			String writer = ScanUtil.nextLine("작성자검색 >>");
			sugList = sugService.suggestionWriterSearch(writer);
				for (SugVo sugVo : sugList) {
					System.out.println(sugVo.getSug_no()+"\t"+sugVo.getSug_title()+"\t"+sugVo.getSug_con()+"\t"+sugVo.getMem_id()+"\t"+sugVo.getSug_date()+"\t"+sugVo.getSug_view());
				}
			return View.SUGGESTION_LIST;
			
		case 4:
			return View.SUGGESTION;			

		default:
			return View.SUGGESTION_LIST;
		}
	}

	private View blacklist() {
		printVar("블랙 리스트 추가");
		List<MemberVo> mem = memService.memberAllList();
		printBlackList(mem);
		int sel = ScanUtil.nextInt("블랙리스트로 추가할 회원 번호를 선택하세요");
		List<Object> param = new ArrayList<Object>();
		param.add(sel);
		memService.memBlacklist(param);

		return View.ADMIN;
	}
	private View adminModify() {
		printVar("메뉴수정하기");
		System.out.println("1.아이템 메뉴수정하기");
		System.out.println("2.강화 수치 수정하기");
		System.out.println("3.뒤로가기");
		int sel = ScanUtil.nextInt("수정할 메뉴를 선택하세요");
		switch (sel) {
		case 1:
			return View.ADMIN_ITEMMENU_UPDATE;
		case 2:
			return View.ADMIN_UPGRADE_UPDATE;
		case 3:
			return View.ADMIN;

		default:
			return View.MODIFY;
		}
	}
	
	private View noticeDelete() {
		printVar("공지글 삭제");
		List<NoticeVo> not =  noService.noticeAllLest();	
		printNoticeAllList(not);
		List<Object> param = new ArrayList<Object>();
		int sel = ScanUtil.nextInt("삭제할 글 번호를 선택해주세요");
		param.add(sel);
		noService.noticeDelete(param);
		return View.A_NOTICE;
	}

	private View noticeUpdate() {
		printVar("공지글수정");
		
		List<NoticeVo> not =  noService.noticeAllLest();
		printNoticeAllList(not);
		List<Object> param = new ArrayList<Object>();
		
		int sel = ScanUtil.nextInt("수정할 글 번호를 선택하세요.");
		String title = ScanUtil.nextLine("제목 수정 >>");
		String con = ScanUtil.nextLine("내용 수정 >>");
		param.add(title);
		param.add(con);
		param.add(sel);
		noService.noticeUpdate(param);
		return View.A_NOTICE;
	}

	private View noticeInsert() {
		printVar("공지글작성");
		
		List<Object> param = new ArrayList<Object>();
		String title = ScanUtil.nextLine("제목 : ");
		String con = ScanUtil.nextLine("내용 : ");
		AdminVo ad = (AdminVo) sessionStorage.get("ADMIN");
		int no = ad.getAd_no();
		
		param.add(title);
		param.add(con);
		param.add(no);
		noService.noticeInsert(param);
		
		return View.A_NOTICE;

	}
	
	private View noticeList() {
		printVar("공지사항 목록");
		List<NoticeVo> no = noService.noticeAllLest();
		printNoticeAllList(no);
		
		int sel = ScanUtil.nextInt("열람할 공지사항 번호를 입력해주세요 >>");
		List<Object> param = new ArrayList<Object>();
		param.add(sel);
		List<NoticeVo> de = noService.noticeDetail(param);
		for (NoticeVo noticeVo : de) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
			String date_Str = sdf.format(noticeVo.getNtc_date());
			System.out.println(noticeVo.getNtc_no()+"\t"+noticeVo.getNtc_title()+"\t"+noticeVo.getNtc_con()+"\t"+date_Str+"\t"+noticeVo.getNtc_view());
		}
		return View.A_NOTICE;
	}

	private View adminNotice() {
		printAdminNotice();
		
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		switch (sel) {
		case 1:
			return View.A_NOTICE_LIST;
		case 2:
			return View.A_NOTICE_INSERT;
		case 3:
			return View.A_NOTICE_UPDATE;
		case 4:
			return View.A_NOTICE_DELETE;
		case 5:
			return View.ADMIN;
		default:
			return View.A_NOTICE;
		}
	}
	
	private View suggestion() {
		printSuggestion();
		
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		switch (sel) {
		case 1:
			return View.SUGGESTION_LIST;
		case 2:
			return View.SUGGESTION_INSERT;
		case 3:
			return View.SUGGESTION_UPDATE;
		case 4:
			return View.SUGGESTION_DELETE;
		case 5:
			return View.M_COMMUNITY;
		default:
			return View.SUGGESTION;
		}
	}

	private View memberNotice() {
		printVar("공지사항");
		List<NoticeVo> no = noService.noticeAllLest();
		printNoticeAllList(no);
		
		int sel = ScanUtil.nextInt("열람할 공지사항 번호를 입력해주세요 >>");
		List<Object> param = new ArrayList<Object>();
		param.add(sel);
		List<NoticeVo> de = noService.noticeDetail(param);
		for (NoticeVo noticeVo : de) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
			String date_Str = sdf.format(noticeVo.getNtc_date());
			System.out.println(noticeVo.getNtc_no()+"\t"+noticeVo.getNtc_title()+"\t"+noticeVo.getNtc_con()+"\t"+date_Str+"\t"+noticeVo.getNtc_view());
		}
		return View.M_COMMUNITY;
	}

	private View memberCommunity() {
		printMemberCommunity();
		
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		switch (sel) {
		case 1:
			return View.M_NOTICE;
		case 2:
			return View.SUGGESTION;
		case 3:
			return View.MEMBER;
		default:
			return View.M_COMMUNITY;
		}
	}
	//인벤토리 넘버 메소드
	private int inventoryNum() {
		List<Object> param = new ArrayList<Object>();
		MemberVo mem =  (MemberVo) sessionStorage.get("MEMBER");
		int no = (int) mem.getMem_no();
		param.add(no);
		InvenVo iv = itemService.inventoryNum(param);
		
		
		return iv.getInven_no(); 
	}

	private View cashChange() {
		printCashChange();
		
		MemberVo c = memService.membercash();
		System.out.println("보유 캐시 금액"+c.getMem_cash());
		int change = ScanUtil.nextInt("환전하실 금액을 입력하세요 >>");
		memService.memberCashChange(change);
		
		MemberVo gc = memService.membergcash();
		System.out.println(change*10+"게임머니가 환전되었습니다");
		System.out.println("즐거운 게임 되시길 바랍니다");
		
		
		return View.CASHSTORE;
	}

	private View cashPurchase() {
		printCashPurchase();
		
		int purchase = ScanUtil.nextInt("결제하실 금액을 입력하세요 >>");
		List<Object> param = new ArrayList();
		param.add(purchase);
		memService.membercashPurchase(param);
		
		System.out.println(purchase+"원 충전 완료되었습니다");
		System.out.println("귀하의 돈은 저희 회사 발전에 잘 먹겠습니다 ㅋ");
		return View.CASHSTORE;
	}

	private View cashStore() {
		printCashStore();
		
		int sel = ScanUtil.nextInt("메뉴선택>>");
		switch (sel) {
		case 1:
			return View.PURCHASE;
		case 2:
			return View.CHANGE;
		case 3:
			return View.MEMBER;
		default:
			return View.CASHSTORE;
		}
	}

	private View itemDrop() {
		
		printVar("아이템 버리기");
		List<Object> param = new ArrayList<Object>();
		int sel = ScanUtil.nextInt("버릴 아이템 번호를 선택해주세요 ");
		param.add(sel);
		itemService.itemspaceDelete(param);
		
		return View.INVENTORY;
	}

	private View itemSale() {
		printVar("아이템 판매");
		MemberVo mem =  (MemberVo) sessionStorage.get("MEMBER");
		int memnum = (int) mem.getMem_no();
		List<Object> param = new ArrayList();
		int no = inventoryNum();
		param.add(no);
		List<ItemSpaceVo> inventory = itemService.itemList(param);
		printList(inventory);
		List<Object> param2 = new ArrayList<Object>();
		int sel = ScanUtil.nextInt("판매할 아이템을 선택해주세요>>");
		param2.add(sel);
		itemService.itemSale(param2);
		
		List<Object> param1 = new ArrayList<Object>();
		param1.add(sel);
		param1.add(memnum);
		itemService.memberGcashplus(param1);
		
		printVar("판매 완료");
		printSaleSelect();
		
		int select = ScanUtil.nextInt("메뉴 선택 >>");
		switch (select) {
		case 1:
			return View.INVENTORY;
		case 2:
			return View.ITEMSTORE;
		default:
			return View.ITEM_SALE;
		}
	}


	private View itemBuy() {
		
		List<ItemListVo> itemList = itemService.itemAllList();
		MemberVo mem =  (MemberVo) sessionStorage.get("MEMBER");
		int no = (int) mem.getMem_no();
		
		List<Object> param = new ArrayList();
		printAllList(itemList);
		
		printVar("아이템 구매");
		int sel = ScanUtil.nextInt("구매하실 아이템 번호를 입력하세요>>");
		
		param.add(no);
		param.add(sel);
		itemService.itemBuyItem(param);
		
		List<Object> param1 = new ArrayList<Object>();
		param1.add(no);
		param1.add(sel);
		itemService.itemUpdate(param1);
		
		List<Object> param2 = new ArrayList<Object>();
		param2.add(sel);
		param2.add(no);
		itemService.memberGcashminus(param2);

		printVar("구매 완료");
		return View.ITEMSTORE;
	}
	
	private View itemSearch() {
		printVar("아이템 검색");
		
		List<ItemListVo> itemList = itemService.itemAllList();
		printAllList(itemList);
		
		printItemSearch();
		
		int sel = ScanUtil.nextInt("메뉴 선택를 선택하세요>> ");
			switch (sel) {
		case 1:
			String name = ScanUtil.nextLine("아이템 이름을 입력해주세요>>" );
			printVar();
			itemList = (List<ItemListVo>) itemService.itemNameSearch(name);
			for (ItemListVo itemListVo : itemList) {
				System.out.println(itemListVo.getItm_no()+"\t"+itemListVo.getItm_name()+"\t"+itemListVo.getItm_con()+"\t"+itemListVo.getItm_cls()+"\t"+itemListVo.getItm_type()+"\t"+itemListVo.getItm_price());
			}
			printVar();
			return View.ITEM_SEARCH;
		case 2:
			String cls = ScanUtil.nextLine("아이템 등급을 입력해주세요>>" );
			printVar();
			itemList = (List<ItemListVo>) itemService.itemClsSearch(cls);
			for (ItemListVo itemListVo : itemList) {
				System.out.println(itemListVo.getItm_no()+"\t"+itemListVo.getItm_name()+"\t"+itemListVo.getItm_con()+"\t"+itemListVo.getItm_cls()+"\t"+itemListVo.getItm_type()+"\t"+itemListVo.getItm_price());
			}
			printVar();
			return View.ITEM_SEARCH;
		case 3:
			String type = ScanUtil.nextLine("아이템 타입을 입력해주세요>>" );
			printVar();
			itemList = (List<ItemListVo>) itemService.itemTypeSearch(type);
			for (ItemListVo itemListVo : itemList) {
				System.out.println(itemListVo.getItm_no()+"\t"+itemListVo.getItm_name()+"\t"+itemListVo.getItm_con()+"\t"+itemListVo.getItm_cls()+"\t"+itemListVo.getItm_type()+"\t"+itemListVo.getItm_price());
			}
			printVar();
			return View.ITEM_SEARCH;
		case 4:
			return View.ITEMSTORE;
		default:
			return View.ITEM_SEARCH;
			}
	}
	
	private View itemStore() {
		printItemStore();
		int sel = ScanUtil.nextInt("메뉴선택>>");
		switch (sel) {
		case 1:
			return View.ITEM_SEARCH;
		case 2:
			return View.ITEM_BUY;
		case 3:
			return View.ITEM_SALE;
		case 4:
			return View.MEMBER;
		default:
			return View.ITEMSTORE;
		}
		
	}

	private View itemSelect() {
		
		List<Object> param = new ArrayList<Object>();
		int select = ScanUtil.nextInt("아이템을 선택해주세요 >>");
		param.add(select);
		printVar("선택된 아이템");
		ItemSpaceVo item = itemService.itemSpaceDetail(param);
		int num = item.getSp_no();
		ItemDetailspaceVo it = itemService.itemSelDetail(num);
		itemStorage.put("it", it);
		printItemDetail(it);
		printItemSelect();
		
		int sel = ScanUtil.nextInt("메뉴 선택>>");
		switch (sel) {
		case 1:
			return View.ITEM_UPGRADE;
		case 2:
			return View.ITEM_SALE;
		case 3:
			return View.ITEM_DROP;
		case 4:
			return View.MEMBER;
		default:
			return View.ITEM_SELECT;
		}
		
	}
	private View itemUpgradeSystem() {
		printVar("자 게임 시작이다 !!!!!!!!!!!!!!!!!!!!!!!!");
		
		ItemDetailspaceVo it = (ItemDetailspaceVo) itemStorage.get("it");
		
		printItemDetail(it);
		
		int inven = it.getInven_no();
		int num = it.getSp_no();
		int up = it.getUp_no();
		List<Object> parami = new ArrayList();
		
		parami.add(up);
		ItemUgVo iu = itemService.itemUpgradeSystem(parami);
		
		itemUpgradePrint();
		
		int rank = up;
		int suc = iu.getUp_suc();
		END : while (true) {
			
			List<Object> param = new ArrayList();
			
			param.add(rank);
			itemService.itemStorageUpdate(param);
			
			int ran = new Random().nextInt(100) + 1;
			
			int s = ScanUtil.nextInt("강화하시겠습니까?");
			List<Object> param2 = new ArrayList<Object>();
			param2.add(s);
			itemService.itemUPgcashMinus(param2);
			
			switch (s) {
			case 1:
				
				if (ran < suc) {
					System.out.println("!!!!! 성공 !!!!!");
					List<Object> param1 = new ArrayList<Object>();
					param1.add(++rank);
					param1.add(inven);
					param1.add(num);
					itemService.itemUpnoUpdate(param1);
					
					System.out.println(rank + "강 강화하시겠습니까?");
					
					
					} 
				
				else {
					System.out.println("----- 실패 -----");
					if(rank > 1) {
						List<Object> param1 = new ArrayList<Object>();
						param1.add(--rank);
						param1.add(inven);
						param1.add(num);
						itemService.itemUpnoUpdate(param1);
						
						
						
					}
					System.out.println(rank + "강 강화하시겠습니까?");
					}
				break;
			case 2:
				
				break END;
			default:
			}

		}
		
		
		return View.ITEM_UPGRADE;
		
	}
	
	private View inventory() {
		printVar("인벤토리");

		List<Object> param = new ArrayList();
		int no = inventoryNum();
		param.add(no);
		List<ItemSpaceVo> inventory = itemService.itemList(param);
		printList(inventory);
		
		System.out.println("1. 아이템 선택");
		System.out.println("2. 나가기");
		
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		switch (sel) {
		case 1:
			return View.ITEM_SELECT;
		case 2:
			return View.MEMBER;
		default:
			return View.INVENTORY;
		}
	}

	private View member() {
		
		printMember();
		
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		switch (sel) {
		case 1:
			return View.INVENTORY;
		case 2:
			return View.ITEMSTORE;
		case 3:
			return View.CASHSTORE;
		case 4:
			return View.M_COMMUNITY;
		default:
			return View.MEMBER;
			
		}
	}

	private View admin() {
		printAdmin();
		
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		switch (sel) {
		case 1:
			return View.A_NOTICE;
		case 2:
			return View.SUGGESTION;
		case 3:
			return View.MODIFY;
		case 4:
			return View.BLACKLIST;
		default:
			return View.ADMIN;
		}
	}

	private View memberLogin() {
		String id   = "A2";//ScanUtil.nextLine("ID   >>");
		String pass = "A2";//ScanUtil.nextLine("PASS >>");
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
			case 2:
				return View.SIGNUP;
			default:
				return View.MEMBER_LOGIN;
			}
		}
			MemberVo mem = (MemberVo) sessionStorage.get("MEMBER");
			System.out.println(mem.getMem_name()+"님 환영합니다.");
			printStory();
			return View.MEMBER;
	}

	private View adminLogin() {
		String id   = "test1";//ScanUtil.nextLine("ID   >>");
		String pass = "1234";//ScanUtil.nextLine("PASS >>");

		
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
		AdminVo admin = (AdminVo) sessionStorage.get("ADMIN");
		System.out.println(admin.getAd_name()+"님 환영합니다.");
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

}
