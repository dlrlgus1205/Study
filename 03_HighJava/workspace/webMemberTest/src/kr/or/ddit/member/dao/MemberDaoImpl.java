package kr.or.ddit.member.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.member.vo.MemberVo;
import kr.or.ddit.util.MybatisUtil;

public class MemberDaoImpl implements IMemberDao {
	private static MemberDaoImpl dao;
	
	private MemberDaoImpl() {}
	
	public static MemberDaoImpl getInstance() {
		if(dao == null) dao = new MemberDaoImpl();
		return dao;
	}
	
	@Override
	public List<MemberVo> getAllMember() {
		List<MemberVo> list = new ArrayList<MemberVo>();
		SqlSession session = null;
		try {
			session = MybatisUtil.getSqlSession();
			list = session.selectList("member.getAllMember");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		return list;
	}
	
	@Override
	public int insertMember(MemberVo memVo) {
		int cnt = 0;		//반환값이 저장될 변수 선언
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.insert("member.insertMember", memVo);
			if(cnt > 0) {
				session.commit();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) session.close();
		}
		return cnt;
	}

	@Override
	public int MemberIdChk(String memId) {
		int res = 0;
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			res = session.selectOne("member.MemberIdChk", memId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		return res;
	}

	@Override
	public MemberVo MemberDetail(String memId) {
		MemberVo res = null;
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			res = session.selectOne("member.MemberDetail", memId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		return res;
	}

	@Override
	public int updateMember(MemberVo memVo) {
		int res = 0;
		SqlSession session = null;
		try {
			session = MybatisUtil.getSqlSession();
			res = session.update("member.updateMember", memVo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
			session.commit();
		}
		return res;
	}

	@Override
	public int deleteMember(String memId) {
		int res = 0;
		SqlSession session = null;
		try {
			session = MybatisUtil.getSqlSession();
			res = session.delete("member.deleteMember", memId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
			session.commit();
		}
		return res;
	}
	
	@Override
	public MemberVo getMember(String memId) {
		SqlSession session = null;
		MemberVo loginMemberVo = null;
		try {
			session = MybatisUtil.getSqlSession();
			loginMemberVo = session.selectOne("member.getMember", memId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		} 
		return loginMemberVo;
	}

}
