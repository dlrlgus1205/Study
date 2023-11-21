package kr.or.ddit.study06.sec05.test01;

public class SingleTon {
	// 싱글톤 객체를 저장하기 위한 곳
	private static SingleTon singleTon = null;
	
	// 기본생성자를 만들어 외부에서 접근을 금지
	private SingleTon() {
		
	}
	
	// 외부에서 객체 생성을 위해서는 반드시 getInstance를 통해서 가져가야함
	public static SingleTon getInstance() {
		
		// singleton 객체가 생성 안됐을 경우
		if(singleTon == null) {
			// 싱글톤 객체를  새로 만듬
			singleTon = new SingleTon();
		}
		// singleton 객체를 리턴
		return singleTon;
	}
}


// 싱글톤의 기본적인 방법