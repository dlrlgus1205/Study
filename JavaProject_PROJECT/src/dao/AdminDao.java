package dao;

import java.util.List;

import util.JDBCUtil;
import vo.AdminVo;

public class AdminDao {
	private static AdminDao instance = null;

	private AdminDao() {
	}

	public static AdminDao getInstance() {
		if (instance == null) {
			instance = new AdminDao();
		}
		return instance;
	}
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public AdminVo adminLogin(List<Object> param) {
		String sql = " SELECT *\r\n" + 
					 "   FROM ADMIN\r\n" + 
					 "  WHERE AD_ID = ?\r\n" + 
					 "    AND AD_PASS = ?";
		return jdbc.selectOne(sql,param,AdminVo.class);
	}

	public void adminItInsert(List<Object> param) {
		String sql = " INSERT INTO ITEMMENU(ITM_NO,ITM_NAME,ITM_CON,ITM_CLS,ITM_TYPE,ITM_PRICE)\r\n" + 
				"    VALUES (SEQ_ITM_NO.NEXTVAL,?,?,?,?,?)";
		
		jdbc.update(sql, param);
	}

	public void adminUpgradeChange(List<Object> param) {
		String sql = "       UPDATE UPGRADE\r\n" + 
				"          SET UP_SUC = ?,\r\n" + 
				"              UP_FAIL = ?\r\n" + 
				"        WHERE UP_NO = ?";
		jdbc.update(sql, param);
	}
}
