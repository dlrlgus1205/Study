package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.exception.PkNotFoundException;
import kr.or.ddit.member.dao.MemberDAO;
import kr.or.ddit.member.dao.MemberDAOImpl;
import kr.or.ddit.vo.MemberVO;

public class MemberServiceImpl_my implements MemberService {
	private MemberDAO dao = new MemberDAOImpl();
	@Override
	public ServiceResult createMember(MemberVO member) {
		if(dao.selectMember(member.getMemId()) != null) {
			return ServiceResult.PKDUPLICATED;
		}
		else if(dao.insertMember(member) == 0) {
			return ServiceResult.FAIL;
		}
		else {
			return ServiceResult.OK;
		}
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
