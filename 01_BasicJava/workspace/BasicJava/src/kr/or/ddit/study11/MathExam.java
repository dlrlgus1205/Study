package kr.or.ddit.study11;

public class MathExam {
	public static void main(String[] args) {
		double ran = Math.random();
		System.out.println(ran);
		
		// 절댓값
		int abs = Math.abs(-100);
		System.out.println(abs);
		
		int a = 30;
		int b = 10;
		int max = Math.max(a, b);
		System.out.println("최댓값 : " + max);
		
		int min = Math.min(a, b);
		System.out.println("최솟값 : " + min);
		
		// 2^4
		double pow = Math.pow(2, 4);
		System.out.println(pow);
		
		double log10 = Math.log10(100);
		System.out.println(log10);
		
		double sqrt = Math.sqrt(2);
		System.out.println(sqrt);
		
		// 반올림
		double data = 12.5154654;
		double round = Math.round(data);
		MathExam me = new MathExam();
		double result = me.round(data, 2);
		System.out.println(result);
		
		// 자연 상수
		double E = Math.E;
		// 3.14~~
		double PI = Math.PI;
	}
	
	public double round(double data, int num) {
		int temp = 1;
		for(int i = 0; i < num; i++) {
			temp *= 10;
		}
		System.out.println(Math.round(data * temp));
		return Math.round(data * temp) / temp;
	}
}
