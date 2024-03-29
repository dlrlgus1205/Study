package mypost.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.mybatis.config.MybatisUtil;
import mypost.vo.MyPostPageVO;
import mypost.vo.MyPostVO;

public class MyPostDao implements IMyPostDao {
	
private static MyPostDao instance;
	
	private MyPostDao() { }
	
	public static MyPostDao getInstance() {
		if(instance==null) instance= new MyPostDao();
		
		return instance;
	}

	@Override
	public int getTotalCount(Map<String, Object> map) {
		int num = 0;
		SqlSession session = null;
		try {
			session = MybatisUtil.getSqlSession();
			num = session.selectOne("mypost.getTotalCount", map);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		return num;
	}

	@Override
	public List<MyPostVO> selctByPage(Map<String, Object> map) {
		List<MyPostVO> list = null;
		SqlSession session = null;
		try {
			session = MybatisUtil.getSqlSession();
			list = session.selectList("mypost.selctByPage", map);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		return list;
	}

}
