package kr.or.ddit.board.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.PageVO;
import kr.or.ddit.board.vo.ReplyVO;
import kr.or.ddit.config.MybatisUtil;

public class BoardDaoImpl implements IBoardDao{
	
	private static BoardDaoImpl dao;
	
	private BoardDaoImpl() {}
	
	public static BoardDaoImpl getInstance() {
		if(dao==null) dao = new BoardDaoImpl();
		return dao;
	}
	
	
	@Override
	public List<BoardVO> selectByPage(Map<String, Object> map) {
		List<BoardVO> list = new ArrayList<>();
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			
			list = session.selectList("board.selectByPage", map);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		return list;
	}

	@Override
	public int insertBoard(BoardVO vo) {
		int count = 0;
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			
			count = session.insert("board.insertBoard", vo);
			
			if(count>0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		return count;
	}

	@Override
	public int updateBoard(BoardVO vo) {
		int count = 0;
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			
			count = session.update("board.updateBoard", vo);
			
			if(count>0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		return count;
	}

	@Override
	public int deleteBoard(int num) {
		int count = 0;
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			
			count = session.delete("board.deleteBoard", num);
			
			if(count>0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		return count;
	}

	@Override
	public int getTotalCount(Map<String, Object> map) {
		int count = 0;
		
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			
			count = session.selectOne("board.getTotalCount", map);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		
		} finally {
			
			if(session!=null) session.close();
		}
		return count;
	}

	
	@Override
	public int updateHit(int num) {
		int count = 0;
		
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			
			count = session.update("board.updateHit", num);
			
			if(count>0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		return count;
	}

	@Override
	public int insertReply(ReplyVO vo) {
		int count = 0;
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			
			count = session.insert("reply.insertReply", vo);
			
			if(count>0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close(); 
		}
		return count;
	}

	@Override
	public List<ReplyVO> listReply(int bonum) {
		List<ReplyVO> list = new ArrayList<ReplyVO>();
		
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			
			list = session.selectList("reply.listReply", bonum);
		
		} catch (Exception e) {
		
			e.printStackTrace();
		
		} finally {
		
			if(session!=null) session.close();
		}
		return list;
	}

	@Override
	public int updateReply(ReplyVO vo) {
		int count = 0;
		
		SqlSession session = null;
		
		
		try {
			session = MybatisUtil.getSqlSession();
			
			count = session.update("reply.updateReply", vo);
			
			
			if(count>0) {
				session.commit();
			}
		
		} catch (Exception e) {
			
			e.printStackTrace();
		
		} finally {
			
			if(session!=null) session.close(); 
		}
		
		return count;
	}

	@Override
	public int deleteReply(int renum) {
		int count = 0;
		
		SqlSession session = null;
		
		
		try {
			session = MybatisUtil.getSqlSession();
			
			count = session.delete("reply.deleteReply", renum);
			
			
			if(count>0) {
				
				session.commit();
			}
		
		} catch (Exception e) {
			
			e.printStackTrace();
		
		} finally {
			
			if(session!=null) session.close(); 
		}
		
		return count;
	}
}
