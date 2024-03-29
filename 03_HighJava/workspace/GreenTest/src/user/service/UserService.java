package user.service;

import member.dao.MemberDao;
import member.vo.MemberVO;
import user.dao.UserDao;
import user.vo.UserVO;

public class UserService implements IUserService {

	private  UserDao dao;
	private static UserService instance;
	
	private UserService() { 
		dao=UserDao.getInstance();
	}
	
	public static UserService getInstance() {
		if(instance==null) instance= new UserService();
		
		return instance;
	}

	@Override
	public int insertUser(UserVO vo) {
		
		return dao.insertUser(vo);
	}

	@Override
	public UserVO selectUser(String mem_id) {
		
		return dao.selectUser(mem_id);
	}
	

}
