package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.IO;

/*
문제) 이름, 주소, 전화번호를 멤버로 갖는 Phone클래스를 만들고
	Map을 이용하여 '전화번호 정보'를 관리하는 프로그램을 작성하시오.
	(이 때 Map의 구조는 key값으로 '이름'데이터를 사용하고, value값으로는 'Phone클래스의 인스턴스'로 한다.)
	
	아래의 메뉴를 처리하는 프로그램을 완성하시오
	
	- 추가 조건
	1) '6. 전화번호 저장' 메뉴를 추가하고 구현한다.
		(자장 파일명은 'phoneBook.data'로 한다.)
	2) 프로그램이 시작될 때 저장된 파일이 있으면  그 데이터를 읽어와 Map에 저장한다.
	3) 프로그램을 종료할 때 Map의 데이터가 변경(추가, 수정, 삭제했을 때)됐으면 파일로 저장 후 종료하도록 한다.
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
	private Scanner sc;
	private HashMap<String, Phone> map;
	private String fileName;
	
	// 데이터가 변경됐는지 여부를 나타내는 변수
	// (데이터가 변경되면 true, 그렇지 않으면 false가 저장된다.)
	private boolean dataChk = false;
	
	public PhoneBookTest(){
		sc = new Scanner(System.in);
//		map = new HashMap<String, Phone>();
		fileName = "d:/d_other/phoneBook.data";
		
		//파일 내용을 읽어와 Map에 저장하기
		map = load();
		
		// 파일이 없거나 잘못됐을 때
		if(map == null) {
			map = new HashMap<String, Phone>();
		}
	}
	
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
			case 6:
				save();
				break;
			case 0:
				if(dataChk == true) save();
				System.out.println("프로그램을 종료합니다");
				break;
			default:
				break;
			}
			if(n == 0) break;
		}
	}
	
	// 전화번호 정보가 저장된 파일을 읽어오는 메서드
	private HashMap<String, Phone> load(){
		// 읽어온 데이터가 저장될 변수
		HashMap<String, Phone> pMap = null;
		
		File file = new File(fileName);
		// 저장된 파일이 없으면
		if(!file.exists()) {
			return null;
		}
		
		ObjectInputStream oin = null;
		try {
			// 입력용 스트림 객체
			oin = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
			
			// 방법1로 저장했을 때
//			pMap = (HashMap<String, Phone>)oin.readObject();
			
			// 방법2로 저장했을 때
			Object obj;
			// 파일에서 읽어온 데이터가 저장될 Map 객체 생성
			pMap = new HashMap<String, Phone>();
			
			while ((obj=oin.readObject()) != null) {
				Phone p = (Phone) obj;
				pMap.put(p.getName(), p);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 스트림 닫기
		finally {
			if(oin != null) try {oin.close();} catch (IOException e){}
		}
		return pMap;
	}

	private void save() {
		ObjectOutputStream oout = null; 
		try {
			//객체 출력(저장)용 스트림 객체 생성
			oout = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));
			
			// 방법1) Map 객체를 파일로 저장한다.
			oout.writeObject(map);
			
			System.out.println("저장 완료!");
			
			// 방법2) Map의 데이터를 하나씩 꺼내서 저장한다.
			for(String name : map.keySet()) {
				Phone p = map.get(name);
				oout.writeObject(p);
			}
			oout.writeObject(null);
			
			dataChk = false;
			
			System.out.println("저장 완료!");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		//사용했던 스트림 닫기
		finally {
			if(oout != null) try {oout.close();} catch(IOException e) {}
		}
	}

	private void allList() {
		Set<String> keySet = map.keySet();
		System.out.println("-----------------------------------");
		System.out.println("번호\t이름\t전화번호\t주소");
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
			
			dataChk = true;
			
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
		
		dataChk = true;
	
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
		
		dataChk = true;
		
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
		System.out.println("6. 전화번호 저장");
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
