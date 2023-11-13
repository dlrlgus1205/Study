package kr.or.ddit.study06.sec02.test02;

public class Computer {
	static String name = "컴퓨터";
	String cpu;
	String ram;
	String hdd;
	@Override
	public String toString() {
		return "Computer [cpu=" + cpu + ", ram=" + ram + ", hdd=" + hdd + "]";
	}
}
