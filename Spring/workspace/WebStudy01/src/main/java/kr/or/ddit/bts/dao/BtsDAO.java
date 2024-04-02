package kr.or.ddit.bts.dao;

import java.util.List;

import kr.or.ddit.vo.BtsVO;

/**
 *	Persistence Layer
 */
public interface BtsDAO {
	
	/**
	 * 한 명의 멤버 조회
	 * @param code
	 * @return 없으면 null 반환
	 */
	public BtsVO selectBts(String code);
	
	/**
	 * BTS 멤버 전체 조회
	 * @return
	 */
	public List<BtsVO> selectBtsList();
	
	/**
	 * 한 사람의 멤버가 조회될 때 조회수를 증가
	 * @param code
	 */
	public void incrementHit(String code);
}
