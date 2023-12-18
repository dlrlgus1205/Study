package service;

import java.util.List;

import dao.BookDao;
import vo.BookVo;

public class BookService {
	private static BookService instance = null;

	private BookService() {
	}

	public static BookService getInstance() {
		if (instance == null) {
			instance = new BookService();
		}
		return instance;
	}
	BookDao dao = BookDao.getInstance();
	
	public List<BookVo> bookList() {
		return dao.bookList();
	}
	
	public void bookInsert(List<Object> param) {
		  dao.bookInsert(param);
	}

	public void bookDelete(List<Object> param) {
		dao.bookDelete(param);
		
	}

	public void bookHeldList(List<Object> param, int bookno) {
		dao.bookHeldList(param, bookno); 
	}
}
