package kr.or.ddit.bts.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InMemoryBtsDAOImplTest {

	@Test
	void test() {
		InMemoryBtsDAOImpl imbdi = new InMemoryBtsDAOImpl();
		imbdi.incrementHit("B001");
	}

}
