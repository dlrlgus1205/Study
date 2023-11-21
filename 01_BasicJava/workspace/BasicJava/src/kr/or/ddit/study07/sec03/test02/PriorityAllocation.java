package kr.or.ddit.study07.sec03.test02;

public class PriorityAllocation extends Schedular {

	@Override
	void getNextCall() {
		System.out.println("우선순위가 높은 상담전화를 대기열에서 가져옴");
	}

	@Override
	void sendCallToAgent() {
		System.out.println("업무 스킬이 가장 우수한 상담원에게 상담전화를 분배");
	}

}
