package likes.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import util.MybatisUtil;

public class LikesDaoImpl implements ILikesDao {
	private static ILikesDao dao;
	
	private LikesDaoImpl() {}
	
	public static ILikesDao getInstance() {
		if(dao == null) {
			dao = new LikesDaoImpl();
		}
		return dao;
	}
	
	
	
	@Override
	public int Likeinsert(Map<String, Object> param) {
		SqlSession session = null;
		int cnt = 0;
		try {
			session = MybatisUtil.getSqlSession();
			
			cnt = session.insert("likes.wikiLike",param);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			if(session != null) session.close();
		}
		return cnt;
	}
	
	@Override
	public int LikeDelete(Map<String, Object> param) {
		SqlSession session = null;
		int cnt = 0;
		try {
			session = MybatisUtil.getSqlSession();
			
			cnt = session.delete("likes.likeDelete",param);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			if(session != null) session.close();
		}
		return cnt;
	}
	
	@Override
	public int LikeSelect(Map<String, Object> param) {
		SqlSession session = null;
		int cnt = 0;
		try {
			session = MybatisUtil.getSqlSession();
			
			cnt = session.selectOne("likes.likeSelect",param);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			if(session != null) session.close();
		}
		return cnt;
	}

	@Override
	public int likesCount(int post_no) {
		SqlSession session = null;
		int cnt = 0;
		try {
			session = MybatisUtil.getSqlSession();
			
			cnt = session.selectOne("likes.likesCount",post_no);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			if(session != null) session.close();
		}
		return cnt;
	}
	
}
