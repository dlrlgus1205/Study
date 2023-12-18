package service;


import java.util.List;

import controller.MainController;
import dao.MemberDao;
import vo.Member;

public class MemberService {
	private static MemberService instance = null;

	private MemberService() {
	}

	public static MemberService getnInstance() {
		if (instance == null) {
			instance = new MemberService();
		}
		return instance;
	}
	
	MemberDao dao = MemberDao.getnInstance();
	
	public boolean login(List<Object> param) {
		Member member = dao.login(param);
		if(member != null) {
			MainController.sessionStorage.put("login", member);
			return true;
		}
		return false;
	}
}
