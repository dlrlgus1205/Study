package print;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import vo.ItemDetailspaceVo;
import vo.ItemListVo;
import vo.ItemSpaceVo;
import vo.MemberVo;
import vo.NoticeVo;
import vo.SugVo;


public class Print {
	
	public void printVar() {
		System.out.println("------------------------------------------------------------");
	}
	
	public void printVar(String s) {
		System.out.println("---------------"+s+"---------------");
	}
	
	public void printLn(int n) {
		for(int i=0; i<n; i++)
			System.out.println();
	}
	
	public void itemUpgradePrint() {
		System.out.println("1. 강화하겠습니다.");
		System.out.println("2. 강화하지 않겠습니다.");
	}
	
	public void printLogin() {
		printVar();
		System.out.println("1. 관리자 로그인");
		System.out.println("2. 회원 로그인");
		printLn(5);
		printVar();
	}
	
	public void printMemberCommunity() {
		printVar("커뮤니티");
		System.out.println("1. 공지사항");
		System.out.println("2. 건의사항");
		System.out.println("3. 돌아가기");
	}
	
	public void printMember() {
		System.out.println("1. 인벤토리");
		System.out.println("2. 아이템 상점");
		System.out.println("3. 캐시 상점");
		System.out.println("4. 커뮤니티");
	}
	
	public void printSuggestion() {
		printVar("건의사항");
		System.out.println("1.건의사항 전체 리스트보기");
		System.out.println("2.건의사항 작성");
		System.out.println("3.건의사항 수정");
		System.out.println("4.건의사항 삭제");
		System.out.println("5.뒤로 가기");
	}
	
	public void printNoticeAllList(List<NoticeVo> not) {
		System.out.println("글번호\t제목\t내용\t작성일자\t조회수");
		for (NoticeVo noticeVo : not) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
			String date_Str = sdf.format(noticeVo.getNtc_date());
			System.out.println(noticeVo.getNtc_no() + "\t" + noticeVo.getNtc_title() + "\t" + noticeVo.getNtc_con() + "\t" + date_Str + "\t" + noticeVo.getNtc_view());
		}
	}
	
	public void printAdmin() {
		System.out.println("1. 공지사항");
		System.out.println("2. 건의사항");
		System.out.println("3. 상점 수정");
		System.out.println("4. 블랙리스트 추가");
	}
	
	public void printAdminNotice() {
		System.out.println("1. 공지사항 리스트 보기");
		System.out.println("2. 공지사항 추가");
		System.out.println("3. 공지사항 수정");
		System.out.println("4. 공지사항 삭제");
		System.out.println("5. 돌아가기");
	}
	
	public void printBlackList(List<MemberVo> mem) {
		System.out.println("번호\t아이디\t이름\t닉네임");
		for (MemberVo memberVo : mem) {
			System.out.println(memberVo.getMem_no() + "\t" + memberVo.getMem_id() + "\t" + memberVo.getMem_name() + "\t" + memberVo.getMem_nname());
		}
	}
	
	public void printsugAllList(List<SugVo> sugList) {
		System.out.println("글번호\t제목\t내용\t작성자\t작성일자\t조회수");
		for (SugVo sugVo : sugList) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
			String date_Str = sdf.format(sugVo.getSug_date());
			System.out.println(sugVo.getSug_no() + "\t" + sugVo.getSug_title() + "\t" + sugVo.getSug_con() + "\t" + sugVo.getMem_id() + "\t" + date_Str + "\t" + sugVo.getSug_view());
		}
	}
	
	public void printsuggestionList() {
		System.out.println("1.건의사항 제목 검색");
		System.out.println("2.건의사항 내용 검색");
		System.out.println("3.건의사항 작성자 검색");
		System.out.println("4.뒤로가기");
	}
	
	public void printList(List<ItemSpaceVo> inventory) {
		System.out.println("아이템\t고유번호\t강화수치");
		for (ItemSpaceVo itemSpaceVo : inventory) {
			System.out.println(itemSpaceVo.getSp_no()+"\t" + itemSpaceVo.getItm_no() + "\t" + itemSpaceVo.getUp_no());
		}
	}
	
	public void printAllList(List<ItemListVo> param) {
		System.out.println("번호\t이름\t내용\t등급\t타입\t가격");
		for (ItemListVo itemListVo : param) {
			System.out.println(itemListVo.getItm_no() + "\t" + itemListVo.getItm_name() + "\t" + itemListVo.getItm_con() + "\t" + itemListVo.getItm_cls() + "\t" + itemListVo.getItm_type() + "\t" + itemListVo.getItm_price());
		}
	}
	
	public void printItemDetail(ItemDetailspaceVo it) {
		System.out.println("고유번호\t이름\t내용\t등급\t타입\t강화수치");
		
			System.out.println(it.getItm_no() + "\t" + it.getItm_name() + "\t" + it.getItm_con() + "\t" + it.getItm_cls() + "\t" + it.getItm_type() + "\t" + it.getUp_no());
		
	}
	
	public void printItemSelect() {
		System.out.println("1. 아이템 강화");
		System.out.println("2. 아이템 판매");
		System.out.println("3. 아이템 버리기");
		System.out.println("4. 돌아가기");
	}
	
	public void printItemStore() {
		printVar("아이템 상점");
		System.out.println("1. 아이템 검색");
		System.out.println("2. 아이템 구매");
		System.out.println("3. 아이템 판매");
		System.out.println("4. 상점 나가기");
	}

	public void printItemSearch() {
		printVar();
		System.out.println("1. 아이템 이름 검색");
		System.out.println("2. 아이템 등급 검색");
		System.out.println("3. 아이템 타입  선택");
		System.out.println("4. 뒤로 가기");
	}
	
	public void printCashStore() {
		printVar("캐시 아이템 상점");
		System.out.println("1. 결제하기");
		System.out.println("2. 환전하기");
		System.out.println("3. 상점 나가기");
	}
	
	public void printCashChange() {
		printVar("환전");
		System.out.println("이곳에서는 충전하신 캐시를 게임머니로 교환할 수 있습니다");
		System.out.println("빠르게 강해지고 싶다면 뒤로 돌아가서 더 충전하고 돌아오세요ㅋ");
		System.out.println("1.뒤로가기");
		System.out.println("응 ~안눌려 환전부터 일단 하자~");
	}
	
	public void printCashPurchase() {
		printVar("결제");
		System.out.println("지나친 현질은 인생에 크나큰 오예입니다");
		System.out.println("어서오십쇼 호갱님^_^");
	}
	
	public void printSaleSelect() {
		System.out.println("어디로 가시겠습니까?");
		System.out.println("1. 인벤토리");
		System.out.println("2. 아이템 상점");
	}
	
	public void printStory() {
		
	}
}
