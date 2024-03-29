package kr.or.ddit.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.PageVO;
import kr.or.ddit.board.vo.ReplyVO;

public class BoardServiceImpl implements IBoardService {
	
	private IBoardDao dao;
	
	private static BoardServiceImpl service;
	
	private BoardServiceImpl() {
		dao = BoardDaoImpl.getInstance();
	}
	
	public static BoardServiceImpl getInstance() {
		if(service==null) service = new BoardServiceImpl();
		return service;
	}
	@Override
	public List<BoardVO> selectByPage(Map<String, Object> map) {
		return dao.selectByPage(map);
	}

	@Override
	public int insertBoard(BoardVO vo) {
		return dao.insertBoard(vo);
	}

	@Override
	public int updateBoard(BoardVO vo) {
		return dao.updateBoard(vo);
	}

	@Override
	public int deleteBoard(int num) {
		return dao.deleteBoard(num);
	}

	@Override
	public int getTotalCount(Map<String, Object> map) {
		return dao.getTotalCount(map);
	}

	@Override
	public PageVO pageInfo(int pageNo, String stype, String sword) {
		
		// 전체 글 갯수
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("stype", stype);
		map.put("sword", sword);
		
		int count = this.getTotalCount(map);
		
		// 전체 페이지 수 구하기
		int perList = PageVO.getPerList();
		
		int totalPage = (int)Math.ceil((double)count / perList);
		
		// 시작 글 번호, 끝 글번호
		// 1 -> 1~3, 2 -> 4~6, 3 -> 7~9
		int start = (pageNo -1) * perList +1;
		int end = start + perList -1;
		if(end > count) end = count ;	
		
		// 시작 페이지, 끝 페이지
		// [1] -> 1~2, [2] -> 1~2, [3] -> 3~4, [4] -> 3~4
		int perPage = PageVO.getPerPage();
		int startPage = ((pageNo-1) / perPage * perPage)+1;
		int endPage = startPage + perPage -1;
		if(endPage > totalPage) endPage = totalPage;
		
		PageVO vo = new PageVO();
		vo.setStart(start);
		vo.setEnd(end);
		vo.setStartPage(startPage);
		vo.setEndPage(endPage);
		vo.setTotalPage(totalPage);
		
		return vo;
	}

	@Override
	public int updateHit(int num) {
		return dao.updateHit(num);
	}

	@Override
	public int insertReply(ReplyVO vo) {
		return dao.insertReply(vo);
	}

	@Override
	public List<ReplyVO> listReply(int bonum) {
		return dao.listReply(bonum);
	}

	@Override
	public int updateReply(ReplyVO vo) {
		return dao.updateReply(vo);
	}

	@Override
	public int deleteReply(int renum) {
		return dao.deleteReply(renum);
	}

}
