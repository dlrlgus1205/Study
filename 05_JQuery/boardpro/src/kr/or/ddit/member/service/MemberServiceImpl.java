package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.vo.MemberVo;
import kr.or.ddit.member.vo.ZipVo;

public class MemberServiceImpl implements IMemberService {

	
	private static MemberServiceImpl service;
	
	
	public static MemberServiceImpl getInstance() {
		if(service == null) service = new MemberServiceImpl();
		
		return service;
	}
	
	private IMemberDao dao;
	
	private MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance();
	}

	@Override
	public String searchMemId(String memId) {
		// TODO Auto-generated method stub
		return dao.searchMemId(memId);
	}

	@Override
	public List<ZipVo> selectByDong(String dong) {
		// TODO Auto-generated method stub
		return dao.selectByDong(dong);
	}

	@Override
	public int insertMember(MemberVo Vo) {
		// TODO Auto-generated method stub
		return dao.insertMember(Vo);
	}

	@Override
	public MemberVo logSelect(MemberVo vo) {
		return dao.logSelect(vo);
	}

}
