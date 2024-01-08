package kr.or.ddit.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayIOTest01 {
	public static void main(String[] args) {
		byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		byte[] outSrc = null;
		
		// 입력용 스트림 객체 생성
		ByteArrayInputStream bin = new ByteArrayInputStream(inSrc);
		// 출력용 스트림 객체 생성
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		
		int data;		// 읽어온 자료가 저장될 변수
		
		while((data = bin.read()) != -1) {
			// 읽어온 데이터를 처리하는 명령을 반복문 안에 기술하면 된다
			
			bout.write(data);		// 출력하기
		}
		
		// 출력된 스트림 값을 배열로 변환해서 저장하기
		outSrc = bout.toByteArray();
		
		// 스트림을 닫아준다
		try {
			bin.close();
			bout.close();
		}
		catch (IOException e) {
		}
		
		System.out.println("inSrc => " + Arrays.toString(inSrc));
		System.out.println("OutSrc => " + Arrays.toString(outSrc));
	}
}
