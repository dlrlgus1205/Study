package kr.or.ddit.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import kr.or.ddit.mvc.util.DBUtil3;
import kr.or.ddit.mvc.vo.MemberVo;

public class MemberDaoImpl implements IMemberDao {
	private Logger logger = Logger.getLogger(MemberDaoImpl.class);
	// 싱글톤으로 하는법
	// 1번
	private static MemberDaoImpl dao;
	
	// 2번
	private MemberDaoImpl() { }
	
	// 3번
	public static MemberDaoImpl getInstance() {
		if(dao==null) dao = new MemberDaoImpl();
		return dao;
	}

	@Override
	public int insertMember(MemberVo memVo) {
		
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil3.getConnection();
			logger.debug("Connection객체 생성...");
			
			String sql = "insert into mymember(mem_id,mem_pass,mem_name,mem_tel,mem_addr)"
					+ "		values(?,?,?,?,?)";
			
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, memVo.getMem_id());
			pstmt.setString(2, memVo.getMem_pass());
			pstmt.setString(3, memVo.getMem_name());
			pstmt.setString(4, memVo.getMem_tel());
			pstmt.setString(5, memVo.getMem_addr());
			
			logger.debug("PreparedStatement객체 생성");
			logger.debug("실행 SQL : " + sql);
			logger.debug("사용 데이터 : ["+memVo.getMem_id()+","+memVo.getMem_pass() + "," + memVo.getMem_name() + "," +memVo.getMem_tel()+","+memVo.getMem_addr());
			
			cnt = pstmt.executeUpdate();
			logger.info("insert 작업 성공!!!");
		} catch (SQLException e) {
			logger.error("insert 작업 실패~~~",e);
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
			logger.info("사용했던 자원 반납...");
		}
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil3.getConnection();
			logger.debug("Connection객체 생성...");

			String sql = "delete from mymember where mem_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			logger.debug("PreparedStatement객체 생성");
			logger.debug("실행 SQL : " + sql);
			logger.debug("사용 데이터 : " + memId);
			cnt = pstmt.executeUpdate();
			logger.info("delete 작업 성공!!!");

		} catch (SQLException e) {
			logger.error("delete 작업 실패~~~",e);
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
			logger.info("사용했던 자원 반납...");

		}
		return cnt;
	}

	@Override
	public int updateMember(MemberVo memVo) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil3.getConnection();
			logger.debug("Connection객체 생성...");

			String sql = "update mymember"
					+ "		 set mem_pass = ?,"
					+ "			 mem_name = ?,"
					+ "			 mem_tel = ?,"
					+ "			 mem_addr = ?"
					+ "		where mem_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memVo.getMem_pass());
			pstmt.setString(2, memVo.getMem_name());
			pstmt.setString(3, memVo.getMem_tel());
			pstmt.setString(4, memVo.getMem_addr());
			pstmt.setString(5, memVo.getMem_id());
			
			logger.debug("PreparedStatement객체 생성");
			logger.debug("실행 SQL : " + sql);
			logger.debug("사용 데이터 : " + memVo.getMem_id()+","+memVo.getMem_pass()+","+memVo.getMem_name()+","+memVo.getMem_tel()+","+memVo.getMem_addr());
			
			cnt = pstmt.executeUpdate();
			logger.info("update 작업 성공!!!");

		} catch (SQLException e) {
			logger.error("update 작업 실패~~~",e);
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
			logger.info("사용했던 자원 반납..");
		}
		return cnt;
	}

	@Override
	public List<MemberVo> getAllMember() {
		List<MemberVo> memList = null;	// 반환값이 저장될 변수 선언
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil3.getConnection();
			logger.debug("Connection객체 생성...");
			
			String sql = "select * from mymember";
			
			pstmt = conn.prepareStatement(sql);
			
			logger.debug("PreparedStatement객체 생성");
			logger.debug("실행 SQL : " + sql);
			
			rs = pstmt.executeQuery();
			logger.info("select 작업 성공!!!");
			memList = new ArrayList<MemberVo>();
			while(rs.next()) {
				// 1개의 레코드가 저장될 VO객체 생성
				MemberVo memVo = new MemberVo();
				
				//ResultSet객체의 데이터를 꺼내서 VO객체에 저장한다.
				memVo.setMem_id(rs.getString("mem_id"));
				memVo.setMem_pass(rs.getString("mem_pass"));
				memVo.setMem_name(rs.getString("mem_name"));
				memVo.setMem_tel(rs.getString("mem_tel"));
				memVo.setMem_addr(rs.getString("mem_addr"));
				logger.debug("가져온 결과 : " + memVo.getMem_id()+","+memVo.getMem_pass()+","+memVo.getMem_name()+","+memVo.getMem_tel()+","+memVo.getMem_addr());
				// List에 VO객체를 추가한다.
				memList.add(memVo);
			}
			
			
		} catch (SQLException e) {
			logger.error("select 작업 실패 ~~~~",e);
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
			if(rs!=null) try {rs.close();} catch(SQLException e) {}
			logger.info("사용했던 자원 반납...");
		}
		return memList;
	}

	@Override
	public int getMemberCount(String memId) {
		int cnt = 0;	// 반환값이 저장될 변수 선언
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil3.getConnection();
			logger.debug("Connection객체 생성");
			String sql = "select count(*) cnt from mymember where mem_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			logger.debug("PreparedStatement객체 생성");
			logger.debug("실행 SQL : " + sql);
			logger.debug("사용 데이터 : " + memId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				cnt = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
			if(rs!=null) try {rs.close();} catch(SQLException e) {}
		}
		return cnt;
	}

	@Override
	public int updateMember2(Map<String, String> param) {
		//회원ID(memberId), 수정할 컬럼명(fieldName), 수정할 데이터(data)
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil3.getConnection();
			logger.debug("Connection객체 생성...");

			String sql = "update mymember set " + param.get("fieldName") + " = ? where mem_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, param.get("data"));
			pstmt.setString(2, param.get("memberId"));
			logger.debug("PreparedStatement객체 생성");
			logger.debug("실행 SQL : " + sql);
			logger.debug("사용 데이터 : " + param.get("data")+","+param.get("memberId"));
			
			cnt = pstmt.executeUpdate();
			logger.info("update 작업 성공!!!!");
		} catch (SQLException e) {
			logger.error("update 작업 실패~~~",e);
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
			logger.info("사용했던 자원 반납...");
		}
		return cnt;
	}
	
}
