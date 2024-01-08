package kr.or.ddit.basic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileIOTest07 {
	public static void main(String[] args) {
		// 사용자로부터 출력한 단을 입력 받아 구구단을 파일로 출력하는 프로그램 작성하기
		// (출력할 파일명 : 'd:/d_other/gugudan2.txt')
		// 문자 기반 스트림을 이용해서 작성하시오
		Scanner sc = new Scanner(System.in);
		FileOutputStream fout = null;
		
		try {
			File file = new File("d:/d_other/gugudan2.txt");
			
			// 파일 출력용 스트림 객체 생성
			fout = new FileOutputStream(file);
			
			System.out.print("단 입력 >> ");
			int n = sc.nextInt();
			int gugudan;
			
			for(int i = 1; i < 10; i++) {
				gugudan = n * i;
				String str = n + "*" + i + "=" + gugudan;
				byte[] bStrArr = str.getBytes("utf-8");
				fout.write(bStrArr);
				fout.write('\n');
			}
			
			System.out.println("작업 완료 !!!");
			fout.close();	// 스트림 닫기
		}
		catch (IOException e) {
		}
	}
}
