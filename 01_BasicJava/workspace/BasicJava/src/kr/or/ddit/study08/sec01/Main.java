package kr.or.ddit.study08.sec01;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("전화 상담의 분배 방식 선택");
		System.out.println("R : RoundRobin");
		System.out.println("L : LeastJob");
		System.out.println("P : PriorityAllocation");
		
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		Schedular schedular = null;
		
		if(s.equals("R")) {
			schedular = new RoundRobin();
		}
		if(s.equals("L")) {
			schedular = new LeastJob();
		}
		if(s.equals("P")) {
			schedular = new PriorityAllocation();
		}
		schedular.getNextCall();
		schedular.sendCallToAgent();
	}
}
