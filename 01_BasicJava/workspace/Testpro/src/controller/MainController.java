package controller;

import java.util.Scanner;

import util.View;

public class MainController {
	public static void main(String[] args) {
		
		// new MainController().start();
		MainController mc = new MainController();
		mc.start();
		
	}
	
	public void start() {
		View view = View.MAIN;
		
		while(true) {
			switch (view) {
			case MAIN:
				view = home();
				break;
			case FREE_LIST:
				view = freeList();
				break;
			case FREE_WRITE:
				break;
			case FREE_DETAIL:
				break;
			default:
				break;
			} //switch
		}//while
	}//start
	
	public View freeList() {
		
		return View.FREE_DETAIL;
	}
	
	public View home() {
		
		System.out.println("1. 자유게시판 전체 조회");
		System.out.println("2. 로그인");
		
		Scanner sc = new Scanner(System.in);
		int sel = sc.nextInt();
		
		return View.FREE_LIST;
	}
}
