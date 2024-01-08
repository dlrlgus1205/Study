package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/*
 * 'd:/d_other' 폴더에 있는 '펭귄.jpg' 파일을
 * 'd:/d_other/연습용' 폴더에 '복사본_펭귄.jpg' 파일로
 * 복사하는 프로그램을 작성하시오
 */
public class FileCopyTest {
	public static void main(String[] args) {
		try {
			// 문자 기반의 파일 입력용 스트림 객체 생성
			FileInputStream fin = new FileInputStream("d:/d_other/펭귄.jpg");
			FileOutputStream fout = new FileOutputStream("d:/d_other/연습용/복사본_펭귄.jpg");
			
			int c;	// 읽어온 데이터가 저장될 변수 
			while((c = fin.read()) != -1) {
				fout.write(c);
			}
			fin.close();
			fout.close();
		}
		catch (IOException e) {
		}
	}
}