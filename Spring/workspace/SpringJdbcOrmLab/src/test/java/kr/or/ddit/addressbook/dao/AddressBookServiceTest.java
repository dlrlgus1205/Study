package kr.or.ddit.addressbook.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.AbstractModelContextTest;
import kr.or.ddit.addressbook.service.AddressBookService;
import kr.or.ddit.vo.AddressBookVO;

@Transactional // AOP 방법에 따른 트랜잭션 관리
class AddressBookServiceTest extends AbstractModelContextTest{
	@Autowired
	AddressBookService service;
	
	@Test
	void testSelectAddressBookList() {
		List<AddressBookVO> list = service.selectAddressBookList();
	}

	@Test
	void testInsertAddressBook() {
		AddressBookVO address = new AddressBookVO();
		address.setMemId("a001");
		address.setAdrsName("닌");
		address.setAdrsTel("닌");
		address.setAdrsAdd("닌");
		
		service.insertAddressBook(address);
	}
}