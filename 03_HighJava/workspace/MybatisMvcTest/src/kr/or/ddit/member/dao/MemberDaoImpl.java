package kr.or.ddit.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.member.vo.MemberVo;
import kr.or.ddit.util.MybatisUtil;

public class MemberDaoImpl implements IMemberDao {
	private static MemberDaoImpl dao;
	
	private MemberDaoImpl() { }
	
	public static MemberDaoImpl getInstance() {
		if(dao == null) dao = new MemberDaoImpl();
		return dao;
	}

	@Override
	public int getMemberCount(String memId) {
		SqlSession session = null;
		int cnt = 0;
		
		try {
			session = MybatisUtil.getSqlSession();
			
			cnt = session.selectOne("MyMem.getMemberCount", memId);
			if(cnt > 0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		return cnt;
	}
	
	@Override
	public int insertMember(MemberVo memVo) {
		SqlSession session = null;
		int cnt = 0;
		
		try {
			session = MybatisUtil.getSqlSession();
			
			cnt = session.insert("MyMem.insertMember", memVo);
			if(cnt > 0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		return cnt;
	} 

	@Override
	public int deleteMember(String memId) {
		SqlSession session = null;
		int cnt = 0;
		
		try {
			session = MybatisUtil.getSqlSession();
			
			cnt = session.delete("MyMem.deleteMember", memId);
			if(cnt > 0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		return cnt;
	}

	@Override
	public int updateMember(MemberVo memVo) {
		SqlSession session = null;
		int cnt = 0;
		try {
			session = MybatisUtil.getSqlSession();
			
			cnt = session.update("MyMem.updateMember", memVo);
			if(cnt > 0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		return cnt;
	}

	@Override
	public List<MemberVo> getAllMember() {
		SqlSession session = null;
		List<MemberVo> memList = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			memList = session.selectList("MyMem.getAllMember");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		return memList;
	}

	@Override
	public int updateMember2(Map<String, String> param) {
		SqlSession session = null;
		int cnt = 0;
		try {
			session = MybatisUtil.getSqlSession();
			
			cnt = session.update("MyMem.updateMember2", param);
			if(cnt > 0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		return cnt;
	}
	
}
