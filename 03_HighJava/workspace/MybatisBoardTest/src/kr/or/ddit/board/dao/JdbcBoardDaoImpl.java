package kr.or.ddit.board.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.vo.BoardVo;
import kr.or.ddit.util.MybatisUtil;

public class JdbcBoardDaoImpl implements IJdbcBoardDao {
	
	private static JdbcBoardDaoImpl dao;
	
	private JdbcBoardDaoImpl() {}
	
	public static JdbcBoardDaoImpl getInstance() {
		if(dao==null) dao = new JdbcBoardDaoImpl();
		
		return dao;
	}
	@Override
	public int insertBoard(BoardVo boardVo) {
		
		int cnt = 0;
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			
			cnt = session.insert("jdbc.insertBoard", boardVo);
			
			if(cnt>0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		return cnt;
	}

	@Override
	public int updateBoard(BoardVo boardVo) {
		int cnt = 0;
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			
			cnt = session.update("jdbc.updateBoard", boardVo);
			
			if(cnt>0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
				
		return cnt;
	}

	@Override
	public int deleteBoard(int boardNo) {
		int cnt = 0;
		
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			
			cnt = session.update("jdbc.deleteBoard", boardNo);
			
			if(cnt>0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
				
		return cnt;
	}

	@Override
	public List<BoardVo> getAllBoardList() {
		List<BoardVo> bdList = new ArrayList<BoardVo>();
		
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			
			bdList = session.selectList("jdbc.getAllBoardList");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		return bdList;
	}

	@Override
	public BoardVo getBoard(int boardNo) {
		BoardVo bdVo = new BoardVo();
		
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			
			bdVo = session.selectOne("jdbc.getBoard", boardNo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bdVo;
	}

	@Override
	public List<BoardVo> getSearchBoardList(String title) {
		List<BoardVo> bdList = new ArrayList<BoardVo>();
		
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			
			bdList = session.selectOne("jdbc.getSearchBoardList",title);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		return bdList;
	}

	@Override
	public int updateBoardCount(int boardNo) {
		int cnt = 0;
		
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			
			cnt = session.update("jdbc.updateBoardCount", boardNo);
			
			if(cnt>0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		return cnt;
	}

}
