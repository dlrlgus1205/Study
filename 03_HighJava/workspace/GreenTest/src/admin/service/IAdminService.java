package admin.service;

import java.util.List;
import java.util.Map;

import admin.vo.PageVo;
import member.vo.MemberVO;
import post.vo.PostVO;

public interface IAdminService {
	
	//////////////////////// 회원 //////////////////////////////////
	/**
	 * 맴버 정보 가져오기
	 * @return
	 */
	public List<MemberVO> memList(Map<String, Object> map);
	
	/**
	 * 맴버 탈퇴기능
	 * @param mem_id
	 * @return
	 */
	public int memDelete(String mem_id);
	
	/**
	 * 맴버 총원 구하기
	 * @return
	 */
	public int memCount();

	
	/**
	 * 맴버 검색별 총원 구하기
	 * @param map
	 * @return
	 */
	public int memSelectCount(Map<String, Object> map);
	
	
	
	//////////////////////// 게시판 //////////////////////////////////
	/**
	 * 게시글 정보 가져오기
	 * @return
	 */
	public List<PostVO> postList(Map<String, Object> map);
	
	/**
	 * 게시글 삭제기능
	 * @param mem_id
	 * @return
	 */
	public int postDelete(String mem_id);
	
	/**
	 * 총 게시글 구하기
	 * @return
	 */
	public int postCount();

	
	/**
	 * 게시글 검색별 갯수 구하기
	 * @param map
	 * @return
	 */
	public int postSelectCount(Map<String, Object> map);
	
	/**
	 * 게시글 페이지수 구하기
	 * @param pageNo
	 * @param stype
	 * @param sword
	 * @return
	 */
	public PageVo postpageInfo(int pageNo, String stype, String sword);
	
	
	
	
	//페이지 구하기
	PageVo pageInfo(int pageNo, String stype, String sword);
}