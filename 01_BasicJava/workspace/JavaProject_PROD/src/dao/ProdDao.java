package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class ProdDao {
	private static ProdDao instance = null;

	private ProdDao() {
	}

	public static ProdDao getnInstance() {
		if (instance == null) {
			instance = new ProdDao();
		}
		return instance;
	}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public List<Map<String, Object>> prodList() {
		String sql = "SELECT * FROM PROD";
		
		return jdbc.selectList(sql);
	}

	public List<Map<String, Object>> prodTypeSearch(String type) {
		/*
		String format = " SELECT * FROM PROD\r\n" + 
						" WHERE type = '%s'";
		String sql = String.format(format, type);
		
		jdbc.selectList(sql);
		*/
		
		/*
		String sql = " SELECT * FROM PROD\r\n" + 
					 " WHERE type = '" + type +"'";
		jdbc.selectList(sql);
		*/
		
		String sql = " SELECT * FROM PROD\r\n" + 
					 " WHERE type = ? ";
		
		List<Object> param = new ArrayList();
		param.add(type);
		
		return jdbc.selectList(sql, param);
	}

	public List<Map<String, Object>> prodNameSearch(String name) {
		String sql = " SELECT * FROM PROD\r\n" + 
					 " WHERE name like '%' || ? || '%'";
		
		List<Object> param = new ArrayList();
		param.add(name);
		
		return jdbc.selectList(sql, param);
	}
	
	public void prodSale(List<Object> param) {
		String sql = "  UPDATE PROD\r\n" + 
					 " SET COUNT = (SELECT COUNT - ?\r\n" + 
					 "                FROM PROD\r\n" + 
					 "               WHERE NO = ?)\r\n" + 
					 " WHERE NO = ?";
		jdbc.update(sql, param);
	}
}
