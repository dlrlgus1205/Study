package kr.or.ddit.study05;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class Free02 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		Free02 obj = new Free02();
//		obj.process();
		List<Integer> list = new ArrayList();
		for(int i = 0; i < 100; i++) {
			list.add(i);
//			System.out.println(list);
		}
		for(int i = 0; i < 100; i++) {
		int a = list.get(i);
		System.out.println(a);
		}
		
		Iterator it = list.iterator();
	}
	
//	private void process() {
//	}
	
}
