package kr.or.ddit.lprod.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import kr.or.ddit.AbstractRootContextTest;


class OthersServiceImplTest extends AbstractRootContextTest{
	
	@Autowired
	OthersService service;
	
	@Test
	void testRetrieveLprodList() {
		service.retrieveLprodList();
	}

	@Test
	void testRetrieveBuyerList() {
		service.retrieveBuyerList();
	}

}
