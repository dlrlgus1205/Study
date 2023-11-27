package kr.or.ddit.study13.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MapExam05 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		MapExam05 obj = new MapExam05();
		obj.process();
	}

	private void process() {
		List<Map<String, Object>> data = dataInput();
		
		// a. 전체 출력 메소드
		viewList(data);

		// b. 월급 제일 많은 사람 정보 출력
		bestSalary(data);
		
		// c. 입력된 부서 salary 총합
		sumSalary(data);
		
		// d. 입력된 emp_no 정보 전체 출력
		printEmpNo(data);
	}
	
	public List<Map<String, Object>> dataInput(){
		List<Map<String, Object>> list = new ArrayList();
		
		Map<String, Object> m1 = new HashMap();
		m1.put("emp_no", 100);
		m1.put("emp_name", "장승수");
		m1.put("dept", "영업부");
		m1.put("tel", "010-8422-8117");
		m1.put("salary", 300);
		list.add(m1);
		
		Map<String, Object> m2 = new HashMap();
		m2.put("emp_no", 101);
		m2.put("emp_name", "홍성범");
		m2.put("dept", "기획부");
		m2.put("tel", "010-7562-3217");
		m2.put("salary", 350);
		list.add(m2); 
		
		Map<String, Object> m3 = new HashMap();
		m3.put("emp_no", 102);
		m3.put("emp_name", "이만수");
		m3.put("dept", "기획부");
		m3.put("tel", "010-5562-6677");
		m3.put("salary", 500);
		list.add(m3);
		
		Map<String, Object> m4 = new HashMap();
		m4.put("emp_no", 103);
		m4.put("emp_name", "강나미");
		m4.put("dept", "영업부");
		m4.put("tel", "010-4442-5614");
		m4.put("salary", 350);
		list.add(m4);
		
		Map<String, Object> m5 = new HashMap();
		m5.put("emp_no", 109);
		m5.put("emp_name", "민병철");
		m5.put("dept", "총무부");
		m5.put("tel", "010-2542-8211");
		m5.put("salary", 250);
		list.add(m5);
		
		return list;
	}
	
	public void viewList(List<Map<String, Object>> list) {
		dataInput();
		System.out.println("전체 출력 메소드");
		System.out.println("---------------------------------------------");
		System.out.println("부서코드\t이름\t부서\t번호\t\t월급");
		
		for(int i = 0; i < list.size(); i++) {
			Map<String, Object> m = list.get(i);
			Iterator it = m.keySet().iterator();
			
			while(it.hasNext()) {
				String key = (String)it.next();
				System.out.print(m.get(key) + "\t");
			}
			System.out.println();
		}
		
		System.out.println();
//		for(int i = 0; i < list.size(); i++) {
//			Map<String, Object> m = (Map<String, Object>) list.get(i);
//			int emp_no = (int)m.get("emp_no");
//			String emp_name = (String)m.get("emp_name");
//			String dept = (String)m.get("dept");
//			String tel = (String)m.get("tel");
//			int salary = (int)m.get("salary");
//			System.out.println(emp_no + "\t" + emp_name + "\t" + dept + "\t" + tel + "\t" + salary);
//		}
		
	}
	
	public void bestSalary(List<Map<String, Object>> list) {
		dataInput();
		System.out.println("월급 제일 많은 사람");
		System.out.println("---------------------------------------------");
		Map<String, Object> mp = new HashMap();
		int max = 0;
		
		for(int i = 0; i < list.size(); i++) {
			Map m = list.get(i);
			int salary = (int)m.get("salary");
			if(max < salary) {
				max = salary;
				mp = m;
			}
		}
		System.out.println("부서코드\t이름\t부서\t번호\t\t월급");
		System.out.println(mp.get("emp_no") + "\t" + mp.get("emp_name") + "\t" + mp.get("dept") + "\t" + mp.get("tel") + "\t" + mp.get("salary"));
		System.out.println();
	}
	
	public void sumSalary(List<Map<String, Object>> list) {
		dataInput();
		System.out.println("부서 월급 총합");
		System.out.println("---------------------------------------------");
		System.out.println("부서 입력");
		String s = sc.next();
		int sum = 0;
//		while(true) {
//			
//		}
		
		for(int i = 0; i < list.size(); i++) {
			Map m = list.get(i);
			String dept = (String) m.get("dept");
			if(!dept.equals(s)) continue;
			int salary = (int) m.get("salary");
			sum+=salary;
		}
		System.out.println(sum);
	}
	
	public void printEmpNo(List<Map<String, Object>> list) {
		dataInput();
		System.out.println("부서 정보 출력");
		System.out.println("---------------------------------------------");
		System.out.println("부서 코드 입력");
		int s = sc.nextInt();
		
		for(int i = 0; i < list.size(); i++) {
			Map m = list.get(i);
			int emp_no = (int) m.get("emp_no");
			if(emp_no == s) continue;
			
			Iterator it = m.keySet().iterator();
			
			while(it.hasNext()) {
				String key = (String)it.next();
				System.out.print(m.get(key) + "\t");
			}
			
		}
	}
}
