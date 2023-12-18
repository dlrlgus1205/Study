package dao;

import java.util.List;

import util.JDBCUtil;
import vo.MemberVo;

public class MemberDao {
	private static MemberDao instance = null;

	private MemberDao() {
	}

	public static MemberDao getnInstance() {
		if (instance == null) {
			instance = new MemberDao();
		}
		return instance;
	}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public MemberVo login(List<Object> params) {
		String sql = " SELECT * " + 
					 " FROM MEMBER_BOARD " + 
					 " WHERE ID = ? AND PASS = ? ";
		
		return jdbc.selectOne(sql, params, MemberVo.class);
	}
}
