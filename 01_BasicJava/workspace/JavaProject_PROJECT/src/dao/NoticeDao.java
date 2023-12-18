package dao;

import java.util.List;

import util.JDBCUtil;
import vo.NoticeVo;

public class NoticeDao {
	private static NoticeDao instance = null;

	private NoticeDao() {
	}

	public static NoticeDao getInstance() {
		if (instance == null) {
			instance = new NoticeDao();
		}
		return instance;
	}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();

	public void noticeInsert(List<Object> param) {
		String sql = "INSERT INTO NOTICE(NTC_NO, NTC_TITLE, NTC_CON, AD_NO)\r\n" + 
				"VALUES (SEQ_NOT_NO.NEXTVAL,?,?,?)";
		jdbc.update(sql,param);
	}

	public List<NoticeVo> noticeAllLest() {
		String sql = "\r\n" + 
				"SELECT *\r\n" + 
				"  FROM NOTICE\r\n" + 
				" WHERE NTC_DEL = 'N'"
				+ "ORDER BY 1 DESC";
		return jdbc.selectList(sql,NoticeVo.class);
	}

	public void noticeUpdate(List<Object> param) {
		String sql = " UPDATE NOTICE\r\n" + 
				"    SET NTC_TITLE = ?,\r\n" + 
				"        NTC_CON = ?\r\n" + 
				"    WHERE NTC_NO = ?";
		jdbc.update(sql,param);
	}

	public void noticeDelete(List<Object> param) {
		String sql = "UPDATE NOTICE\r\n" + 
				"   SET  NTC_DEL = 'Y'\r\n" + 
				"   WHERE NTC_NO = ?";
		jdbc.update(sql,param);

	}
	public void noticeViewPlus(List<Object> param) {
		String view = "UPDATE NOTICE\r\n" + 
				"   SET NTC_VIEW = NTC_VIEW+1\r\n" + 
				"   WHERE NTC_NO = ?";

		jdbc.update(view,param);
	}
	public List<NoticeVo> noticeDetail(List<Object> param) {
		String sql = "SELECT *\r\n" + 
				"  FROM NOTICE\r\n" + 
				"  WHERE NTC_NO = ?\r\n" + 
				"    AND NTC_DEL = 'N'";
		
		return jdbc.selectList(sql,param,NoticeVo.class);
	}
}
