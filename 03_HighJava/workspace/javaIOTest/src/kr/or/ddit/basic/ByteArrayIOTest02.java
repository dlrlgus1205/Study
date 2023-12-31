package kr.or.ddit.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayIOTest02 {
	public static void main(String[] args) {
		byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		byte[] outSrc = null;
		byte[] temp = new byte[4];	// 4개짜리 byte 배열 생성
		
		// 입력용 스트림 객체 생성
		ByteArrayInputStream bin = new ByteArrayInputStream(inSrc);
		// 출력용 스트림 객체 생성
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		
		try {
			// 읽어올 데이터가 있는지 확인
			while(bin.available() > 0) {
//				bin.read(temp);
//				bout.write(temp);
				
				// 실제 읽어온 byte 수를 반환한다
				int len = bin.read(temp);
				
				// temp 배열의 데이터들 중에서 0번째부터 len 개수만큼 출력한다
				bout.write(temp, 0, len);
				
				System.out.println("temp => " + Arrays.toString(temp));
			}
			System.out.println();
			
			outSrc = bout.toByteArray();
			
			bin.close();
			bout.close();
			
			System.out.println("inSrc => " + Arrays.toString(inSrc));
			System.out.println("outSrc => " + Arrays.toString(outSrc));
		}
		catch (IOException e) {
		}
	}
}
