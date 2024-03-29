package post.dao;

import java.util.List;
import java.util.Map;

import blacklist.vo.BlacklistVO;
import likes.vo.LikesVO;
import post.vo.PostVO;
import reply.vo.ReplyVO;
import vo.PageVO;

public interface IPostDao {
	
	//페이지별 리스트 - 검색 , 페이지처리
				public List<PostVO> getAllPost(BlacklistVO vo);
				
				
				//글쓰기
				public int insertPost(PostVO vo);
				//글수정
				public int updatePost(PostVO vo);
				//글삭제
				public int deletePost(int num);
				//조회수 증가
				
				public int updateCount(int num);	
				
				public PostVO detailPost(int num);
				
				
				//전체글 갯수 얻기
				public int getTotalCount(Map<String, Object> map);
				
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

			/**
			 * 식물위키 추가 
			 * @param vo
			 * @return
			 */
			public int wikiInsert(Map<String,Object> list);

			/**
			 * 식물위키 삭제 기능
			 * @param vo
			 * @return
			 */
			public int wikiDelete(PostVO vo);

			/**
			 * 식물위키 전체 리스트 조회
			 * @return
			 */
			public List<PostVO> wikiListAll(int no);

			/**
			 * 식물위키 상세 페이지 조회
			 * @param post_no
			 * @return
			 */
			public PostVO wikiDetail(int post_no);
			
			/**
			 * 식물위키 수정
			 * @param vo
			 * @return
			 */
			public int wikiUpdate(PostVO vo);
			
			/**
			 * 식물위키 검색
			 * @param param
			 * @return
			 */
			public List<PostVO> wikiSearch(Map<String,Object> param);
			
			/**
			 * 식물위키 좋아요 기능
			 * @param vo
			 * @return
			 */
			public int wikiLike(LikesVO vo);
			
			/**
			 * 식물위키 조회수 증가 기능
			 * @param post_no
			 * @return
			 */
			public int wikiCount(int post_no);
			


			
			/**
			 * 식물스타그램 조회
			 * @return
			 */
			public List<PostVO> starListAll(int boNo);
			
			/**
			 * 식물스타그램 추가 
			 * @param vo
			 * @return
			 */
			public int starInsert (PostVO vo);

			/**
			 * 식물스타그램 삭제
			 * @param vo
			 * @return
			 */
			public int starDelete(PostVO vo);
			
			/**
			 * 식물스타그램 수정
			 * @param vo
			 * @return
			 */
			public int starUpdate(PostVO vo);
	}


