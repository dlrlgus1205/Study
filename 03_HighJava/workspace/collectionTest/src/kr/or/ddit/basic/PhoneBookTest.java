package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/*
문제) 이름, 주소, 전화번호를 멤버로 갖는 Phone클래스를 만들고
	Map을 이용하여 '전화번호 정보'를 관리하는 프로그램을 작성하시오.
	(이 때 Map의 구조는 key값으로 '이름'데이터를 사용하고, value값으로는 'Phone클래스의 인스턴스'로 한다.)
	
	아래의 메뉴를 처리하는 프로그램을 완성하시오
실행예시)
	메  뉴
1. 전화번호 등록
2. 전화번호 수정
3. 전화번호 삭제
4. 전화번호 검색
5. 전화번호 전체 출력
0. 프로그램 종료
------------------	
번호 입력 >> 1

새롭게 등록할 전화번호 정보를 입력하세요.
이름 >> 홍길동
전화번호 >> 010-1111-1111
주소 >> 대전시 중구 대흥동

'홍길동' 전화번호 등록 완료!!

	메  뉴
1. 전화번호 등록
2. 전화번호 수정
3. 전화번호 삭제
4. 전화번호 검색
5. 전화번호 전체 출력
0. 프로그램 종료
------------------	
번호 입력 >> 1

새롭게 등록할 전화번호 정보를 입력하세요.
이름 >> 홍길동
'홍길동'은 이미 등록된 사람입니다.

	메  뉴
1. 전화번호 등록
2. 전화번호 수정
3. 전화번호 삭제
4. 전화번호 검색
5. 전화번호 전체 출력
0. 프로그램 종료
------------------	
번호 입력 >> 5

----------------------------------------
번호         이름          전화번호         주소
----------------------------------------
1      홍길동       010-1111-1111  대전시 중구 대흥동
  ~~~
  ~~~
----------------------------------------
출력 끝...
 
	메  뉴
1. 전화번호 등록
2. 전화번호 수정
3. 전화번호 삭제
4. 전화번호 검색
5. 전화번호 전체 출력
0. 프로그램 종료
------------------	
번호 입력 >> 0

프로그램을 종료합니다...


 */
public class PhoneBookTest {
	Scanner sc = new Scanner(System.in);
	HashMap<String, Phone> map = new HashMap<String, Phone>();
	public static void main(String[] args) {
		PhoneBookTest obj = new PhoneBookTest();
		obj.start();
	}

	private void start() {
		while(true) {
			int n = home();
			switch (n) {
			case 1:
				insert();
				break;
			case 2:
				update();
				break;
			case 3:
				delete();
				break;
			case 4:
				search();
				break;
			case 5:
				allList();
				break;
			case 0:
				System.out.println("프로그램을 종료합니다");
				break;
			default:
				break;
			}
			if(n == 0) break;
		}
	}

	private void allList() {
		Set<String> keySet = map.keySet();
		System.out.println("-----------------------------------");
		System.out.println("번호/t이름/t전화번호/t주소");
		System.out.println("-----------------------------------");
		int cnt = 1;
		
		for (String key : keySet) {
			Phone p = map.get(key);
			System.out.println(cnt++ + "\t" + p.getName() + "\t" + p.getNum() + "\t" + p.getAddress());
		}
			
		
		System.out.println("-----------------------------------");
		System.out.println();
	}

	private void search() {
		System.out.println("검색할 이름을 입력하세요");
		
		String name = sc.next();
		if(map.containsKey(name)) {
			Phone p = map.get(name);
			System.out.println(p.getName() + "\t" + p.getNum() + "\t" + p.getAddress());
		}
		else {
			System.out.println("없는 사람입니다");
		}
	}

	private void delete() {
		System.out.println("삭제할 사람을 입력하세요");
		String name = sc.next();
		
		if(map.containsKey(name)) {
			Phone p = map.remove(name);
			System.out.println("삭제 완료 !!");
			System.out.println();
		}
		else {
			System.out.println("없는 사람입니다");
		}
		
	}

	private void update() {
		System.out.println("수정할 사람을 입력하세요");
		String name = sc.next();
		
		// 사람 찾기 (존재하면 가져온다)
		if(map.containsKey(name)) {
			Phone p = map.get(name);
			System.out.println("수정할 정보를 선택하세요");
			System.out.println("1. 전화번호");
			System.out.println("2. 주소");
			System.out.println("3. 뒤로가기");
			int n = sc.nextInt();
			switch (n) {
			case 1:
				System.out.println("수정할 이름을 입력하세요");
				String updateName = sc.next();
				p.setName(updateName);
				break;
			case 2:
				System.out.println("수정할 전화번호을 입력하세요");
				String updateNum = sc.next();
				p.setNum(updateNum);
				break;
			case 3:
				System.out.println("수정할 주소을 입력하세요");
				String updateAddress = sc.next();
				p.setAddress(updateAddress);
				break;
			case 4:
				return;
			default:
				break;
			}
			
		}
		else {
			System.out.println("없는 사람입니다");
		}
		
		
	
		System.out.println();
		System.out.println("수정 완료 !!");
		System.out.println();
	}

	private void insert() {
		Phone p = new Phone();
		System.out.println("새롭게 등록할 전화번호 정보를 입력하세요");
		System.out.print("이름 >> ");
		String name = sc.next();
		p.setName(name);
		
		if(map.containsKey(name)) {
			System.out.println("이미 등록된 사람입니다");
			System.out.println();
			return;
		}
		
		System.out.print("전화번호 >> ");
		String num = sc.next();
		p.setNum(num);
		
		System.out.print("주소 >> ");
		String address = sc.next();
		p.setAddress(address);
		
		map.put(name, p);
		
		
		System.out.println();
		System.out.println("'" + name + "' 등록 완료 !!");
		System.out.println();
	}

	private int home() {
		System.out.println("===================================");
		System.out.println("\t\t메  뉴");
		System.out.println("===================================");
		System.out.println("1. 전화번호 등록");
		System.out.println("2. 전화번호 수정");
		System.out.println("3. 전화번호 삭제");
		System.out.println("4. 전화번호 검색");
		System.out.println("5. 전화번호 전체 출력");
		System.out.println("0. 프로그램 종료");
		System.out.println("-----------------------------------");
		System.out.print("번호 입력 : ");
		int n = sc.nextInt();
		System.out.println();
		return n;
	}
}

class Phone {
	private String name;
	private String num;
	private String address;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
