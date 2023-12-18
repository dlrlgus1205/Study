package dao;


import java.util.List;

import util.JDBCUtil;
import vo.Member;

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
	
	public Member login(List<Object> param){
		String sql = " SELECT * FROM MEMBER\r\n" + 
					 " WHERE ID = ?\r\n" + 
					 " AND PASS = ?";
		
		return jdbc.selectOne(sql, param, Member.class);
	}
}
