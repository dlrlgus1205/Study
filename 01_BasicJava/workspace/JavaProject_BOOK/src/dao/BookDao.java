package dao;

import java.util.List;
import java.util.Map;

import util.JDBCUtil;
import vo.BookVo;

public class BookDao {
	private static BookDao instance = null;

	private BookDao() {
	}

	public static BookDao getnInstance() {
		if (instance == null) {
			instance = new BookDao();
		}
		return instance;
	}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();

	public List<Map<String, Object>> bookHeldList() {
		String sql = " SELECT BH.BOOK_ID, B.*\r\n" + 
					 " FROM BOOK_HELD BH LEFT JOIN BOOK_RENT BR\r\n" + 
					 " ON BH.BOOK_ID = BR.BOOK_ID,\r\n" + 
					 " BOOK B\r\n" + 
					 " WHERE BH.BOOK_NO = B.BOOK_NO\r\n" + 
					 " AND BR.RENT_NO IS NULL\r\n" + 
					 " ORDER BY BH.BOOK_NO";
		
		return jdbc.selectList(sql);
	}
	
	
	public void bookBorrow(List<Object> param) {
		String sql = " INSERT INTO BOOK_RENT (RENT_NO, BOOK_ID, MEM_NO)\r\n" + 
					 " VALUES ((SELECT MAX(RENT_NO) + 1 FROM BOOK_RENT), ?, ?)";
		
		jdbc.update(sql, param);
	}

	public List<BookVo> bookList() {
		String sql = "SELECT * FROM BOOK";
		
		return jdbc.selectList(sql, BookVo.class);
	}

}
