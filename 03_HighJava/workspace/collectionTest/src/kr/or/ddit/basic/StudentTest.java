package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
    문제) 학번, 이름, 국어점수, 영어점수, 수학점수, 총점, 등수를 멤버로 갖는 Student클래스를 만든다.
             이 Student클래스의 생성자에서는 학번, 이름, 국어점수, 영어점수, 수학점수만 매개변수로 받아서
             초기화 처리를 한다. (총점은 3과목 점수의 합계로 초기화 한다.)

             이 Student객체는 List에 저장하여 관리한다.

       List에 저장된 데이터들을 학번의 오름차순으로 정렬할 수 있는 내부 정렬 기준을 구현하고,
            총점의 내림차순으로 정렬하는데 총점이 같으면 이름의 오름차순으로 정렬되는 외부 정렬 기준 클래스를
            작성하여 정렬된 결과를 출력하시오.

       (단, 등수는 List에 전체 데이터가 추가된 후에 저장되도록 한다.)
 */
public class StudentTest {
	public static void main(String[] args) {
		ArrayList<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student(1, "카리나", 100, 100, 100));
		studentList.add(new Student(8, "홍은채", 80, 80, 80));
		studentList.add(new Student(5, "김민정", 80, 80, 80));
		studentList.add(new Student(13, "장원영", 90, 90, 90));
		studentList.add(new Student(9, "안유진", 90, 90, 90));
		studentList.add(new Student(7, "조유리", 85, 85, 85));
		studentList.add(new Student(2, "김채원", 85, 85, 85));
		
		for(Student stu : studentList) {
			int rank = 1;
			for(Student stu1 : studentList) {
				if(stu.getSum() < stu1.getSum()) {
					rank++;
				}
				stu.setRank(rank);
			}
			
		}
		
		System.out.println("정렬 전");
		for (Student stu : studentList) {
			System.out.println(stu);
		}
		System.out.println("-------------------------------------------------------------------");
		
		Collections.sort(studentList);
		
		System.out.println("학번 오름차순 정렬 후");
		for (Student stu : studentList) {
			System.out.println(stu);
		}
		System.out.println("-------------------------------------------------------------------");
		
		Collections.sort(studentList, new SumDesc());
		
		System.out.println("총점 내림차순 정렬 후");
		for (Student stu : studentList) {
			System.out.println(stu);
		}
		System.out.println("-------------------------------------------------------------------");

		Collections.sort(studentList, new NameAsc());
		
		System.out.println("이름 오름차순 정렬 후");
		for (Student stu : studentList) {
			System.out.println(stu);
		}
		System.out.println("-------------------------------------------------------------------");
	}
}

class Student implements Comparable<Student> {
	private int num;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int sum;
	private int rank;
	
	public Student(int num, String name, int kor, int eng, int math) {
		super();
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		sum = kor + eng + math;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int kor, int eng, int math) {
		this.sum = kor + eng + math;
	}
	
	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Stundent [num=" + num + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", sum="
				+ sum + ", rank=" + rank + "]";
	}

	@Override
	public int compareTo(Student stu) {
		return this.getNum() - stu.getNum();
	}
}

class SumDesc implements Comparator<Student> {

	@Override
	public int compare(Student stu1, Student stu2) {
		return stu2.getSum() - stu1.getSum();
	}
	
}

class NameAsc implements Comparator<Student> {

	@Override
	public int compare(Student stu1, Student stu2) {
		if(stu1.getSum() > stu2.getSum()) {
			return -1;
		}
		
		else if(stu1.getSum() < stu2.getSum()) {
			return 1;
		}
		
		else if(stu1.getSum() == stu2.getSum()) {
			
			if(stu1.getName().compareTo(stu2.getName()) > 0) {
				return 1;
			}
			
			else if(stu1.getName().compareTo(stu2.getName()) < 0) {
				return -1;
			}
			
		}
		
			return 0;
	}
	
}