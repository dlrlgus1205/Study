package kr.or.ddit.person.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import kr.or.ddit.AbstractRootContextTest;

class PersonDAOTest extends AbstractRootContextTest{

	@Autowired
	PersonDAO dao;
	
	@Test
	void testSelectPersonList() {
		dao.selectPersonList();
	}

	@Test
	void testSelectPerson() {
		dao.selectPerson("M0001");
	}

}
