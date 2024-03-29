package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.ReplyVO;

/**
 * Servlet implementation class ReplyList
 */
@WebServlet("/replyList.do")
public class ReplyList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//요청시 전송 데이터 가져오기
		int bnum = Integer.parseInt(request.getParameter("bonum"));
		
		BoardServiceImpl service = BoardServiceImpl.getInstance();
		
		List<ReplyVO> list = service.listReply(bnum);
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/boardview/replyList.jsp").forward(request, response);
	}

}
