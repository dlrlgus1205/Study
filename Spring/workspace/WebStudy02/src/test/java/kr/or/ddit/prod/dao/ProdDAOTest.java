package kr.or.ddit.prod.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import kr.or.ddit.vo.ProdVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class ProdDAOTest {
	ProdDAO dao = new ProdDAOImpl();
	
	@Test
	void testInsertProd() {
		ProdVO prod = new ProdVO();
		prod.setProdName("잉");
		prod.setProdLgu("P101");
		prod.setProdBuyer("P10101");
		prod.setProdCost(500L);
		prod.setProdPrice(5000L);
		prod.setProdSale(2500L);
		prod.setProdOutline("잉");
		prod.setProdImg("잉");
		prod.setProdTotalstock(0L);
		prod.setProdProperstock(0L);
		int rowcnt = dao.insertProd(prod);
		assertEquals(1, rowcnt);
		log.info("ProdVO : {}", prod);
	}

	@Test
	void testSelectProdList() {
		List<ProdVO> prodList = dao.selectProdList();
		log.info("list : {}", prodList);
	}

	@Test
	void testSelectProd() {
		String prodId = "P101000001";
		ProdVO prod = dao.selectProd(prodId);
		log.info("ProdVO : {}", prod);
	}

	@Test
	void testUpdateProd() {
		fail("Not yet implemented");
	}

}
