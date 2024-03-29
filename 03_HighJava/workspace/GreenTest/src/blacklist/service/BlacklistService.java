package blacklist.service;

import java.util.List;
import java.util.Map;

import blacklist.dao.BlacklistDao;
import blacklist.vo.BlacklistPageVO;
import blacklist.vo.BlacklistVO;

public class BlacklistService implements IBlacklistService {

private BlacklistDao dao;
private static BlacklistService instance;
	
	private BlacklistService() { 
		dao = BlacklistDao.getInstance();
	}
	
	public static BlacklistService getInstance() {
		if(instance==null) instance= new BlacklistService();
		
		return instance;
	}
	
	
	@Override
	public int insertBlacklist(BlacklistVO vo) {
		
		return dao.insertBlacklist(vo);
	}

	@Override
	public int deleteBlacklist(BlacklistVO vo) {
		
		return dao.deleteBlacklist(vo);
	}


	@Override
	public List<BlacklistVO> selectBlacklistMine(String mem_id) {
		
		return dao.selectBlacklistMine(mem_id);
	}

	@Override
	public BlacklistPageVO pageInfo(int pageNo,String mem_id) {
		
		int count = this.getTotalCount(mem_id);
		
		//전체 페이지수 구하기
		int perList = BlacklistPageVO.getPerList();
		
		int totalPage = (int)Math.ceil((double)count/perList);
		
		//시작 글번호
		int start = (pageNo -1) * perList + 1;
		int end = start + perList -1;
		if(end>count) end = count;
		
		//시작페이지
		int perPage = BlacklistPageVO.getPerPage(); 
		int startPage = ((pageNo-1) / perPage * perPage)+1;
		int endPage = startPage + perPage - 1;
		if(endPage > totalPage) endPage = totalPage ;
		
		BlacklistPageVO vo = new BlacklistPageVO();
		vo.setStart(start);
		vo.setEnd(end);
		vo.setStartPage(startPage);
		vo.setEndPage(endPage);
		vo.setTotalPage(totalPage);
		
	
		return vo;
	}

	@Override
	public int getTotalCount(String mem_id) {
		
		return dao.getTotalCount(mem_id);
	}

	@Override
	public List<BlacklistVO> selctByPage(Map<String, Object> map) {
		
		return dao.selctByPage(map);
	}


}
