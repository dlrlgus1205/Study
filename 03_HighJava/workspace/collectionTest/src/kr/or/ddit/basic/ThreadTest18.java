package kr.or.ddit.basic;

/*
 * 
 */
public class ThreadTest18 {
	public static void main(String[] args) {
		WorkObject workObj = new WorkObject();
		
		ThreadA thA = new ThreadA(workObj); 
		ThreadB thB = new ThreadB(workObj);
		
		thA.start();
		thB.start();
	}
}

// 공통으로 사용할 객체
class WorkObject {
	public synchronized void method01() {
		System.out.println("method01() 메서드 실행 중...");
		
		notify();
		
		try {
			wait();
		}
		catch (InterruptedException e) {
		}
	}
	
	public synchronized void method02() {
		System.out.println("method02() 메서드 실행 중...");
		
		notify();
		
		try {
			wait();
		}
		catch (InterruptedException e) {
		}
	}
}

// WorkObject(공통으로 사용하는 객체)의 method01() 메서드만 호출하는 쓰레드
class ThreadA extends Thread {
	private WorkObject workObj;
	
	public ThreadA(WorkObject workObj) {
		this.workObj = workObj;
	}
	
	@Override
	public void run() {
		for(int i = 1; i < 11; i++) {
			workObj.method01();
		}
	}
}

// WorkObject의 method02() 메서드만 호출하는 쓰레드
class ThreadB extends Thread {
	private WorkObject workObj;
	
	public ThreadB(WorkObject workObj) {
		this.workObj = workObj;
	}
	
	@Override
	public void run() {
		for(int i = 1; i < 11; i++) {
			workObj.method02();
		}
	}
}