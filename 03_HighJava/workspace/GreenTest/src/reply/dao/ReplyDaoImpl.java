package reply.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.mybatis.config.MybatisUtil;
import reply.vo.ReplyVO;

public class ReplyDaoImpl implements IReplyDao{
	
	private static ReplyDaoImpl dao;
	
	private ReplyDaoImpl() {
		
	}
	public static ReplyDaoImpl getInstance() {
		if(dao==null) dao =new ReplyDaoImpl();
		return dao;
	}

	@Override
	public int insertReply(ReplyVO vo) {
		SqlSession session = MybatisUtil.getSqlSession();
		int res =0;
		
		try {
			res = session.insert("reply.insertReply", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
			
		}
		return res;
	}

	@Override
	public int updateReply(ReplyVO vo) {
		
		int res=0;
		SqlSession session = MybatisUtil.getSqlSession();
		try {
			res = session.update("reply.updateReply", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}
		return res;
	}

	@Override
	public int deleteReply(int renum) {
		int res =0;
		SqlSession session = MybatisUtil.getSqlSession();
		try {
			res = session.delete("reply.deleteReply", renum);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}
		return res;
	}

	@Override
	public List<ReplyVO> listReply(int bonum) {
		SqlSession session = MybatisUtil.getSqlSession();
		List<ReplyVO> list =null;
		
		try {
			list = session.selectList("reply.listReply", bonum);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}
		return list;
	}

}
