package kr.or.ddit.study04.sec02;

import java.util.Scanner;

public class HangMan {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		HangMan obj = new HangMan();
		obj.process();
	}

	private void process() {
		/*
		 * 문자열 맞추는 게임
		 * ㅁㅁㅁㅁㅁ
		 * ex) 정답 : apple
		 * a 입력시
		 * aㅁㅁㅁㅁ
		 * 완료될 때까지 시행
		 */
		
		String question = "apple";
		int cnt = 0;
		char[] answer = new char[question.length()];
		for(int i = 0; i < question.length(); i++) {
			answer[i] = 'ㅁ';
		}
		while(true) {
			for(int i = 0; i < question.length(); i++) {
				System.out.print(answer[i]);
			}
			System.out.println();
			cnt++;
			System.out.println("문자 입력 : ");
			String str = sc.nextLine();
			char ch = str.charAt(0);
			for(int i = 0; i < question.length(); i++) {
				if(ch == question.charAt(i)) {
					answer[i] = ch;
				}
			}
			String com = "";
			for(int i = 0; i < answer.length; i++) {
				com += answer[i];
			}
			if(com.equals(question)) {
				System.out.println("정답\n" + cnt + "번 입력");
				break;
			}
		}
	}
}
