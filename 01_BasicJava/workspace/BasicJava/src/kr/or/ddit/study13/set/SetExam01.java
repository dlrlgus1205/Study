package kr.or.ddit.study13.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

/*
 * HashSet
 * 
 * key로 이루어짐
 * key 값은 중복을 허용하지 않고 순서가 보장되지 않음
 * 
 * SEt 타입의 대표 컬렉션
 * 
 * 주요 메소드
 * .add(key) 		: 값 추가
 * .remove(key) 	: 값 삭제
 * .contains(key)	: 포함 여부
 * .iterator()		: 전체 출력을 위한 iterator
 */

public class SetExam01 {
	public static void main(String[] args) {
//		HashSet set = new HashSet();
//		set.add(100);
//		set.add("가");
//		set.add("a");
//		set.add("e");
//		
//		Iterator it = set.iterator();
//		
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}
		
		HashSet lotto = new HashSet();
		while(lotto.size() < 6) {
			int random = new Random().nextInt(45) + 1;
			lotto.add(random);
		}
		System.out.println(lotto);
	}
}
