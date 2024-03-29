package notice.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.mybatis.config.MybatisUtil;
import notice.vo.NoticeVO;
import reply.vo.ReplyVO;
import vo.PageVO;

public class NoticeDaoImpl implements INoticeDao{
	
	
	
	private static NoticeDaoImpl dao;
	
	private NoticeDaoImpl() {
		
	}
	public static NoticeDaoImpl getInstance() {
		if(dao==null) dao =new NoticeDaoImpl();
		return dao;
	}

	@Override
	public List<NoticeVO> getAllNotice() {
		SqlSession session = null;
		
		List<NoticeVO> noticeList = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			noticeList = session.selectList("notice.getAllNotice");
		} catch (Exception e) {
		e.printStackTrace();
		}finally {
			if(session!=null) session.close();
			
		}
		return noticeList;
	}

	@Override
	public int insertNotice(NoticeVO vo) {
		
			int cnt =0;
			SqlSession session =MybatisUtil.getSqlSession();
			try {
				cnt =session.insert("notice.insertNotice", vo);
				if(cnt>0) {
					session.commit();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(session!=null);
			}
			return cnt;
		
	}

	@Override
	public int updateNotice(NoticeVO vo) {
		int cnt =0;
		SqlSession session =MybatisUtil.getSqlSession();
		try {
			cnt =session.update("notice.updateNotice", vo);
			if(cnt>0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null);
		}
		return cnt;
	}

	@Override
	public int deleteNotice(int num) {
		int cnt =0;
		SqlSession session =MybatisUtil.getSqlSession();
		try {
			cnt =session.delete("notice.deleteNotice", num);
			if(cnt>0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null);
		}
		return cnt;
	}

	@Override
	public int updateCount(int num) {
		SqlSession session = MybatisUtil.getSqlSession();
		int res=0;
		
		try {
			res =session.update("notice.updateCount" ,num);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
			
		}
		return res;
	}

	@Override
	public NoticeVO detailNotice(int num) {
		
		NoticeVO vo =null;
		SqlSession session = MybatisUtil.getSqlSession();
		try {
			System.out.println("num ============값" + num);
			vo = session.selectOne("notice.detailNotice", num);
			System.out.println("vo======================1" +vo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}
		return vo;
	}

	@Override
	public PageVO pageInfo(int pageNo, String stype, String sword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertReply(ReplyVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateReply(ReplyVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteReply(int renum) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ReplyVO> listReply(int bonum) {
		// TODO Auto-generated method stub
		return null;
	}

}
