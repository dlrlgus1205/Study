package kr.or.ddit.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	private SqlSessionFactory factory;
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insertMember(MemberVO member) {
		int rowcnt = sqlSession.getMapper(MemberDAO.class).insertMember(member);
		if(rowcnt > 0) sqlSession.commit();
		return rowcnt;
	}
		
	@Override
	public List<MemberVO> selectMemberList() {
		MemberDAO mapperProxy = sqlSession.getMapper(MemberDAO.class);
		return mapperProxy.selectMemberList();
	}

	@Override
	public MemberVO selectMember(String memId) {
		return sqlSession.getMapper(MemberDAO.class).selectMember(memId);
	}

	@Override
	public int updateMember(MemberVO member) {
		int rowcnt = sqlSession.getMapper(MemberDAO.class).updateMember(member);
		if(rowcnt > 0) sqlSession.commit();
		return rowcnt;
	}

	@Override
	public int deleteMember(String memId) {
		int rowcnt = sqlSession.getMapper(MemberDAO.class).deleteMember(memId);
		if(rowcnt > 0) sqlSession.commit();
		return rowcnt;
	}

	@Override
	public MemberVO selectMemeberForAuth(String memId) {
		return sqlSession.getMapper(MemberDAO.class).selectMemeberForAuth(memId);
	}
}