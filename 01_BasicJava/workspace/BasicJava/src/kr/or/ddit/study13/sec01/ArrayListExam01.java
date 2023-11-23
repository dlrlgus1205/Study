package kr.or.ddit.study13.sec01;

import java.util.ArrayList;

/*
 * ArrayList
 * 	- 1차원 배열 구조
 * 	- 중복을 허락하고 순서화 제공
 * 	- List 타입의 컬렉션
 * 
 * 주요메서드
 * 	.add(데이터)				: ArrayList에 데이터 삽입
 * 	.contains(Object obj)	: ArrayList에 저장된 데이터에 obj가 있는지 판단
 * 							   있다면 true 없으면 false 반환
 * 
 * 	.get(int index)			: idx번째 자료 반환
 * 	.iterator()				: 반복자로 객체에 저장된 자료를 맨 처음부터 마지막까지
 * 							    순차적으로 검색
 * 	.clear()				: ArrayList에 모든 내용 초기화
 * 	.remove(int idx)		: 리스트에 특정값 삭제. 반환값 있음
 */

public class ArrayListExam01 {
	public static void main(String[] args) {
//		ArrayList list1 = new ArrayList();
//		list1.add("홍길동");
//		list1.add(200);
//		list1.add(10.5);
//		
//		for(int i = 0; i < list1.size(); i++) {
//			System.out.println(list1.get(i));
//		}
		
		ArrayList list2 = new ArrayList();
		list2.add(new Prod("볼펜", 300));
		list2.add(new Prod("마우스", 25000));
		list2.add(new Prod("키보드", 25000));
		
		for(int i = 0; i < list2.size(); i++) {
			Prod p = (Prod)list2.get(i);
			System.out.println(p.name + p.price);
		}
		
	}
}
