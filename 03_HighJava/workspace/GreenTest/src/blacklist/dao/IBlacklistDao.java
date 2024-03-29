package blacklist.dao;

import java.util.List;
import java.util.Map;

import blacklist.vo.BlacklistVO;

public interface IBlacklistDao {

	public int insertBlacklist(BlacklistVO vo);
	
	public int deleteBlacklist(BlacklistVO vo);

	
	public List<BlacklistVO> selectBlacklistMine(String mem_id);
	
	public int getTotalCount(String mem_id);
	
	public List<BlacklistVO> selctByPage(Map<String, Object> map);

}
