package Level0;

public class Age {
	public static void main(String[] args) {
		Age age = new Age();
		age.solution(30);
	}
	public int solution(int age) {
		int answer = 2022 - age;
		System.out.println(age);
		return answer;
	}
}
