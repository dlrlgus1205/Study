package kr.or.ddit.case5.person.service;

import java.util.List;

import kr.or.ddit.case5.person.dao.PersonDAO;
import kr.or.ddit.case5.person.dao.PersonDAOImple;
import kr.or.ddit.case5.person.exception.PersonNotFoundException;
import kr.or.ddit.vo.PersonVO;

public class PersonServiceImpl implements PersonService{
	private PersonDAO dao = new PersonDAOImple();
	
	@Override
	public List<PersonVO> retrievePersonList() {
		List<PersonVO> people = dao.selectPersonList();
		for (PersonVO once : people) {
			System.out.printf("%s 조회\n", once.getName());
		}
		return people;
	}

	@Override
	public PersonVO retrievePerson(String id) {
		PersonVO person = dao.selectPerson(id);
		if(person == null)
			throw new PersonNotFoundException(id);
		return person;
	}
	
}
