package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectIOTest02 {
	public static void main(String[] args) {
		// 저장된 객체를 읽어와 그 내용을 화면에 출력하기
		try {
			// 입력용 스트림 객체 생성
			ObjectInputStream oin = new ObjectInputStream(new BufferedInputStream(new FileInputStream("d:/d_other/memObj.data")));
			
			Object obj = null;
			System.out.println("객체 읽기 작업 시작");
			
			while((obj = oin.readObject()) != null) {
				Member mem = (Member)obj;
				
				System.out.println("이 름 : " + mem.getName());
				System.out.println("나 이 : " + mem.getAge());
				System.out.println("주 소 : " + mem.getAddr());
				System.out.println("-------------------------------");
			}
			
			System.out.println("객체 읽기 작업 끝");
		}
		catch (IOException e) {
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
