package kr.or.ddit.study11.homework;

import java.util.Calendar;
import java.util.Scanner;

public class HomeWorkCalendar2 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		HomeWorkCalendar2 obj = new HomeWorkCalendar2();
		obj.process();
	}
	private void process() {
		Calendar cal = Calendar.getInstance();
		
		System.out.println("연도 입력");
		int y = sc.nextInt();
		System.out.println("월 입력");
		int m = sc.nextInt();
		
		while(true) {
			// 달력정보 세팅
			cal.set(Calendar.YEAR, y);
			cal.set(Calendar.MONTH, m);
			cal.set(y, m - 1, 1);
			
			int s = cal.get(Calendar.DAY_OF_WEEK);
			int dayOfmonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			
			// 달력 출력
			
			System.out.println("----------------------" + y + "년 " + m + "월----------------------");
			System.out.println("일\t월\t화\t수\t목\t금\t토");
			
			for(int i = 1; i < s; i++) {
				System.out.print("\t");
			}
			
			for(int i = 1; i <= dayOfmonth; i++) {
				System.out.print(i + "\t");
				if(s % 7 == 0) {
					System.out.println();
				}
				s++;
			}
			System.out.println();
			System.out.println("-----------------------------------------------------");
			
			// 커맨드 입력 
			System.out.println("[<, >, =]");
			String str = sc.next();
			
			// 커맨드 조건
			if(str.equals("<")) {
				cal.add(Calendar.MONTH, -1);
				m--;
			}
			
			else if(str.equals(">")) {
				cal.add(Calendar.MONTH, 1);
				m++;
			}
			
			else if(str.equals("=")) {
				break;
			}
		}
		
	}
}
