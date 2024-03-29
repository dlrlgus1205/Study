package member.service;

import member.dao.MemberDao;
import member.vo.MemberVO;

public class MemberService implements IMemberService {

	private  MemberDao dao;
	private static MemberService instance;
	
	private MemberService() { 
		dao=MemberDao.getInstance();
	}
	
	public static MemberService getInstance() {
		if(instance==null) instance= new MemberService();
		
		return instance;
	}
	
	
	@Override
	public int insertMember(MemberVO vo) {
		
		return dao.insertMember(vo);
	
	}

	@Override
	public int selectMemberCountOne(String mem_id) {
		
		return dao.selectMemberCountOne(mem_id);
		
	}

	@Override
	public MemberVO selectMemberOne(MemberVO vo) {
		
		return dao.selectMemberOne(vo);
	}

	@Override
	public int updateMemberOne(MemberVO vo) {
		
		return dao.updateMemberOne(vo);
	}

	@Override
	public int updateMemberLeave(MemberVO vo) {
		
		return dao.updateMemberLeave(vo);
	}

	@Override
	public MemberVO selectMemberLogin(MemberVO vo) {
		
		return dao.selectMemberLogin(vo);
	}

	@Override
	public MemberVO selectMemberFineId(MemberVO vo) {
		
		return dao.selectMemberFineId(vo);
	}

	@Override
	public MemberVO selectMemberFindPass(MemberVO vo) {
		
		return dao.selectMemberFindPass(vo);
	}

}
