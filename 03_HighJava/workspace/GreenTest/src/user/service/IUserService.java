package user.service;

import member.vo.MemberVO;
import user.vo.UserVO;

public interface IUserService {

	public int insertUser(UserVO vo);
	
	public UserVO selectUser(String mem_id);
	
}
