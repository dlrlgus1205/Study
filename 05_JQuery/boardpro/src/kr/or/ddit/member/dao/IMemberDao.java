package kr.or.ddit.member.dao;

import java.util.List;

import kr.or.ddit.member.vo.MemberVo;
import kr.or.ddit.member.vo.ZipVo;

public interface IMemberDao {
	
	//로그인 처리
	public MemberVo logSelect(MemberVo vo);
	//아이디 중복검사
	public String searchMemId(String memId);
	//우편번호 검색
	public List<ZipVo> selectByDong(String dong);
	//전송(가입신청)
	public int insertMember(MemberVo Vo);
}
