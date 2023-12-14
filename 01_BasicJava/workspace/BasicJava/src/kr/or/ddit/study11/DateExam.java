package kr.or.ddit.study11;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateExam {
	boolean debug = true;
	public static void main(String[] args) {
		DateExam de = new DateExam();
//		de.datemethod1();
//		de.datemethod2();
//		de.datemethod3();
		de.datemethod4();
//		de.datemethod5();
//		de.datemethod6();
	}

	private void datemethod6() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, 11);
		cal.add(Calendar.DATE, 2);
		
		int dayOfmonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // 해당 달의 마지막 일
		System.out.println(dayOfmonth);
		
		int day = cal.get(Calendar.DAY_OF_WEEK); // 1 = 일요일, 7 = 토요일
		System.out.println(day);
		
//		cal.add(Calendar.DATE, 1);
//		cal.add(Calendar.YEAR, 1);
//		cal.add(Calendar.HOUR, 1);
//		cal.add(Calendar.MINUTE, 30);
		
		Date date = cal.getTime();
		System.out.println(date);
	}

	private void datemethod5() {
		// 1주일 뒤에 날짜 구해보기
		// 2023.12.01
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd hh:mm");
		Date date = new Date();
		long time = date.getTime() + 86400 * 1000 * 7;
		
		Date add = new Date(time);
		
		String date_str = sdf.format(add);
		System.out.println(date_str);
		
	}

	private void datemethod4() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd hh:mm");
		Date date = new Date();
		System.out.println(date);
		String date_Str = sdf.format(date);
		System.out.println(date_Str);
		
	}

	private void datemethod3() {
		String dateStr = "2023-11-24 09:00";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		
		try {
			Date date = sdf.parse(dateStr);
			
			Date cur = new Date();
			long time = cur.getTime() - date.getTime();
			int min = (int)(time / 1000 / 60);
			System.out.println(min + "분 지각");
		}
		catch (Exception e) {
		}
	}

	private void datemethod2() {
		String dateStr = "2023/11/23";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		
		try {
			// 어제시간
			Date yesterDay = sdf.parse(dateStr);
			// 현재시간
			Date date = new Date();
			System.out.println(yesterDay);
			// 1일  10시간 30분 15초 형태로 나타내 볼 것
			
			long time = (date.getTime() - yesterDay.getTime()) / 1000;
			
			int day = 60 * 60 * 24;
			int days = (int)(time / day);
			time = time % day;
			System.out.print(days + "일, ");
			
			int hour = 60 * 60;
			int hours = (int)(time / hour);
			time = time % hour;
			System.out.print(hours + "시간, ");
			
			int min = 60;
			int mins = (int)(int)(time / min);
			time = time % min;
			System.out.print(mins + "분, ");
			System.out.print(time + "초");
			System.out.println(time);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}

	public void datemethod1() {
		if(debug)System.out.println("datemethod1");
		
		Date d1 = new Date();
		System.out.println("현재 시간");
		System.out.println(d1);
		
		try {
			Thread.sleep(1000);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		Date d2 = new Date();
		System.out.println(d2);
		// 1970년부터 현재까지 진행된 시간
		System.out.println(d2.getTime());
		System.out.println(d1.getTime());
		long time = d2.getTime() - d1.getTime();
		
		System.out.println(time + "ms");
	}
}
