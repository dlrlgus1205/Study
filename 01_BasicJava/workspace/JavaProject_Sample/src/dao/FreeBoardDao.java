package dao;

import java.util.List;
import java.util.Map;

import util.JDBCUtil;

/**
 * 자유게시판
 * 작성자 : lgh
 * 작성일 : 2023.11.28
 * 
 * 자유게시판 쿼리를 위한 클래스
 * 
 * 수정 : lgh
 * 수정일 : 2023.11.30
 * 자유게시판 조회 쿼리 추가
 *
 */
public class FreeBoardDao {
	private static FreeBoardDao instance = null;

	private FreeBoardDao() {
	}

	public static FreeBoardDao getnInstance() {
		if (instance == null) {
			instance = new FreeBoardDao();
		}
		return instance;
	}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();

	public List<Map<String, Object>> freeList() {
		String sql = " SELECT NO, TITLE, SUBSTR(CONTENT, 1, 10) CONTENT, WRITER, COUNT,\r\n" + 
					 " TO_CHAR(REG_DATE, 'yyyy-mm-dd') REG_DATE\r\n" + 
					 " FROM FREE_BOARD\r\n" + 
					 " WHERE DEL_YN = 'N'\r\n" + 
					 " ORDER BY NO DESC";
	
		return jdbc.selectList(sql);
	}

	public void updateBoard(List<Object> param, String colum) {
		String format = "UPDATE FREE_BOARD\r\n" + 
						"   SET %s = ?\r\n" + 
						" WHERE NO = ?";

		String sql = String.format(format, colum);
		jdbc.update(sql, param);
	}

	public Map<String, Object> freeDetail(int no) {
		String sql = " SELECT NO, TITLE, CONTENT, WRITER, TO_CHAR(REG_DATE, 'yyyy-mm-dd') REG_DATE, COUNT\r\n" + 
				     " FROM FREE_BOARD\r\n" + 
				 	 " WHERE NO = " + no;
	
		return jdbc.selectOne(sql);
	}

	public int writeBoard(List<Object> param) {
		String sql = " INSERT INTO FREE_BOARD\r\n" + 
					 " (NO, TITLE, CONTENT, WRITER)\r\n" + 
					 " VALUES\r\n" + 
					 " ((SELECT MAX(NO) + 1 FROM FREE_BOARD), ?, ?, ?)";
		
		return jdbc.update(sql, param);
	}
}
