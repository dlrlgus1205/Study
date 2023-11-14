package kr.or.ddit.study06.sec04.test01;

public class MethodExam03 {
	public static void main(String[] args) {
		MethodExam03 obj = new MethodExam03();
		int add = obj.add(10, 3);
		int sub = obj.sub(10, 3);
		int mul = obj.mul(10, 3);
		double div = obj.div(10, 3);
		System.out.println("add 받은 리턴 값 : " + add);
		System.out.println("sub 받은 리턴 값 : " + sub);
		System.out.println("mul 받은 리턴 값 : " + mul);
		System.out.println("div 받은 리턴 값 : " + div);
	}
	
	public int add(int a, int b) {
		return a + b;
	}
	
	public int sub(int a, int b) {
		return a - b;
	}
	
	public int mul(int a, int b) {
		return a * b;
	}
	
	public double div(int a, int b) {
		return (double)(a / b);
	}
}
