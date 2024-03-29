package kr.or.ddit.prod.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.prod.vo.ProdVO;
import kr.or.ddit.util.DBUtil3;

public class ProdDaoImpl implements IProdDao {
	
	//db 관련
	Connection  con;
	PreparedStatement  stmt;
	ResultSet rs;
		
	//싱글톤 자신의 객체 
	private static IProdDao dao;
	
	//생성자 
	private ProdDaoImpl() { }
	
	//싱글톤 자신의 객체 생성 리턴 
	public static IProdDao  getDao() {
		if(dao == null) dao = new ProdDaoImpl();
		return dao;
	}
	
	@Override
	public List<ProdVO> selectByLgu(String gu) {
		List<ProdVO>  list = new ArrayList<ProdVO>();
		
		//db연결, 
		String sql = "select prod_id, prod_name from prod where prod_lgu=?";
		
		con = DBUtil3.getConnection();
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, gu);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				ProdVO  vo = new ProdVO();
				vo.setProd_id(rs.getString("prod_id"));
				vo.setProd_name(rs.getString("prod_name"));
				list.add(vo);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
				try {
					if(rs != null) rs.close();
					if(stmt != null)  stmt.close();
					if(con != null)  con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		return list;
	}

	@Override
	public ProdVO selectById(String prod_id) {
		ProdVO  vo = null;
		
		String sql = "select * from prod where prod_id=?";
		
		con = DBUtil3.getConnection();
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, prod_id);
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				vo = new ProdVO();
				vo.setProd_id(rs.getString("prod_id"));
				vo.setProd_name(rs.getString("prod_name"));
				vo.setProd_buyer(rs.getString("prod_buyer"));
				vo.setProd_lgu(rs.getString("prod_id"));
				vo.setProd_price(rs.getInt("prod_price"));
				vo.setProd_cost(rs.getInt("prod_cost"));
				vo.setProd_sale(rs.getInt("prod_sale"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null)  stmt.close();
				if(con != null)  con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return vo;
	}

}
