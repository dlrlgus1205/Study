package kr.or.ddit.person.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import kr.or.ddit.AbstractModelContextTest;
import kr.or.ddit.vo.PersonVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class PersonDAOTest extends AbstractModelContextTest{
	@Autowired
	PersonDAO dao;
	
	@Test
	void testSelectPersonList() {
		List<PersonVO> list = dao.selectPersonList();
		log.info("list : {}", list);
	}
	
	@Test
	void testSelectPerson() {
		PersonVO person = dao.selectPerson("M0014");
		log.info("person : {}", person);
	}
}
