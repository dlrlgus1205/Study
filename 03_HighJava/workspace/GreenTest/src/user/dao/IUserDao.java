package user.dao;

import member.vo.MemberVO;
import user.vo.UserVO;

public interface IUserDao {

	public int insertUser(UserVO vo);
	
	public UserVO selectUser(String mem_id);
	
}
