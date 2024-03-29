package mypost.dao;

import java.util.List;
import java.util.Map;

import mypost.vo.MyPostPageVO;
import mypost.vo.MyPostVO;

public interface IMyPostDao {

	public int getTotalCount(Map<String, Object> map);
	
	public List<MyPostVO> selctByPage(Map<String, Object> map);
	
}
