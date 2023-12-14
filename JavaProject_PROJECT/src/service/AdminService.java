package service;

import java.util.List;

import controller.MainController;
import dao.AdminDao;
import vo.AdminVo;

public class AdminService {
	private static AdminService instance = null;

	private AdminService() {
	}

	public static AdminService getInstance() {
		if (instance == null) {
			instance = new AdminService();
		}
		return instance;
	}
	AdminDao dao = AdminDao.getInstance();
	
	public boolean adminLogin(List<Object> param) {
		AdminVo admin = dao.adminLogin(param);
		if(admin!=null) {
			MainController.sessionStorage.put("ADMIN",admin);
			return true;
		}
		return false;
	}

	public void adminItInsert(List<Object> param) {
		dao.adminItInsert(param);
	}

	public void adminUpgradeChange(List<Object> param) {
		dao.adminUpgradeChange(param);
	}
}
