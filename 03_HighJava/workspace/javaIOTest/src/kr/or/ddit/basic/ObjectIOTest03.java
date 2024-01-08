package kr.or.ddit.basic;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class ObjectIOTest03 {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			ObjectOutputStream oout = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("d:/d_other/memObj.data")));
			
			while(true) {
				System.out.println("저장할 Member 정보를 입력하세요");
				System.out.print("이름 >> ");
				String name = sc.next();
				System.out.print("나이 >> ");
				int age = sc.nextInt();
				sc.nextLine();	// 버퍼 키우기
				System.out.print("주소 >> ");
				String addr = sc.nextLine();
				
				Member mem = new Member(name, age, addr);
				
				oout.writeObject(mem);
				
				System.out.print("계속 하시겠습니까?(Y / N) >> ");
				String ans = sc.next();
				
				if("N".equals(ans.toUpperCase())) {
					break;
				}
			}
			oout.writeObject(null);
			
			oout.close();
		}
		catch (IOException e) {
		}
	}
}
