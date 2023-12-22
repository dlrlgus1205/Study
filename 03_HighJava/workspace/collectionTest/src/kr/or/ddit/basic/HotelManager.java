package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Scanner;

public class HotelManager {
	private HashMap<Integer, Room> roomMap;
	Scanner sc;
	Room r;
	public HotelManager() {
		roomMap = new HashMap<Integer, Room>();
		sc = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		HotelManager hm = new HotelManager();
		
		hm.start();
	}
	private void start() {
		System.out.println("******************************************************");
		System.out.println("\t\t호텔에 오신걸 환영합니다람쥐");
		System.out.println("******************************************************");
		System.out.println();
		System.out.println();
		room();
		while(true) {
			int n = select();
			switch (n) {
			case 1:
				checkIn();
				break;
			case 2:
				checkOut();
				break;
			case 3:
				printRoomList();
				break;
			case 4:
				System.out.println("******************************************************");
				System.out.println("\t\t\t호텔 영업 종료");
				System.out.println("******************************************************");
				return;
			default:
				break;
			}
		}
	}
	
	private void room() {
		for(int i = 0; i < 9; i++) {
			r = new Room();
			r.setRoomnum(201 + i);
			r.setRoomtype("싱글룸");
			r.setName("-");
			roomMap.put(201 + i, r);
		}
		for(int i = 0; i < 9; i++) {
			r = new Room();
			r.setRoomnum(301 + i);
			r.setRoomtype("트윈룸");
			r.setName("-");
			roomMap.put(301 + i, r);
		}
		for(int i = 0; i < 9; i++) {
			r = new Room();
			r.setRoomnum(401 + i);
			r.setRoomtype("스위트룸");
			r.setName("-");
			roomMap.put(401 + i, r);
		}
	}

	private void printRoomList() {
		System.out.println("------------------------------------------------------");
		System.out.println("\t\t\t현재 객실 상태");
		System.out.println("------------------------------------------------------");
		System.out.println("방번호\t방종류\t투숙객");
		System.out.println("------------------------------------------------------");
		roomList();
		System.out.println("------------------------------------------------------");
	}

	private void roomList() {
		for(int i = 0; i < 9; i++) {
			Room r = roomMap.get(201 + i);
			System.out.println(r.getRoomnum() + "\t" + r.getRoomtype() + "\t" + r.getName());
		}
		for(int i = 0; i < 9; i++) {
			Room r = roomMap.get(301 + i);
			System.out.println(r.getRoomnum() + "\t" + r.getRoomtype() + "\t" + r.getName());
		}
		for(int i = 0; i < 9; i++) {
			Room r = roomMap.get(401 + i);
			System.out.println(r.getRoomnum() + "\t" + r.getRoomtype() + "\t" + r.getName());
		}
	}

	private void checkOut() {
		System.out.println();
		System.out.println("------------------------------------------------------");
		System.out.println("\t\t\t체크아웃 작업");
		System.out.println("------------------------------------------------------");
		System.out.print("방 선택 >> ");
		int n = sc.nextInt();
		
		if(!roomMap.containsKey(n)) {
			System.out.println(n + "호 객실은 존재하지 않습니다");
			System.out.println();
			return;
		}
		
		r = roomMap.get(n);
		
		if(!r.getName().equals("-")) {
			System.out.print("이름 입력 >> ");
			String name = sc.next();
			r.setName("-");
			System.out.println("'" + name + "'님 체크아웃이 완료 됐습니다");
			System.out.println();
		}
		else {
			System.out.println(n + "호 객실은 체크인 한 사람이 없습니다");
			System.out.println();
		}
	}

	private void checkIn() {
		System.out.println();
		System.out.println("------------------------------------------------------");
		System.out.println("\t\t\t체크인 작업");
		System.out.println("------------------------------------------------------");
		System.out.println("* 201 ~ 209 : 싱글룸");
		System.out.println("* 301 ~ 309 : 트윈룸");
		System.out.println("* 401 ~ 409 : 스위트룸");
		System.out.println("------------------------------------------------------");
		System.out.print("방 선택 >> ");
		int n = sc.nextInt();
		
		if(!roomMap.containsKey(n)) {
			System.out.println(n + "호 객실은 존재하지 않습니다");
			System.out.println();
			return;
		}
		
		r = roomMap.get(n);
		
		if(r.getName().equals("-")) {
			System.out.print("이름 입력 >> ");
			String name = sc.next();
			r.setName(name);
			System.out.println("'" + name + "'님 체크인이 완료 됐습니다");
			System.out.println();
		}
		else {
			System.out.println(n + "호 객실은 이미 손님이 있습니다");
			System.out.println();
		}
	}
	
	private int select() {
		System.out.println("------------------------------------------------------");
		System.out.println("\t\t\t업무 선택");
		System.out.println("1. 체크인");
		System.out.println("2. 체크아웃");
		System.out.println("3. 객실상태");
		System.out.println("4. 업무종료");
		System.out.println("------------------------------------------------------");
		System.out.print("선택 >> ");
		return sc.nextInt();
	}
}

class Room{
	private int roomnum;
	private String roomtype;
	private String name;
	
	public int getRoomnum() {
		return roomnum;
	}

	public void setRoomnum(int roomnum) {
		this.roomnum = roomnum;
	}

	public String getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}