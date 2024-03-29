package kr.or.ddit.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;

/**
 * Servlet implementation class ReplyDelete
 */
@WebServlet("/replyDelete.do")
public class ReplyDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ReplyDelete() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int rnum = Integer.parseInt(request.getParameter("renum"));
		
		BoardServiceImpl service = BoardServiceImpl.getInstance();
		
		int res = service.deleteReply(rnum);
		
		request.setAttribute("result", res);
		
		request.getRequestDispatcher("/boardview/result.jsp").forward(request, response);
	}

}
