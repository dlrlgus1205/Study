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
			
			case SIGNUP:
				view = signUp();
				break;

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
			
			case MINIGAME:
				view = minigameAll();
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
			
			case M_SUGGESTION:
				view = memSuggestion();
				break;
			case A_SUGGESTION:
				view = adminSuggestion();
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
			
			case M_SUGGESTION_LIST:
				view = memsuggestionList();
				break;
				
			case A_SUGGESTION_LIST:
				view = adsuggestionList();
				break;
			
			case M_SUGGESTION_INSERT:
				view = suggestionInsert();
				break;
			
			case M_SUGGESTION_UPDATE:
				view = suggestionUpdate();
				break;
			
			case M_SUGGESTION_DELETE:
				view = memsuggestionDelete();
				break;

			case A_SUGGESTION_DELETE:
				view = adsuggestionDelete();
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
		
			case HAIFHAIFGAME:
				view = halfhalfGame();
				break;
			
			case ITEM_STORE_UPGRADE:
				view = itemstoreUpgrade();
				break;
			
			case HHGAMEBETTING:
				view = hhgameBetting();
				break;
				
			case HHCASHGAMESTART:
				view = hhcashgameStart();
				break;
				
			case HHGCASHGAMESTART:
				view = hhgcashgameStart();
				break;
				
			case ROLLDICE:
				view = rolldiceGame();
				break;
				
			case RDGAMEBETTING:
				view = rdgameBetting();
				break;
				
			case RDCASHGAMESTART:
				view = rdcashGameStart();
				break;
				
			case RDGCASHGAMESTART:
				view = rdgcashGameStart();
				break;
				
			default:
				break;
			}
		}
	}
	//대소문자 구별함수
		public boolean equalsIgnoreCase(String str1, String str2) {
		
			str1 = str1.toLowerCase().trim();
			str2 = str2.toLowerCase().trim();
			return str1.equals(str2);
		}
		
		
		private View rdgcashGameStart() {
			printVar("게임 시작");
			System.out.println("1.GAME PLAY!!");
			System.out.println("2.뒤로 가기");
			int menu = ScanUtil.nextInt("메뉴를 선택하세요 ");
			switch (menu) {
			case 1:
				int right = ScanUtil.nextInt("번호를 입력하세요");
				int ran = new Random().nextInt(5);
					if(ran==1) {
						if(right==ran) {
							System.out.println("정답입니다");
							 List<Object> param = new ArrayList();
								MemberVo mem = (MemberVo) sessionStorage.get("MEMBER");
								int num = mem.getMem_no();
								param.add(num);
								MemberVo bet = memService.membetgcash(num);
								System.out.println(bet.getMem_bgcash()*5+"원 당첨되셨습니다!!!!!!!!");
								memService.memRdGetGCash(param);
								System.out.println("축하드립니다~~~~~~~~~~~~~~~~~~~~~~");
								
								String yn = ScanUtil.nextLine("다시 도전 하시겠습니까?");
								if(yn.equalsIgnoreCase("y")) {
									return View.RDGCASHGAMESTART;
								}
								if(yn.equalsIgnoreCase("n")) {
									return View.ROLLDICE;
								}
						
						}else {
						System.out.println("정답이 아닙니다");
						System.out.println("안타깝네요 돈은 좋은곳에 쓰겠습니다..");
						String yn = ScanUtil.nextLine("다시 도전 하시겠습니까?(Y/N)");
						if(yn.equalsIgnoreCase("y")) {
							return View.RDGCASHGAMESTART;
						}
						if(yn.equalsIgnoreCase("n")) {
							return View.ROLLDICE;
						}
						}
					}
					if(ran==2) {
						if(right==ran) {
							System.out.println("정답입니다");
							 List<Object> param = new ArrayList();
								MemberVo mem = (MemberVo) sessionStorage.get("MEMBER");
								int num = mem.getMem_no();
								param.add(num);
								MemberVo bet = memService.membetgcash(num);
								System.out.println(bet.getMem_bgcash()*5+"원 당첨되셨습니다!!!!!!!!");
								memService.memRdGetGCash(param);
								System.out.println("축하드립니다~~~~~~~~~~~~~~~~~~~~~~");
								
								String yn = ScanUtil.nextLine("다시 도전 하시겠습니까?");
								if(yn.equalsIgnoreCase("y")) {
									return View.RDGAMEBETTING;
								}
								if(yn.equalsIgnoreCase("n")) {
									return View.ROLLDICE;
								}
							
						}else {
							System.out.println("정답이 아닙니다");
							System.out.println("안타깝네요 돈은 좋은곳에 쓰겠습니다..");
							String yn = ScanUtil.nextLine("다시 도전 하시겠습니까?");
							if(yn.equalsIgnoreCase("y")) {
								return View.RDGAMEBETTING;
							}
							if(yn.equalsIgnoreCase("n")) {
								return View.ROLLDICE;
							}
						}
						
					}
					if(ran==3) {
						if(right==ran) {
							System.out.println("정답입니다");
							 List<Object> param = new ArrayList();
								MemberVo mem = (MemberVo) sessionStorage.get("MEMBER");
								int num = mem.getMem_no();
								param.add(num);
								MemberVo bet = memService.membetgcash(num);
								System.out.println(bet.getMem_bgcash()*5+"원 당첨되셨습니다!!!!!!!!");
								memService.memRdGetGCash(param);
								System.out.println("축하드립니다~~~~~~~~~~~~~~~~~~~~~~");
								
								String yn = ScanUtil.nextLine("다시 도전 하시겠습니까?");
								if(yn.equalsIgnoreCase("y")) {
									return View.RDGAMEBETTING;
								}
								if(yn.equalsIgnoreCase("n")) {
									return View.ROLLDICE;
								}
						}else {
							System.out.println("정답이 아닙니다");
							System.out.println("안타깝네요 돈은 좋은곳에 쓰겠습니다..");
							String yn = ScanUtil.nextLine("다시 도전 하시겠습니까?");
							if(yn.equalsIgnoreCase("y")) {
								return View.RDGAMEBETTING;
							}
							if(yn.equalsIgnoreCase("n")) {
								return View.ROLLDICE;
							}
						}
					}
					if(ran==4) {
						if(right==ran) {
							System.out.println("정답입니다");
							 List<Object> param = new ArrayList();
								MemberVo mem = (MemberVo) sessionStorage.get("MEMBER");
								int num = mem.getMem_no();
								param.add(num);
								MemberVo bet = memService.membetgcash(num);
								System.out.println(bet.getMem_bgcash()*5+"원 당첨되셨습니다!!!!!!!!");
								memService.memRdGetGCash(param);
								System.out.println("축하드립니다~~~~~~~~~~~~~~~~~~~~~~");
								
								String yn = ScanUtil.nextLine("다시 도전 하시겠습니까?");
								if(yn.equalsIgnoreCase("y")) {
									return View.RDGAMEBETTING;
								}
								if(yn.equalsIgnoreCase("n")) {
									return View.ROLLDICE;
								}
						}else {
							System.out.println("정답이 아닙니다");
							System.out.println("안타깝네요 돈은 좋은곳에 쓰겠습니다..");
							String yn = ScanUtil.nextLine("다시 도전 하시겠습니까?");
							if(yn.equalsIgnoreCase("y")) {
								return View.RDGAMEBETTING;
							}
							if(yn.equalsIgnoreCase("n")) {
								return View.ROLLDICE;
							}
						}
						
					}
					if(ran==5) {
						if(right==ran) {
							System.out.println("정답입니다");
							 List<Object> param = new ArrayList();
								MemberVo mem = (MemberVo) sessionStorage.get("MEMBER");
								int num = mem.getMem_no();
								param.add(num);
								MemberVo bet = memService.membetgcash(num);
								System.out.println(bet.getMem_bgcash()*5+"원 당첨되셨습니다!!!!!!!!");
								memService.memRdGetGCash(param);
								System.out.println("축하드립니다~~~~~~~~~~~~~~~~~~~~~~");
								
								String yn = ScanUtil.nextLine("다시 도전 하시겠습니까?");
								if(yn.equalsIgnoreCase("y")) {
									return View.RDGAMEBETTING;
								}
								if(yn.equalsIgnoreCase("n")) {
									return View.ROLLDICE;
								}
						}else {
							System.out.println("정답이 아닙니다");
							System.out.println("안타깝네요 돈은 좋은곳에 쓰겠습니다..");
							String yn = ScanUtil.nextLine("다시 도전 하시겠습니까?");
							if(yn.equalsIgnoreCase("y")) {
								return View.RDGAMEBETTING;
							}
							if(yn.equalsIgnoreCase("n")) {
								return View.ROLLDICE;
							}
						}
						
					}
					if(ran==6) {
						if(right==ran) {
							System.out.println("정답입니다");
							 List<Object> param = new ArrayList();
								MemberVo mem = (MemberVo) sessionStorage.get("MEMBER");
								int num = mem.getMem_no();
								param.add(num);
								MemberVo bet = memService.membetgcash(num);
								System.out.println(bet.getMem_bgcash()*5+"원 당첨되셨습니다!!!!!!!!");
								memService.memRdGetGCash(param);
								System.out.println("축하드립니다~~~~~~~~~~~~~~~~~~~~~~");
								
								String yn = ScanUtil.nextLine("다시 도전 하시겠습니까?");
								if(yn.equalsIgnoreCase("y")) {
									return View.RDGAMEBETTING;
								}
								if(yn.equalsIgnoreCase("n")) {
									return View.ROLLDICE;
								}
						}else {
							System.out.println("정답이 아닙니다");
							System.out.println("안타깝네요 돈은 좋은곳에 쓰겠습니다..");
							String yn = ScanUtil.nextLine("다시 도전 하시겠습니까?");
							if(yn.equalsIgnoreCase("y")) {
								return View.RDGAMEBETTING;
							}
							if(yn.equalsIgnoreCase("n")) {
								return View.ROLLDICE;
							}
						}	
					}
			case 2 :
				return View.MINIGAME;
				

			default:
				return View.RDGCASHGAMESTART;
			}
		}

		private View rdcashGameStart() {
			printVar("게임 시작");
			System.out.println("1.GAME PLAY!!");
			System.out.println("2.뒤로 가기");
			int menu = ScanUtil.nextInt("메뉴를 선택하세요 ");
			switch (menu) {
			case 1:
				int right = ScanUtil.nextInt("번호를 입력하세요");
				int ran = new Random().nextInt(5);
					if(ran==1) {
						if(right==ran) {
							System.out.println("정답입니다");
							 List<Object> param = new ArrayList();
								MemberVo mem = (MemberVo) sessionStorage.get("MEMBER");
								int num = mem.getMem_no();
								param.add(num);
								MemberVo bet = memService.membetcash(num);
								System.out.println(bet.getMem_bcash()*15+"원 당첨되셨습니다!!!!!!!!");
								memService.memRdGetCash(param);
								System.out.println("축하드립니다~~~~~~~~~~~~~~~~~~~~~~");
								
								String yn = ScanUtil.nextLine("다시 도전 하시겠습니까?");
								if(yn.equalsIgnoreCase("y")) {
									return View.RDCASHGAMESTART;
								}
								if(yn.equalsIgnoreCase("n")) {
									return View.ROLLDICE;
								}
						
						}else {
						System.out.println("정답이 아닙니다");
						System.out.println("안타깝네요 돈은 좋은곳에 쓰겠습니다..");
						String yn = ScanUtil.nextLine("다시 도전 하시겠습니까?");
						if(yn.equalsIgnoreCase("y")) {
							return View.RDCASHGAMESTART;
						}
						if(yn.equalsIgnoreCase("n")) {
							return View.ROLLDICE;
						}
						}
					}
					if(ran==2) {
						if(right==ran) {
							System.out.println("정답입니다");
							 List<Object> param = new ArrayList();
								MemberVo mem = (MemberVo) sessionStorage.get("MEMBER");
								int num = mem.getMem_no();
								param.add(num);
								MemberVo bet = memService.membetcash(num);
								System.out.println(bet.getMem_bcash()*15+"원 당첨되셨습니다!!!!!!!!");
								memService.memRdGetCash(param);
								System.out.println("축하드립니다~~~~~~~~~~~~~~~~~~~~~~");
								
								String yn = ScanUtil.nextLine("다시 도전 하시겠습니까?");
								if(yn.equalsIgnoreCase("y")) {
									return View.RDCASHGAMESTART;
								}
								if(yn.equalsIgnoreCase("n")) {
									return View.ROLLDICE;
								}
							
						}else {
							System.out.println("정답이 아닙니다");
							System.out.println("안타깝네요 돈은 좋은곳에 쓰겠습니다..");
							String yn = ScanUtil.nextLine("다시 도전 하시겠습니까?");
							if(yn.equalsIgnoreCase("y")) {
								return View.RDCASHGAMESTART;
							}
							if(yn.equalsIgnoreCase("n")) {
								return View.ROLLDICE;
							}
						}
						
					}
					if(ran==3) {
						if(right==ran) {
							System.out.println("정답입니다");
							 List<Object> param = new ArrayList();
								MemberVo mem = (MemberVo) sessionStorage.get("MEMBER");
								int num = mem.getMem_no();
								param.add(num);
								MemberVo bet = memService.membetcash(num);
								System.out.println(bet.getMem_bcash()*15+"원 당첨되셨습니다!!!!!!!!");
								memService.memRdGetCash(param);
								System.out.println("축하드립니다~~~~~~~~~~~~~~~~~~~~~~");
								
								String yn = ScanUtil.nextLine("다시 도전 하시겠습니까?");
								if(yn.equalsIgnoreCase("y")) {
									return View.RDCASHGAMESTART;
								}
								if(yn.equalsIgnoreCase("n")) {
									return View.ROLLDICE;
								}
						}else {
							System.out.println("정답이 아닙니다");
							System.out.println("안타깝네요 돈은 좋은곳에 쓰겠습니다..");
							String yn = ScanUtil.nextLine("다시 도전 하시겠습니까?");
							if(yn.equalsIgnoreCase("y")) {
								return View.RDCASHGAMESTART;
							}
							if(yn.equalsIgnoreCase("n")) {
								return View.ROLLDICE;
							}
						}
					}
					if(ran==4) {
						if(right==ran) {
							System.out.println("정답입니다");
							 List<Object> param = new ArrayList();
								MemberVo mem = (MemberVo) sessionStorage.get("MEMBER");
								int num = mem.getMem_no();
								param.add(num);
								MemberVo bet = memService.membetcash(num);
								System.out.println(bet.getMem_bcash()*15+"원 당첨되셨습니다!!!!!!!!");
								memService.memRdGetCash(param);
								System.out.println("축하드립니다~~~~~~~~~~~~~~~~~~~~~~");
								
								String yn = ScanUtil.nextLine("다시 도전 하시겠습니까?");
								if(yn.equalsIgnoreCase("y")) {
									return View.RDCASHGAMESTART;
								}
								if(yn.equalsIgnoreCase("n")) {
									return View.ROLLDICE;
								}
						}else {
							System.out.println("정답이 아닙니다");
							System.out.println("안타깝네요 돈은 좋은곳에 쓰겠습니다..");
							String yn = ScanUtil.nextLine("다시 도전 하시겠습니까?");
							if(yn.equalsIgnoreCase("y")) {
								return View.RDCASHGAMESTART;
							}
							if(yn.equalsIgnoreCase("n")) {
								return View.ROLLDICE;
							}
						}
						
					}
					if(ran==5) {
						if(right==ran) {
							System.out.println("정답입니다");
							 List<Object> param = new ArrayList();
								MemberVo mem = (MemberVo) sessionStorage.get("MEMBER");
								int num = mem.getMem_no();
								param.add(num);
								MemberVo bet = memService.membetcash(num);
								System.out.println(bet.getMem_bcash()*15+"원 당첨되셨습니다!!!!!!!!");
								memService.memRdGetCash(param);
								System.out.println("축하드립니다~~~~~~~~~~~~~~~~~~~~~~");
								
								String yn = ScanUtil.nextLine("다시 도전 하시겠습니까?");
								if(yn.equalsIgnoreCase("y")) {
									return View.RDCASHGAMESTART;
								}
								if(yn.equalsIgnoreCase("n")) {
									return View.ROLLDICE;
								}
						}else {
							System.out.println("정답이 아닙니다");
							System.out.println("안타깝네요 돈은 좋은곳에 쓰겠습니다..");
							String yn = ScanUtil.nextLine("다시 도전 하시겠습니까?");
							if(yn.equalsIgnoreCase("y")) {
								return View.RDCASHGAMESTART;
							}
							if(yn.equalsIgnoreCase("n")) {
								return View.ROLLDICE;
							}
						}
						
					}
					if(ran==6) {
						if(right==ran) {
							System.out.println("정답입니다");
							 List<Object> param = new ArrayList();
								MemberVo mem = (MemberVo) sessionStorage.get("MEMBER");
								int num = mem.getMem_no();
								param.add(num);
								MemberVo bet = memService.membetcash(num);
								System.out.println(bet.getMem_bcash()*15+"원 당첨되셨습니다!!!!!!!!");
								memService.memRdGetCash(param);
								System.out.println("축하드립니다~~~~~~~~~~~~~~~~~~~~~~");
								
								String yn = ScanUtil.nextLine("다시 도전 하시겠습니까?");
								if(yn.equalsIgnoreCase("y")) {
									return View.RDCASHGAMESTART;
								}
								if(yn.equalsIgnoreCase("n")) {
									return View.ROLLDICE;
								}
						}else {
							System.out.println("정답이 아닙니다");
							System.out.println("안타깝네요 돈은 좋은곳에 쓰겠습니다..");
							String yn = ScanUtil.nextLine("다시 도전 하시겠습니까?");
							if(yn.equalsIgnoreCase("y")) {
								return View.RDCASHGAMESTART;
							}
							if(yn.equalsIgnoreCase("n")) {
								return View.ROLLDICE;
							}
						}	
					}
			case 2 :
				return View.MINIGAME;
				

			default:
				return View.RDCASHGAMESTART;
			}
		}

		private View rdgameBetting() {
			printVar("게임 금액 베팅!!");
			MemberVo member = (MemberVo) sessionStorage.get("MEMBER");
			System.out.println("1. 캐시로 베팅(보상 15배)");
			System.out.println("2. 게임머니로 베팅(보상 5배)");
			int sel = ScanUtil.nextInt("메뉴를 선택해주세요");
			switch (sel) {
			case 1:
				List<Object> param = new ArrayList();
				int money = ScanUtil.nextInt("캐시금액을 베팅해주세요");
				int mem = member.getMem_no();
				param.add(money);
				param.add(money);
				param.add(mem);
				
				memService.gameCashBetting(param);
				return View.RDCASHGAMESTART;
			case 2:
				param = new ArrayList();
				money = ScanUtil.nextInt("게임 머니금액을 베팅해주세요");
				mem = member.getMem_no();
				param.add(money);
				param.add(money);
				param.add(mem);
				memService.gameGcashBetting(param);
				return View.RDGCASHGAMESTART;
			default:
				return View.RDGAMEBETTING;
			}
		}

		private View rolldiceGame() {
			printVar("돌려라 다이스 게임");
			MemberVo member = (MemberVo) sessionStorage.get("MEMBER");
			System.out.println("돌려라 다이스 게임에 오신걸 환영합니다");
			System.out.println("주사위를 돌려서 나오는 숫자를 맞추는 게임입니다");
			System.out.println("맞출 확률이 낮은 만큼 그 어떤 게임보다 보상은 높게 책정됩니다");
			System.out.println("인생은 뭐다? ~~~~~~~~~~~~~~~~~~~~");
			System.out.println("자~~~~~~드가자~~~~~~~~~~~~~");
			System.out.println("1. 베팅하기");
			System.out.println("2. 지금 현재 내 잔고 확인하기");
			System.out.println("3. 뒤로가기");
			int select = ScanUtil.nextInt("메뉴를 선택해주세요");
			switch (select) {
			case 1:
				return View.RDGAMEBETTING;
			case 2:
				int num = member.getMem_no();
				MemberVo mem = memService.memberAllCash(num);
				System.out.println(member.getMem_nname()+"님의 보유 캐시는 "+mem.getMem_cash()+"원입니다");
				System.out.println(member.getMem_nname()+"님의 보유 게임머니는"+mem.getMem_gcash()+"원입니다");
			case 3:
				return View.MINIGAME;
			default:
				return View.ROLLDICE;
			}
		}
	private View signUp() {
		printVar("회원가입");
		List<Object> param = new ArrayList<Object>();
		String id = ScanUtil.nextLine("아이디 >>");
		String pass = ScanUtil.nextLine("비밀번호 >>");
		String name = ScanUtil.nextLine("이름 >>");
		String nname = ScanUtil.nextLine("닉네임 >>");
		
		param.add(id);
		param.add(pass);
		param.add(name);
		param.add(nname);
		memService.memsignUp(param);
		return View.LOGIN_PAGE;
	}

	private View hhgcashgameStart() {
		printVar("게임 시작");
		System.out.println("1.홀에 걸겠습니다");
		System.out.println("2.짝에 걸겠습니다");
		System.out.println("3.나가기");
		int select = ScanUtil.nextInt("홀짝 선택>>>");
		switch (select) {
		case 1:
			//홀짝 게임
			int[]hh = new int[1];
			int ran = new Random().nextInt(100)-1;
			for (int i = 0; i < hh.length; i++) {
				if(ran%2==0) {
					System.out.println("짝");
					System.out.println("안타깝네요 ㅠ_ㅠ");
					String yn = ScanUtil.nextLine("다시 도전 하시겠습니까?");
					if(yn.equalsIgnoreCase("y")) {
						return View.HHGAMEBETTING;
					}
					if(yn.equalsIgnoreCase("n")) {
						System.out.println("감사합니다 다음에 또 와주세요~");
						return View.MINIGAME;
					}
					
				}
				if(ran%2!=0){
					System.out.println("홀");
					System.out.println("축하드립니다^________^ 곧 부자되시겠어요");
				    List<Object> param = new ArrayList();
					MemberVo mem = (MemberVo) sessionStorage.get("MEMBER");
					int num = mem.getMem_no();
					param.add(num);
					MemberVo bet = memService.membetgcash(num);
					System.out.println(bet.getMem_bgcash()*2+"원 당첨되셨습니다!!!!!!!!");
					memService.memGetGCash(param);
					String yn = ScanUtil.nextLine("다시 도전 하시겠습니까?");
					if(yn.equalsIgnoreCase("y")) {
						return View.HHGAMEBETTING;
					}
					if(yn.equalsIgnoreCase("n")) {
						System.out.println("감사합니다 다음에 또 와주세요~");
						return View.MINIGAME;
					}
				}
				
			}
		case 2:
			int[]hh1 = new int[1];
			ran = new Random().nextInt(100)-1;
			for (int i = 0; i < hh1.length; i++) {
				if(ran%2==0) {
					System.out.println("짝");
					System.out.println("축하드립니다^________^ 곧 부자되시겠어요");
				    List<Object> param = new ArrayList();
					MemberVo mem = (MemberVo) sessionStorage.get("MEMBER");
					int num = mem.getMem_no();
					param.add(num);
					MemberVo bet = memService.membetgcash(num);
					System.out.println(bet.getMem_bgcash()*2+"원 당첨되셨습니다!!!!!!!!");
					memService.memGetGCash(param);
					
					String yn = ScanUtil.nextLine("다시 도전 하시겠습니까?");
					if(yn.equalsIgnoreCase("y")) {
						return View.HHGAMEBETTING;
					}
					if(yn.equalsIgnoreCase("n")) {
						System.out.println("감사합니다 다음에 또 와주세요~");
						return View.MINIGAME;
					}	
				}
				if(ran%2!=0){
					System.out.println("홀");
					System.out.println("안타깝네요 ㅠ_ㅠ");
					String yn = ScanUtil.nextLine("다시 도전 하시겠습니까?");
					if(yn.equalsIgnoreCase("y")) {
						return View.HHGAMEBETTING;
					}
					if(yn.equalsIgnoreCase("n")) {
						System.out.println("감사합니다 다음에 또 와주세요~");
						return View.MINIGAME;
					}
				}
			}	
		case 3:
			return View.MINIGAME;
		default:
			return View.HHGAMEBETTING;
		}
	}

	private View hhcashgameStart() {
		printVar("게임 시작");
		System.out.println("1.홀에 걸겠습니다");
		System.out.println("2.짝에 걸겠습니다");
		System.out.println("3.나가기");
		int select = ScanUtil.nextInt("홀짝 선택>>>");
		switch (select) {
		case 1:
			//홀짝 게임
			int[]hh = new int[1];
			int ran = new Random().nextInt(100)-1;
			for (int i = 0; i < hh.length; i++) {
				if(ran%2==0) {
					System.out.println("짝");
					System.out.println("안타깝네요 ㅠ_ㅠ");
					String yn = ScanUtil.nextLine("다시 도전 하시겠습니까?");
					if(yn.equalsIgnoreCase("y")) {
						return View.HHGAMEBETTING;
					}
					if(yn.equalsIgnoreCase("n")) {
						System.out.println("감사합니다 다음에 또 와주세요~");
						return View.MINIGAME;
					}
					
				}
				if(ran%2!=0){
					System.out.println("홀");
					System.out.println("축하드립니다^________^ 곧 부자되시겠어요");
				    List<Object> param = new ArrayList();
					MemberVo mem = (MemberVo) sessionStorage.get("MEMBER");
					int num = mem.getMem_no();
					param.add(num);
					MemberVo bet = memService.membetcash(num);
					System.out.println(bet.getMem_bcash()*8+"원 당첨되셨습니다!!!!!!!!");
					memService.memGetCash(param);
					String yn = ScanUtil.nextLine("다시 도전 하시겠습니까?");
					if(yn.equalsIgnoreCase("y")) {
						return View.HHGAMEBETTING;
					}
					if(yn.equalsIgnoreCase("n")) {
						System.out.println("감사합니다 다음에 또 와주세요~");
						return View.MINIGAME;
					}
				}
			}
		case 2:
			int[]hh1 = new int[1];
			ran = new Random().nextInt(100)-1;
			for (int i = 0; i < hh1.length; i++) {
				if(ran%2==0) {
					System.out.println("짝");
					System.out.println("축하드립니다^________^ 곧 부자되시겠어요");
				    List<Object> param = new ArrayList();
					MemberVo mem = (MemberVo) sessionStorage.get("MEMBER");
					int num = mem.getMem_no();
					param.add(num);
					MemberVo bet = memService.membetcash(num);
					System.out.println(bet.getMem_bcash()*8+"원 당첨되셨습니다!!!!!!!!");
					memService.memGetCash(param);
					String yn = ScanUtil.nextLine("다시 도전 하시겠습니까?");
					if(yn.equalsIgnoreCase("y")) {
						return View.HHGAMEBETTING;
					}
					if(yn.equalsIgnoreCase("n")) {
						System.out.println("감사합니다 다음에 또 와주세요~");
						return View.MINIGAME;
					}
				}
				if(ran%2!=0){
					System.out.println("홀");
					System.out.println("안타깝네요 ㅠ_ㅠ");
					String yn = ScanUtil.nextLine("다시 도전 하시겠습니까?");
					if(yn.equalsIgnoreCase("y")) {
						return View.HHGAMEBETTING;
					}
					if(yn.equalsIgnoreCase("n")) {
						System.out.println("감사합니다 다음에 또 와주세요~");
						return View.MINIGAME;
					}
				}
			}	
		case 3:
			return View.MINIGAME;
		default:
			return View.HHGAMEBETTING;
		}
	}
	  
	private View hhgameBetting() {
		printVar("게임 금액 베팅!!");
		MemberVo member = (MemberVo) sessionStorage.get("MEMBER");
		System.out.println("1. 캐시로 베팅(보상 8배)");
		System.out.println("2. 게임머니로 베팅(보상 2배)");
		int sel = ScanUtil.nextInt("메뉴를 선택해주세요");
		switch (sel) {
		case 1:
			List<Object> param = new ArrayList();
			int money = ScanUtil.nextInt("캐시금액을 베팅해주세요");
			int mem = member.getMem_no();
			param.add(money);
			param.add(money);
			param.add(mem);
			
			memService.gameCashBetting(param);
			return View.HHCASHGAMESTART;
		case 2:
			param = new ArrayList();
			money = ScanUtil.nextInt("게임 머니금액을 베팅해주세요");
			mem = member.getMem_no();
			param.add(money);
			param.add(money);
			param.add(mem);
			memService.gameGcashBetting(param);
			return View.HHGCASHGAMESTART;
		default:
			return View.HHGAMEBETTING;
		}
	}

	private View halfhalfGame() {
		printVar("홀짝게임");
		MemberVo member = (MemberVo) sessionStorage.get("MEMBER");
		System.out.println("홀짝게임에 오신걸 환영합니다");
		System.out.println("100사이의 숫자를 랜덤으로 돌려서 나오는 숫자에 짝인지 홀인지 베팅하시면 됩니다");
		System.out.println("각각 캐시와 게임머니를 걸고 게임할 수 있습니다");
		System.out.println("맞출 시에 캐시는 걸은 금액에 8배의 게임머니를 얻을수있고,"
				+ "게임머니는 걸은 금액의 2배의 게임머니를 얻게 됩니다.");
		System.out.println("맞추지 못 할시에는 잃은 금액은 되돌릴수 없다는건 다들 알고계시죠 ?^__^");
		System.out.println("자 그럼 시작해보아요~~^_^");
		System.out.println("1. 베팅하기");
		System.out.println("2. 지금 현재 내 잔고 확인하기");
		System.out.println("3. 뒤로가기");
		int select = ScanUtil.nextInt("메뉴를 선택해주세요");
		switch (select) {
		case 1:
			return View.HHGAMEBETTING;
		case 2:
			int num = member.getMem_no();
			MemberVo mem = memService.memberAllCash(num);
			System.out.println(member.getMem_nname()+"님의 보유 캐시는 "+mem.getMem_cash()+"원입니다");
			System.out.println(member.getMem_nname()+"님의 보유 게임머니는"+mem.getMem_gcash()+"원입니다");
		case 3:
			return View.MINIGAME;
		default:
			return View.HAIFHAIFGAME;
		}
	}

	private View minigameAll() {
		printVar("미니 게임");
		System.out.println("     여기는 미니게임존입니다");
		System.out.println("     캐시와 게임머니를 통해서 게임머니를 얻을 수 있습니다");
		System.out.println("     캐시와 게임머니의 보상배율은 차이가 있으니 그건 플레이어의 선택입니다");
		System.out.println("     나는 노가다가 싫어!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("     라고 생각드시는 분들에겐 I AM 적극 추천이예요^___^");
		System.out.println("     1. 홀짝 게임");
		System.out.println("     2. 돌려라 다이스!");
		System.out.println("     3. 뒤로 가기");
		int sel = ScanUtil.nextInt("게임을 선택해주세요>>");
		switch (sel) {
		case 1:
			return View.HAIFHAIFGAME;
		case 2:
			return View.ROLLDICE;
		case 3:
			return View.MEMBER;
		default:
			return View.MINIGAME;
		}
	}

	private View itemstoreUpgrade() {
		printItemStoreUpgrade();
		int select = ScanUtil.nextInt("메뉴선택>>");
		
		switch (select) {
		case 1:
			MemberVo mem = (MemberVo) sessionStorage.get("MEMBER");
			System.out.println("     "+mem.getMem_nname()+"님 어서오세요");
			System.out.println("     상점 업그레이드에 처음 오신걸 환영합니다^________________^");
			System.out.println("     저는 상점 관리자입니다");
			System.out.println("     아직은 만난지 얼마 되지 않았으니 이미지 관리 차원 빠르게 진행할게요^______^");
			System.out.println("     다음 등급 업그레이드에 필요한 금액은 50만게임머니입니다ㅎ_ㅎv");
			int money = ScanUtil.nextInt("     금액을 입력해주세요 ");
			int memno = mem.getMem_no();
			List<Object> param = new ArrayList();
			
			param.add(money);
			param.add(memno);
			itemService.rareitemstoreUpgrade(param);
			
			MemberVo member = memService.membertake(memno);
			sessionStorage.put("MEMBER", member);
			
			System.out.println("     레어 등급 상점으로 업그레이드 하셨습니다");
			System.out.println("     첫 상점 업그레이드를 완료하였습니다");
			System.out.println("     이제부터는 상점에서 레어 등급 아이템도 구매가 가능해집니다");
			System.out.println("     보상으로 50만게임머니가 지급됩니다");
			System.out.println("     라고 할뻔~~~");
			System.out.println("     다음 등급업에 만나요^_____________^");
			System.out.println("     즐거운 게임 되시길 바랍니다");
			
			return View.ITEM_STORE_UPGRADE;
		case 2:
			mem = (MemberVo) sessionStorage.get("MEMBER");
			System.out.println("     "+mem.getMem_nname()+"님 어서오세요");
			System.out.println("     유니크상점 업그레이드에 오신걸 환영합니다");
			System.out.println("     느끼기엔 등급 업이 조금 빠르신데 잠은 주무시면서 게임하시는거 맞죠?");
			System.out.println("**:~;!*:;**!**;!;!*;::~~~-~--!;;:!;;!!!!;:;:;;;!!!\r\n" + 
     "!=;!!!!;;*!**!;*==!:::~~~-~--;!;:!!:;!;~;;!!;;;!;;\r\n" + 
     "***!!!*;;**=~**===*;:~~~~-~~-;!;:;*!*;:~;;*;!!*!:!\r\n" + 
     "*==;::!-~:;!;=!;!===!:~~~--~-;!:~~;;!!;;;;!!;!!!:;\r\n" + 
     ";;;:::;:::::$*,  .~**::~~~---;;~-:;!;;;;;:~;:!;;!:\r\n" + 
     ";;::::~~;:;;$~,.  .:$!:::~--~;:~;~~:;;::::.:::;:;;\r\n" + 
     "~~:~~~~~::;~;.,-  .-=::::~-~~~~::~~~;;~::;::;;;;;:\r\n" + 
     "::~:;:;;;::~-   . :.*;:;:~-~~-;!;;!!;!;~;~;:;;;!;;\r\n" + 
     "::-;:;;;;;~--   -,  :;:::~-~~,~~::;;;;::~:;::~:;;;\r\n" + 
     "~:~~:;;;;:;:-      ,;;;:::~~~,;~;;!:;;;:;;:;;:;;;:\r\n" + 
     ":;--,,,-,,~**  .. .~;;;:::~~~,;-;;;;:::::~;::~~~:;\r\n" + 
     "!;;;;;-..;=$-,    -!;;;;::~~~-:~;;;:~-~~:;:!:~~::~\r\n" + 
     ";;;;!!::====..,..-**!;;;;:~-~~.,-::;;!;~-.,,--~~~-\r\n" + 
     "::~::~. ====~  .,~===!;;;:~-~~~~~~~~,.,:;:::::;:;:\r\n" + 
     "~;;;:.  ====$    !==== :;;:--~~~-------------,  -;\r\n" + 
     ",,$$~   ===== .  $==== .;;:~---~-----~~~-----,-,,,\r\n" + 
     "-, ;.   =====:!*,=====   ;;:~-,,,,,,,,,,,,,,--~~-,\r\n" + 
     ",-,~    =====;!:,=====...-;::~~---,,,,,,,,,.......\r\n" + 
     ",--,    =====;;.:===$$....~-!##$!-.---,,,,,,,,,,..\r\n" + 
     ".--    .=======*;====:..,.-~~----,.:**;:- ~!;~~-..\r\n" + 
     ".--    .=======!:===$; ,..,;:~-~~-,,,,,,,,-~~--,.!\r\n" + 
     "-,.   .;=======**===$*~.. . $!:::~~---:---,,,.....\r\n" + 
     ",,    .$==============!-.  ,#$$$$=;!;!;~==~---.~;;\r\n" + 
     "--    :$$===$$$$$$$$$##!.  ~##$$$$$$#$$$=*!;~~,;*=\r\n" + 
     ",,    ;$$$$$$$$$$$$$#*#:. .,=**!;!!!!####$**=!~,~:\r\n" + 
     "-. .  !=$$$$$$$$$$$$@:-,,-.=====**#$!,-,.*@!!:-,..\r\n" + 
     "-,      -;!*!$$$$$$$-...,:!=$$$=:-!$$$$#..-!!~,..-\r\n" + 
     "--.        ..~~-!$#=!.,.,*=*$$=#;*##$.;=...~:~,,,~");
			System.out.println("     BUT I AM 신뢰예요~~~~~~~~~ ");
			System.out.println("     YOU의 대한 ME의 믿음은 언제나 100%니까요^______^ ");
			System.out.println("     자 다음 GRADE로 갈 YOUR TURN이예요^____^v ");
			System.out.println("     이번 등급 업그레이드에 필요한 금액은 200만게임머니입니다");
			money = ScanUtil.nextInt("     금액을 입력해주세요 ");
			memno = mem.getMem_no();
			param = new ArrayList();
			
			param.add(money);
			param.add(memno);
			itemService.uniqueitemstoreUpgrade(param);
			member = memService.membertake(memno);
			sessionStorage.put("MEMBER", member);
			
			System.out.println("     유니크 등급 상점으로 업그레이드 하셨습니다");
			System.out.println("     이제부터는 상점에서 유니크 등급 아이템도 구매가 가능해집니다");
			System.out.println("     그럼 우리 NEXT TIME에 봐요^_____^");
			System.out.println("     즐거운 GAME 되시길 바랍니다");
			return View.ITEM_STORE_UPGRADE;
		case 3:
			mem = (MemberVo) sessionStorage.get("MEMBER");
			System.out.println("     "+mem.getMem_nname()+"님 어서오세요");
			System.out.println("     영웅상점 업그레이드에 오신걸 환영합니다");
			System.out.println("     엊그제 유니크등급으로 업그레이드 하신거같은데 감회가 새롭군요");
			System.out.println("     자식이 있다면 이런기분일까나?											");
			System.out.println(" ,ggg, ,ggg,_,ggg,   ,ggg,         gg        ,ggggggggggg,             ,ggg,   ,ggggggggggg,   ,ggg,         gg \r\n" + 
     "dP\"\"Y8dP\"\"Y88P\"\"Y8b dP\"\"Y8a        88       dP\"\"\"88\"\"\"\"\"\"Y8,          dP\"\"8I  dP\"\"\"88\"\"\"\"\"\"Y8,dP\"\"Y8a        88 \r\n" + 
     "Yb, `88'  `88'  `88 Yb, `88        88       Yb,  88      `8b         dP   88  Yb,  88      `8bYb, `88        88 \r\n" + 
     " `\"  88    88    88  `\"  88        88        `\"  88      ,8P        dP    88   `\"  88      ,8P `\"  88        88 \r\n" + 
     "     88    88    88      88        88            88aaaad8P\"        ,8'    88       88aaaad8P\"      88        88 \r\n" + 
     "     88    88    88      88        88            88\"\"\"\"Y8ba        d88888888       88\"\"\"\"Y8ba      88        88 \r\n" + 
     "     88    88    88      88       ,88            88      `8b __   ,8\"     88       88      `8b     88       ,88 \r\n" + 
     "     88    88    88      Y8b,___,d888            88      ,8PdP\"  ,8P      Y8       88      ,8P     Y8b,___,d888 \r\n" + 
     "     88    88    Y8,      \"Y88888P\"88,           88_____,d8'Yb,_,dP       `8b,     88_____,d8'      \"Y88888P\"88,\r\n" + 
     "     88    88    `Y8           ,ad8888          88888888P\"   \"Y8P\"         `Y8    88888888P\"             ,ad8888\r\n" + 
     "                              d8P\" 88                                                                   d8P\" 88 \r\n" + 
     "                            ,d8'   88                                                                 ,d8'   88 \r\n" + 
     "                            d8'    88                                                                 d8'    88 \r\n" + 
     "                            88     88                                                                 88     88 \r\n" + 
     "                            Y8,_ _,88                                                                 Y8,_ _,88 \r\n" + 
     "                             \"Y888P\"                                                                   \"Y888P\"  ");
			System.out.println("     기특합니다 게임을 열심히 즐겨주시니 이 관리자는 그저 감동일뿐이예요");
			System.out.println("     아직 다음 등급들이 남았으니 이대로 열심히 즐겨주신다면 금방 다시 오실수 있을거라 믿어요^____^");
			System.out.println("     이번 등급 업그레이드에 필요한 금액은 500만게임머니입니다");
			money = ScanUtil.nextInt("     금액을 입력해주세요>> ");
			memno = mem.getMem_no();
			param = new ArrayList();
			
			param.add(money);
			param.add(memno);
			itemService.heroitemstoreUpgrade(param);
			
			member = memService.membertake(memno);
			sessionStorage.put("MEMBER", member);
			
			System.out.println("     영웅 등급 상점으로 업그레이드 하셨습니다");
			System.out.println("     이제부터는 상점에서 영웅 등급 아이템도 구매가 가능해집니다");
			System.out.println("     우리 다시 만나요~~~~");
			System.out.println("     즐거운 게임 되시길 바랍니다ㅎ_ㅎvvvvv");
			return View.ITEM_STORE_UPGRADE;
		case 4:
			mem = (MemberVo) sessionStorage.get("MEMBER");
			System.out.println("     "+mem.getMem_nname()+"님 어서오세요");
			System.out.println("     전설상점 업그레이드에 오신걸 환영합니다");
			System.out.println("     벌써 전설 등급 상점까지 오셨다니 제가 다 기특하네요");
			System.out.println("     속도가 너무 빠르신데 매크로 쓰시는건 아니죠 ?");
			System.out.println("     안걸리게 쓰면 모른척 해드리겠지만 걸리면 정지때릴거예요 ㅋ_ㅋㅗ");
			System.out.println("#;-,,--~$$====*=*=$$######$*$=$$$$$$$$$$$$*$$$#$=!\r\n" + 
     "#;-,,---=$$$$$$=$$$##$####$*$===========$=*$$$#$$!\r\n" + 
     "#;--,-;=$#######$$$###$$$#$==========$==$==$$$=#$!\r\n" + 
     "@!,.-$*$##@#######$#$###$===$===========$*=$$$$==!\r\n" + 
     "@!:;=$###@@##########@#@$$$$$#$$$$$$$$$$$*=$$$$$=;\r\n" + 
     "@*=$###@@@@@@#######@###$$$#@##$#$$$$$$$=*$$$$$$=!\r\n" + 
     "#$@##@@@@@@@#########@###$$$#$###$$$$$$$*=##$$$$$;\r\n" + 
     "@####@@@@@@@##$$$$$$$#####$$$#$##$$$$$$*=$##$$$$$;\r\n" + 
     "@##@@@@@@@@@##$$===$$####$$==$=###$$$=*=$##$$$$$=;\r\n" + 
     "@@@@@@@@@@##$$=======$###$$===$$$#$***=$########=;\r\n" + 
     "@@@@@@@@@###$==******=$###$==$$=$$#==$$#########=;\r\n" + 
     "@@@@@@@@@##$==*****!!*=$$$=====$$$$@############=;\r\n" + 
     "@@@@@@@@@#$==******!!!*$$$==$===$$$#$$$$###$$###=;\r\n" + 
     "@@@@@@@###$===*!!**!!!*=$=======$$=$$********==$=;\r\n" + 
     "@@@@@@#$$$====*!***!!;!*===**======$$$$$$$$$$$=**;\r\n" + 
     "@@@@@#$$$$====****!!!!!;!*!!!***==$$$*;;*#$$$$$**;\r\n" + 
     "@@@@##$$======****!!!;;:;::::;****=#=;~;;!==$$$**;\r\n" + 
     "@@##$$$==$====***!!!!;::::::::!****$=:~;*:*=$$$**;\r\n" + 
     "@#$$$=========**!!!;!!;::::::::;!*!**:!:!!;=$$$=*;\r\n" + 
     "@$$$=$==$$====***!!!!!!;::::::::;!*!;~*!:;;=$$$=*:\r\n" + 
     "@$$$$=$$====$=**!*!**!!;:::::::::;!!:~!;!;;!==*=*;\r\n" + 
     "@$$$$$$=$=$$==********!!;:::::::::;!:-===*;:==$#=;\r\n" + 
     "@$$$$$$$$$$$==**=*===*!;:;!;;:::~~:;;~*===!;=###*;\r\n" + 
     "@$$$=$#$$$$$=========*!;::!**;;:~~~;!;;!==*:;###*;\r\n" + 
     "@$$=$$$$$$$$$$$========*=$=$=*!;:~~:!;;!=*;::$##*;\r\n" + 
     "@$$$$$$$$$$$$$$$$==$$#@==*$$=*!;:~~:;!:!=!~;:$##*;\r\n" + 
     "@$$$$$$$$#$$$$$$=$@###@#*!$$=**;:~~:::~!=;~:~$##*;\r\n" + 
     "@$$$$$$$$###$$=**$#####$*====*!;:~~:::~~;;:~!$##$*\r\n" + 
     "@$$$$$$$$$$#$=!!=##@##$$$$===*!;:~~:::~::;:~=#@@@@\r\n" + 
     "@$$$$$$$$#$==*;;=######$$===**!;:~~::::~;::~!$@@@@\r\n" + 
     "@$$$$$$####$==!;*=$$$$$$$===**!;:~~::::~::~~:=#@@@\r\n" + 
     "@$$$$$###@@@$==!;**====$$===**!;:::::::~~~~~~;##@@\r\n" + 
     "@$$$$#@@@@@@#$=*;;!***=======*!;;::::::~~::~~:*#$@\r\n" + 
     "@#$##@@@@@@@@$==!;;;!*=======*!;;::::::~::::~~:$*#\r\n" + 
     "@#$#@@@@@@@@@#$=*;;;;!======**!;:;:::::~:~:::~:!*=\r\n" + 
     "@@##@@@@@@@@##$==*;::;*$$$==**!;;::::::~~~~::~:;*!\r\n" + 
     "@##@@@@@@#@@#$$==*!;;!!*$$$$=*!!;::;;:::~~~~:::;!:\r\n" + 
     "@$##@@@@####$$$$==*;;;:~!=$$$=*!;::;;;::~~~~:::;!~\r\n" + 
     "@=*##@@####$$$$$===!;~:;;*===$=*;;::;;:::~~~:::;!~\r\n" + 
     "@=;*##@####$$$#$$$$=::$=!*;:!*==*;:;;;;:::~~:::;!~\r\n" + 
     "@$*=######$$$$##$$$$!:***=*;;!**=!;;;;;::::::;;!;~\r\n" + 
     "@##$@##$$#$$$$#####$!!*====*!:!***;:;;;::::::;;*:~\r\n" + 
     "@######$$$$$$$#########$==$=*;;!**!:;;;::::::;!=~~\r\n" + 
     "@@@@###$$$$#######@####$$=$==;;;***;;;;;:::;;;**~~\r\n" + 
     "@@@@@############$$####$$====!!:==*;;;;;;;:;;!$;~~\r\n" + 
     "@#####@##########$$####$$====*!;:=*!;;;;;;;;!*=~~:\r\n" + 
     "@####@@###########$######$*!==*!:;!!;;;;;;;!!$!:::\r\n" + 
     "@@@@@@@@################@@***==*;:;;;;;;;;!!*=;::;\r\n" + 
     "@@@@@@@@#@@@###########@@#::===*!;;;;;;;;;!*$*;;;;\r\n" + 
     "@@@@@@@@@@@@@#########@##*담배*$$==;;;!;;;;!**#!;;;!\r\n" + 
     "@@@@@@@@@@@@@@@#########$$담배:$$$$$*;;!;;;;!*$*!!!!*\r\n" + 
     "@@@@@@@@@@@@@@@@########$##$$$$$$=!;!!;;!*=$**!!*=\r\n" + 
     "@@@@@@@@@@@@@@@@@######$$$###$$===*;!!!;!*$=*****$\r\n" + 
     "@@@@@@@@@@@@@@@@#$$$$$$$=$$##$$===*;;!!!!$$===**=#\r\n" + 
     "@@@@@@@@@@@@@@@#$$=========$$#$====!;***=#$$====$#\r\n" + 
     "@@@@@@@@@@@@@$$$$$$$=$$===***=$$===*;!*=$$$$$==$$#\r\n" + 
     "@@@@@@@@@@@@#$$$$$$$$$$$====***=$$=*!;=$#$#$$$$$##\r\n" + 
     "@@@@@@@@@@@@#$######$$$$$======**==**;!###$$$$$##@\r\n" + 
     "@@@@@@@@@@@@@@@@@@@#$===$$=======*!!!;;=##$$$###@@\r\n" + 
     "@@@@@@@@@@@@@#@@@@@$$===**#$======*!;;;!#$######@@\r\n" + 
     "@@@@@@@@@@@@@@@@@#$$============$=*!;;:;*#######@@\r\n" + 
     "@@@@@@@@@@@@@@@@#$==$==========*****!;;;;$#######@\r\n" + 
     "@@@@@@@@@@@@@@@@$$=*!*$$======*!!*!!*;;;;!########\r\n" + 
     "@@@@@@@@@@@@@@@@$$$*!;*$=$====*!!*!;!!;;;;########\r\n" + 
     "@@@@@@@@@@@@@@@$$$$;:!=**=***=*!!**!;!;;;;=##$$$$#\r\n" + 
     "@@@@@@@@@@@@@@$$$$=::$====**!!!!!!!!!;!;;;*#$$===@\r\n" + 
     "@@@@@@@@@@@@@@#$###=*@$====*!!!!;!!!!!!;;;;======@\r\n" + 
     "@#@@@@@@@@@@@@##@@@@@#$$$$=*****!!!!!!!;;;;*=====@\r\n" + 
     "@@#@@@@@@@@@@@#@@@@@@@$$$$==******;!!!!;;;;;=====@\r\n" + 
     "@@##@@@@@@@@@@@@@@@@@@#$$$$==******!!!;!;;;;!===$@\r\n" + 
     "@@##@@@@@@@@@@@@@@@@@@#$$$$$$==*****!!;;!;;;;$==$@\r\n" + 
     "@@@##@@@@@@@@@@@@@@@@@@#$$$$$===*****!;;;!;;!=##@@\r\n" + 
     "@@@@####@@@@@@@@@@@@@@@@$$$$$===******!;;!!;!=*#@@\r\n" + 
     "@@@@@@#$@@@@@@@@@@@@@@@@#$$$$$===******;;!*;;$$#@@\r\n" + 
     "@@@@@@##@@@@@@@@@@@@@@@@@#$$$$=====****!!!*;;=$@@@\r\n" + 
     "@@@@@@##@@@@@@@@@@@@@@@@@#$$$$$=====***!***!!*$#=*\r\n" + 
					"@@@@@@@##@@@@@@@@@@@@@@@@@#$##$$$=====****=*==$=*=");
			System.out.println("     하하 장난이예요 얼른 전설 아이템을 만나러 가볼까요 ?");
			System.out.println("     이번 등급 업그레이드에 필요한 금액은 1000만게임머니입니다");
			money = ScanUtil.nextInt("     금액을 입력해주세요 ");
			memno = mem.getMem_no();
			param = new ArrayList();
			
			param.add(money);
			param.add(memno);
			itemService.legenditemstoreUpgrade(param);
			member = memService.membertake(memno);
			sessionStorage.put("MEMBER", member);
			
			System.out.println("     전설 등급 상점으로 업그레이드 하셨습니다");
			System.out.println("     이제부터는 상점에서 전설 등급 아이템도 구매가 가능해집니다");
			System.out.println("     최종 업그레이드까지 한 단계 남았네요 열심히 해서 다음 등급 아이템도 얼른 만나봐요!");
			System.out.println("     즐거운 게임 되시길 바랍니다(엄근진)");
			return View.ITEM_STORE_UPGRADE;
		case 5:
			mem = (MemberVo) sessionStorage.get("MEMBER");
			System.out.println("     "+mem.getMem_nname()+"님 어서오세요");
			System.out.println("     신화상점 업그레이드에 오신걸 환영합니다");
			System.out.println("     우와 정말 놀라운데요 ? 벌써 최종 단계네요 ;;;;");
			System.out.println("     솔직히 말해보세요 적금깼죠 ?");
			System.out.println("\r\n" + 
     "▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░\r\n" + 
     "▓▓▓▓▓▓▓▓▓▓▓▓▓▓█▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\r\n" + 
     "▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\r\n" + 
     "▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\r\n" + 
     "▓▓▓▓▓▓▒▒▓▓▓▓▓▓▓▓▓▓▓░░░░░░░░▒▓░▒▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\r\n" + 
     "▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓░░░░░░░░░░░░░░░▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\r\n" + 
     "▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓░░▒░░░░░░▒░░░░░░░░▒▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\r\n" + 
     "▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒░░░░░░░░░░░░░░░░░░▒░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\r\n" + 
     "▒▒▒▒▓▓▓▓▓▓▓▓▓░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒\r\n" + 
     "▒▒▒▒▒▒▒▒▒▒▓▓▒░░▒░▒░░░░▒▒░▒░░░░░░░░░░░▒▒░▒▒▒▒▒▒▒▒▒▒\r\n" + 
     "▒▒▒▒▒▒▒▒▒▓▓░░░░░░░░░░▒▒▒▒░░░░░░░░░░░▒▒░░░▒▒▒▒▒▒▒▒▒\r\n" + 
     "▒▒▒▒▒▒▒▒▒▒▓░░░░░░░░░░▒▒▒░░▒░░░░▒░░░░░░░░░░▒▒▒▒▒▒▒▒\r\n" + 
     "▒▒▒▒▒▒▒▒▒▒░░░░░░░▒░░░▒▒▒░░▒░░░░░░░░░░░░░░░▒▒▒▒▒▒▒▒\r\n" + 
     "▒▒▒▒▒▒▒▒▒▒░─░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒▒▒▒\r\n" + 
     "▒▒▒▒▒▒▒▒▒▓░░░░░░░░░░░░░░░░░░░░░░▒░░░░░░░░░░▒▒▒▒▒▒▒\r\n" + 
     "▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▓▒▒▒▒▒▒\r\n" + 
     "▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░░░░░░░░░░▓▓▓░░░░░░░░░░▒▓▓▒▒▒▒▒\r\n" + 
     "▒▒▒▒▒▒▒▒▒▓░░░░░░░░░░░░░░░░░░▓▓▓▓▓▓░░░░░░▓▒▒▒▒▒▒▒▒▒\r\n" + 
     "▒▒▒▒▒▒▒░░▓░░░░░▓▓▓▒░░░░░░░▓▓▓▓▓▓▓▓▒░░░░░▒░▒▒▒▒▒▒▒▒\r\n" + 
     "▒▒▒▒▒▒░░░▒░░░▒▓▓▓▓▓▒░░░░▒▒▓▓▓▓▓▓▓▓▒░░░░░░░▒▒▒▒▒▒▒▒\r\n" + 
     "▒▒▒▒░░▒░░░▒░░▓▓▓▓▓▒▒▒░░▒▓▓▓▓▓▓▓▓▓▓▓░░░░░░░▒▒▓▒▒▒▒▒\r\n" + 
     "▒▒▒▒▒▒░░░░▒░░▓▓▓▓▒▒░▒░▒▓▓▓▓▓▓▓▓▓▓▓░░░░░░░▓▓▒▒▒▒▒▒▒\r\n" + 
     "▒▒▒░░░░░░░▒▒▒▓▓▓▓░▒▒░░▒▓▓▓▓▓▓▓▓▓▓▓░▒▓▒░░▒▓▓▓▒▒▒▒▒▒\r\n" + 
     "▒▒▒▒▒▒░░░▒▓▒▒▓▓▓▒░▒▒░░▒▓▓▓▓▓▓▓▓▓▒░░░░▒░░░▓▓▓▓▓▒▒▒▒\r\n" + 
     "▒▒▒▒▒▒▒░░░▒▒▒░▒▓▒░░░░░▒▓▓▓▓▓▓▓▓▒▒▒░░▒▒░░░▒▓▓▓▓▒▒▓▓\r\n" + 
     "▒▒▒▒▒▒▒░░░▒▒▒░░░▒░░░░░▒▒▒▒▒▒▒▒▒░░▒░░▒░░░░▒▓▓▓▓▒▒▒▓\r\n" + 
     "▒▒▒▒▒▒▒░░░░▒▒░░░▒▒▒░░▒░░░░░░░░░░░▒░▒▒░░░░░▒▓▓▓▒▒▒▒\r\n" + 
					"▒▒▒▒▒▒▒░░░░▒▒░░░░░▒▒░░░░░░░░░░░░░▒░▒▒▓░░░░▒▒▒▓▒▒▒▒");
			System.out.println("     아니면 부모님 지갑에서 슬쩍 몇장 뺀거같은데......");
			System.out.println("     플레이어님이 너무 대단하셔서 자꾸 장난을 치게되네요 기분나쁘셨다면 죄송해요ㅠ_^");
			System.out.println("     자~~이제 정말 마지막 업그레이드단계입니다");
			System.out.println("     최종 등급 아이템의 풀강에 도전하러 가볼까요?");
			System.out.println("     이번 등급 업그레이드에 필요한 금액은 5000만게임머니입니다");
			money = ScanUtil.nextInt("     금액을 입력해주세요 ");
			memno = mem.getMem_no();
			param = new ArrayList();
			
			param.add(money);
			param.add(memno);
			itemService.misticitemstoreUpgrade(param);
			
			member = memService.membertake(memno);
			sessionStorage.put("MEMBER", member);
			
			System.out.println("     신화 등급 상점으로 최종 업그레이드 하셨습니다");
			System.out.println("     이제부터는 상점에서 신화 등급 아이템도 구매가 가능해집니다");
			System.out.println("     최종 단계까지 업그레이드가 완료 되었습니다.");
			System.out.println("     즐거운 게임 되시길 바랍니다");
			return View.ITEM_STORE_UPGRADE;
		case 6: 
			return View.ITEMSTORE;
		default:
			return View.ITEM_STORE_UPGRADE;
		}
	}

	private View adminItemList() {
		System.out.println("\t\t\t\t전체 아이템 리스트");
		printLn(1);
		List<ItemListVo> itemList = itemService.itemAllList();
		printAllList(itemList);
		printLn(2);
		return View.ADMIN_ITEMMENU_UPDATE;
	}

	private View adminItemUpdate() {
		printadminItemUpdate();
		
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		
		
		switch (sel) {
		case 1:
			List<ItemListVo> item = itemService.itemAllList();
			printAdItemAllList(item);
			int select = ScanUtil.nextInt("아이템을 선택해주세요");
			printAdSelectItem(select);
			List<Object> param = new ArrayList<Object>();
			String name = ScanUtil.nextLine("변경할 아이템 이름 >>");
			param.add(name);
			param.add(select);
			adService.adminItNameUpdate(param);
			return View.ADMIN_ITEM_UPDATE;
		case 2:
			item = itemService.itemAllList();
			printAdItemAllList(item);
			select = ScanUtil.nextInt("아이템을 선택해주세요");
			printAdSelectItem(select);
			param = new ArrayList<Object>();
			String con = ScanUtil.nextLine("변경할 아이템 내용 >>");
			param.add(con);
			param.add(select);
			adService.adminItConUpdate(param);
			return View.ADMIN_ITEM_UPDATE;
		case 3:
			item = itemService.itemAllList();
			printAdItemAllList(item);
			select = ScanUtil.nextInt("아이템을 선택해주세요");
			printAdSelectItem(select);
			param = new ArrayList<Object>();
			String cls = ScanUtil.nextLine("변경할 아이템 등급 >>");
			param.add(cls);
			param.add(select);
			adService.adminItClsUpdate(param);
			return View.ADMIN_ITEM_UPDATE;
		case 4:
			item = itemService.itemAllList();
			printAdItemAllList(item);
			select = ScanUtil.nextInt("아이템을 선택해주세요");
			printAdSelectItem(select);
			param = new ArrayList<Object>();
			String type = ScanUtil.nextLine("변경할 아이템 타입 >>");
			param.add(type);
			param.add(select);
			adService.adminItTypeUpdate(param);
			return View.ADMIN_ITEM_UPDATE;
		case 5:
			item = itemService.itemAllList();
			printAdItemAllList(item);
			select = ScanUtil.nextInt("아이템을 선택해주세요");
			printAdSelectItem(select);
			param = new ArrayList<Object>();
			int price = ScanUtil.nextInt("변경할 아이템 가격 >>");
			param.add(price);
			param.add(select);
			adService.adminItPriceUpdate(param);
			return View.ADMIN_ITEM_UPDATE;
		case 6:
			item = itemService.itemAllList();
			printAdItemAllList(item);
			select = ScanUtil.nextInt("아이템을 선택해주세요");
			printAdSelectItem(select);
			param = new ArrayList<Object>();
			int grade = ScanUtil.nextInt("변경할 아이템 상점 등급 >>");
			param.add(grade);
			param.add(select);
			adService.adminItStgradeUpdate(param);
			return View.ADMIN_ITEM_UPDATE;
		case 7:
			return View.ADMIN_ITEMMENU_UPDATE;
		
		default:
			return View.ADMIN_ITEM_UPDATE;
		}
		
		
	}

	private View adminItemInsert() {
		printLn(5);
		printVar("신규 아이템 추가하기");
		printLn(2);
		List<Object> param = new ArrayList<Object>();
		String name = ScanUtil.nextLine("신규 아이템 이름>>");
		String con = ScanUtil.nextLine("신규 아이템 내용 >>");
		String cls = ScanUtil.nextLine("신규 아이템 등급>>");
		String type = ScanUtil.nextLine("신규 아이템 타입>>");
		int price = ScanUtil.nextInt("신규 아이템 가격>>");
		int grade = ScanUtil.nextInt("신규 아이템 상점등급>>");
		
		param.add(name);
		param.add(con);
		param.add(cls);
		param.add(type);
		param.add(price);
		param.add(grade);
		adService.adminItInsert(param);
		return View.ADMIN_ITEMMENU_UPDATE;
	}

	private View adminUpgradeUpdate() {
		printLn(2);
		System.out.println("\t\t강화 수치 수정");
		printLn(2);
		List<Object> param = new ArrayList<Object>();
		int no = ScanUtil.nextInt("변경할 강화 수치를 선택해주세요 >>");
		int suc = ScanUtil.nextInt("변경할 강화 확률을 입력해주세요 >>");
		int fail = ScanUtil.nextInt("변경할 실패확률을 입력해주세요 >>");
		
		param.add(suc);
		param.add(fail);
		param.add(no);
		
		adService.adminUpgradeChange(param);
		
		printLn(2);
		System.out.println("\t\t 수정 완료!!");
		printLn(2);
		
		return View.ADMIN_ITEMMENU_UPDATE;
	}

	private View adminItemmenuUpdate() {
		printItemMenuUpdate();
		
		int sel = ScanUtil.nextInt("수정/추가할 메뉴를 선택해주세요 >>");
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

	private View adsuggestionDelete() {
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
		sugService.adsuggestionDelete(param);
		return View.A_SUGGESTION;
	}
	
	private View memsuggestionDelete() {
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
		return View.M_SUGGESTION;
	}

	private View suggestionUpdate() {
		printLn(2);
		printVar("수정");
		printLn(2);
		
		MemberVo mem = (MemberVo) sessionStorage.get("MEMBER");
		String id = mem.getMem_id();
		List<SugVo> sugList = sugService.suggestionDetail(id);
		printsugMyList(sugList);
		
		int sel = ScanUtil.nextInt("수정할 글 번호를 선택해주세요");
		
		List<Object> param = new ArrayList<Object>();
		
		String title = ScanUtil.nextLine("제목 수정 >>");
		String con = ScanUtil.nextLine("내용 수정 >>");
		param.add(title);
		param.add(con);
		param.add(sel);
		sugService.suggestionUpdate(param);
		return View.M_SUGGESTION;
	}

	private View suggestionInsert() {
		printLn(2);
		printVar("글작성");
		printLn(2);
		
		List<Object> param = new ArrayList<Object>();
		String title = ScanUtil.nextLine("제목 : ");
		String con = ScanUtil.nextLine("내용 : ");
		MemberVo mem = (MemberVo) sessionStorage.get("MEMBER");
		String id = mem.getMem_id();
		param.add(title);
		param.add(con);
		param.add(id);
		sugService.suggestionInsert(param);

		return View.M_SUGGESTION;
	}

	private View memsuggestionList() {
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
			return View.M_SUGGESTION_LIST;
		case 2:
			String con = ScanUtil.nextLine("내용검색 >>");
			sugList = sugService.suggestionConSearch(con);
				for (SugVo sugVo : sugList) {
					System.out.println(sugVo.getSug_no()+"\t"+sugVo.getSug_title()+"\t"+sugVo.getSug_con()+"\t"+sugVo.getMem_id()+"\t"+sugVo.getSug_date()+"\t"+sugVo.getSug_view());
				}
			return View.M_SUGGESTION_LIST;
		case 3:
			String writer = ScanUtil.nextLine("작성자검색 >>");
			sugList = sugService.suggestionWriterSearch(writer);
				for (SugVo sugVo : sugList) {
					System.out.println(sugVo.getSug_no()+"\t"+sugVo.getSug_title()+"\t"+sugVo.getSug_con()+"\t"+sugVo.getMem_id()+"\t"+sugVo.getSug_date()+"\t"+sugVo.getSug_view());
				}
			return View.M_SUGGESTION_LIST;
			
		case 4:
			return View.M_SUGGESTION;			

		default:
			return View.M_SUGGESTION_LIST;
		}
	}
	
	private View adsuggestionList() {
		List<SugVo> sugList = sugService.suggestionAllList();
		
		printsugAllList(sugList);
		printsuggestionList();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		String date_Str;
		
		int no = ScanUtil.nextInt("메뉴를 선택해주세요");
		switch (no) {
		case 1:
			String title = ScanUtil.nextLine("제목검색 >>");
			sugList = sugService.suggestionTitleSearch(title);
			for (SugVo sugVo : sugList) {
				date_Str = sdf.format(sugVo.getSug_date());
				System.out.println(sugVo.getSug_no() + "\t" + sugVo.getSug_title() + "\t" + sugVo.getSug_con() + "\t" + sugVo.getMem_id() + "\t" + date_Str + "\t" + sugVo.getSug_view());
			}
			return View.A_SUGGESTION_LIST;
		case 2:
			String con = ScanUtil.nextLine("내용검색 >>");
			sugList = sugService.suggestionConSearch(con);
			for (SugVo sugVo : sugList) {
				date_Str = sdf.format(sugVo.getSug_date());
				System.out.println(sugVo.getSug_no() + "\t" + sugVo.getSug_title() + "\t" + sugVo.getSug_con() + "\t" + sugVo.getMem_id() + "\t" + date_Str + "\t" + sugVo.getSug_view());
			}
			return View.A_SUGGESTION_LIST;
		case 3:
			String writer = ScanUtil.nextLine("작성자검색 >>");
			sugList = sugService.suggestionWriterSearch(writer);
			for (SugVo sugVo : sugList) {
				date_Str = sdf.format(sugVo.getSug_date());
				System.out.println(sugVo.getSug_no() + "\t" + sugVo.getSug_title() + "\t" + sugVo.getSug_con() + "\t" + sugVo.getMem_id() + "\t" + date_Str + "\t" + sugVo.getSug_view());
			}
			return View.A_SUGGESTION_LIST;
			
		case 4:
			return View.A_SUGGESTION;			
			
		default:
			return View.A_SUGGESTION_LIST;
		}
	}

	private View blacklist() {
		printBlackList();
		List<MemberVo> mem = memService.memberAllList();
		printBlackListMember(mem);
		int sel = ScanUtil.nextInt("블랙리스트로 추가할 회원 번호를 선택하세요 >>");
		List<Object> param = new ArrayList<Object>();
		param.add(sel);
		memService.memBlacklist(param);

		return View.ADMIN;
	}
	private View adminModify() {
		printAdminModify();
		
		int sel = ScanUtil.nextInt("수정할 메뉴를 선택하세요 >>");
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
		printLn(5);
		printVar("공지글 삭제");
		printLn(1);
		
		List<NoticeVo> not =  noService.noticeAllLest();	
		printNoticeAllList(not);
		List<Object> param = new ArrayList<Object>();
		int sel = ScanUtil.nextInt("삭제할 글 번호를 선택해주세요 >>");
		param.add(sel);
		noService.noticeDelete(param);
		return View.A_NOTICE;
	}

	private View noticeUpdate() {
		printLn(5);
		printVar("공지글수정");
		printLn(1);
		
		List<NoticeVo> not =  noService.noticeAllLest();
		printNoticeAllList(not);
		List<Object> param = new ArrayList<Object>();
		
		int sel = ScanUtil.nextInt("수정할 글 번호를 선택하세요");
		String title = ScanUtil.nextLine("제목 수정 >> ");
		String con = ScanUtil.nextLine("내용 수정 >> ");
		param.add(title);
		param.add(con);
		param.add(sel);
		noService.noticeUpdate(param);
		return View.A_NOTICE;
	}

	private View noticeInsert() {
		printVar("공지글작성");
		
		List<Object> param = new ArrayList<Object>();
		String title = ScanUtil.nextLine("제목 >> ");
		String con = ScanUtil.nextLine("내용 >> ");
		AdminVo ad = (AdminVo) sessionStorage.get("ADMIN");
		int no = ad.getAd_no();
		
		param.add(title);
		param.add(con);
		param.add(no);
		noService.noticeInsert(param);
		
		return View.A_NOTICE;

	}
	
	private View noticeList() {
		
		List<NoticeVo> no = noService.noticeAllLest();
		printNoticeAllList(no);
		
		int sel = ScanUtil.nextInt("열람할 공지사항 번호를 입력해주세요 >>");
		printLn(1);
		List<Object> param = new ArrayList<Object>();
		param.add(sel);
		List<NoticeVo> de = noService.noticeDetail(param);
		for (NoticeVo noticeVo : de) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
			String date_Str = sdf.format(noticeVo.getNtc_date());
			System.out.println(noticeVo.getNtc_no() + "\t" + noticeVo.getNtc_title() + "\t" + date_Str + "\t" + noticeVo.getNtc_view());
			System.out.println(noticeVo.getNtc_con());
		}
		printLn(1);
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
	
	private View memSuggestion() {
		printMemberSuggestion();
		
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		switch (sel) {
		case 1:
			return View.M_SUGGESTION_LIST;
		case 2:
			return View.M_SUGGESTION_INSERT;
		case 3:
			return View.M_SUGGESTION_UPDATE;
		case 4:
			return View.M_SUGGESTION_DELETE;
		case 5:
			return View.M_COMMUNITY;
		default:
			return View.M_SUGGESTION;
		}
	}
	
	private View adminSuggestion() {
		printAdminSuggestion();
		
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		switch (sel) {
		case 1:
			return View.A_SUGGESTION_LIST;
		case 2:
			return View.A_SUGGESTION_DELETE;
		case 3:
			return View.ADMIN;
		default:
			return View.A_SUGGESTION;
		}
	}


	private View memberNotice() {
		List<NoticeVo> no = noService.noticeAllLest();
		printNoticeAllList(no);
		
		int sel = ScanUtil.nextInt("열람할 공지사항 번호를 입력해주세요 >>");
		printLn(2);
		List<Object> param = new ArrayList<Object>();
		param.add(sel);
		List<NoticeVo> de = noService.noticeDetail(param);
		for (NoticeVo noticeVo : de) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
			String date_Str = sdf.format(noticeVo.getNtc_date());
			System.out.println(noticeVo.getNtc_no()+"\t"+noticeVo.getNtc_title()+"\t"+noticeVo.getNtc_con()+"\t"+date_Str+"\t"+noticeVo.getNtc_view());
		}
		printLn(2);
		return View.M_COMMUNITY;
	}

	private View memberCommunity() {
		printMemberCommunity();
		
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		switch (sel) {
		case 1:
			return View.M_NOTICE;
		case 2:
			return View.M_SUGGESTION;
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
		
		printLn(1);
		System.out.println(change*10+"게임머니가 환전되었습니다");
		System.out.println("즐거운 게임 되시길 바랍니다");
		printLn(1);
		
		return View.CASHSTORE;
	}

	private View cashPurchase() {
		printCashPurchase();
		
		int purchase = ScanUtil.nextInt("결제하실 금액을 입력하세요 >>");
		List<Object> param = new ArrayList();
		param.add(purchase);
		memService.membercashPurchase(param);
		
		System.out.println(purchase*10+"원 충전 완료되었습니다");
		System.out.println("귀하의 돈은 저희 회사 발전에 잘 먹겠습니다 ㅋ");
		printLn(1);
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
		ItemDetailspaceVo it =  (ItemDetailspaceVo)itemStorage.get("it");
		printItemDetail(it);
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
		
		List<Object> itemList = new ArrayList();
		MemberVo mem =  (MemberVo) sessionStorage.get("MEMBER");
		int no = (int) mem.getMem_stgrade();
		int num = mem.getMem_no();
		itemList.add(no);
		List<ItemListVo> item =itemService.itemStoreList(itemList);
		printAllList(item);
		
		printLn(2);
		System.out.println("\t\t\t아이템 구매");
		printLn(2);
		int sel = ScanUtil.nextInt("구매하실 아이템 번호를 입력하세요>>");
		
		List<Object> param = new ArrayList();
		param.add(num);
		param.add(sel);
		itemService.itemBuyItem(param);
		
		List<Object> param1 = new ArrayList<Object>();
		param1.add(num);
		param1.add(sel);
		itemService.itemUpdate(param1);
		
		List<Object> param2 = new ArrayList<Object>();
		param2.add(sel);
		param2.add(num);
		itemService.memberGcashminus(param2);

		printVar("구매 완료");
		return View.ITEMSTORE;
	}
	
	private View itemSearch() {
		printLn(2);
		List<Object> itemList = new ArrayList();
		MemberVo mem =  (MemberVo) sessionStorage.get("MEMBER");
		int no = mem.getMem_stgrade();
		itemList.add(no);
		List<ItemListVo> item =itemService.itemStoreList(itemList);
		printAllList(item);
		
		printItemSearch();
		
		int sel = ScanUtil.nextInt("메뉴 선택를 선택하세요>> ");
			switch (sel) {
		case 1:
			String name = ScanUtil.nextLine("아이템 이름을 입력해주세요>>" );
			item = (List<ItemListVo>) itemService.itemNameSearch(name);
			for (ItemListVo itemListVo : item) {
				System.out.println(itemListVo.getItm_no()+"\t"+itemListVo.getItm_name()+"\t"+itemListVo.getItm_con()+"\t"+itemListVo.getItm_cls()+"\t"+itemListVo.getItm_type()+"\t"+itemListVo.getItm_price());
			}
			return View.ITEM_SEARCH;
		case 2:
			String cls = ScanUtil.nextLine("아이템 등급을 입력해주세요>>" );
			item = (List<ItemListVo>) itemService.itemClsSearch(cls);
			for (ItemListVo itemListVo : item) {
				System.out.println(itemListVo.getItm_no()+"\t"+itemListVo.getItm_name()+"\t"+itemListVo.getItm_con()+"\t"+itemListVo.getItm_cls()+"\t"+itemListVo.getItm_type()+"\t"+itemListVo.getItm_price());
			}
			return View.ITEM_SEARCH;
		case 3:
			String type = ScanUtil.nextLine("아이템 타입을 입력해주세요>>" );
			item = (List<ItemListVo>) itemService.itemTypeSearch(type);
			for (ItemListVo itemListVo : item) {
				System.out.println(itemListVo.getItm_no()+"\t"+itemListVo.getItm_name()+"\t"+itemListVo.getItm_con()+"\t"+itemListVo.getItm_cls()+"\t"+itemListVo.getItm_type()+"\t"+itemListVo.getItm_price());
			}
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
			return View.ITEM_STORE_UPGRADE;
		case 5:
			return View.MEMBER;
		default:
			return View.ITEMSTORE;
		}
		
	}

private View itemSelect() {
		
		List<Object> param = new ArrayList<Object>();
		int select = ScanUtil.nextInt("아이템을 선택해주세요 >>");
		param.add(select);
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
		printLn(2);
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!! 자 게임 시작이다 !!!!!!!!!!!!!!!!!!!!!!!!");
		
		ItemDetailspaceVo it = (ItemDetailspaceVo) itemStorage.get("it");
		
		printItemDetail(it);
		itemUpgradePrint();
		
		int inven = it.getInven_no();
		int num = it.getSp_no();
		int up = it.getUp_no();
		
		int rank = up;
		 while (true) {
			
			List<Object> param = new ArrayList();
			
			param.add(rank);
			Map<String, Object> map = itemService.itemStorageUpdate(param);
			
			int suc = Integer.parseInt(map.get("UP_SUC").toString());
			int ran = new Random().nextInt(100) + 1;
			
			int s = ScanUtil.nextInt("강화하시겠습니까?");
			printLn(1);
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
					}
				System.out.println("현재 " + rank + "강 입니다.");
				printLn(1);
				itemUpgradePrint();
				break;
			case 2:
				return View.INVENTORY;
			default:
				return View.ITEM_UPGRADE;
			}
		}
	}	
	
	private View inventory() {
		List<Object> param = new ArrayList();
		int no = inventoryNum();
		param.add(no);
		List<ItemSpaceVo> inventory = itemService.itemList(param);
		
		printList(inventory);
		
		System.out.println("1. 아이템 선택");
		System.out.println("2. 나가기");
		printLn(2);
		
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
		case 5:
			return View.MINIGAME;
		case 6:
			return View.LOGIN_PAGE;
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
			return View.A_SUGGESTION;
		case 3:
			return View.MODIFY;
		case 4:
			return View.BLACKLIST;
		case 5:
			return View.LOGIN_PAGE;
		default:
			return View.ADMIN;
		}
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
			case 2:
				return View.SIGNUP;
			default:
				return View.MEMBER_LOGIN;
			}
		}
			MemberVo mem = (MemberVo) sessionStorage.get("MEMBER");
			printLn(1);
			System.out.println("    " + mem.getMem_name() + "님 환영합니다.");
			printLn(1);
			printStory();
			return View.MEMBER;
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
			int select = ScanUtil.nextInt("메뉴 선택 >>");
			switch (select) {
			case 1:
				return View.ADMIN_LOGIN;
			default:
				return View.ADMIN_LOGIN;
			}
		}
		AdminVo admin = (AdminVo) sessionStorage.get("ADMIN");
		printLn(1);
		System.out.println("    " + admin.getAd_name() + "님 환영합니다.");
		printLn(1);
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
		case 3:	
			return View.SIGNUP;
		default:
			return View.LOGIN_PAGE;
		}
	}

}
