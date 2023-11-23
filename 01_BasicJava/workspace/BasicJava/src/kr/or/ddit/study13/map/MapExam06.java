package kr.or.ddit.study13.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MapExam06 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		MapExam06 me = new MapExam06();
		
		me.process();
	}

	private void process() {
		List<Map<String, Object>> data = dataInput();
		
		System.out.print("차 번호 입력 : ");
		String s = sc.next();
		
		// 차 번호 입력했을 때 주차한 시간 구하기
		int min = getMin(s, data);
		System.out.println(s + " : " + min + "분 주차");
		
		//주차한 시간 구한 후 요금 정산
		int price = getPrice(min);
		System.out.println("주차 요금 : " + price + "원");
		// 요금표
		// 기본 시간(분) 180
		// 기본 요금(원) 5000
		// 단위 시간(분) 10
		// 단위 요금(원) 600
	}
	
	public List<Map<String, Object>> dataInput(){
		List<Map<String, Object>> list = new ArrayList();
		
		Map<String, Object> m1 = new HashMap();
		m1.put("time", "05:34");
		m1.put("number", "5961");
		m1.put("inout", "입차");
		Map<String, Object> m2 = new HashMap();
		m2.put("time", "06:34");
		m2.put("number", "0000");
		m2.put("inout", "입차");
		Map<String, Object> m3 = new HashMap();
		m3.put("time", "06:34");
		m3.put("number", "0000");
		m3.put("inout", "출차");
		Map<String, Object> m4 = new HashMap();
		m4.put("time", "07:59");
		m4.put("number", "5961");
		m4.put("inout", "출차");
		Map<String, Object> m5 = new HashMap();
		m5.put("time", "07:59");
		m5.put("number", "0148");
		m5.put("inout", "입차");
		Map<String, Object> m6 = new HashMap();
		m6.put("time", "18:59");
		m6.put("number", "0000");
		m6.put("inout", "입차");
		Map<String, Object> m7 = new HashMap();
		m7.put("time", "19:09");
		m7.put("number", "0148");
		m7.put("inout", "출차");
		Map<String, Object> m8 = new HashMap();
		m8.put("time", "22:59");
		m8.put("number", "5961");
		m8.put("inout", "입차");
		Map<String, Object> m9 = new HashMap();
		m9.put("time", "23:00");
		m9.put("number", "5961");
		m9.put("inout", "입차");
		
		list.add(m1);
		list.add(m2);
		list.add(m3);
		list.add(m4);
		list.add(m5);
		list.add(m6);
		list.add(m7);
		list.add(m8);
		list.add(m9);
		
		return list;
	}
	
	public int getTime(String time) {
		String h1 = time.split(":")[0];
		String m1 = time.split(":")[1];
		
		return Integer.parseInt(h1) * 60 + Integer.parseInt(m1);
	}
	
	public int getMin(String carnum, List<Map<String, Object>> list) {
		String temp = "";
		int sum = 0;
		
		for(int i = 0; i < list.size(); i++) {
			Map m = list.get(i);
			String number = (String) m.get("number");
			if(!number.equals(carnum))continue;
			
			String inout = (String)m.get("inout");
			if(inout.equals("입차")) {
				temp = (String)m.get("time");
			}
			if(inout.equals("출차")) {
				String out = (String)m.get("time");
				int time = getTime(out) - getTime(temp);
				sum += time;
			}
			
			System.out.println(m);
		}
		
		return sum;
	}
	
	public int getPrice(int min) {
		// 요금표
		// 기본 시간(분) 180
		// 기본 요금(원) 5000
		// 단위 시간(분) 10
		// 단위 요금(원) 600
		int price = 0;
		if(min < 181) {
			price = 5000;
		}
		else {
			price = 5000 + ((min - 180) / 10) * 600;
		}
		
		return price;
	}
}
