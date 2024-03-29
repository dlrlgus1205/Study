package likes.dao;

import java.util.Map;

public interface ILikesDao {
	/**
	 * 좋아요 버튼 누르면 게시판 생성
	 * @param param post_no, mem_id 두가지
	 * @return
	 */
	public int Likeinsert(Map<String,Object> param);
	
	/**
	 * 좋아요 버튼 한번 더 누르면 좋아요 게시판 삭제
	 * @param param post_no, mem_id 두가지
	 * @return
	 */
	public int LikeDelete(Map<String,Object> param);
	
	/**
	 * 좋아요 버튼 누르면 해당 게시판이 있는지(좋아요 누름여부)확인하는 메소드
	 * @param param
	 * @return
	 */
	public int LikeSelect(Map<String,Object> param);
	
	/**
	 * 좋아요 갯수 확인 메소드
	 * @param post_no
	 * @return
	 */
	public int likesCount(int post_no);
}
