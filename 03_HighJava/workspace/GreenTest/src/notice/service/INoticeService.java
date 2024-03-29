package notice.service;

import java.util.List;

import notice.vo.NoticeVO;
import post.vo.PostVO;
import reply.vo.ReplyVO;
import vo.PageVO;

public interface INoticeService {


	
	public List<NoticeVO> getAllNotice();
	
	
	
	
	//글쓰기
	public int insertNotice(NoticeVO vo);
	//글수정
	public int updateNotice(NoticeVO vo);
	//글삭제
	public int deleteNotice(int num);
	//조회수 증가
	
	public int updateCount(int num);	
	
	public NoticeVO detailNotice(int num);
	
	
	//전체글 갯수 얻기
	
	
	//계산-시작페이지, 끝페이지, 시작글번호, 끝글번호
	public PageVO pageInfo(int pageNo, String stype, String sword);
	
	//댓글 쓰기 
	public int insertReply(ReplyVO vo);
	//댓글 수정
	public int updateReply(ReplyVO vo);
	//댓글 삭제 
	public int deleteReply(int renum);
	
	//댓글 리스트 가져오기
	public List<ReplyVO>listReply(int bonum);

}

