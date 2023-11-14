package kr.or.ddit.study06.homework;

public class Tv {
	
	String com;
	int year;
	int size;

	public static void main(String[] args) {
		Tv tv = new Tv("삼성", 2023, 80);
		System.out.println(tv);
	}
	
	public Tv(String com, int year, int size) {
		this.com = com;
		this.year = year;
		this.size = size;
	}

	@Override
	public String toString() {
		return "Tv [제조사 = " + com + ", 생산년도 = " + year + ", 크기 = " + size + "인치]";
	}
	
	
}
