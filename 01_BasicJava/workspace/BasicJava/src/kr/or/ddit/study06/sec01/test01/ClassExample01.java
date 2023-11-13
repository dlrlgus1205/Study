package kr.or.ddit.study06.sec01.test01;

public class ClassExample01 {
	public static void main(String[] args) {
		Product prod1 = new Product();
		prod1.prodname = "컴퓨터";
		prod1.prodno = 101;
		Product prod2 = new Product();
		prod2.prodname = "TV";
		prod2.prodno = 102;
		Product prod3 = new Product();
		prod3.prodname = "스마트폰";
		prod3.prodno = 103;
		
		System.out.println(prod1);
		System.out.println(prod2);
		System.out.println(prod3);
	}
}
