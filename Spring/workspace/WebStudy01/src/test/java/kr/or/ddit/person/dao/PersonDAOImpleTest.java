package kr.or.ddit.person.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.vo.PersonVO;

public class PersonDAOImpleTest {
	PersonDAO dao = new PersonDAOImple();
	
	@Test
	public void testSelectPersonList() {
		List<PersonVO> people = dao.selectPersonList();
		System.out.println(people.size());
	}

	@Test
	public void testSelectPerson() {
		// assertion 구조를 통해 테스트 결과를 추정함
		assertNotNull(dao.selectPerson("A0011"));
	}
	
	@Test
	public void testSelectPersonNotExist() {
		// assertion 구조를 통해 테스트 결과를 추정함
		assertNull(dao.selectPerson("asdf"));
	}

}
