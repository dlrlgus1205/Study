package kr.or.ddit.person.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import kr.or.ddit.AbstractRootContextTest;

class PersonServiceImplTest extends AbstractRootContextTest{

	@Autowired
	PersonService service;
	@Test
	void testRetrievePersonList() {
		service.retrievePersonList();
	}

	@Test
	void testRetrievePerson() {
		service.retrievePerson("H0011");
	}

}
