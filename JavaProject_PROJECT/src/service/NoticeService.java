package service;

import java.util.List;

import dao.NoticeDao;
import vo.NoticeVo;

public class NoticeService {
	private static NoticeService instance = null;

	private NoticeService() {
	}

	public static NoticeService getInstance() {
		if (instance == null) {
			instance = new NoticeService();
		}
		return instance;
	}
	
	NoticeDao dao = NoticeDao.getInstance();

	public void noticeInsert(List<Object> param) {
		dao.noticeInsert(param);
	}

	public List<NoticeVo> noticeAllLest() {
		return dao.noticeAllLest();
	}

	public void noticeUpdate(List<Object> param) {
		dao.noticeUpdate(param);
	}

	public void noticeDelete(List<Object> param) {
		dao.noticeDelete(param);
	}

	public List<NoticeVo> noticeDetail(List<Object> param) {
		       dao.noticeViewPlus(param);
		return dao.noticeDetail(param);
	}
	
}
