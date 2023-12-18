package dao;

import java.awt.image.DataBufferDouble;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.JDBCUtil;

/**
 * 	DAO 디비 접속을 위한 클래스
 * 	디비 접속을 여러번 하면 사용이 어렵기 때문에
 * 	MVC 패턴에선 기본적으로 싱글톤 패턴을 적용함
 */

public class FreeDao {
	
	private static FreeDao instance = null;

	private FreeDao() {
	}

	public static FreeDao getnInstance() {
		if (instance == null) {
			instance = new FreeDao();
		}
		return instance;
	}
	
	JDBCUtil jdbc =JDBCUtil.getInstance();
	
	public static void main(String[] args) {
		FreeDao dao = new FreeDao();
//		List<Object> param = new ArrayList();
//		param.add("자바 인서트 쿼리");
//		param.add("내용");
//		param.add("자바");
//		dao.insertFreeBoard(param);
	}
	
	public int insertFreeBoard(List<Object> param) {
		String sql = " INSERT INTO FREE_BOARD\r\n" + 
					 " (NO, TITLE, CONTENT, WRITER)\r\n" + 
					 " VALUES\r\n" + 
					 " ((SELECT MAX(NO) + 1 FROM FREE_BOARD), ?, ?, ?)";
		return jdbc.update(sql, param);
	}
	
	public List<Map<String, Object>> listBoard() {
		String sql = " SELECT NO, TITLE, SUBSTR(CONTENT, 1, 10) CONTENT, WRITER, COUNT\r\n" + 
				 	 " FROM FREE_BOARD\r\n" + 
					 " WHERE DEL_YN = 'N'\r\n" + 
					 " ORDER BY NO DESC";
		
		List<Map<String, Object>> list = jdbc.selectList(sql);
		return list;
	}
	
	public Map<String, Object> detailBoard(int no){
		String sql = " SELECT NO, TITLE, CONTENT, WRITER, TO_CHAR(REG_DATE, 'yyyy-mm-dd') REG_DATE, COUNT\r\n" + 
					 " FROM FREE_BOARD\r\n" + 
				 	 " WHERE NO = " + no;
		
		return jdbc.selectOne(sql);
	}
	
	public void updateBoardCount(int no) {
		
		String sql = " UPDATE FREE_BOARD\r\n" + 
					 "   SET COUNT = (SELECT COUNT + 1\r\n" + 
					 "                  FROM FREE_BOARD\r\n" + 
					 "                 WHERE NO = " + no + ")\r\n" + 
					 " WHERE NO = " + no;
		
		jdbc.update(sql);
	}
	
	public void updateBoard(List<Object> param, String column) {
		
		String format = "UPDATE FREE_BOARD\r\n" + 
						"   SET %s = ?\r\n" + 
						" WHERE NO = ?";
		
		String sql = String.format(format, column);
		jdbc.update(sql, param);
	}
}
