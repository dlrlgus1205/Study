package member.service;

import member.vo.MemberVO;

public interface IMemberService {

	public int insertMember(MemberVO vo);
	
	public int selectMemberCountOne(String mem_id);
	
	public MemberVO selectMemberOne(MemberVO vo);
	
	public int updateMemberOne(MemberVO vo);
	
	public int updateMemberLeave(MemberVO vo);
	
	public MemberVO selectMemberLogin(MemberVO vo);
	
	public MemberVO selectMemberFineId(MemberVO vo);
	
	public MemberVO selectMemberFindPass(MemberVO vo);
}
