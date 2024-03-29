package user.dao;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.mybatis.config.MybatisUtil;
import member.vo.MemberVO;
import user.vo.UserVO;


public class UserDao implements IUserDao {
	
	private static UserDao instance;
	
	private UserDao() { }
	
	public static UserDao getInstance() {
		if(instance==null) instance= new UserDao();
		
		return instance;
	}
	

	@Override
	public int insertUser(UserVO vo) {
		SqlSession session =null;
		int res = 0;
		
		try {
			session = MybatisUtil.getSqlSession();
			res = session.insert("user.insertUser",vo);
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
	public UserVO selectUser(String mem_id) {
		SqlSession session =null;
		UserVO vo  = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			vo = session.selectOne("user.selectUser",mem_id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		return vo;
	}



}
