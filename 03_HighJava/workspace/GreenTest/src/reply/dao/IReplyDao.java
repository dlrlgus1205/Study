package reply.dao;

import java.util.List;

import reply.vo.ReplyVO;

public interface IReplyDao {
	
	//댓글 넣기
	public int insertReply(ReplyVO vo);

	// 댓글 수정
	public int updateReply(ReplyVO vo);

	// 댓글 삭제
	public int deleteReply(int no);

	// 댓글 리스트 가져오기
	public List<ReplyVO> listReply(int bonum);

}
