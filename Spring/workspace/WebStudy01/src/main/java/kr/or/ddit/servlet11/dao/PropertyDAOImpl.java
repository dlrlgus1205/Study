package kr.or.ddit.servlet11.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.db.ConnectionFactory_HikariCP;
import kr.or.ddit.exception.PersistenceException;
import kr.or.ddit.utils.NamingUtils;

public class PropertyDAOImpl implements PropertyDAO {

	@Override
	public List<Map<String, Object>> selectProperties(Map<String, Object> paramMap) {
		try(
		Connection conn = ConnectionFactory_HikariCP.getConnection();
		Statement stmt = conn.createStatement();
		){
			StringBuffer sql = new StringBuffer();
			sql.append(" SELECT PROPERTY_NAME, PROPERTY_VALUE, DESCRIPTION ");
			sql.append(" FROM DATABASE_PROPERTIES ");
		  
			ResultSet rs = stmt.executeQuery(sql.toString());
			ResultSetMetaData metaData = rs.getMetaData();
			int count = metaData.getColumnCount();
		  
			String[] headers = new String[count];
			String[] propsName = new String[count];
			paramMap.put("headers", headers);
			paramMap.put("propsName", propsName);
			
			for(int i = 1; i <= count; i++){
				headers[i - 1] = metaData.getColumnName(i);
				propsName[i - 1] = NamingUtils.snakeToCamel(headers[i - 1]);
			}
			
			List<Map<String, Object>> list = new ArrayList<>();
			paramMap.put("list", list);
			while(rs.next()) { 
				Map<String,Object> map = new HashMap<>();
				list.add(map);
				
				for(String columnName : headers){
					map.put(NamingUtils.snakeToCamel(columnName), rs.getString(columnName));
				}
			}
			rs.close();
			return list;
		}catch (SQLException e) {
			throw new PersistenceException(e);
		}
	}
}
