package kr.or.ddit.study06.sec04.test05;

public class MetodRecursion {
	public static void main(String[] args) {
		MetodRecursion mr = new MetodRecursion();
		int result1 = mr.pow(3);
		System.out.println(result1);
		// 1 ~ 10의 합
		int result2 = mr.sum(10);
		System.out.println(result2);
		int result3 = mr.fibonacci(9);
		System.out.println(result3);
		
	}
	
	public int pow(int t) {
		// 1번째 종료 조건
		if(t == 0) {
			return 1;
		}
		return 2 * pow(t - 1);
	}
	
	public int sum(int t) {
		if(t == 1) return 1;
		return t + sum(t - 1);
	}
	
	public int fibonacci(int n) {
		if(n == 1 || n == 2) return 1;
		return fibonacci(n - 2) + fibonacci(n - 1);
	}
}
