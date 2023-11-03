package kr.or.ddit.study02.homework;

import java.util.Date;

public class HomeWork1 {
	public static void main(String[] args) {
		Date date = new Date();
		long time = date.getTime() / 1000;
		/*
		 *  date 란 객체는 1970년 기준 시간으로 부터 지난 시간을 가져옵니다. 
		 *  오늘 날짜는 1970년 기준 시간을 기준으로 현재 
		 *  
		 *  몇년 몇월 몇일이... 몇초가 지났는지 출력해보세요. 
		 *  
		 */
		
		System.out.println(time);
		System.out.println(date);
		
		int min = 60;
		int hour = min * 60;
		int day = hour * 24;
		int year = day * 365;
		
		int years = (int)(time / year);
		System.out.println(years + "년");
		
		time = time - year * years;
		
		int days = (int)(time / day);
		System.out.println(days + "일");
		
		time = time - day * days;
		
		int hours = (int)(time / hour);
		System.out.println(hours + "시간");
		
		time = time - hour * hours;
		
		int mins = (int)(time / min);
		System.out.println(mins + "분");
		
		time = time - min * mins;
		
		int secs = (int)time;
		System.out.println(secs + "초");
		
	}
}
