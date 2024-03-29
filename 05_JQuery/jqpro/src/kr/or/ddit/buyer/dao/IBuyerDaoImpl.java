package kr.or.ddit.buyer.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.buyer.vo.BuyerVO;
import kr.or.ddit.config.MybatisUtil;

public class IBuyerDaoImpl implements IBuyerDao {

	private static IBuyerDao dao = null;
	
	private IBuyerDaoImpl(){
		
	}
	
	public static IBuyerDao getInstance(){
		if(dao == null){
			dao = new IBuyerDaoImpl();
		}
		return dao;
	}

	@Override
	public List<BuyerVO> getNameList() throws SQLException {
		SqlSession  session = null;
		List<BuyerVO> list = null;
		try {
			session = MybatisUtil.getSqlSession();
			list = session.selectList("buyer.buyerNameList");
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			session.commit();
			session.close();
		}
		return list;
	}

	@Override
	public BuyerVO getBuyerDetail(String buyer_id) throws SQLException {
		SqlSession  session = null;
		BuyerVO vo = null;
		try {
			session = MybatisUtil.getSqlSession();
			vo = session.selectOne("buyer.buyerDetail",buyer_id );
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			session.commit();
			session.close();
		}
		return vo;
		
	}

}




