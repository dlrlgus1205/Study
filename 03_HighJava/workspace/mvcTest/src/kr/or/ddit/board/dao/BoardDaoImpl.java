
package kr.or.ddit.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.board.util.DBUtil3;
import kr.or.ddit.board.vo.BoardVo;

public class BoardDaoImpl implements IBoardDao {
	private static BoardDaoImpl dao;
	
	private BoardDaoImpl() {}
	
	public static BoardDaoImpl getInstance() {
		if(dao == null) dao = new BoardDaoImpl();
		return dao;
	}
	
	@Override
	public List<BoardVo> selectAllBoard() {
		List<BoardVo> bList = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil3.getConnection();
			
			String sql = "select board_no, board_title, board_writer, board_cnt from jdbc_board";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			bList = new ArrayList<BoardVo>();
			while(rs.next()) {
				BoardVo bVo = new BoardVo();
				
				bVo.setBoard_no(rs.getInt("board_no"));
				bVo.setBoard_title(rs.getString("board_title"));
				bVo.setBoard_writer(rs.getString("board_writer"));
				bVo.setBoard_cnt(rs.getInt("board_cnt"));
				
				bList.add(bVo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) try {pstmt.close();} catch(SQLException e) {}
			if(conn != null) try {conn.close();} catch(SQLException e) {}
			if(rs != null) try {rs.close();} catch(SQLException e) {}
		}
		return bList;
	}
	
	@Override
	public int insertBoard(BoardVo bVo) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil3.getConnection();
			
			String sql = "insert into jdbc_board(board_no, board_title, board_writer, board_content)"
					+ " values(board_seq.nextVal, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bVo.getBoard_title());
			pstmt.setString(2, bVo.getBoard_writer());
			pstmt.setString(3, bVo.getBoard_content());
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) try {pstmt.close();} catch(SQLException e) {}
			if(conn != null) try {conn.close();} catch(SQLException e) {}
		}
		return cnt;
	}

	@Override
	public BoardVo getBoard(int bNo) {
		BoardVo bVo = new BoardVo();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil3.getConnection();
			
			String sql = "select board_no, board_title, board_writer, board_content, board_date, board_cnt from jdbc_board where board_no = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bNo);
			
			rs = pstmt.executeQuery();
			rs.next();
			
			bVo.setBoard_no(rs.getInt("board_no"));
			bVo.setBoard_title(rs.getString("board_title"));
			bVo.setBoard_writer(rs.getString("board_writer"));
			bVo.setBoard_content(rs.getString("board_content"));
			bVo.setBoard_date(rs.getString("board_date"));
			bVo.setBoard_cnt(rs.getInt("board_cnt"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) try {pstmt.close();} catch(SQLException e) {}
			if(conn != null) try {conn.close();} catch(SQLException e) {}
			if(rs != null) try {rs.close();} catch(SQLException e) {}
		}
		
		return bVo;
	}

	@Override
	public int updateBoard(BoardVo bVo) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil3.getConnection();
			
			String sql = "update jdbc_board"
					+ "	set board_title = ?,"
					+ " board_content = ?"
					+ "	where board_no = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bVo.getBoard_title());
			pstmt.setString(2, bVo.getBoard_content());
			pstmt.setInt(3, bVo.getBoard_no());
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) try {pstmt.close();} catch(SQLException e) {}
			if(conn != null) try {conn.close();} catch(SQLException e) {}
		}
		return cnt;
	}
	
	@Override
	public int deleteBoard(BoardVo bVo) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil3.getConnection();
			
			String sql = "delete from jdbc_board where board_no = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bVo.getBoard_no());
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) try {pstmt.close();} catch(SQLException e) {}
			if(conn != null) try {conn.close();} catch(SQLException e) {}
		}
		return cnt;
	}

	@Override
	public List<BoardVo> searchBoard(String bTitle) {
		List<BoardVo> bList = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil3.getConnection();
			bList = new ArrayList<BoardVo>();
			
			String sql = "select board_no, board_title, board_writer, board_cnt from jdbc_board\r\n" + 
					" where board_title like ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%" + bTitle + "%");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVo bVo = new BoardVo();
				
				bVo.setBoard_no(rs.getInt("board_no"));
				bVo.setBoard_title(rs.getString("board_title"));
				bVo.setBoard_writer(rs.getString("board_writer"));
				bVo.setBoard_cnt(rs.getInt("board_cnt"));
				
				bList.add(bVo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) try {pstmt.close();} catch(SQLException e) {}
			if(conn != null) try {conn.close();} catch(SQLException e) {}
			if(rs != null) try {rs.close();} catch(SQLException e) {}
		}
		return bList;
	}

}
