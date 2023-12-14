package dao;

import java.util.List;

import util.JDBCUtil;
import vo.SugVo;

public class SugDao {
	private static SugDao instance = null;

	private SugDao() {
	}

	public static SugDao getInstance() {
		if (instance == null) {
			instance = new SugDao();
		}
		return instance;
	}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public void suggestionViewPlus(List<Object> param) {
		String view = "UPDATE SUGGESTION\r\n" + 
				"   SET SUG_VIEW = SUG_VIEW+1\r\n" + 
				"   WHERE SUG_NO = ?";

		jdbc.update(view,param);
	}

	public List<SugVo> suggestionAllList() {
		
		String sql = "      SELECT * \r\n" + 
				"        	  FROM SUGGESTION \r\n" + 
				"       	 WHERE SUG_DEL = 'N'";
		
		return jdbc.selectList(sql,SugVo.class);
	}

	public List<SugVo> suggestionTitleSearch(String title) {
		String sql ="\r\n" + 
				"  SELECT *\r\n" + 
				"    FROM SUGGESTION\r\n" + 
				"    WHERE SUG_TITLE LIKE '"+title+"%'";
		return jdbc.selectList(sql,SugVo.class);
	}

	public List<SugVo> suggestionConSearch(String con) {
		String sql ="\r\n" + 
				"  SELECT *\r\n" + 
				"    FROM SUGGESTION\r\n" + 
				"    WHERE SUG_CON LIKE '"+con+"%'";
		return jdbc.selectList(sql,SugVo.class);
		
	}

	public List<SugVo> suggestionWriterSearch(String writer) {
		String sql ="\r\n" + 
				"  SELECT *\r\n" + 
				"    FROM SUGGESTION\r\n" + 
				"    WHERE MEM_ID LIKE '"+writer+"%'";
		return jdbc.selectList(sql,SugVo.class);
		
	}
	
	public void suggestionInsert(List<Object> param) {
		String sql = "INSERT INTO SUGGESTION(SUG_NO,SUG_TITLE,SUG_CON,MEM_ID)\r\n" + 
				"VALUES (SEQ_SUG_NO.NEXTVAL,?,?,?)";
		jdbc.update(sql,param);
	}

	public void suggestionUpdate(List<Object> param) {
		String sql = "UPDATE SUGGESTION\r\n" + 
				"   SET SUG_TITLE = ?,\r\n" + 
				"       SUG_CON = ?\r\n" + 
				"  WHERE MEM_ID = ?";
		jdbc.update(sql, param);
	}

	public List<SugVo> suggestionDetail(String id) {
		String sql = "\"SELECT *\\r\\n\" + \r\n" + 
				"				\"  FROM SUGGESTION\\r\\n\" + \r\n" + 
				"				\"  WHERE SUG_DEL = 'N'"
				+ "					  AND MEM_ID = '"+id+"'";
		return jdbc.selectList(sql,SugVo.class);
	}

	public void suggestionDelete(List<Object> param) {
		String sql = "  UPDATE SUGGESTION\r\n" + 
				"     SET SUG_DEL = 'Y'\r\n" + 
				"     WHERE MEM_ID = ? "
						+ "AND SUG_NO = ?";
		jdbc.update(sql,param);
	}

	public List<SugVo> suggestionDetailView(List<Object> param) {
		String sql = "SELECT *\r\n" + 
				"       FROM SUGGESTION\r\n" + 
				"      WHERE SUG_NO = ?";
		
		return jdbc.selectList(sql,param,SugVo.class);
	}
	
}
