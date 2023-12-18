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
			MainController.sessionStorage.put("ADMIN02",admin);
			return true;
		}
		return false;
	}
}
