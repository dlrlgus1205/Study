package kr.or.ddit.basic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOTest02 {
	public static void main(String[] args) {
		try {
			File file = new File("d:/d_other/out.txt");
			
			// 파일 출력용 스트림 객체 생성
			FileOutputStream fout = new FileOutputStream(file);
			
			for(char ch = 'A'; ch <= 'Z'; ch++) {
				fout.write(ch);		// ch 변수의 데이터를 파일로 출력한다
			}
			
			fout.write('\n');	// 줄바꿈 문자 출력
			String str = "HELLO !!";
			byte[] bStrArr = str.getBytes("utf-8");
			fout.write(bStrArr);
			
			System.out.println("작업 완료 !!!");
			fout.close();	// 스트림 닫기
		}
		catch (IOException e) {
			// TODO: handle exception
		}
	}
}
