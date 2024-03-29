package admin.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.mybatis.config.MybatisUtil;
import member.vo.MemberVO;
import post.vo.PostVO;

public class AdminDaoImpl implements IAdminDao {
	private static AdminDaoImpl dao;
	
	private AdminDaoImpl() {}
	
	public static AdminDaoImpl getInstance() {
		if(dao==null) dao= new AdminDaoImpl();
		return dao;
	}
	
	//회원 조회 기능
	@Override
	public List<MemberVO> memList(Map<String, Object> map) {
		SqlSession session = null;
		List<MemberVO> memlist = null;  // 반환값이 저장될 변수
		try {
			session = MybatisUtil.getSqlSession();
			memlist = session.selectList("admin.memList",map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		return memlist;
	}

	//회원 탈퇴기능
	@Override
	public int memDelete(String mem_id) {
		SqlSession session = null;
		int res = 0;
		try {
			session = MybatisUtil.getSqlSession();
			res = session.update("admin.memDelete",mem_id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			if(session!=null) session.close();
		}
		return res;
	}

	@Override
	public int memCount() {
		SqlSession session = null;
		int res = 0;
		try {
			session = MybatisUtil.getSqlSession();
			res = session.selectOne("admin.memCount");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			if(session!=null) session.close();
		}
		return res;
	}

	//검색 회원 총원 구하기
	@Override
	public int memSelectCount(Map<String, Object> map) {
		SqlSession session = null;
		int res = 0;
		try {
			session = MybatisUtil.getSqlSession();
			res = session.selectOne("admin.memSelectCount",map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			if(session!=null) session.close();
		}
		return res;
	}

	////////////////// 게시판 /////////////////////////////////////////
	@Override
	public List<PostVO> postList(Map<String, Object> map) {
		SqlSession session = null;
		List<PostVO> postlist = null;  // 반환값이 저장될 변수
		try {
			session = MybatisUtil.getSqlSession();
			postlist = session.selectList("admin.postList",map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		return postlist;
	}

	@Override
	public int postDelete(String mem_id) {
		SqlSession session = null;
		int res = 0;
		try {
			session = MybatisUtil.getSqlSession();
			res = session.update("admin.postDelete",mem_id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			if(session!=null) session.close();
		}
		return res;
	}

	@Override
	public int postCount() {
		SqlSession session = null;
		int res = 0;
		try {
			session = MybatisUtil.getSqlSession();
			res = session.selectOne("admin.postCount");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			if(session!=null) session.close();
		}
		return res;
	}

	@Override
	public int postSelectCount(Map<String, Object> map) {
		SqlSession session = null;
		int res = 0;
		try {
			session = MybatisUtil.getSqlSession();
			res = session.selectOne("admin.postSelectCount",map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			if(session!=null) session.close();
		}
		return res;
	}

}
