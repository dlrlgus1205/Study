package kr.or.ddit.study13.sec02;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListExam02 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		ArrayListExam02 ale = new ArrayListExam02();
		ale.process();
	}

	public void process() {
		
		/*
		 * n 명의 국어 영어 수학 점수를
		 * 리스트를 이용해 선언 및 값 저장
		 * 
		 * Student 클래스 만들어서 리스트에 넣을 것
		 * 
		 * 1. 학생 추가
		 * 2. 학생 조회
		 * 3. 학생 수정
		 * 4. 학생 삭제
		 */
		
		ArrayList list = new ArrayList();
		
		while(true) {
			
			selectview();
			int n = sc.nextInt();
			
			if(n == 1) {
				Student s = insertStudent();
				list.add(s);
			}
			else if(n == 2){
				printStudeint(list);
			}
			else if(n == 3){
				
			}
			else if(n == 4){
				deleteStudent(list);
			}
			else if(n == 5){
				System.out.println("종료");
				break;
			}
			else {
				System.out.println("[1, 2, 3, 4, 5] 입력");
			}
		}
	}
	
	public void selectview() {
		System.out.println("1. 학생 추가");
		System.out.println("2. 학생 조회");
		System.out.println("3. 학생 수정");
		System.out.println("4. 학생 삭제");
		System.out.println("5. 종료");
	}
	
	public Student insertStudent() {
		System.out.println("이름 >> ");
		String name = sc.next();
		System.out.println("국어 >> ");
		int kor = sc.nextInt();
		System.out.println("영어 >> ");
		int eng = sc.nextInt();
		System.out.println("수학 >> ");
		int math = sc.nextInt();
		System.out.println();
		return new Student(name, kor, eng, math);
	}
	
	public void printStudeint(ArrayList list) {
		for(int i = 0; i < list.size(); i++) {
			Student s = (Student)list.get(i);
			System.out.println((i + 1) + ".\t" + s);
		}
		System.out.println();
	}
	
	public void updateStudent(ArrayList list) {
		printStudeint(list);
		System.out.println("수정할 학생 선택");
		
		Student stu = null;
		int n = sc.nextInt();
		
		for(int i = 0; i < list.size(); i++) {
			
		}
	} 
	
	public void deleteStudent(ArrayList list) {
		printStudeint(list);
		System.out.println("삭제할 학생 선택");
		
		int idx = sc.nextInt() - 1;
		Student s = (Student)list.remove(idx);
		System.out.println("삭제 완료");
		System.out.println(s);
	}
}
