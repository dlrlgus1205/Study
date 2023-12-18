package service;

import java.util.List;

import dao.SugDao;
import util.JDBCUtil;
import vo.SugVo;

public class SugService {
	private static SugService instance = null;

	private SugService() {
	}

	public static SugService getInstance() {
		if (instance == null) {
			instance = new SugService();
		}
		return instance;
	}
	
	SugDao dao = SugDao.getInstance();
	public List<SugVo> suggestionDetail(String id) {
		return dao.suggestionDetail(id);
	}
	
	public List<SugVo> suggestionAllList() {
		return dao.suggestionAllList();
	}

	public List<SugVo> suggestionTitleSearch(String title) {
		return dao.suggestionTitleSearch(title);
	}

	public List<SugVo> suggestionConSearch(String con) {
		return dao.suggestionConSearch(con);
	}

	public List<SugVo> suggestionWriterSearch(String writer) {
		return dao.suggestionWriterSearch(writer);
	}

	public void suggestionInsert(List<Object> param) {
		dao.suggestionInsert(param);
	}

	public void suggestionUpdate(List<Object> param) {
		dao.suggestionUpdate(param);
	}

	public void suggestionDelete(List<Object> param) {
		dao.suggestionDelete(param);
	}
	
	public void adsuggestionDelete(List<Object> param) {
		dao.suggestionDelete(param);
	}

	public List<SugVo> suggestionDetailView(List <Object> param) {
			dao.suggestionViewPlus(param);
		return dao.suggestionDetailView(param);
	}
}
