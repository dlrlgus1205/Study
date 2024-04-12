package kr.or.ddit.addressbook.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.ddit.addressbook.dao.AddressBookDAO;
import kr.or.ddit.vo.AddressBookVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddressBookServiceImpl implements AddressBookService {
	private final AddressBookDAO dao;

	@Override
	public List<AddressBookVO> selectAddressBookList() {
		return dao.selectAddressBookList();
	}

	@Override
	public int insertAddressBook(AddressBookVO address) {
		return dao.insertAddressBook(address);
	}

}
