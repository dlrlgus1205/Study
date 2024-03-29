package kr.or.ddit.mvc.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.mvc.dao.IMemberDao;
import kr.or.ddit.mvc.dao.MemberDaoImpl;
import kr.or.ddit.mvc.vo.MemberVo;

public class MemberServiceImpl implements IMemberService {
	private static MemberServiceImpl service;
	
	public static MemberServiceImpl getInstance() {
		if (service == null) service = new MemberServiceImpl();
		return service;
	}
	// DAO 객체의 참조 값이 저장될 변수 선언
	private IMemberDao dao;
	
	// 생성자
	private MemberServiceImpl() {
		// DAO 객체 생성
		dao = MemberDaoImpl.getInstance();
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
	public int getMemberCount(String memId) {
		return dao.getMemberCount(memId);
	}
	@Override
	public int updateMember2(Map<String, String> param) {
		// TODO Auto-generated method stub
		return 0;
	}

}
