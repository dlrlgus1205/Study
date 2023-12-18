package print;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import service.ItemService;
import vo.ItemDetailspaceVo;
import vo.ItemListVo;
import vo.ItemSpaceVo;
import vo.MemberVo;
import vo.NoticeVo;
import vo.SugVo;


public class Print {
	ItemService itemService = ItemService.getInstance();

	public void printBar(int n) {
		for(int i = 0; i < n; i++) {
			System.out.print("─");
		}
	}
	
	public void printUpBox(int n) {
		System.out.print("┌");
		for(int i = 0; i < n; i++) {
			System.out.print("─");
		}
		System.out.println("┐");
	}
	public void printDownBox(int n) {
		System.out.print("└");
		for(int i = 0; i < n; i++) {
			System.out.print("─");
		}
		System.out.print("┘");
	}
	
	public void printDoubleBar(int n) {
		for(int i = 0; i < n; i++) {
			System.out.print("═");
		}
	}
	public void printDoubleUpBox(int n) {
		System.out.print("╔");
		for(int i = 0; i < n; i++) {
			System.out.print("═");
		}
		System.out.println("╗");
	}
	
	public void printDoubleDownBox(int n) {
		System.out.print("╚");
		for(int i = 0; i < n; i++) {
			System.out.print("═");
		}
		System.out.println("╝");
	}
	
	public void printVar() {
		System.out.println("--------------------------------------------------");
	}
	
	public void printVar(String s) {
		System.out.println("------------------"+s+"------------------");
	}
	
	public void printLn(int n) {
		for(int i=0; i<n; i++)
			System.out.println();
	}
	
	public void itemUpgradePrint() {
		printDoubleUpBox(31);
		System.out.println("║	1. 강화하겠습니다.		║");
		System.out.println("║	2. 강화하지 않겠습니다.	║");
		printDoubleDownBox(31);
		printLn(1);
	}
	
	public void printLogin() {
		printUpBox(39);
		System.out.println("│		1. 관리자 로그인		│");
		System.out.println("│		2. 회원 로그인		│");
		System.out.println("│		3. 회원가입		│");
		printDownBox(39);
		printLn(2);
	}
	
	public void printMemberCommunity() {
		System.out.println("\t\t커뮤니티");
		printUpBox(39);
		System.out.println("│		1. 공지사항		│");
		System.out.println("│		2. 건의사항		│");
		System.out.println("│		3. 돌아가기		│");
		printDownBox(39);
		printLn(2);
	}
	
	public void printMember() {
		printUpBox(39);
		System.out.println("│		1. 인벤토리		│");
		System.out.println("│		2. 아이템 상점		│");
		System.out.println("│		3. 캐시 상점		│");
		System.out.println("│		4. 커뮤니티		│");
		System.out.println("│		5. 미니 게임		│");
		System.out.println("│		6. 로그 아웃		│");
		printDownBox(39);
		printLn(2);
	}
	
	public void printMemberSuggestion() {
		System.out.println("\t\t건의사항");
		printUpBox(39);
		System.out.println("│		1. 건의사항 리스트 보기	│");
		System.out.println("│		2. 건의사항 작성		│");
		System.out.println("│		3. 건의사항 수정		│");
		System.out.println("│		4. 건의사항 삭제		│");
		System.out.println("│		5. 뒤로 가기		│");
		printDownBox(39);
		printLn(2);
	}
	
	public void printAdminSuggestion() {
		System.out.println("\t\t건의사항");
		printUpBox(39);
		System.out.println("│		1. 건의사항 리스트 보기	│");
		System.out.println("│		2. 건의사항 삭제		│");
		System.out.println("│		3. 뒤로 가기		│");
		printDownBox(39);
		printLn(2);
	}
	
	public void printAdItemAllList(List<ItemListVo> item) {
		printLn(2);
		System.out.println("고유번호\t\t아이템 이름\t\t아이템 내용\t\t아이템 등급\t\t아이템 타입\t\t아이템 가격");
		printDoubleBar(88);
		printLn(1);
		
		String name;
		String con;
		
		for (ItemListVo itemListVo : item) {
			if(itemListVo.getItm_name().length() >= 5) {
				name =  itemListVo.getItm_name().substring(0, 5);
			}
			else name =  itemListVo.getItm_name();
			
			if(itemListVo.getItm_con().length() >= 5) {
				con = itemListVo.getItm_con().substring(0, 5);
			}
			else con = itemListVo.getItm_con();
			System.out.println(itemListVo.getItm_no() + "\t\t" + name + "\t\t" + con + "\t\t" + itemListVo.getItm_cls() + "\t\t" + itemListVo.getItm_type() + "\t\t" + itemListVo.getItm_price());
		}
		printDoubleBar(88);
		printLn(2);
	}
	
