package kr.or.ddit.study07.sec03.test02;

public class RoundRobin extends Schedular {

	@Override
	void getNextCall() {
		System.out.println("상담전화를 대기열에서 차례대로 가져옴");
	}

	@Override
	void sendCallToAgent() {
		System.out.println("차례대로 다음 상담원에게 상담전화를 분배");
	}

}
