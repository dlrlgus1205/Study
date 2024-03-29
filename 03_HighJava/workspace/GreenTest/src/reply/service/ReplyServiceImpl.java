package reply.service;

import java.util.List;

import post.dao.IPostDao;
import post.dao.PostDaoImpl;
import post.service.PostServiceImpl;
import reply.dao.IReplyDao;
import reply.dao.ReplyDaoImpl;
import reply.vo.ReplyVO;

public class ReplyServiceImpl implements IReplyService{
	
	private static ReplyServiceImpl service;
	private IReplyDao dao;
	
	public ReplyServiceImpl() {
		dao=ReplyDaoImpl.getInstance();
	}
	
	public static ReplyServiceImpl getInstance() {
		if(service==null) service = new ReplyServiceImpl();
		return service;
	}

	@Override
	public int insertReply(ReplyVO vo) {
		
		return dao.insertReply(vo);
	}

	@Override
	public int updateReply(ReplyVO vo) {
		
		return dao.updateReply(vo);
	}

	@Override
	public int deleteReply(int renum) {
		
		return dao.deleteReply(renum);
	}

	@Override
	public List<ReplyVO> listReply(int bonum) {
		
		return dao.listReply(bonum);
	}

}
