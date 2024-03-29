package kr.or.ddit.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVo;

public class MyMemberController {
	private Scanner sc;
	private IMemberService service;
	private MemberVo memVo;
	public MyMemberController() {
		sc = new Scanner(System.in);
		service = MemberServiceImpl.getInstance();
	}
	
	public static void main(String[] args) {
		new MyMemberController().startMember();
	}
	
	private void startMember() {
		while(true) {
			int s = displayMenu();
			switch(s) {
				case 1 :
					insertMember();
					break;
				case 2 :
					deleteMember();
					break;
				case 3 :
					updateMember();
					break;
				case 4 :
					displayAllMember();
					break;
				case 5 :
					updateMember2();
					break;
				case 0 :
					System.out.println("!!! 작업 끝 !!!");
					return;
				default : 
					System.out.println("다시 입력하세요");
			}
		}
	}
	
	private void updateMember2() {
		System.out.println("======================");
		System.out.println("수정할 회원의 정보를 입력하세요");
		System.out.println("======================");
		System.out.print("ID >> ");
		String memId = sc.next();
		
		int chk = service.getMemberCount(memId);
		if(chk == 0) {
			System.out.println("없는 ID 입니다");
			return;
		}
		
		int u;
		String uf = null;
		String ut = null;
		do {
			System.out.println("======================");
			System.out.println("1.PASS");
			System.out.println("2.NAME");
			System.out.println("3.TEL");
			System.out.println("4.ADDR");
			System.out.println("======================");
			System.out.print("선택 >> ");
			u = sc.nextInt();
			
			switch (u) {
			case 1:
				uf = "mem_pass";
				ut = "비밀번호";
				break;
			case 2:
				uf = "mem_name";
				ut = "회원이름";
				break;
			case 3:
				uf = "mem_tel";
				ut = "전화번호";
				break;
			case 4:
				uf = "mem_addr";
				ut = "회원주소";
				break;
			default:
				System.out.println("다시 입력하세요");
			}
		}
		while(u < 1 || u > 4);
		sc.nextLine();
		System.out.println();
		System.out.print("새로운 " + ut + " >> ");
		String updateData = sc.nextLine();
		
		Map<String, String> pMap = new HashMap<String, String>();
		pMap.put("memberID", memId);
		pMap.put("fieldName", uf);
		pMap.put("data", updateData);
		
		int cnt = service.updateMember2(pMap);
		
		if(cnt > 0) {
			System.out.println(">> 수정 완료 <<");
		}else {
			System.out.println(">> 수정 실패 <<");
		}
			
	}

	private void displayAllMember() {
		System.out.println("=====================================");
		System.out.println("ID      PASS    NAME    TEL     ADDR");
		System.out.println("=====================================");
		
		List<MemberVo> memList = service.getAllMember();
		
		if(memList == null || memList.size() == 0) {
			System.out.println("등록된 회원이 없습니다");
		}
		else {
			for(MemberVo memVo : memList) {
				String id = memVo.getMem_id();
				String pass = memVo.getMem_pass();
				String name = memVo.getMem_name();
				String tel = memVo.getMem_tel();
				String addr = memVo.getMem_addr();
				System.out.println(id + "\t" + pass + "\t" + name + "\t" + tel + "\t" + addr);
			}
		}
	}

	private void updateMember() {
		System.out.println("======================");
		System.out.println("수정할 회원의 정보를 입력하세요");
		System.out.println("======================");
		System.out.print("ID >> ");
		String memId = sc.next();
		
		int chk = service.getMemberCount(memId);
		if(chk == 0) {
			System.out.println("없는 ID 입니다");
			return;
		}
		
		System.out.println("수정할 정보를 입력하세요");
		System.out.print("PASS >> ");
		String memPass = sc.next();
		
		System.out.print("NAME >> ");
		String memName = sc.next();
		
		System.out.print("TEL >> ");
		String memTel = sc.next();
		
		sc.nextLine(); // 입력 버퍼 비우기
		System.out.print("ADDR >> ");
		String memAddr = sc.nextLine();
		
		memVo = new MemberVo();
		memVo.setMem_id(memId);
		memVo.setMem_pass(memPass);
		memVo.setMem_name(memName);
		memVo.setMem_tel(memTel);
		memVo.setMem_addr(memAddr);
		
		int cnt = service.updateMember(memVo);
		if(cnt > 0) {
			System.out.println(">> 수정 완료 <<");
		}
		else {
			System.out.println(">> 수정 실패 <<");
		}
	}

	private void deleteMember() {
		System.out.println("======================");
		System.out.println("삭제할 회원의 정보를 입력하세요");
		System.out.println("======================");
		System.out.print("ID >> ");
		String memId = sc.next();
		
		int cnt = service.deleteMember(memId);
		if(cnt > 0) {
			System.out.println(">> 삭제 성공 <<");
		}
		else {
			System.out.println(">> 삭제 실패 <<");
		}
		
	}

	private void insertMember() {
		System.out.println("======================");
		System.out.println("추가할 회원의 정보를 입력하세요");
		System.out.println("======================");
		
		int chk = 0;
		String memId = null;
		do {
			System.out.print("ID >> ");
			memId = sc.next();
			
			chk = service.getMemberCount(memId);
			if(chk > 0) {
				System.out.println("사용중인 ID 입니다");
			}
		}
		while(chk > 0);
		
		System.out.print("PASS >> ");
		String memPass = sc.next();
		
		System.out.print("NAME >> ");
		String memName = sc.next();
		
		System.out.print("TEL >> ");
		String memTel = sc.next();
		
		sc.nextLine(); // 입력 버퍼 비우기
		System.out.print("ADDR >> ");
		String memAddr = sc.nextLine();
		
		memVo = new MemberVo();
		memVo.setMem_id(memId);
		memVo.setMem_pass(memPass);
		memVo.setMem_name(memName);
		memVo.setMem_tel(memTel);
		memVo.setMem_addr(memAddr);
		
		int cnt = service.insertMember(memVo);
		if(cnt > 0) {
			System.out.println(">> 추가 완료 <<");
		}
		else {
			System.out.println(">> 추가 실패 <<");
		}
	}
	
	private int displayMenu() {
		System.out.println("======================");
		System.out.println(" 1. 자료 추가");
		System.out.println(" 2. 자료 삭제");
		System.out.println(" 3. 전체 자료 수정");
		System.out.println(" 4. 전체 자료 출력");
		System.out.println(" 5. 자료 항목 수정");
		System.out.println(" 0. 작업 종료");
		System.out.println("======================");
		System.out.print("작업 번호 >> ");
		int s = sc.nextInt();
		return s;
	}
}
