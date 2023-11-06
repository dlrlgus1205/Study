package kr.or.ddit.study04.sec01;

import java.util.Scanner;

public class SwitchExample01 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		SwitchExample01 obj = new SwitchExample01();
		obj.method1();
	}

	private void method1() {
		System.out.println("---메뉴---");
		System.out.println("1. 입력");
		System.out.println("2. 검색");
		System.out.println("3. 수정");
		System.out.println("4. 삭제");

		String sql = "";

		int select = sc.nextInt();

		switch (select) {
			case 1:
				sql += "Insert Into member(mem_id, mem_pass) " + "values('a001', '1234')";
			break;
			case 2:
				sql += "SELECT * FROM MEMBER";
				break;
			case 3:
				sql += "UPDATE MEMBER" + "SET MEM_ID = 'a002'";
				break;
			case 4:
				sql += "DELETE MEMBER" + "WHERE MEM_ID = 'a001'";
				break;
		
		default :
			System.out.println("잘못 입력 됐습니다.");
			break;
		}
		System.out.println(sql);
	}
}
