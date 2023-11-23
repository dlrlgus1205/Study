package kr.or.ddit.study13.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MapExam02 {
	public static void main(String[] args) {
		//ID NAME LGU BUYER
//		P101000001	모니터 삼성전자15인치칼라	P101	P10101
//		P101000002	모니터 삼성전자17인치칼라	P101	P10101
//		P101000003	모니터 삼성전자19인치칼라	P101	P10101
		
		// <> -- 제네릭
		// 안에 선언된 타입만 데이터를 넣을 수 있음
		// 생략 시 Object로 기본 설정
		ArrayList<Map<String, String>> list = new ArrayList();
		
		HashMap<String, String> m1 = new HashMap();
		m1.put("ID", "P101000001");
		m1.put("NAME", "모니터 삼성전자15인치칼라");
		m1.put("LGU", "P101");
		m1.put("BUYER", "P10101");
		
		HashMap<String, String> m2 = new HashMap();
		m2.put("ID", "P101000002");
		m2.put("NAME", "모니터 삼성전자17인치칼라");
		m2.put("LGU", "P101");
		m2.put("BUYER", "P10101");
		
		HashMap<String, String> m3 = new HashMap();
		m3.put("ID", "P101000003");
		m3.put("NAME", "모니터 삼성전자19인치칼라");
		m3.put("LGU", "P101");
		m3.put("BUYER", "P10101");
	
		list.add(m1);
		list.add(m2);
		list.add(m3);
		
		for(int i = 0; i < list.size(); i++) {
			Map<String, String> m = list.get(i);
			String id = m.get("ID");
			String name = m.get("NAME");
			String lgu = m.get("LGU");
			String buyer = m.get("BUYER");
			System.out.println(id + "\t" + name + "\t" + lgu + "\t" + buyer);
		}
		
	}
}
