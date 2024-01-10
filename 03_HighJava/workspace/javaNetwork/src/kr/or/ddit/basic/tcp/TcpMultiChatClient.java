package kr.or.ddit.basic.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TcpMultiChatClient {
	public static void main(String[] args) {
		new TcpMultiChatClient().clientStart();
	}
	
	// 시작 메서드
	public void clientStart() {
		Socket socket = null;
		try {
			socket = new Socket("192.168.142.3", 7777);
			System.out.println("서버에 연결됐습니다");
			
			// 메시지 전송용 쓰레드 작성
			ClientSender sender = new ClientSender(socket);
			
			// 메시지 수신용 쓰레드 작성
			ClientReceiver receiver = new ClientReceiver(socket);
			
			sender.start();
			receiver.start();
			
		}
		catch (Exception e) {
		}
	}
		
	// -----------------------------------------------------------------
	// 메시지 전송용 쓰레드 작성
	class ClientSender extends Thread {
		private Socket socket;
		private DataInputStream din;
		private DataOutputStream dout;
		
		private String name;
		private Scanner sc;
		
		// 생성자
		public ClientSender(Socket socket) {
			sc = new Scanner(System.in);
			this.socket = socket;
			try {
				din = new DataInputStream(this.socket.getInputStream());
				dout = new DataOutputStream(this.socket.getOutputStream());
				
				if(dout != null) {
					while(true) {
						// 클라이언트가 '대화명'을 입력 받아 서버로 전송하고 서버에서 '대화명'의 중복 여부를 응답으로 받아서 확인한다.
						System.out.print("대화명 >> ");
						String name = sc.nextLine();
						
						// 대화명 전송
						dout.writeUTF(name);
						
						// '대화명'의 중복 여부를 응답으로 받는다.
						String feedBack = din.readUTF();
						
						// 중복될 때
						if("대화명 중복".equals(feedBack)) {
							System.out.println(name + "은 이미 사용 중입니다");
							System.out.println("다른 대화명을 입력하세요");
						}
						// 중복되지 않을 때
						else {
							this.name = name;
							System.out.println("[" + name + "] 대화명으로 대화방에 입장했습니다");
							break;
						}
					}
				}
			}
			catch (Exception e) {
			}
		}
		
		@Override
		public void run() {
			try {
				while(dout != null) {
					// 키보드로 입력한 내용을 서버로 전송한다.
					dout.writeUTF("[" + name + "] " + sc.nextLine());
				}
			}
			catch (Exception e) {
			}
		}
	}
	// ----------------------------------------------------------------------------
	class ClientReceiver extends Thread {
		private Socket socket;
		private DataInputStream din;
		
		//생성자
		public ClientReceiver(Socket socket) { 
			this.socket = socket;
			try {
				din = new DataInputStream(this.socket.getInputStream());
			}
			catch (Exception e) {
			}
		}
		
		@Override
		public void run() {
			try {
				while(din != null) {
					System.out.println(din.readUTF());
				}
			}
			catch (Exception e) {
			}
		}
	}
	
}
