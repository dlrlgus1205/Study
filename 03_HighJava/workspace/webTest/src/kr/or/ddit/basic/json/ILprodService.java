package kr.or.ddit.basic.json;

import java.util.List;

public interface ILprodService {
	/**
	 * Lprod테이블의 전체 목록을 가져와 List에 담아서 반환하는 메서드
	 *  
	 * @return Lprod 전체 목록이 저장된 List 객체
	 */
	public List<LprodVo> getAllLprod();
}
