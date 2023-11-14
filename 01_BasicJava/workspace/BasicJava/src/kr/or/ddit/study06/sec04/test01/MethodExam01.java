package kr.or.ddit.study06.sec04.test01;

public class MethodExam01 {
	public static void main(String[] args) {
		MethodExam01 obj = new MethodExam01();
		obj.method1("테스트1");
		obj.method1("테스트2");
		obj.method1("test");
	}
	
	public void method1(String param) {
		System.out.println("외부에서 준 파라미터 값 : " + param);
	}
}
