package kr.or.ddit.study07.sec02.test03;

public class FountainPen extends BallPen {
	
	public int refill(int ink) {
		int re_ink = 100;
		
		if(ink == 0) ink = re_ink; 
			
		return ink;
	}
	
}
