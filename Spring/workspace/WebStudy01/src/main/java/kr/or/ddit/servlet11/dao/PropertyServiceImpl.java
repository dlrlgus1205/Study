package kr.or.ddit.servlet11.dao;

import java.util.Map;

public class PropertyServiceImpl implements PropertyService {
	private PropertyDAO dao = new PropertyDAOImpl();
	@Override
	public void readProperties(Map<String, Object> paramMap) {
		dao.selectProperties(paramMap);
	}

}
