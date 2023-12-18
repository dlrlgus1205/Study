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

	public MemberVo memberAllCash(int num) {
		return dao.memberAllCash(num);
	}

	public void gameCashBetting(List<Object> param) {
		dao.gameCashBetting(param);
		
	}

	public void gameGcashBetting(List<Object> param) {
		dao.gameGcashBetting(param);
	}

	public void memGetCash(List<Object> param) {
		dao.memGetCash(param);
	}
	
	public void memRdGetCash(List<Object> param) {
		dao.memRdGetCash(param);
	}

	public void memGetGCash(List<Object> param) {
		dao.memGetGCash(param);
	}
	
	public void memRdGetGCash(List<Object> param) {
		dao.memRdGetGCash(param);
	}

	public void memsignUp(List<Object> param) {
		dao.memsignUp(param);
	}

	public MemberVo membertake(int memno) {
		return dao.membertake(memno);
	}
	
	public MemberVo membetcash(int num) {
		return dao.membetcash(num);
	}
	
	public MemberVo membetgcash(int num) {
		return dao.membetgcash(num);
	}
	
}
