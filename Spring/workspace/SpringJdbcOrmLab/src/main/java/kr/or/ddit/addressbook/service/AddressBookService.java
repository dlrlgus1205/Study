package kr.or.ddit.addressbook.service;

import java.util.List;

import kr.or.ddit.vo.AddressBookVO;

public interface AddressBookService {
	public List<AddressBookVO> selectAddressBookList();
	public int insertAddressBook(AddressBookVO address);
}
