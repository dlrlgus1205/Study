package kr.or.ddit.basic;

import java.util.ArrayList;

public class ArrayListTest01 {
	public static void main(String[] args) {
		// ArrayList의 기본적인 사용법은 Vector와 같다.
		
		ArrayList al1= new ArrayList();
		
		// add() 메서드를 이용해서 데이터를 추가한다.
		al1.add("aaa");
		al1.add("bbb");
		al1.add(123);
		al1.add('k');
		al1.add(true);
		al1.add(123.45);
		
		System.out.println("al1 => " + al1);
		System.out.println("size => " + al1.size());
		
		// get() 메서드를 이용해서 데이터를 꺼낸다.
		System.out.println("1번째 자료 : " + al1.get(1));
		
		// 데이터 끼워넣기도 Vector와 같다.
		al1.add(3, "zzz");
		System.out.println("al1 => " + al1);
		System.out.println();
		
		// 데이터 변경하기
		String sTemp = (String) al1.set(3, "yyy");
		System.out.println("al1 ==> " + al1);
		System.out.println("sTemp ==> " + sTemp);
		System.out.println();
		
		//데이터 삭제하기
		al1.remove(3);	//index로 삭제하기
		al1.remove("bbb");	// 데이터를 찾아서 삭제하기
		System.out.println("삭제 후 al1 ==> " + al1);
		
		// 제네릭을 사용할 수 있다.
		ArrayList<String> al2 = new ArrayList<String>();
		al2.add("AAAA");
		al2.add("BBBB");
		al2.add("CCCC");
		al2.add("DDDD");
		al2.add("EEEE");
		//al2.add(1234);
		
		for(int i = 0; i < al2.size(); i++) {
			System.out.println(i + " ==> " + al2.get(i));
		}
		System.out.println();
		
		for (String str : al2) {
			System.out.println(str);
		}
		System.out.println("---------------------------------------------------------");
		
		// contains(비교객체) ==> List에 저장된 데이터 중에서 '비교객체'가 있으면 true, 없으면 false를 반환한다.
		System.out.println("DDDD값의 존재 여부 : " + al2.contains("DDDD"));
		System.out.println("ZZZZ값의 존재 여부 : " + al2.contains("ZZZZ"));
		
		// indexOf(비교객체)
		// lastIndexOf(비교객체)	==> List에 '비교객체'가 있으면 '비교객체'가 저장된
		//							index값을 반환하고 없으면 -1을 반환한다.
		// - indexOf() 메서드는 검색 방향이 앞에서 뒤쪽으로 검색하고,
		//	 lastIndexOf() 메서드는 검색 방향이 뒤에서 앞쪽으로 검색한다.
		// - List에 '비교객체'가 많으면 첫번째로 찾아진 데이터의 위치값이 반환된다.
		al2.add("AAAA");
		al2.add("BBBB");
		al2.add("CCCC");
		al2.add("DDDD");
		al2.add("EEEE");
		System.out.println("al2 ==>" + al2);
		
		System.out.println("DDDD의 위치값 : " + al2.indexOf("DDDD"));
		System.out.println("ZZZZ의 위치값 : " + al2.indexOf("ZZZZ"));
		System.out.println("DDDD의 위치값 : " + al2.lastIndexOf("DDDD"));
		
		// - toArray() ==> List 안의 데이터를 배열로 변환해서 반환한다.
		//			   ==> 기본적으로 Object형 배열로 변환한다.
		// - toArray(new 제네릭타입[0]) ==> 제네릭 타입의 배열로 변환해서 반환한다.
		
		Object[] strArr = al2.toArray();
		// String[] strArr2 = (String[]) al2.toArray();	// 이 방법은 사용할 수 없다.
		
		System.out.println("List의 개수 : " + al2.size());
		System.out.println("배열의 개수 : " + strArr.length);
		
		for(int i = 0; i < strArr.length; i++) {
			System.out.println(i + "번째 자료 : " + strArr[i]);
		}
		System.out.println("---------------------------------------------------------");
		
		String[] StrArr2 = al2.toArray(new String[0]);
		for (String str : StrArr2) {
			System.out.println(str);
		}
	}
}
