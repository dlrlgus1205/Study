package service;

import java.util.List;

import dao.FreeBoardDao;
import vo.FreeBoard;

public class FreeBoardService {
	private static FreeBoardService instance = null;

	private FreeBoardService() {
	}

	public static FreeBoardService getnInstance() {
		if (instance == null) {
			instance = new FreeBoardService();
		}
		return instance;
	}
	
	FreeBoardDao dao = FreeBoardDao.getnInstance();
	
	public List<FreeBoard> freeList(List<Object> param) {
		return dao.freeList(param);
	}

	public FreeBoard freeDetail(int board_no) {
		return dao.freeDetail(board_no);
	}

	public void freeUpdate(int board_no) {
		dao.freeUpdate(board_no);
	}
	
	public void freeDelete(int board_no) {
		dao.freeDelete(board_no);
	}
}
