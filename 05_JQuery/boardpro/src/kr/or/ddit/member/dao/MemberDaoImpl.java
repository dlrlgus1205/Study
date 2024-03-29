package kr.or.ddit.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.config.MybatisUtil;
import kr.or.ddit.member.vo.MemberVo;
import kr.or.ddit.member.vo.ZipVo;

public class MemberDaoImpl implements IMemberDao {
	
	private static MemberDaoImpl dao;
	
	private MemberDaoImpl() {}
	
	
	public static MemberDaoImpl getInstance() {
		if(dao == null) dao = new MemberDaoImpl();
		
		return dao;
	}

	@Override
	public String searchMemId(String memId) {
		SqlSession session = MybatisUtil.getSqlSession();
		
		String res = null;
		
		try {
			res = session.selectOne("jdbc.searchMemId", memId);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		return res;
	}


	@Override
	public List<ZipVo> selectByDong(String dong) {
		SqlSession session =null;
		List<ZipVo> list = new ArrayList<ZipVo>();
		try {
			session = MybatisUtil.getSqlSession();
			
			list = session.selectList("jdbc.selectByDong", dong);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			if(session!=null) session.close();
		}
		
		return list;
	}


	@Override
	public int insertMember(MemberVo Vo) {
		int cnt = 0;
		SqlSession session = null;
		try {
			session = MybatisUtil.getSqlSession();
			
			cnt = session.insert("jdbc.insertMember", Vo);
			if(cnt>0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null)session.close();
		}
		return cnt;
	}


	@Override
	public MemberVo logSelect(MemberVo vo) {
		MemberVo mVo = new MemberVo();
		
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			
			mVo = session.selectOne("jdbc.logSelect", vo);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		return mVo;
	}

}
