package member.dao;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.mybatis.config.MybatisUtil;
import member.vo.MemberVO;


public class MemberDao implements IMemberDao {
	
	private static MemberDao instance;
	
	private MemberDao() { }
	
	public static MemberDao getInstance() {
		if(instance==null) instance= new MemberDao();
		
		return instance;
	}
	

	@Override
	public int insertMember(MemberVO vo) {
		SqlSession session =null;
		int res = 0;
		
		try {
			session = MybatisUtil.getSqlSession();
			res = session.insert("member.insertMember",vo);
			if(res>0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		return res;
	}

	@Override
	public int selectMemberCountOne(String mem_id) {
		SqlSession session =null;
		int res = 0;
		
		try {
			session = MybatisUtil.getSqlSession();
			res = session.selectOne("member.selectMemberCountOne",mem_id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		return res;
	}

	@Override
	public MemberVO selectMemberOne(MemberVO vo) {
		SqlSession session =null;
		MemberVO memVo = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			memVo = session.selectOne("member.selectMemberOne",vo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		return memVo;
	}

	@Override
	public int updateMemberOne(MemberVO vo) {
		SqlSession session =null;
		int res = 0;
		
		try {
			session = MybatisUtil.getSqlSession();
			res = session.update("member.updateMemberOne",vo);
			if(res>0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		return res;
	}

	@Override
	public int updateMemberLeave(MemberVO vo) {
		SqlSession session =null;
		int res = 0;
		
		try {
			session = MybatisUtil.getSqlSession();
			res = session.update("member.updateMemberLeave",vo);
			if(res>0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		return res;
	}

	@Override
	public MemberVO selectMemberLogin(MemberVO vo) {
		SqlSession session =null;
		MemberVO memVo = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			memVo = session.selectOne("member.selectMemberLogin",vo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		return memVo;
	}

	@Override
	public MemberVO selectMemberFineId(MemberVO vo) {
		SqlSession session =null;
		MemberVO memVo = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			memVo = session.selectOne("member.selectMemberFineId",vo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		return memVo;
	}

	@Override
	public MemberVO selectMemberFindPass(MemberVO vo) {
		SqlSession session =null;
		MemberVO memVo = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			memVo = session.selectOne("member.selectMemberFindPass",vo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		return memVo;
	}

}
