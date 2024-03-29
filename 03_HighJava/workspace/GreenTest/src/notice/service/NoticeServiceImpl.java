package notice.service;

import java.util.List;

import notice.dao.INoticeDao;
import notice.dao.NoticeDaoImpl;
import notice.vo.NoticeVO;
import post.dao.IPostDao;
import post.dao.PostDaoImpl;
import post.service.PostServiceImpl;
import post.vo.PostVO;
import reply.vo.ReplyVO;
import vo.PageVO;

public class NoticeServiceImpl implements INoticeService{
	
	private static NoticeServiceImpl service;
	private INoticeDao dao;
	
	public NoticeServiceImpl() {
		dao=NoticeDaoImpl.getInstance();
	}
	
	public static NoticeServiceImpl getInstance() {
		if(service==null) service = new NoticeServiceImpl();
		return service;
	}

	@Override
	public List<NoticeVO> getAllNotice() {
		
		return dao.getAllNotice();
	}

	@Override
	public int insertNotice(NoticeVO vo) {
		
		return dao.insertNotice(vo);
	}

	@Override
	public int updateNotice(NoticeVO vo) {
	
		return dao.updateNotice(vo);
	}

	@Override
	public int deleteNotice(int num) {
		// TODO Auto-generated method stub
		return dao.deleteNotice(num);
	}

	@Override
	public int updateCount(int num) {
		
		return dao.updateCount(num);
	}

	@Override
	public NoticeVO detailNotice(int num) {
		
		return dao.detailNotice(num);
	}

	@Override
	public PageVO pageInfo(int pageNo, String stype, String sword) {
		
		return dao.pageInfo(pageNo, stype, sword);
	}

	@Override
	public int insertReply(ReplyVO vo) {
		
		return dao.insertReply(vo);
	}

	@Override
	public int updateReply(ReplyVO vo) {
		// TODO Auto-generated method stub
		return dao.updateReply(vo);
	}

	@Override
	public int deleteReply(int renum) {
		// TODO Auto-generated method stub
		return dao.deleteReply(renum);
	}

	@Override
	public List<ReplyVO> listReply(int bonum) {
		// TODO Auto-generated method stub
		return dao.listReply(bonum);
	}

}
