package kr.or.ddit.study05.homework;

import java.util.Random;
import java.util.Scanner;

public class HomeWork5 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		HomeWork5 obj = new HomeWork5();
		obj.process();
	}

	private void process() {
		
		String[] words = {"apple", "banana", "melon", "strawberry"};
		int ran = new Random().nextInt(words.length);
		String ans = words[ran];
		int n = 0;
		
		// 단어 문자들 섞기
		char[] cArray = ans.toCharArray();
		
		for (int i = 0; i < 100000; i++) {
			int suffle = new Random().nextInt(ans.length());
			char temp = cArray[0];
			cArray[0] = cArray[suffle];
			cArray[suffle] = temp;
		}
		
		for (int i = 0; i < cArray.length; i++) {
			System.out.print(cArray[i]);
		}
		System.out.println();
		System.out.print("단어 입력 : ");
		while(true) {
			n++;
			String str = sc.nextLine();
			if(str.equals(ans)) {
				System.out.println("정답");
				System.out.println(n + "번 시도");
				break;
			}
			else {
				System.out.println("오답");
			}
		}
		/*
		 * 맞출 때까지 실행 
		 * 말출 경우 종료 후 실행 횟수 출력 
		 */
	}
}
