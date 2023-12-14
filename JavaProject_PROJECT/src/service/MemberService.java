package service;

import java.util.List;

import controller.MainController;
import dao.MemberDao;
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
			MainController.sessionStorage.put("MEMBER",mem);
			return true;
		}
		return false;
	}

	public void memBlacklist(List<Object> param) {
		dao.memBlacklist(param);
	}

	public List<MemberVo> memberAllList() {
		return dao.memberAllList();
	}

	public void membercashPurchase(List<Object> param) {
		dao.membercashPurchase(param);
	}

	public void memberCashChange(int change) {
		dao.memberCashChange(change);
	}
	
	public MemberVo membercash() {
		return dao.membercash();
	}

	public MemberVo membergcash() {
		return dao.membergcash();
	}
	
}
