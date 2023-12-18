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
					"    FROM ADMIN02\r\n" + 
					"   WHERE ID = ?\r\n" + 
					"     AND PASS = ?";
		return jdbc.selectOne(sql,param,AdminVo.class);
	}
}
