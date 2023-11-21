package kr.or.ddit.study06.sec06.test04;

public class Book {
	
	private String name;
	private int price;
	private String writer;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	@Override
	public String toString() {
		return "[이름 = " + name + ", 가격  = " + price + ", 작가 = " + writer + "]";
	}
	
}
