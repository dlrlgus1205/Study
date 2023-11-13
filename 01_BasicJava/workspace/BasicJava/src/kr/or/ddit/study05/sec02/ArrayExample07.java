package kr.or.ddit.study05.sec02;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayExample07 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayExample07 obj = new ArrayExample07();
//		obj.shallow();
		/*
		 * deepCopy : 깊은 복사
		 * 배열 공간이 별도로 확보(메모리에 신규 할당)되고 내용이 복사되는 방식
		 * clone, System.arraycopy(), for 문을 이용
		 */
//		obj.deepCopy01();
//		obj.deepCopy02();
//		obj.deepCopy03();
	}

	private void deepCopy03() {
		String[] source1 = {"a1", "a2", "a3"};
		String[] source2 = {"b1", "b2", "b3"};
		String[] target = new String[6];
		// 원본배열명, 복사해줄 위치, 복사배열명, 복사받을 위치, 개수
		System.arraycopy(source1, 0, target, 0, 3);
		System.arraycopy(source2, 0, target, 3, 3);
		target[0] = "b1";
		
		System.out.println("source : " + Arrays.toString(source1));
		System.out.println("source : " + Arrays.toString(source2));
		System.out.println("source : " + Arrays.toString(target));
	}

	private void deepCopy02() {
		String[] source = {"a1", "a2", "a3"};
		String[] target = source.clone();
		// Object class의 clone 사용
		target[0] = "b1";
		
		System.out.println("source : " + Arrays.toString(source));
		System.out.println("source : " + Arrays.toString(target));
	}

	private void deepCopy01() {
		String[] source = {"a1", "a2", "a3"};
		String[] target = new String[source.length];
		// for 문을 이용한 방법
		
		for(int i = 0; i < source.length; i++) {
			target[i] = source[i];
		}
		target[0] = "b1";
		System.out.println("source : " + Arrays.toString(source));
		System.out.println("source : " + Arrays.toString(target));
	}

	private void shallow() {
		// shallow copy 얕은 복사
		// 배열명이 가지고 있는 배열의 주소 값만 복사
		// 부작용 발생 메소드의 매개변수 전달 방식이 이 복사 방법
		String[] source = {"a1", "a2", "a3"};
		String[] target = source;
		
		target[0] = "b1";
		System.out.println(source[0]);
		System.out.println(target[0]);
	}
}
