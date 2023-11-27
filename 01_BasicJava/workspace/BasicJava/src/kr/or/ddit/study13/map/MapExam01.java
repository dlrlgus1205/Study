package kr.or.ddit.study13.map;

import java.util.HashMap;

/*
 * HashMap
 * key value 로 이루어짐
 * key 값은 중복을 허용하지 않고 순서가 보장되지 않음
 * 
 * Map 타입의 컬렉션
 * 
 * 주요 메소드
 * 
 * .put(key, value)			: 데이터 입력 key 값은 중복되지 않음
 * 							  value는 중복될 수 있음
 * .get(key)				: 입력받은 value 값을 key 값을 통해 꺼내올 수 있음
 * .keySet()				:key로 이루어진 HashSet 값을 가져옴
 */

public class MapExam01 {
	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("홍길동", 90);
		map.put("이순신", 87);
		map.put("정몽주", 90);
		map.put("이성계", 90);
		
		int hong_score = (int)map.get("홍길동");

		System.out.println(map);
	}
}
