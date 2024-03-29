package blacklist.service;

import java.util.List;
import java.util.Map;

import blacklist.vo.BlacklistPageVO;
import blacklist.vo.BlacklistVO;


public interface IBlacklistService {

	public int insertBlacklist(BlacklistVO vo);
	
	public int deleteBlacklist(BlacklistVO vo);

	
	public List<BlacklistVO> selectBlacklistMine(String mem_id);
	
	public BlacklistPageVO pageInfo(int pageNo,String mem_id);
	
	public int getTotalCount(String mem_id);
	
	public List<BlacklistVO> selctByPage(Map<String, Object> map);
	
	
}
