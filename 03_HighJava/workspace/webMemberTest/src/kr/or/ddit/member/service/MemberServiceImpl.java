package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.vo.MemberVo;

public class MemberServiceImpl implements IMemberService {
	private IMemberDao dao;
	
	private static MemberServiceImpl service;
	
	private MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance();
	}
	
	public static MemberServiceImpl getInstance() {
		if(service == null) service = new MemberServiceImpl();
		return service;
	}
	
	@Override
	public List<MemberVo> getAllMember() {
		// TODO Auto-generated method stub
		return dao.getAllMember();
	}

	@Override
	public int insertMember(MemberVo mVo) {
		// TODO Auto-generated method stub
		return dao.insertMember(mVo);
	}

	@Override
	public int MemberIdChk(String id) {
		// TODO Auto-generated method stub
		return dao.MemberIdChk(id);
	}

	@Override
	public MemberVo MemberDetail(String id) {
		// TODO Auto-generated method stub
		return dao.MemberDetail(id);
	}

	@Override
	public int updateMember(MemberVo mVo) {
		// TODO Auto-generated method stub
		return dao.updateMember(mVo);
	}

	@Override
	public int deleteMember(String id) {
		// TODO Auto-generated method stub
		return dao.deleteMember(id);
	}
	
	@Override
	public MemberVo getMember(String memId) {
		return dao.getMember(memId);
	}
}
