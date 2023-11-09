package kr.or.ddit.study05.sec01;

public class VarExample {
	
	int a = 10;
	static int b = 11;
	
	public static void main(String[] args) {
		System.out.println(b);
		
		
		int c = 12;
		System.out.println(c);
		
		VarExample ve = new VarExample();
		System.out.println(ve.a);
		
		ve.method1();
	}
	
	public void method1() {
		int d = 13;
		if(true) {
			int e = 14;
			for(int i = 0; i < 10; i++) {
				System.out.println();
			}
		}
	}
}
