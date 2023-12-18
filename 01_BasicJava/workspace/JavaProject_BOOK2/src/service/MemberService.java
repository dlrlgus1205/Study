package service;

import java.util.List;

import controller.MainController;
import dao.MemberDao;
import vo.AdminVo;
import vo.MemberVo;

public class MemberService {
	private static MemberService instance = null;
	
	private MemberService() {
	}
	
	public static MemberService getInstance() {
		if (instance == null) {
			instance = new MemberService();
		}
		return instance;
	}
	
	MemberDao dao = MemberDao.getInstance();
	
	public boolean memberLogin(List<Object> param) {
		MemberVo mem = dao.memberLogin(param);
		if(mem!=null) {
			MainController.sessionStorage.put("MEMBER02",mem);
			return true;
		}
		return false;
	}
}
