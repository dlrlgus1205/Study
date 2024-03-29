package post.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import blacklist.vo.BlacklistVO;
import kr.or.ddit.mybatis.config.MybatisUtil;
import likes.vo.LikesVO;
import post.vo.PostVO;
import reply.vo.ReplyVO;
import vo.PageVO;

public class PostDaoImpl implements IPostDao{
	
	private static PostDaoImpl dao;
	
	private PostDaoImpl() {
		
	}
	public static PostDaoImpl getInstance() {
		if(dao==null) dao =new PostDaoImpl();
		return dao;
	}

	
	@Override
	public int insertPost(PostVO vo) {
		int cnt =0;
		SqlSession session =MybatisUtil.getSqlSession();
		try {
			cnt =session.insert("post.insertPost", vo);
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
	public int updatePost(PostVO vo) {
		int cnt=0;
		SqlSession session = MybatisUtil.getSqlSession();
		
		try {
			cnt =session.update("post.updatePost", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		return cnt;
	}

	@Override
	public int deletePost(int num) {
		int cnt =0;
		SqlSession session = MybatisUtil.getSqlSession();
		try {
			cnt= session.delete("post.deletePost", num);
			if(cnt >0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		return cnt;
	}

	@Override
	public int updateCount(int num) {
		SqlSession session = MybatisUtil.getSqlSession();
		int res=0;
		
		try {
			res =session.update("post.updateCount" ,num);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
			
		}
		return res;
	}

	@Override
	public int getTotalCount(Map<String, Object> map) {
		
		int cnt =0;
		SqlSession session = MybatisUtil.getSqlSession();
		try {
			cnt = session.selectOne("post.getTotalCount", map);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.commit();
			if(session!=null) session.close();
		}
		return cnt;
	}

	@Override
	public PageVO pageInfo(int pageNo, String stype, String sword) {
		
		return null;
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
			list = session.selectList("reply.listReplay", bonum);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}
		return list;
	}
	@Override
	public List<PostVO> getAllPost(BlacklistVO vo) {
		SqlSession session = null;
		
		List<PostVO> postList = null;  // 반환값이 저장될 변수
		
		try {
			session = MybatisUtil.getSqlSession();
			postList = session.selectList("post.getAllPost",vo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		
		return postList;
	}
	@Override
	public PostVO detailPost(int num) {
		PostVO vo =null;
		SqlSession session = MybatisUtil.getSqlSession();
		try {
			vo = session.selectOne("post.detailPost", num);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}
		return vo;
	}
	
	
	@Override
	public int wikiInsert(Map<String,Object> list) {
		SqlSession session = null;
		int cnt = 0;
		try {
			session = MybatisUtil.getSqlSession();
			
			cnt = session.delete("post.wikiInsert",list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			if(session != null) session.close();
		}
		return cnt;
	}
	
	@Override
	public int wikiDelete(PostVO vo) {
		SqlSession session = null;
		int cnt = 0;
		try {
			session = MybatisUtil.getSqlSession();
			
			cnt = session.update("post.wikiDelete",vo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			if(session != null) session.close();
		}
		return cnt;
	}

	@Override
	public List<PostVO> wikiListAll(int no) {
		SqlSession session = null;
		List<PostVO> list  = new ArrayList<PostVO>();
		try {
			session = MybatisUtil.getSqlSession();
			
			list = session.selectList("post.wikiListAll",no);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		return list;
	}

	@Override
	public PostVO wikiDetail(int post_no) {
		SqlSession session = null;
		PostVO vo  = new PostVO();
		try {
			session = MybatisUtil.getSqlSession();
			
			vo = session.selectOne("post.wikiDetail",post_no);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		return vo;
	}

	@Override
	public int wikiUpdate(PostVO vo) {
		SqlSession session = null;
		int cnt = 0;
		try {
			session = MybatisUtil.getSqlSession();
			
			cnt = session.update("post.wikiUpdate",vo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			if(session != null) session.close();
		}
		return cnt;
	}

	@Override
	public List<PostVO> wikiSearch(Map<String, Object> param) {
		SqlSession session = null;
		List<PostVO> list  = new ArrayList<PostVO>();
		try {
			session = MybatisUtil.getSqlSession();
			
			list = session.selectList("post.wikiSearch",param);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		return list;
	}

	@Override
	public int wikiCount(int post_no) {
		SqlSession session = null;
		int cnt = 0;
		try {
			session = MybatisUtil.getSqlSession();
			
			cnt = session.update("post.wikiCount",post_no);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			if(session != null) session.close();
		}
		return cnt;
	}
	
	@Override
	public int wikiLike(LikesVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List<PostVO> starListAll(int boNo) {
		SqlSession session = null;
		
		List<PostVO> starList = null;  // 반환값이 저장될 변수
		
		try {
			session = MybatisUtil.getSqlSession();
			starList = session.selectList("post.starListAll",boNo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		
		return starList;
	}
	
	@Override
	public int starInsert(PostVO vo) {
		int cnt =0;
		SqlSession session =MybatisUtil.getSqlSession();
		try {
			cnt =session.insert("post.starInsert", vo);
			if(cnt>0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		return cnt;
	}
	@Override
	public int starDelete(PostVO vo) {
		SqlSession session = null;
		int cnt = 0;
		try {
			session = MybatisUtil.getSqlSession();
			
			cnt = session.update("post.starDelete",vo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			if(session != null) session.close();
		}
		return cnt;
	}
	@Override
	public int starUpdate(PostVO vo) {
		SqlSession session = null;
		int cnt = 0;
		try {
			session = MybatisUtil.getSqlSession();
			
			cnt = session.update("post.starUpdate",vo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			if(session != null) session.close();
		}
		return cnt;
	}

}
