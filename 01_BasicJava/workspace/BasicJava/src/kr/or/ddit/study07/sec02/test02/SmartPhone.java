package kr.or.ddit.study07.sec02.test02;

public class SmartPhone extends Phone {
	
	public void touch() {
		System.out.println("터치 기능");
	}

	@Override
	public void camera() {
		System.out.println("1000만 화소 사진 기능");
	}
	
}
