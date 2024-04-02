package kr.or.ddit.servlet11.dao;

import java.util.List;
import java.util.Map;

public interface PropertyDAO {
	public List<Map<String, Object>> selectProperties(Map<String, Object> paramMap);
}
