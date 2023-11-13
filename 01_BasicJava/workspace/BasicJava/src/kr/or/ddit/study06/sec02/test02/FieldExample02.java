package kr.or.ddit.study06.sec02.test02;

public class FieldExample02 {
	public static void main(String[] args) {
		Computer c1 = new Computer();
		c1.cpu = "인텔";
		c1.ram = "16기가";
		c1.hdd = "1테라";
		Computer c2 = new Computer();
		c1.cpu = "인텔";
		c1.ram = "32기가";
		c1.hdd = "2테라";
		Computer c3 = new Computer();
		c1.cpu = "라이젠";
		c1.ram = "16기가";
		c1.hdd = "1테라";
		
		System.out.println(c1.name + c1);
		System.out.println(c2.name + c2);
		System.out.println(c3.name + c3);
	}
}
