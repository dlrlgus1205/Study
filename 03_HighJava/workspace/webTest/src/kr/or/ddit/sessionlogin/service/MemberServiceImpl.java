package kr.or.ddit.sessionlogin.service;

import kr.or.ddit.sessionlogin.dao.IMemberDao;
import kr.or.ddit.sessionlogin.dao.MemberDaoImpl;
import kr.or.ddit.sessionlogin.vo.MemberVo;

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
	public MemberVo getLoginMember(MemberVo memVo) {
		return dao.getLoginMember(memVo);
	}

}
