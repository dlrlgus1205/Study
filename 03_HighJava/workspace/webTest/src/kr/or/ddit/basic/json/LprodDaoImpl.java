package kr.or.ddit.basic.json;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;

public class LprodDaoImpl implements ILprodDao {
	private static LprodDaoImpl dao;
	
	private LprodDaoImpl() {
	}
	
	public static LprodDaoImpl getInstance() {
		if(dao == null) dao = new LprodDaoImpl();
		return dao;
	}
	@Override
	public List<LprodVo> getAllLprod() {
		// 반환값이 저장될 변수
		List<LprodVo> lprodList = null;
		SqlSession session = null;
		try {
			session = MybatisUtil.getSqlSession();
			
			lprodList = session.selectList("Lprod.getAllLprod");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		return lprodList;
	}

}
