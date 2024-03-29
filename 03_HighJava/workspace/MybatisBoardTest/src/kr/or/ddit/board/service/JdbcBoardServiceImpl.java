package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.dao.IJdbcBoardDao;
import kr.or.ddit.board.dao.JdbcBoardDaoImpl;
import kr.or.ddit.board.vo.BoardVo;

public class JdbcBoardServiceImpl implements IJdbcBoardService {
	
	private IJdbcBoardDao dao;
	
	private static JdbcBoardServiceImpl service;
	
	private JdbcBoardServiceImpl() {
		dao = JdbcBoardDaoImpl.getInstance();
	}
	
	public static JdbcBoardServiceImpl getInstance() {
		
		if(service==null) service = new JdbcBoardServiceImpl();
		
		return service;
	}
	
	@Override
	public int insertBoard(BoardVo boardVo) {
		return dao.insertBoard(boardVo);
	}

	@Override
	public int updateBoard(BoardVo boardVo) {
		return dao.updateBoard(boardVo);
	}

	@Override
	public int deleteBoard(int boardNo) {
		return dao.deleteBoard(boardNo);
	}

	@Override
	public List<BoardVo> getAllBoardList() {
		return dao.getAllBoardList();
	}

	@Override
	public BoardVo getBoard(int boardNo) {
		if(updateBoardCount(boardNo) == 0) {
			return null;
		}
		
		return dao.getBoard(boardNo);
	}

	@Override
	public List<BoardVo> getSearchBoardList(String title) {
		return dao.getSearchBoardList(title);
	}

	@Override
	public int updateBoardCount(int boardNo) {
		return dao.updateBoardCount(boardNo);
	}

}
