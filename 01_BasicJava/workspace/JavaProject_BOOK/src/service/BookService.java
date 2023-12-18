package service;

import java.util.List;
import java.util.Map;

import dao.BookDao;
import vo.BookVo;

public class BookService {
	private static BookService instance = null;

	private BookService() {
	}

	public static BookService getnInstance() {
		if (instance == null) {
			instance = new BookService();
		}
		return instance;
	}
	
	BookDao dao = BookDao.getnInstance();

	public List<Map<String, Object>> bookHeldList() {
		return dao.bookHeldList();
	}

	public void bookBorrow(List<Object> param) {
		dao.bookBorrow(param);
	}

	public List<BookVo> bookList() {
		return dao.bookList();
	}
}
