package kr.or.ddit.study11.homework;

import java.util.Calendar;
import java.util.Scanner;

public class HomeWorkCalendarAnswer {
	public static void main(String[] args) {
		HomeWorkCalendarAnswer hca = new HomeWorkCalendarAnswer();
		hca.process();
	}

	private void process() {
		Calendar cal = Calendar.getInstance();
		
		Scanner sc = new Scanner(System.in);
		int y = sc.nextInt();
		int m = sc.nextInt() - 1;
		
		cal.set(Calendar.YEAR, y);
		cal.set(Calendar.MONTH, m);
		while(true) {
			cal.set(Calendar.DATE, 1);
			int last_day = cal.getActualMaximum(Calendar.DATE);
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.println("<<작년\t\t<이전달\t\t" + cal.get(Calendar.YEAR) + "년" + "\t" + (cal.get(Calendar.MONTH) + 1) + "월\t\t 다음달>\t\t내년>>");
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.println("일\t월\t화\t수\t목\t금\t토");
			System.out.println("-------------------------------------------------------------------------------------");
			for(int i = 1; i < cal.get(Calendar.DAY_OF_WEEK); i++) {
				System.out.print("\t");
			}
			for(int i = 1; i <= last_day; i++) {
				System.out.print(cal.get(Calendar.DATE) + "\t");
				int day = cal.get(Calendar.DAY_OF_WEEK);
				if( day == 7) {
					System.out.println();
				}
				if(i != last_day) cal.add(Calendar.DATE, 1);
			}
			System.out.println();
			System.out.println("-------------------------------------------------------------------------------------");
			String s = sc.next();
			if(s.equals("<")) cal.add(Calendar.MONTH, -1);
			if(s.equals(">")) cal.add(Calendar.MONTH, 1);
			if(s.equals("<<")) cal.add(Calendar.YEAR, -1);
			if(s.equals(">>")) cal.add(Calendar.YEAR, 1);
		}
	}
}
