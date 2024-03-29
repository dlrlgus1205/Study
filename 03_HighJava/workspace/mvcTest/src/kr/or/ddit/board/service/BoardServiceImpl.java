package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.vo.BoardVo;

public class BoardServiceImpl implements IBoardService {
	private static BoardServiceImpl service;
	
	private BoardServiceImpl() {
		dao = BoardDaoImpl.getInstance();
	}
	public static BoardServiceImpl getInstance() {
		if(service == null) service = new BoardServiceImpl();
		return service;
	}
	
	private IBoardDao dao;
	
	@Override
	public List<BoardVo> selectAllBoard() {
		return dao.selectAllBoard();
	}
	
	@Override
	public int insertBoard(BoardVo bVo) {
		return dao.insertBoard(bVo);
	}

	@Override
	public BoardVo getBoard(int bNo) {
		return dao.getBoard(bNo);
	}
	
	@Override
	public int updateBoard(BoardVo bVo) {
		return dao.updateBoard(bVo);
	}

	@Override
	public int deleteBoard(BoardVo bVo) {
		return dao.deleteBoard(bVo);
	}

	@Override
	public List<BoardVo> searchBoard(String bTitle) {
		return dao.searchBoard(bTitle);
	}
}
