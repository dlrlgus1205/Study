package blacklist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import blacklist.vo.BlacklistVO;
import kr.or.ddit.mybatis.config.MybatisUtil;
import member.dao.MemberDao;

public class BlacklistDao implements IBlacklistDao {

private static BlacklistDao instance;
	
	private BlacklistDao() { }
	
	public static BlacklistDao getInstance() {
		if(instance==null) instance= new BlacklistDao();
		
		return instance;
	}
	
	
	@Override
	public int insertBlacklist(BlacklistVO vo) {
		SqlSession session =null;
		int res = 0;
		
		try {
			session = MybatisUtil.getSqlSession();
			res = session.insert("blacklist.insertBlacklist",vo);
			if(res>0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		return res;
	}

	@Override
	public int deleteBlacklist(BlacklistVO vo) {
		SqlSession session =null;
		int res = 0;
		
		try {
			session = MybatisUtil.getSqlSession();
			res = session.delete("blacklist.deleteBlacklist",vo);
			if(res>0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		return res;
	}


	@Override
	public List<BlacklistVO> selectBlacklistMine(String mem_id) {
		SqlSession session =null;
		List<BlacklistVO> list = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			list = session.selectList("blacklist.selectBlacklistMine",mem_id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		return list;
	}

	@Override
	public int getTotalCount(String mem_id) {
		SqlSession session =null;
		int res = 0;
		
		try {
			session = MybatisUtil.getSqlSession();
			res = session.selectOne("blacklist.getTotalCount",mem_id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		return res;
	}

	@Override
	public List<BlacklistVO> selctByPage(Map<String, Object> map) {
		SqlSession session =null;
		List<BlacklistVO> list = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			list = session.selectList("blacklist.selctByPage",map);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		return list;
		
	}


}
