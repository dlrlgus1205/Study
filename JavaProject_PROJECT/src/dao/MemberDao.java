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
		String sql = " SELECT *\r\n" + 
					 "   FROM MEMBER\r\n" + 
					 "  WHERE MEM_ID = ?\r\n" + 
					 "    AND MEM_PASS = ?";
		return jdbc.selectOne(sql,param,MemberVo.class);
	}

	public void memBlacklist(List<Object> param) {
		String sql = "UPDATE MEMBER\r\n" + 
				"      SET MEM_BLOCK = 'Y'\r\n" + 
				"      WHERE MEM_NO = ?";
		jdbc.update(sql,param);
	}

	public List<MemberVo> memberAllList() {
		String sql = "SELECT * FROM MEMBER WHERE MEM_DEL = 'N'";
		
		return jdbc.selectList(sql,MemberVo.class);
	}

	public void membercashPurchase(List<Object> param) {
		String sql ="UPDATE MEMBER\r\n" + 
				"       SET MEM_CASH = MEM_CASH+?";
		
		   jdbc.update(sql,param);
	}

	public void memberCashChange(int change) {
		String sql ="UPDATE MEMBER\r\n" + 
				"      SET MEM_GCASH = MEM_GCASH+"+change+"*10,\r\n" + 
				"          MEM_CASH = MEM_CASH-"+change+"\r\n";
			
		  
		jdbc.update(sql);

	}

	public MemberVo membercash() {
		String sql = "SELECT MEM_CASH FROM MEMBER";
		
		return jdbc.selectOne(sql,MemberVo.class);
	}

	public MemberVo membergcash() {
		String sql = "SELECT MEM_GCASH FROM MEMBER";
		return jdbc.selectOne(sql,MemberVo.class);
	}
	
}
