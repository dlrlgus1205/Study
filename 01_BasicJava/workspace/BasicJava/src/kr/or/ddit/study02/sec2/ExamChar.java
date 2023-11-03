package kr.or.ddit.study02.sec2;

public class ExamChar {
	public static void main(String[] args) {
		/*
		 * char 문자 하나를 표현 가능
		 * 'a' 작은 따옴표로 문자 표현
		 */
		
		char ch = 'a';
		int c = ch-32;
		char ch2 = (char)c;
		
		System.out.println(c);
		System.out.println(ch);
		System.out.println(ch2);
	}
}
