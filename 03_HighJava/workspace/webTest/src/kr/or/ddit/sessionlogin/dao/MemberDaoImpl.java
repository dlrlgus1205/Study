package kr.or.ddit.sessionlogin.dao;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.sessionlogin.vo.MemberVo;
import kr.or.ddit.util.MybatisUtil;

public class MemberDaoImpl implements IMemberDao {
	private static MemberDaoImpl dao;
	
	private MemberDaoImpl() {
	}
	
	public static MemberDaoImpl  getInstance() {
		if(dao == null) dao = new MemberDaoImpl();
		return dao;
	}
	
	@Override
	public MemberVo getLoginMember(MemberVo memVo) {
		MemberVo loginMemVo = null;
		SqlSession session = null;
		try {
			session = MybatisUtil.getSqlSession();
			
			loginMemVo = session.selectOne("mymember.getLoginMember", memVo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		return loginMemVo;
	}

}
