package day03;

public class MyDef01 {
	public static void main(String[] args) {
		int sum = add(4, 2);
		int min = minus(4, 2);
		int mul = multiply(4, 2);
		int div = divide(4, 2);
		
		System.out.println("sum" + sum);
		System.out.println("min" + min);
		System.out.println("mul" + mul);
		System.out.println("div" + div);
	}
	
	public static int add(int a, int b) {
		return a + b;
	}

	public static int minus(int a, int b) {
		return a - b;
	}
	
	public static int multiply(int a, int b) {
		return a * b;
	}
	
	public static int divide(int a, int b) {
		return a / b;
	}
}
