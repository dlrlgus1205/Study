package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;
import kr.or.ddit.util.DBUtil3;

/*
	회원을 관리하는 프로그램을 작성하시오. (MYMEMBER 테이블 이용)
	
	아래 메뉴의 기능을 모두 구현하시오. (CRUD 기능 구현 연습)
	메뉴 예시)
	1. 자료 추가
	2. 자료 삭제
	3. 자료 수정
	4. 전체 자료 출력
	0. 작업 끝.
	----------------------
	
	조건)
	1) 자료 추가에서 '회원ID'는 중복되지 않는다. (중복되면 다시 입력 받는다.)
	2) 자료 삭제는 '회원ID'를 입력 받아서 처리한다.
	3) 자료 수정에서 '회원ID'는 변경되지 않는다.
*/
public class JdbcTest07 {
	private Scanner sc = null;
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public JdbcTest07() {
		sc = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		JdbcTest07 obj = new JdbcTest07();
		obj.home();
	}

	private void home() {
		while(true) {
			int n = print();
			switch (n) {
			case 1:
				create();
				break;
			case 2:
				delete();
				break;
			case 3:
				update();
				break;
			case 4:
				read();
				break;
			case 0:
				System.out.println("!!! 작업 끝!!!");
				break;
			default:
				break;
			}
			if(n == 0) {
				break;
			}
		}
	}

	private void read() {
		System.out.println("=============================");
		System.out.println();
		System.out.println("전체 자료를 불러옵니다");
		System.out.println();
		System.out.println("=============================");
		
		try {
//			conn = DBUtil.getConnection();
//			conn = DBUtil2.getConnection();
			conn = DBUtil3.getConnection();
			
			String sql = "SELECT * FROM MYMEMBER";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			System.out.println("ID\tPASSWORD\tNAME\tTEL\tADDRESS");
			System.out.println("------------------------------------------------------------------");
			
			while(rs.next()) {
				String id = rs.getString("MEM_ID");
				String pass = rs.getString("MEM_PASS");
				String name = rs.getString("MEM_NAME");
				String tel = rs.getString("MEM_TEL");
				String addr = rs.getString("MEM_ADDR");
				
				System.out.println(id + "\t" + pass + "\t\t" + name + "\t" + tel + "\t" + addr);
			}
			System.out.println("------------------------------------------------------------------");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch(SQLException e) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException e) {}
			if(conn != null) try {conn.close();} catch(SQLException e) {}
		}
	}

	private void update() {
		System.out.println("=============================");
		System.out.println("자료를 수정합니다");
		System.out.println();
		System.out.println("ID를 입력해주세요");
		System.out.println("=============================");
		
		try {
			conn = DBUtil.getConnection();
			System.out.print("ID >> ");
			String id = sc.next();
			System.out.println("=============================");
			System.out.println("PASSWORD");
			System.out.println("NAME");
			System.out.println("TEL");
			System.out.println("ADDRESS");
			System.out.println("=============================");
			System.out.println("수정할 항목을 입력해주세요");
			String sel = sc.next();
			
			switch(sel) {
				case "PASSWORD":
					System.out.println("변경할 PASSWORD를 입력하세요");
					String pass = sc.next();
					String psql = "UPDATE MYMEMBER SET MEM_PASS = ? WHERE MEM_ID = ?";
					
					pstmt = conn.prepareStatement(psql);
					
					pstmt.setString(1, pass);
					pstmt.setString(2, id);
					
					rs = pstmt.executeQuery();

					System.out.println(">> 수정 완료 <<");
					break;
				case "NAME":
					System.out.println("변경할 NAME을 입력하세요");
					String name = sc.next();
					String nsql = "UPDATE MYMEMBER SET MEM_NAME = ? WHERE MEM_ID = ?";
					
					pstmt = conn.prepareStatement(nsql);
					
					pstmt.setString(1, name);
					pstmt.setString(2, id);
					
					rs = pstmt.executeQuery();
					
					System.out.println(">> 수정 완료 <<");
					break;
				case "TEL":
					System.out.println("변경할 NAME을 입력하세요");
					String tel = sc.next();
					String tsql = "UPDATE MYMEMBER SET MEM_TEL = ? WHERE MEM_ID = ?";
					
					pstmt = conn.prepareStatement(tsql);
					
					pstmt.setString(1, tel);
					pstmt.setString(2, id);
					
					rs = pstmt.executeQuery();

					System.out.println(">> 수정 완료 <<");
					break;
				case "ADDRESS":
					System.out.println("변경할 NAME을 입력하세요");
					String addr = sc.next();
					String asql = "UPDATE MYMEMBER SET MEM_ADDR = ? WHERE MEM_ID = ?";
					
					pstmt = conn.prepareStatement(asql);
					
					pstmt.setString(1, addr);
					pstmt.setString(2, id);
					
					rs = pstmt.executeQuery();

					System.out.println(">> 수정 완료 <<");
					break;
				default:
					System.out.println("잘못 입력하셨습니다");
					break;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch(SQLException e) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException e) {}
			if(conn != null) try {conn.close();} catch(SQLException e) {}
		}
	}

	private void delete() {
		System.out.println("=============================");
		System.out.println("자료를 삭제합니다");
		System.out.println();
		System.out.println("ID를 입력해주세요");
		System.out.println("=============================");
		
		try {
			conn = DBUtil.getConnection();
			System.out.print("ID >> ");
			String id = sc.next();
			
			String sql = "DELETE FROM MYMEMBER WHERE MEM_ID = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			System.out.println(">> 삭제 완료 <<");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch(SQLException e) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException e) {}
			if(conn != null) try {conn.close();} catch(SQLException e) {}
		}
	}

	private void create() {
		System.out.println("=============================");
		System.out.println("자료를 추가합니다");
		System.out.println();
		System.out.println("정보를 입력해주세요");
		System.out.println("=============================");
		
		String id = "";
		String pass = "";
		String name = "";
		String tel = "";
		String addr = "";
		
		try {
			conn = DBUtil.getConnection();
			while(true) {
				System.out.print("ID >> ");
				id = sc.next();
				
				String sql = "SELECT COUNT(*) CNT FROM MYMEMBER WHERE MEM_ID = ?";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				
				rs = pstmt.executeQuery();
				
				rs.next();
				String cnt = rs.getString("CNT");
				
				if(cnt.equals("1")) {
					System.out.println("중복입니다 다시 입력하세요");
				}
				else {
					break;
				}
			}
			System.out.print("PASSWORD >> ");
			pass = sc.next();
			System.out.print("NAME >> ");
			name = sc.next();
			System.out.print("TEL >> ");
			tel = sc.next();
			System.out.print("ADDRESS >> ");
			addr = sc.next();
			
			String sql = "INSERT INTO MYMEMBER (MEM_ID, MEM_PASS, MEM_NAME, MEM_TEL, MEM_ADDR)\r\n" + 
					"VALUES (?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			pstmt.setString(3, name);
			pstmt.setString(4, tel);
			pstmt.setString(5, addr);
			
			rs = pstmt.executeQuery();
			
			System.out.println(">> 추가 완료 <<");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch(SQLException e) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException e) {}
			if(conn != null) try {conn.close();} catch(SQLException e) {}
		}
		
	}

	private int print() {
		System.out.println("=============================");
		System.out.println("1. 자료 추가");
		System.out.println("2. 자료 삭제");
		System.out.println("3. 자료 수정");
		System.out.println("4. 전체 자료 출력");
		System.out.println("0. 작업 종료");
		System.out.println("=============================");
		System.out.print("번호 선택 >>");
		int n = sc.nextInt();
		return n;
	}
}
