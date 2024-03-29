package kr.or.ddit.mvc.controller;

import java.util.List;
import java.util.Scanner;

import kr.or.ddit.mvc.service.IMemberService;
import kr.or.ddit.mvc.service.MemberServiceImpl;
import kr.or.ddit.mvc.vo.MemberVo;

public class MemberController {
	//Service객체의 참조값이 저장될 변수 선언
	private IMemberService service;
	private Scanner scan;
	//생성자
	public MemberController() {
		// Service객체 생성
		service = MemberServiceImpl.getInstance();
		scan = new Scanner(System.in);
	}
	public static void main(String[] args) {
		new MemberController().startMember();
	}
	
	// 시작 메서드
	private void startMember() {
		while(true) {
			int choice = displayMenu();
			
			switch (choice) {
			case 1:		// 추가
				insertMember();
				break;
			case 2:		// 삭제
				deleteMember();
				break;
			case 3:		// 수정
				updateMember();
				break;
			case 4:		// 전체 출력
				displayAllMember();
				break;
			case 5:
				//update2Member();
				break;
			case 0:
				System.out.println("작업을 마칩니다...");
				return;
			default:
				System.out.println("작업 번호를 잘못 입력했습니다...");
				System.out.println("다시 입력하세요...");
			}
		}
	}
	// 전체 회원 출력
	private void displayAllMember() {
		List<MemberVo> memList = null;
		System.out.println();
		System.out.println("---------------------------------------------------------------");
		System.out.println("회원ID	비밀번호	회원이름	전화번호	회원주소");
		System.out.println("---------------------------------------------------------------");
		memList = service.getAllMember();

		for (MemberVo memberVo : memList) {
		System.out.println(memberVo.getMem_id()+"\t"+memberVo.getMem_pass()+"\t"
							+memberVo.getMem_name()+"\t"+memberVo.getMem_tel()
							+"\t"+memberVo.getMem_addr());
		}
	}
	// update
	private void updateMember() {
		
		System.out.println();
		System.out.println("수정할 회원 정보를 입력하세요...");
		System.out.println("회원ID>>");
		String memId = scan.next();
		
		int count = service.getMemberCount(memId);
		
		if(count==0) {
			System.out.println(memId+"는(은) 없는 회원입니다.");
			System.out.println("수정작업을 종료합니다...");
			return;
		}
		
		System.out.println("수정할 내용을 입력하세요...");
		System.out.println("새로운 비밀번호>>");
		String newMemPass = scan.next();
		System.out.println("새로운 이름>>");
		String newMemName = scan.next();
		System.out.println("새로운 전화번호>>");
		String newMemTel = scan.next();
		
		scan.nextLine();
		System.out.println("새로운 주소>>");
		String newMemAddr = scan.nextLine();
		
		MemberVo memVo = new MemberVo();
		memVo.setMem_id(memId);
		memVo.setMem_pass(newMemPass);
		memVo.setMem_name(newMemName);
		memVo.setMem_tel(newMemTel);
		memVo.setMem_addr(newMemAddr);
		
		int cnt = service.updateMember(memVo);
		if(cnt>0) {
			System.out.println("update 작업 성공!!");
		}else {
			System.out.println("update 작업 실패!!");
		}
	}
	// delete
	private void deleteMember() {
		System.out.println();
		System.out.println("삭제할 회원 정보를 입력하세요..");
		String memId = scan.next();
		
		int cnt = service.deleteMember(memId);
		if(cnt>0) {
			System.out.println("delete 작업 성공!!!");
		}else {
			System.out.println("delete 작업 실패!!!");
		}
	}
	// insert
	private void insertMember() {
	
		System.out.println();
		System.out.println("추가할 회원 정보를 입력하세요...");
		
		int count = 0;
		String memId = null; 	// 회원ID가 저장될 변수
		
		do {
			System.out.println("회원ID 입력 >>");
			
			memId = scan.next();
			
			count = service.getMemberCount(memId);
			
			if(count>0) {
				System.out.println(memId+"는 이미 등록되어 있는 회원입니다.");
				System.out.println("다른 회원ID를 입력해주세요...");
			}
		}while(count>0);
		
		//------------------------------------------------
		
		System.out.println("비밀번호 입력>>");
		String memPass = scan.next();
		
		System.out.println("회원이름 입력 >>");
		String memName = scan.next();
		
		System.out.println("전화번호 입력>>");
		String memTel = scan.next();
		
		scan.nextLine(); // 입력 버퍼 비우기
		System.out.println("주소 입력>>");
		String memAddr = scan.nextLine();
		
		// 입력이 완료되면 입력한 자료들을 VO객체에 저장한다.
		MemberVo memVo = new MemberVo();
		memVo.setMem_id(memId);
		memVo.setMem_pass(memPass);
		memVo.setMem_name(memName);
		memVo.setMem_tel(memTel);
		memVo.setMem_addr(memAddr);
		
		// service의 insert메서드를 호출해서 처리한다.
		int cnt = service.insertMember(memVo);
		
		if(cnt>0) {
			System.out.println("insert 작업 성공 !!!");
		}else {
			System.out.println("insert 작업 실패 !!!");
		}
		
		
	}
	//메뉴를 출력하고 작업 번호를 입력 받아 반환하는 메서드
	private int displayMenu() {
		System.out.println();
		System.out.println("==회원 관리 메뉴==");
		System.out.println("1. 회원 자료 추가");
		System.out.println("2. 회원 자료 삭제");
		System.out.println("3. 회원 자료 수정");
		System.out.println("4. 회원 전체 자료 출력");
		System.out.println("5. 자료 수정2");		// ==> 원하는 항목만 수정하기
		System.out.println("0. 시스템 종료");
		System.out.println("작업 번호 >>");
			
		return scan.nextInt();
	}
}
