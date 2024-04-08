package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.exception.PkNotFoundException;
import kr.or.ddit.member.dao.MemberDAO;
import kr.or.ddit.member.dao.MemberDAOImpl;
import kr.or.ddit.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	private MemberDAO dao = new MemberDAOImpl();
	@Override
	public ServiceResult createMember(MemberVO member) {
	ServiceResult result = null;
	if(dao.selectMember(member.getMemId())==null) {
		int rowcnt = dao.insertMember(member);
		result = rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
	}
	else {
		result = ServiceResult.PKDUPLICATED;
	}
	return result;
	}

	@Override
	public List<MemberVO> retrieveMemberList() {
		return dao.selectMemberList();
	}

	@Override
	public MemberVO retrieveMember(String memId) throws PkNotFoundException {
		return dao.selectMember(memId);
	}

	@Override
	public ServiceResult modifyMember(MemberVO member) throws PkNotFoundException {
		return null;
	}

	@Override
	public ServiceResult removeMember(MemberVO inputData) throws PkNotFoundException {
		return null;
	}

}