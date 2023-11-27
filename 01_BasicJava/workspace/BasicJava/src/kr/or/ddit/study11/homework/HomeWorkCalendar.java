package kr.or.ddit.study11.homework;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class HomeWorkCalendar {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		HomeWorkCalendar obj = new HomeWorkCalendar();
		obj.process();
	}

	private void process() {
		Calendar cal = Calendar.getInstance();
		/*
		 * 년 월을 스캐너를 통해 입력 받고 달력을 출력해 볼 것
		 * 다음달, 이전달.
		 */
		System.out.println("연도 입력");
		int y = sc.nextInt();
		System.out.println("월 입력");
		int m = sc.nextInt();
		
		int dayOfmonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		cal.set(Calendar.YEAR, y);
		cal.set(Calendar.MONTH, m);
		cal.set(y, m - 1, 1);
	
		int s = cal.get(Calendar.DAY_OF_WEEK);
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

		while(true) {
			System.out.println("[<, >, =]");
			String str = sc.next();
			
			if(str.equals("<")) {
				cal.add(Calendar.MONTH, -1);
				m--;
				if(m < 1) {
					y--;
					m = 12;
				}
				s = cal.get(Calendar.DAY_OF_WEEK);
				dayOfmonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
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
			}
			
			else if(str.equals(">")) {
				cal.add(Calendar.MONTH, 1);
				m++;
				if(m > 12) {
					y++;
					m = 1;
				}
				s = cal.get(Calendar.DAY_OF_WEEK);
				dayOfmonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
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
			}
			
			else if(str.equals("=")) {
				break;
			}
		}
	}
}
