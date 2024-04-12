package kr.or.ddit.prod.dao;

import java.util.List;

import kr.or.ddit.vo.ProdVO;

/**
 * 상품 관리(CRUD)
 *
 */
public interface ProdDAO {
	/**
	 * 상품 등록
	 * @param prod
	 * @return 등록된 레코드 수
	 */
	public int insertProd(ProdVO prod);
	
	/**
	 * 상품 목록 조회
	 * 상품코드, 거래처코드, 분류코드, 상품명, 구매가, 판매가, 마일리지, 입고일
	 * @return 존재하지 않으면, list.size ==0;
	 */
	public List<ProdVO> selectProdList();
	
	/**
	 * 상품 상세 조회
	 * @param prodId
	 * @return 존재하지 않으면 null 반환
	 */
	public ProdVO selectProd(String prodId);
	
	/**
	 * 상품 정보 수정
	 * @param prod
	 * @return 수정된 레코드 수
	 */
	public int updateProd(ProdVO prod);
}
