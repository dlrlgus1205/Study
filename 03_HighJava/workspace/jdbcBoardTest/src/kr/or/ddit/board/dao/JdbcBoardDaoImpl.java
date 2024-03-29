package kr.or.ddit.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.board.vo.BoardVo;
import kr.or.ddit.util.DBUtil3;

public class JdbcBoardDaoImpl implements IJdbcBoardDao {
	//싱글톤 순서
	//1번
	private static JdbcBoardDaoImpl dao;
	
	//2번
	private JdbcBoardDaoImpl() {}
	
	//3번
	public static JdbcBoardDaoImpl getInstance() {
		if(dao==null) dao = new JdbcBoardDaoImpl();
		
		return dao;
	}
	
	@Override
	public int insertBoard(BoardVo boardVo) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil3.getConnection();
			
			String sql = "insert into jdbc_board(board_no,board_title,board_writer,board_content)"
					+ "		values(board_seq.nextval,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, boardVo.getBoard_title());
			pstmt.setNString(2, boardVo.getBoard_writer());
			pstmt.setNString(3, boardVo.getBoard_content());
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
		}
				
		return cnt;
	}

	@Override
	public int updateBoard(BoardVo boardVo) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil3.getConnection();
			
			String sql = "update jdbc_board set board_title = ?, board_content = ?, board_date = sysdate where board_no = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardVo.getBoard_title());
			pstmt.setString(2, boardVo.getBoard_content());
			pstmt.setInt(3, boardVo.getBoard_no());
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn!=null) try {conn.close();} catch (SQLException e) {}
			if(pstmt!=null) try {pstmt.close();} catch (SQLException e) {}
		}
		return 0;
	}

	@Override
	public int deleteBoard(int boardNo) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil3.getConnection();
			
			String sql = "delete from jdbc_board where board_no = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn!=null) try {conn.close();} catch (SQLException e) {}
			if(pstmt!=null) try {pstmt.close();} catch (SQLException e) {}
		}
		
		return cnt;
	}

	@Override
	public List<BoardVo> getAllBoardList() {
		List<BoardVo> boardList = new ArrayList<BoardVo>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil3.getConnection();
			
			String sql = "select * from jdbc_board"
					+ "		order by board_no desc";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVo boardVo = new BoardVo();
				boardVo.setBoard_no(rs.getInt("board_no"));
				boardVo.setBoard_title(rs.getString("board_title"));
				boardVo.setBoard_writer(rs.getString("board_writer"));
				boardVo.setBoard_content(rs.getString("board_content"));
				boardVo.setBoard_date(rs.getString("board_date"));
				boardVo.setBoard_cnt(rs.getInt("board_cnt"));
				
				boardList.add(boardVo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
			if(rs!=null) try {rs.close();} catch(SQLException e) {}
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
		}
		return boardList;
	}

	@Override
	public BoardVo getBoard(int boardNo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		BoardVo boardVo = null;
		try {
			conn = DBUtil3.getConnection();
			
			String sql = "select * from jdbc_board"
					+ "		where board_no = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				boardVo = new BoardVo();
				boardVo.setBoard_no(rs.getInt("board_no"));
				boardVo.setBoard_title(rs.getString("board_title"));
				boardVo.setBoard_writer(rs.getString("board_writer"));
				boardVo.setBoard_content(rs.getString("board_content"));
				boardVo.setBoard_date(rs.getString("board_date"));
				boardVo.setBoard_cnt(rs.getInt("board_cnt"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
			if(rs!=null) try {rs.close();} catch(SQLException e) {}
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
		}
		return boardVo;
	}

	@Override
	public List<BoardVo> getSearchBoardList(String title) {
		List<BoardVo> boardList = new ArrayList<BoardVo>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil3.getConnection();
			
			String sql = "select * from jdbc_board"
					+ "		where board_title like '%' || ? || '%'"
					+ "		order by board_no desc ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVo boardVo = new BoardVo();
				boardVo.setBoard_no(rs.getInt("board_no"));
				boardVo.setBoard_title(rs.getString("board_title"));
				boardVo.setBoard_writer(rs.getString("board_writer"));
				boardVo.setBoard_content(rs.getString("board_content"));
				boardVo.setBoard_date(rs.getString("board_date"));
				boardVo.setBoard_cnt(rs.getInt("board_cnt"));
				
				boardList.add(boardVo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
			if(rs!=null) try {rs.close();} catch(SQLException e) {}
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
		}
		return boardList;
	}
	

	@Override
	public int updateBoardCount(int boardNo) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil3.getConnection();
			
			String sql = "update jdbc_board set"
					+ "		board_cnt = board_cnt+1"
					+ "		where board_no = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
		}
		return cnt;
	}

}
