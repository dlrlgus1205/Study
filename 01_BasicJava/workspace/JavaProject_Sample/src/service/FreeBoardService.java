package service;

import java.util.List;
import java.util.Map;

import dao.FreeBoardDao;

/**
 * 자유게시판 서비스
 * 
 * dao > service > controller 
 * 연결되는 처리 작업을 주로 진행함
 * 
 * 작성자 : lgh
 * 작성일 : 2023.11.28
 *
 */
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
	FreeBoardDao freeDao = FreeBoardDao.getnInstance();

	public List<Map<String, Object>> freeList() {
		return freeDao.freeList();
	}

	public void updateBoard(List<Object> param, String colum) {
		freeDao.updateBoard(param, colum);
	}

	public Map<String, Object> freeDetail(int no) {
		return freeDao.freeDetail(no);
	}

	public void delete(List<Object> param, String colum) {
		freeDao.updateBoard(param, colum);
	}

	public void writeBoard(List<Object> param) {
		freeDao.writeBoard(param);
	}
}
