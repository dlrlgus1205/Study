package kr.or.ddit.study03;

public class Free {
	public static void main(String[] args) {
		// 65430원을 만들기 위한 화폐 갯수
		
		int won = 65430;
		
		int man = (int)65430/10000;
		
		System.out.println("만원 몇 장? " + man);
		
		int chun = (int) man - (man % won);
		
		System.out.println("천원 몇 장 ? " + chun);
	}
}
