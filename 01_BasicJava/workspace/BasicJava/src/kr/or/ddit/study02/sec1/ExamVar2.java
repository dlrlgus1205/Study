package kr.or.ddit.study02.sec1;

public class ExamVar2 {
	
	public static void main(String[] args) {
		// 1년은 365.2422일이다 이 것을 xx 일 xx 시간 xx 분 xx 초로 나타내라.
		double days = 365.2422;
		int day = (int)days;
		
		double hours = (days - day) * 24;
		int hour = (int)hours;
		
		double mins = (hours - hour) * 60;
		int min = (int)mins;
		
		double secs = (mins - min) * 60;
		int sec = (int)secs;
		
		System.out.println(hour + "시간");		
		System.out.println(min + "분");
		System.out.println(sec + "초");
	}
	
}
