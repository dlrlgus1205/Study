package board.service;

import java.util.List;

import board.vo.BoardVO;

public interface IBoardService {
	/**
	 * 식물 위키 리스트를 불러오는 메소드
	 * @return 
	 */
	public List<BoardVO> selectBoardList();
	
	
}
