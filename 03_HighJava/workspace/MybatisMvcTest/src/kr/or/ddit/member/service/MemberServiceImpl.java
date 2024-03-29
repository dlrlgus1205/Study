package kr.or.ddit.member.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.vo.MemberVo;

public class MemberServiceImpl implements IMemberService {
	private static MemberServiceImpl service;
	
	public static MemberServiceImpl getInstance() {
		if (service == null) service = new MemberServiceImpl();
		return service;
	}
	private IMemberDao dao;
	
	private MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance();
	}
	
	@Override
	public int getMemberCount(String memId) {
		return dao.getMemberCount(memId);
	}

	@Override
	public int insertMember(MemberVo memVo) {
		return dao.insertMember(memVo);
	}

	@Override
	public int deleteMember(String memId) {
		return dao.deleteMember(memId);
	}

	@Override
	public int updateMember(MemberVo memVo) {
		return dao.updateMember(memVo);
	}

	@Override
	public List<MemberVo> getAllMember() {
		return dao.getAllMember();
	}
	
	@Override
	public int updateMember2(Map<String, String> param) {
		return dao.updateMember2(param);
	}

}