	public void printAdSelectItem(int select) {
		List<Object> selit = new ArrayList();
		selit.add(select);
		ItemListVo itemList = itemService.itemSelectList(selit);
		System.out.println(itemList.getItm_no()+"\t"+ itemList.getItm_name()+"\t"+
						   itemList.getItm_con()+"\t"+ itemList.getItm_cls()+"\t"+
						   itemList.getItm_type()+"\t"+ itemList.getItm_price());
	}
	
	public void printNoticeAllList(List<NoticeVo> not) {
		System.out.println("\t\t공지사항 목록");
		printLn(1);
		System.out.println("글번호\t제목\t내용\t작성일자\t\t조회수");
		String cont;
		String title;
		
		for (NoticeVo noticeVo : not) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
			String date_Str = sdf.format(noticeVo.getNtc_date());
			
			if(noticeVo.getNtc_title().length() >= 4) {
				title =  noticeVo.getNtc_title().substring(0, 4);
			}
			else title =  noticeVo.getNtc_title();
			
			if(noticeVo.getNtc_con().length() >= 4) {
				cont = noticeVo.getNtc_con().substring(0, 4);
			}
			else cont = noticeVo.getNtc_con();
			
			System.out.println(noticeVo.getNtc_no() + "\t" + title + "\t" + cont + "\t" + date_Str + "\t" + noticeVo.getNtc_view());
		}
		printLn(3);
	}
	
	public void printAdmin() {
		printUpBox(39);
		System.out.println("│		1. 공지사항		│");
		System.out.println("│		2. 건의사항		│");
		System.out.println("│		3. 상점 수정		│");
		System.out.println("│		4. 블랙리스트 추가		│");
		System.out.println("│		5. 로그아웃		│");
		printDownBox(39);
		printLn(2);
	}
	
	public void printAdminNotice() {
		System.out.println("\t\t공지사항");
		printUpBox(39);
		System.out.println("│		1. 공지사항 리스트 보기	│");
		System.out.println("│		2. 공지사항 추가		│");
		System.out.println("│		3. 공지사항 수정		│");
		System.out.println("│		4. 공지사항 삭제		│");
		System.out.println("│		5. 돌아가기		│");
		printDownBox(39);
		printLn(2);
	}
	
	public void printAdminModify() {
		System.out.println("\t\t메뉴 수정");
		printUpBox(39);
		System.out.println("│		1. 아이템 메뉴 수정		│");
		System.out.println("│		2. 강화 수치 수정		│");
		System.out.println("│		3. 뒤로가기		│");
		printDownBox(39);
		printLn(2);
	}
	
	public void printItemMenuUpdate() {
		System.out.println("\t\t아이템 메뉴 수정");
		printUpBox(39);
		System.out.println("│		1. 전체 아이템 보기		│");
		System.out.println("│		2. 신규 아이템 추가		│");
		System.out.println("│		3. 기존 아이템 수정		│");
		System.out.println("│		4. 뒤로가기		│");
		printDownBox(39);
		printLn(2);
	}
	
	public void printBlackList() {
		printLn(2);
		System.out.println("\t\t블랙리스트 추가");
		printLn(2);
	}
	
	public void printBlackListMember(List<MemberVo> mem) {
		printBar(44);
		printLn(1);
		System.out.println("\t번호\t아이디\t이름\t닉네임");
		
		String id;
		String nname;
		
		for (MemberVo memberVo : mem) {
			if(memberVo.getMem_id().length() >= 4) {
				id =  memberVo.getMem_id().substring(0, 4);
			}
			else id =  memberVo.getMem_id();
			
			if(memberVo.getMem_nname().length() >= 4) {
				nname = memberVo.getMem_nname().substring(0, 4);
			}
			else nname = memberVo.getMem_nname();
		
			System.out.println("\t" + memberVo.getMem_no() + "\t" +id + "\t" + memberVo.getMem_name() + "\t" + nname);
		}
		printBar(44);
		printLn(2);
	}
	
	public void printsugAllList(List<SugVo> sugList) {
		System.out.println("\t\t건의사항 목록");
		printLn(1);
		System.out.println("글번호\t제목\t내용\t작성자\t작성일자\t\t조회수");
		
		String title;
		String cont;
		
		for (SugVo sugVo : sugList) {
			if(sugVo.getSug_title().length() >= 4) {
				title =  sugVo.getSug_title().substring(0, 4);
			}
			else title =  sugVo.getSug_title();
			
			if(sugVo.getSug_con().length() >= 4) {
				cont = sugVo.getSug_con().substring(0, 4);
			}
			else cont = sugVo.getSug_con();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
			String date_Str = sdf.format(sugVo.getSug_date());
			System.out.println(sugVo.getSug_no() + "\t" + title + "\t" + cont + "\t" + sugVo.getMem_id() + "\t" + date_Str + "\t" + sugVo.getSug_view());
		}
	}
	
	public void printsugMyList(List<SugVo> sugList) {
		System.out.println("\t\t내가 쓴 건의사항 목록");
		printLn(1);
		System.out.println("글번호\t제목\t내용\t작성자\t작성일자\t\t조회수");
		
		String title;
		String cont;
		
		for (SugVo sugVo : sugList) {
			if(sugVo.getSug_title().length() >= 4) {
				title =  sugVo.getSug_title().substring(0, 4);
			}
			else title =  sugVo.getSug_title();
			
			if(sugVo.getSug_con().length() >= 4) {
				cont = sugVo.getSug_con().substring(0, 4);
			}
			else cont = sugVo.getSug_con();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
			String date_Str = sdf.format(sugVo.getSug_date());
			System.out.println(sugVo.getSug_no() + "\t" + title + "\t" + cont + "\t" + sugVo.getMem_id() + "\t" + date_Str + "\t" + sugVo.getSug_view());
		}
	}
	
	public void printsuggestionList() {
		printLn(2);
		printUpBox(39);
		System.out.println("│		1. 건의사항 제목 검색		│");
		System.out.println("│		2. 건의사항 내용 검색		│");
		System.out.println("│		3. 건의사항 작성자 검색	│");
		System.out.println("│		4. 뒤로가기		│");
		printDownBox(39);
		printLn(2);
	}
	
	public void printList(List<ItemSpaceVo> inventory) {
		printLn(2);
		System.out.println("\t\t\t인벤토리");
		printUpBox(47);
		System.out.println("│		아이템\t고유번호\t강화수치		│");
		for (ItemSpaceVo itemSpaceVo : inventory) {
			System.out.println("│		" + itemSpaceVo.getSp_no() + "\t" + itemSpaceVo.getItm_no() + "\t" + itemSpaceVo.getUp_no() + "		│");
		}
		printDownBox(47);
		printLn(2);
	}
	
	public void printadminItemUpdate() {
		System.out.println("\t\t 기존 아이템 수정하기");
		printUpBox(55);
		System.out.println("│		1. 기존아이템 이름 변경하기			│");
		System.out.println("│		2. 기존아이템 내용 변경하기			│");
		System.out.println("│		3. 기존아이템 등급 변경하기			│");
		System.out.println("│		4. 기존아이템 타입 변경하기			│");
		System.out.println("│		5. 기존아이템 가격 변경하기			│");
		System.out.println("│		6. 기존아이템 상점 등급 변경하기			│");
		System.out.println("│		7. 뒤로 가기				│");
		printDownBox(55);
		printLn(2);
	}
	
	public void printAllList(List<ItemListVo> itemList) {
		System.out.println("고유번호\t\t아이템 이름\t\t아이템 내용\t\t아이템 등급\t\t아이템 타입\t\t아이템 가격");
		printDoubleBar(88);
		printLn(1);
		
		String name;
		String con;
		
		for (ItemListVo itemListVo : itemList) {
			if(itemListVo.getItm_name().length() >= 5) {
				name =  itemListVo.getItm_name().substring(0, 5);
			}
			else name =  itemListVo.getItm_name();
			
			if(itemListVo.getItm_con().length() >= 5) {
				con = itemListVo.getItm_con().substring(0, 5);
			}
			else con = itemListVo.getItm_con();
			System.out.println(itemListVo.getItm_no() + "\t\t" + name + "\t\t" + con + "\t\t" + itemListVo.getItm_cls() + "\t\t" + itemListVo.getItm_type() + "\t\t" + itemListVo.getItm_price());
		}
		printDoubleBar(88);
		printLn(1);
	}
	
	public void printItemDetail(ItemDetailspaceVo it) {
		printLn(2);
		System.out.println("\t\t\t선택된 아이템");
		printUpBox(63);
		
		String name;
		String con;
		
		if(it.getItm_name().length() >= 5) {
			name = it.getItm_name().substring(0, 5);
		}
		else name = it.getItm_name();
		
		if( it.getItm_con().length() >= 5) {
			con =  it.getItm_con().substring(0, 5);
		}
		else con =  it.getItm_con();
			
		System.out.println("│	번호\t이름\t내용\t등급\t타입\t강화수치		│");
		System.out.println("│	" + it.getItm_no() + "\t" + name + "\t" + con + "\t" + it.getItm_cls() + "\t" + it.getItm_type() + "\t" + it.getUp_no() + "		│");
		printDownBox(63);
		printLn(2);
	}
	
	public void printItemSelect() {
		printUpBox(39);
		System.out.println("│		1. 아이템 강화		│");
		System.out.println("│		2. 아이템 판매		│");
		System.out.println("│		3. 아이템 버리기		│");
		System.out.println("│		4. 돌아가기		│");
		printDownBox(39);
		printLn(2);
	}
	
	public void printItemStore() {
		System.out.println("\t\t아이템 상점");
		printUpBox(39);
		System.out.println("│		1. 아이템 검색		│");
		System.out.println("│		2. 아이템 구매		│");
		System.out.println("│		3. 아이템 판매		│");
		System.out.println("│		4. 상점 업그레이드		│");
		System.out.println("│		5. 상점 나가기		│");
		printDownBox(39);
		printLn(2);
	}

	public void printItemSearch() {
		printLn(2);
		printDoubleUpBox(39);
		System.out.println("║		1. 이름 검색		║");
		System.out.println("║		2. 등급 검색		║");
		System.out.println("║		3. 타입 검색		║");
		System.out.println("║		4. 뒤로 가기		║");
		printDoubleDownBox(39);
		printLn(2);
	}
	
	public void printItemStoreUpgrade() {
		System.out.println("\t\t\t상점 업그레이드");
		printDoubleUpBox(63);
		System.out.println("║		게임머니를 모아 다음 등급의 아이템 상점을 오픈해보세요		║");
		System.out.println("║			1.레어 상점 업그레이드			║");
		System.out.println("║			2.유니크 상점 업그레이드			║");
		System.out.println("║			3.영웅 상점 업그레이드			║");
		System.out.println("║			4.전설 상점 업그레이드			║");
		System.out.println("║			5.신화 상점 업그레이드			║");
		System.out.println("║			6.뒤로 가기				║");
		printDoubleDownBox(63);
		printLn(2);
	}
	
	public void printCashStore() {
		System.out.println("\t\t캐시 아이템 상점");
		printUpBox(39);
		System.out.println("│		1. 결제하기		│");
		System.out.println("│		2. 환전하기		│");
		System.out.println("│		3. 상점 나가기		│");
		printDownBox(39);
		printLn(2);
	}
	
	public void printCashChange() {
		printLn(2);
		System.out.println("\t\t┌───────────────┐");
		System.out.println("\t\t│	환전	│");
		System.out.println("\t\t└───────────────┘");
		printLn(2);
		System.out.println("이곳에서는 충전하신 캐시를 게임머니로 교환할 수 있습니다");
		System.out.println("빠르게 강해지고 싶다면 뒤로 돌아가서 더 충전하고 돌아오세요ㅋ");
		System.out.println("1.뒤로가기");
		System.out.println("응 ~안눌려 환전부터 일단 하자~");
		printLn(1);
	}
	
	public void printCashPurchase() {
		printLn(2);
		System.out.println("\t\t┌───────────────┐");
		System.out.println("\t\t│	결제	│");
		System.out.println("\t\t└───────────────┘");
		printLn(2);
		System.out.println("지나친 현질은 인생에 크나큰 오예입니다");
		System.out.println("어서오십쇼 호갱님^_^");
		printLn(1);
	}
	
	public void printSaleSelect() {
		System.out.println("어디로 가시겠습니까?");
		System.out.println("1. 인벤토리");
		System.out.println("2. 아이템 상점");
	}
	
	public void printStory() {
		
	}
}
