package dao;

import java.util.List;

import util.JDBCUtil;
import vo.FreeBoard;

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
	
	public List<FreeBoard> freeList(List<Object> param) {
		String sql = " SELECT *\r\n" + 
					 " FROM (SELECT ROWNUM RN, A.*\r\n" + 
					 " FROM(SELECT BOARD_NO, TITLE, CONTENT, F.MEM_NO, TO_CHAR(WRITE_DATE, 'YYYY-MM-DD') WRITE_DATE, COUNT, M.NAME SPARE1\r\n" + 
					 " FROM FREE_BOARD2 F, MEMBER_BOARD M\r\n" + 
					 " WHERE F.MEM_NO = M.MEM_NO" +
					 " AND DEL_YN = 'N') A)\r\n" + 
					 " WHERE RN BETWEEN ? AND ?";
		
		return jdbc.selectList(sql, param, FreeBoard.class);
	}

	public FreeBoard freeDetail(int board_no) {
		String sql = " SELECT BOARD_NO, TITLE, CONTENT, F.MEM_NO, TO_CHAR(WRITE_DATE, 'YYYY-MM-DD') WRITE_DATE, COUNT, M.NAME SPARE1\r\n" + 
					 " FROM FREE_BOARD2 F, MEMBER_BOARD M\r\n" + 
					 " WHERE F.MEM_NO = M.MEM_NO\r\n" + 
					 " AND BOARD_NO = " + board_no;
		return jdbc.selectOne(sql, FreeBoard.class);
	}

	public void freeUpdate(int board_no) {
		String sql = "";
		jdbc.update(sql);
	}
	
	public void freeDelete(int board_no) {
		String sql = " UPDATE FREE_BOARD2" +
					 " SET DEL_YN = 'Y'" +
					 " WHERE BOARD_NO = " + board_no;
		jdbc.update(sql);
	}
}
