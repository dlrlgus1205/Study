package mypost.service;

import java.util.List;
import java.util.Map;

import mypost.vo.MyPostPageVO;
import mypost.vo.MyPostVO;

public interface IMyPostService {

public int getTotalCount(Map<String, Object> map);
	
	public MyPostPageVO pageInfo(int pageNo, int board_no, String stype, String sword, String mem_id, int category_no);
	
	public List<MyPostVO> selctByPage(Map<String, Object> map);
}
