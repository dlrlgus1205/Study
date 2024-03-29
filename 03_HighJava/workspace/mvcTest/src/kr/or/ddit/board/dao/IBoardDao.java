package kr.or.ddit.board.dao;

import java.util.List;

import kr.or.ddit.board.vo.BoardVo;

public interface IBoardDao {
	/**
	 * 전체 게시글
	 * @return BoardVO객체가 저장된 List객체
	 */
	public List<BoardVo> selectAllBoard();
	
	/**
	 * 새글 작성
	 * @param bVo DB에 insert할 자료가 저장될 BoardVo객체
	 * @return 작업 성공 = 1, 작업 실패 = 0
	 */
	public int insertBoard(BoardVo bVo);
	
	/**
	 *  게시글보기
	 * @param bNo
	 * @return 
	 */
	public BoardVo getBoard(int bNo);
	
	/**
	 *  글 수정
	 * @param bVo
	 * @return
	 */
	public int updateBoard(BoardVo bVo);
	
	/**
	 *  글 삭제
	 * @param bVo
	 * @return 작업성공 = 1, 작업실패 = 0
	 */
	public int deleteBoard(BoardVo bVo);
	
	/**
	 *  검색
	 * @param bTitle
	 * @return
	 */
	public List<BoardVo> searchBoard(String bTitle);
}
