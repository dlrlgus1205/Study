package kr.or.ddit.buyer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.or.ddit.vo.BuyerVO;

@Mapper
public interface BuyerDAO {
//	insert
	/**
	 * 거래처아이디, 거래처명, 분류코드(분류명), 소재지, 담당자명, 전화번호
	 * @return
	 */
	public List<BuyerVO> selectBuyerList();
	
	public BuyerVO selectBuyer(@Param("buyerId") String buyerId);
//	update
}
