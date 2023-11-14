package kr.or.ddit.study06.sec04.test01;

public class MethodExam02 {
	public static void main(String[] args) {
		MethodExam02 obj = new MethodExam02();
		String result = obj.method1();
		System.out.println("method1에서 리턴 받은 값 : " + result);
		int result2 = obj.method2();
		System.out.println("method2에서 리턴 받은 값 : " + result2);
	}
	
	public String method1() {
		return "test";
	}
	
	public int method2() {
		return 10;
	}
	
	public void method3() {
		 
	}
}
