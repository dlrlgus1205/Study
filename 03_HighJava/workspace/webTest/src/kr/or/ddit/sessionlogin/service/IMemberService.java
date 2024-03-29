package kr.or.ddit.sessionlogin.service;

import kr.or.ddit.sessionlogin.vo.MemberVo;

public interface IMemberService {
	/**
	 * 회원 ID와 패스워드가 저장된 MemberVO객체를 인수값으로 받아서 해당 
	 * 
	 * @param memVo 검색할 회원 ID와 패스워드가 저장된 MemberVO객체
	 * @return 검색된 회원 정보가 저장된 MemberVO객체 ()
	 */
	public MemberVo getLoginMember(MemberVo memVo);
}
