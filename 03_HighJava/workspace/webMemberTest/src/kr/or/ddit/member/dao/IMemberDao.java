package kr.or.ddit.member.dao;

import java.util.List;

import kr.or.ddit.member.vo.MemberVo;

public interface IMemberDao {
	/**
	 * 전체 멤버 리스트 출력
	 * @return
	 */
	public List<MemberVo> getAllMember();
	
	/**
	 * 멤버 추가
	 * @return
	 */
	public int insertMember(MemberVo memVo);
	
	/**
	 * 멤버 아이디 중복 체크 
	 * @param id 확인할 ID값
	 * @return 아이디 중복 : 1, 아이디 중복 아님 : 0
	 */
	public int MemberIdChk(String memId);
	
	/**
	 * 선택멤버 상세보기
	 * @param id 상세보기할 아이디 입력
	 * @return 선택한 아이디 전체 내용
	 */
	public MemberVo MemberDetail(String memId);
	
	/**
	 * 멤버 상세리스트 수정
	 * @param memVO 수정할 아이디
	 * @return 수정 성공 : 1, 수정 실패 : 0
	 */
	public int updateMember(MemberVo memVo);
	
	/**
	 * DB에 저장된 ID 검색 후 삭제
	 * @param id
	 * @return 삭제 성공 : 1, 삭제 실패 : 0
	 */
	public int deleteMember(String memId);
	
	/**
	 * 회원ID와 패스워드가 저장된 MemberVO객체를 인수값으로 받아서
	 * 해당 조건에 맞는 회원정보를 검색해서 반환하는 메서드
	 * 
	 * @param memVo 검색할 회원정보가 저장된 MemberVO객체
	 * @return 검색 결과가 저장된 MemberVO객체
	 */
	public MemberVo getMember(String memId);
}
