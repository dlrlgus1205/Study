package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MapTest {
	public static void main(String[] args) {
		/*
		 * - Map ==> Key 값과 value 값을 한 쌍으로 관리하는 객체
		 * - Key 값은 중복을 허용하지 않고 순서도 없다. ==> Set의 특징을 갖는다.
		 * - value 값은 중복을 허용한다.
		 */
		HashMap<String, String> map = new HashMap<String, String>();
		
		// 자료 추가 ==> put(key, value)
		map.put("name", "홍길동");
		map.put("addr", "대전");
		map.put("tel", "010-1234-5678");

		System.out.println("map => " + map);
		
		// 자료 수정 ==> 데이터를 추가할 때 key값이 같으면 나중에 추가한 내용이 저장된다.
		map.put("addr", "서울");
		System.out.println("map => " + map);
		
		// 자료 삭제 ==> remove(key) ==> key 값이 같은 자료를 찾아서 삭제한다.
		//				==> 반환값 : 삭제된 자료의 value 값
//		String removeTel = map.remove("tel");
//		System.out.println("map => " + map);
//		System.out.println("삭제된 value 값 : " + removeTel);
		
		// 자료 읽기 ==> get(key)
		//			==> 반환값 : 주어진 'key값'과 짝이 되는 value 값을 반환한다.
		//					     주어진 'key값'이 없으면 null값을 반환한다.
		System.out.println("이름 : " + map.get("name"));
		System.out.println();
		
		// key값이 존재하는지 여부를 나타내는 메서드 => containsKey(key)
		//		==> 해당 key 값이 있으면 true, 없으면 false를 반환한다.
		System.out.println("tel 키 값의 존재 여부 : " + map.containsKey("tel"));
		System.out.println("age 키 값의 존재 여부 : " + map.containsKey("age"));
		System.out.println();
		
		// Map에 저장된 모든 데이터를 차례로 읽어와 사용하는 방법
		
		// 1. 모든 key값을 읽어와 처리하기 ==> keySet() 메서드 이용하기
		// keySet() 메서드 ==> Map 의 모든 key 값들을 읽어와 Set 형으로 반환한다.
		
		Set<String> keySet = map.keySet();
		
		// 방법 1
		Iterator<String> it = keySet.iterator();
		while(it.hasNext()) {
			String key = it.next();	// 키값 구하기
			String value = map.get(key);
			System.out.println(key + " ==> " + value);
		}
		System.out.println("--------------------------------------");

		// 방법 2
		for (String key : keySet) {
			String value = map.get(key);
			System.out.println(key + " ==> " + value);
		}
		System.out.println("--------------------------------------");
		
		// 2. 모든 value 값들만 읽어와 처리하기 ==> values() 메서드 이용
		for (String value : map.values()) {
			System.out.println(value);
		}
		System.out.println("--------------------------------------");
	}
}
