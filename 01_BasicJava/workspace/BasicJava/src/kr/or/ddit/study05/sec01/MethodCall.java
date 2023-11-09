package kr.or.ddit.study05.sec01;

public class MethodCall {
	
	int a = 10;
	static int b = 10;
	
	public static void main(String[] args) {
		MethodCall obj = new MethodCall();
		obj.method1();
		System.out.println(b);
		System.out.println(obj.a);
	}
	public void method1() {
		
	}
}
