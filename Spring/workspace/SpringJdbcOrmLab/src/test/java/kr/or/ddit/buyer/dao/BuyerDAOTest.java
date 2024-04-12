package kr.or.ddit.buyer.dao;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;

import kr.or.ddit.AbstractModelContextTest;

class BuyerDAOTest extends AbstractModelContextTest{
	@Resource(name = "buyerDAO")
	BuyerDAO buyerDAO;

	@Test
	void testSelectBuyerList() {
		buyerDAO.selectBuyerList();
	}

}
