package dao;

import java.util.List;

import util.JDBCUtil;
import vo.BookVo;

public class BookDao {
	private static BookDao instance = null;

	private BookDao() {
	}

	public static BookDao getInstance() {
		if (instance == null) {
			instance = new BookDao();
		}
		return instance;
	}
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public List<BookVo> bookList() {
		String sql = "SELECT *"
				+ 	 "  FROM BOOK02"
				+    " WHERE DEL_YN = 'N'";
		return jdbc.selectList(sql, BookVo.class);
	}
	
	public void bookInsert(List<Object> param) {
		String sql = " INSERT INTO BOOK02(BOOK_NO,NAME,CONTENT,WRITER)\r\n" + 
				"     VALUES ((SELECT MAX(BOOK_NO)+1 FROM BOOK02),?,?,?)";
		jdbc.update(sql,param);
	}

	public void bookDelete(List<Object> param) {
		String sql = "UPDATE BOOK02\r\n" + 
				"        SET DEL_YN = 'Y'\r\n" + 
				"      WHERE BOOK_NO = ?";
		 jdbc.update(sql, param);
		
	}

	public void bookHeldList(List<Object> param, int bookno) {
		String sql ="  UPDATE BOOK02\r\n" + 
				"       SET RENT_YN = 'Y'\r\n" + 
				"      WHERE BOOK_NO =  "+bookno;
		jdbc.update(sql);
		
	}
}
