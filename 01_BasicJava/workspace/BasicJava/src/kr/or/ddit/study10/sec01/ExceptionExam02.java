package kr.or.ddit.study10.sec01;

public class ExceptionExam02 {
	public static void main(String[] args) {
		ExceptionExam02 obj = new ExceptionExam02();
		obj.process();
	}
	
	public void process() {
		int[] arr = new int[5];
		for(int i = 0; i <= arr.length; i++) {
			arr[i] = i;
			System.out.println(i);
		}
	}
}
