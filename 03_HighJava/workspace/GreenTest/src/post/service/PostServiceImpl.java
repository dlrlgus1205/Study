package post.service;


import java.util.List;
import java.util.Map;

import blacklist.vo.BlacklistVO;
import likes.vo.LikesVO;
import post.dao.IPostDao;
import post.dao.PostDaoImpl;
import post.vo.PostVO;
import reply.vo.ReplyVO;
import vo.PageVO;

public class PostServiceImpl implements IPostService{
	
	private static PostServiceImpl service;
	private IPostDao dao;
	
	public PostServiceImpl() {
		dao=PostDaoImpl.getInstance();
	}
	
	public static PostServiceImpl getInstance() {
		if(service==null) service = new PostServiceImpl();
		return service;
	}
	

	@Override
	public int insertPost(PostVO vo) {
		
		return dao.insertPost(vo);
	}

	@Override
	public int updatePost(PostVO vo) {
		
		return dao.updatePost(vo);
	}

	@Override
	public int deletePost(int num) {
		
		return dao.deletePost(num);
	}

	@Override
	public int updateCount(int num) {
		
		return dao.updateCount(num);
	}

	@Override
	public int getTotalCount(Map<String, Object> map) {
		
		return dao.getTotalCount(map);
	}

	@Override
	public PageVO pageInfo(int pageNo, String stype, String sword) {
		
		return dao.pageInfo(pageNo, stype, sword);
	}

	@Override
	public int insertReply(ReplyVO vo) {
		
		return 0;
	}

	@Override
	public int updateReply(ReplyVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteReply(int reply_no) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ReplyVO> listReply(int post_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostVO> getAllPost(BlacklistVO vo) {
		
		return dao.getAllPost(vo);
	}

	@Override
	public PostVO detailPost(int num) {
		
		//post테이블의 post_count를 1 증가
		//num = 117
		dao.updateCount(num);
		
		return dao.detailPost(num);
	}
	
	@Override
	public int wikiInsert(Map<String,Object> list) {
		return dao.wikiInsert(list);
	}

	@Override
	public int wikiDelete(PostVO vo) {
		return dao.wikiDelete(vo);
	}

	@Override
	public List<PostVO> wikiListAll(int no) {
		return dao.wikiListAll(no);
	}

	@Override
	public PostVO wikiDetail(int post_no) {
		return dao.wikiDetail(post_no);
	}

	@Override
	public int wikiUpdate(PostVO vo) {
		return dao.wikiUpdate(vo);
	}

	@Override
	public List<PostVO> wikiSearch(Map<String, Object> param) {
		return dao.wikiSearch(param);
	}

	@Override
	public int wikiLike(LikesVO vo) {
		return dao.wikiLike(vo);
	}

	@Override
	public int wikiCount(int post_no) {
		return dao.wikiCount(post_no);
	}
	


	@Override
	public List<PostVO> starListAll(int boNo) {
		return dao.starListAll(boNo);
	}

	@Override
	public int starInsert (PostVO vo) {
		return dao.starInsert(vo);
	}

	@Override
	public int starDelete(PostVO vo) {
		return dao.starDelete(vo);
	}

	@Override
	public int starUpdate(PostVO vo) {
		return dao.starUpdate(vo);
	}
	
}
