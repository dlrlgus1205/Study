package dao;

import java.util.List;

import util.JDBCUtil;
import vo.MemberVo;

public class MemberDao {
	private static MemberDao instance = null;

	private MemberDao() {
	}

	public static MemberDao getInstance() {
		if (instance == null) {
			instance = new MemberDao();
		}
		return instance;
	}
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public MemberVo memberLogin(List<Object> param) {
		String sql = "  SELECT *\r\n" + 
					 "    FROM MEMBER02\r\n" + 
					"    WHERE ID = ?\r\n" + 
					"      AND PASS = ?";
		return jdbc.selectOne(sql,param,MemberVo.class);
	}
}
