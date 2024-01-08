package kr.or.ddit.basic.tcp;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

// 이 클래스는 소켓을 통해서 메시지를 보내는 역할만 하는 쓰레드 클래스이다.
public class Sender extends Thread {
	private Socket socket;
	private DataOutputStream dout;
	
	private String name;
	private Scanner sc;
	
	// 생성자
	public Sender(Socket socket) {
		this.socket = socket;
		sc = new Scanner(System.in);
		
		System.out.print("이름 입력 >> ");
		name = sc.nextLine();
		
		try {
			dout = new DataOutputStream(this.socket.getOutputStream());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	@Override
	public void run() {
		while(dout != null) {
			try {
				dout.writeUTF(name + " : " + sc.nextLine());
			} 
			catch (Exception e) {
			}
		}
	}
}
