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

	public void adminItNameUpdate(List<Object> param) {
		dao.adminItNameUpdate(param);
	}
	public void adminItConUpdate(List<Object> param) {
		dao.adminItConUpdate(param);
	}
	public void adminItClsUpdate(List<Object> param) {
		dao.adminItClsUpdate(param);
	}
	public void adminItTypeUpdate(List<Object> param) {
		dao.adminItTypeUpdate(param);
	}
	public void adminItPriceUpdate(List<Object> param) {
		dao.adminItPriceUpdate(param);
	}

	public void adminItStgradeUpdate(List<Object> param) {
		dao.adminItStgradeUpdate(param);
	}
}
