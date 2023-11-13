package kr.or.ddit.study06.sec01.test02;

public class Book {
	int price;
	String name;
	String writer;
	@Override
	public String toString() {
		return "책 [가격 = " + price + ", 이름 = " + name + ", 작가 = " + writer + "]";
	}
}
