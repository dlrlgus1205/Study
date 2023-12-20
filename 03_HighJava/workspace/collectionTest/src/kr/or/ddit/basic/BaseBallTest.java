package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/*
 * 문제) Set을 이용하여 숫자 야구 게임 프로그램을 작성하시오
 * 		컴퓨터의 숫자는 난수를 이용하여 구한다. (1 ~ 9사이의 값으로 한다.)
 * 		(스트라이크는 S, 볼은 B로 출력한다.)
 * 
 * 예) 컴퓨터의 난수 ==> 9 5 7
 * 
 * 실행 예시)
 * 숫자 입력 >> 3 5 6
 * 3 5 6 ==> 1S 0B
 * 숫자 입력 >> 7 8 9
 * 7 8 9 ==> 0S 2B
 * 숫자 입력 >> 9 7 5
 * 9 7 5 ==> 1S 2B
 * 숫자 입력 >> 9 5 7
 * 0 5 7 ==> 3S 0B
 * 
 * 4번째 만에 맞췄습니다.
 * 
 */

public class BaseBallTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		HashSet<Integer> testSet = new HashSet<Integer>();
		while(testSet.size() < 3) {
			testSet.add((int)(Math.random() * (9 - 1 + 1) + 1));
		}
		
		ArrayList<Integer> testList = new ArrayList<Integer>(testSet);
		
		System.out.println(testSet);
		
		int cnt = 0;
		
		while(true) {
			ArrayList<Integer> numList = new ArrayList<Integer>();
			System.out.println("숫자 입력 >> ");
			for(int i = 0; i < 3; i ++) {
				numList.add(sc.nextInt());
			}
			
			int s = 0;
			int b = 0;
			cnt++;
			
			if(numList.get(0) == testList.get(0)) {
				s++;
			}
			else if(numList.get(0) == testList.get(1)) {
				b++;
			}
			else if(numList.get(0) == testList.get(2)) {
				b++;
			}
			
			if(numList.get(1) == testList.get(1)) {
				s++;
			}
			else if(numList.get(1) == testList.get(0)) {
				b++;
			}
			else if(numList.get(1) == testList.get(2)) {
				b++;
			}
			
			if(numList.get(2) == testList.get(2)) {
				s++;
			}
			else if(numList.get(2) == testList.get(0)) {
				b++;
			}
			else if(numList.get(2) == testList.get(1)) {
				b++;
			}
			
			System.out.println(s + "S " + b + "B");
			
			if(s == 3) {
				System.out.println("정답까지 "+ cnt +"번 시도 하셨습니다.");
				break;
			}
		}
	}
}
