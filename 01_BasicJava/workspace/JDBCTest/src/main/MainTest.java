package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import util.JDBCUtil;

public class MainTest {
	JDBCUtil jdbc = JDBCUtil.getInstance();
	public static void main(String[] args) {
		MainTest obj = new MainTest();
		obj.join();
//		obj.login();
//		String sql = "select * from member";
		
//		List<Map<String, Object>> list = jdbc.selectList(sql);
//		
//		for(int i = 0; i < list.size(); i++) {
//			Map m = list.get(i);
//			System.out.println(m);	
//		}
		
	}
	
	private void join() {
		System.out.println("------회원가입------");
		String sql = "insert into member values("
				+ "(select max(mem_no) from member) + 1, ?, ?, ?, 'n')";
		
		Scanner sc = new Scanner(System.in);
		System.out.print("id >> ");
		String id = sc.next();
		
		System.out.print("pass >> ");
		String pass = sc.next();
		
		System.out.print("name >> ");
		String name = sc.next();
		
		List<Object> param = new ArrayList();
		param.add(id);
		param.add(pass);
		param.add(name);
		
		jdbc.update(sql, param);
	}

	public boolean login() {
		System.out.println("------로그인------");
		String sql = "select * "
				+ "from member "
				+ "where id = ? "
				+ "and pass = ? ";
		Scanner sc = new Scanner(System.in);
		System.out.print("id >> ");
		String id = sc.next();
		
		System.out.print("pass >> ");
		String pass = sc.next();
		
		List<Object> list = new ArrayList();
		list.add(id);
		list.add(pass);
		
		Map<String, Object> member = jdbc.selectOne(sql, list);
		if(member == null) {
			System.out.println("로그인 실패");
		}
		else {
			System.out.println(member.get("NAME") + "님 환영합니다");
		}
		
		return false;
	}
}
