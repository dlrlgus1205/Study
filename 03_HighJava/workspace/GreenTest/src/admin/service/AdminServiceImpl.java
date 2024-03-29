package admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import admin.dao.AdminDaoImpl;
import admin.vo.PageVo;
import member.vo.MemberVO;
import post.vo.PostVO;

public class AdminServiceImpl implements IAdminService {

	private static AdminDaoImpl dao;
	private static AdminServiceImpl service;
	
	private AdminServiceImpl() { 
		dao = AdminDaoImpl.getInstance();
	}
	public static AdminServiceImpl getInstance() {
		if(service==null) service= new AdminServiceImpl();
		return service;
	}
	
	@Override
	public List<MemberVO> memList(Map<String, Object> map) {
		return dao.memList(map);
	}
	@Override
	public int memDelete(String mem_id) {
		return dao.memDelete(mem_id);
	}
	@Override
	public int memCount() {
		return dao.memCount();
	}

	@Override
	public int memSelectCount(Map<String, Object> map) {
		return dao.memSelectCount(map);
	}

	//회원 페이지 구하는 메소드
	@Override
	public PageVo pageInfo(int pageNo, String stype, String sword) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("stype", stype);
		map.put("sword", sword);
		
		//전체 글갯수
		int count = this.memSelectCount(map);
		System.out.println(count);
		
		//전체페이지수 구하기
		int perList = PageVo.getPerList();
		int totalPage = (int)Math.ceil((double)count / perList);
		
		//시작글번호, 끝글번호
		int start = (pageNo-1) * perList +1;
		int end = start + perList -1;
		if(end>count) end = count;
		
		//시작페이지, 끝 페이지
		int perPage = PageVo.getPerPage();
		int startPage = ((pageNo-1) / perPage * perPage)+1;
		int endPage = startPage + perPage -1;
		if(endPage > totalPage) endPage = totalPage;
		
		PageVo vo = new PageVo();
		vo.setStart(start);
		vo.setEnd(end);
		vo.setStartPage(startPage);
		vo.setEndPage(endPage);
		vo.setTotalPage(totalPage);
		return vo;
	}
	
	//게시글 페이지 구하는 메소드
		@Override
		public PageVo postpageInfo(int pageNo, String stype, String sword) {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("stype", stype);
			map.put("sword", sword);
			//전체 글갯수
			int count = this.postSelectCount(map);
			
			//전체페이지수 구하기
			int perList = PageVo.getPerList();
			int totalPage = (int)Math.ceil((double)count / perList);
			
			//시작글번호, 끝글번호
			int start = (pageNo-1) * perList +1;
			int end = start + perList -1;
			if(end>count) end = count;
			
			//시작페이지, 끝 페이지
			int perPage = PageVo.getPerPage();
			int startPage = ((pageNo-1) / perPage * perPage)+1;
			int endPage = startPage + perPage -1;
			if(endPage > totalPage) endPage = totalPage;
			
			PageVo vo = new PageVo();
			vo.setStart(start);
			vo.setEnd(end);
			vo.setStartPage(startPage);
			vo.setEndPage(endPage);
			vo.setTotalPage(totalPage);
			return vo;
		}
	
	@Override
	public List<PostVO> postList(Map<String, Object> map) {
		return dao.postList(map);
	}
	@Override
	public int postDelete(String mem_id) {
		return dao.postDelete(mem_id);
	}
	@Override
	public int postCount() {
		return dao.postCount();
	}
	@Override
	public int postSelectCount(Map<String, Object> map) {
		return dao.postSelectCount(map);
	}
}
