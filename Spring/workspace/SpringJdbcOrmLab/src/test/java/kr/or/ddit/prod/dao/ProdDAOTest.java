package kr.or.ddit.prod.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import kr.or.ddit.AbstractModelContextTest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class ProdDAOTest extends AbstractModelContextTest{
	@Autowired
	ProdDAO dao;
	
	@Test
	void testSelectProdList() {
		dao.selectProdList();
		log.info("주입된 dao : {}", dao);
	}

}
