package kr.or.ddit.study08.sec01;

public class PriorityAllocation implements Schedular {

	@Override
	public void getNextCall() {
		System.out.println("우선순위가 높은 상담전화를 대기열에서 가져옴");
	}

	@Override
	public void sendCallToAgent() {
		System.out.println("업무 스킬이 가장 우수한 상담원에게 상담전화를 분배");
	}

}
