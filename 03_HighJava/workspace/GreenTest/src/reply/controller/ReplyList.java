package reply.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reply.service.IReplyService;
import reply.service.ReplyServiceImpl;
import reply.vo.ReplyVO;

/**
 * Servlet implementation class ReplyList
 */
@WebServlet("/replyList.do")
public class ReplyList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int bnum = Integer.parseInt(request.getParameter("postno"));

		
		
		
		IReplyService service = ReplyServiceImpl.getInstance();
		
		List<ReplyVO> list = service.listReply(bnum);
		
		request.setAttribute("list", list);
		System.out.println("repl list ===========" +  list);
		
		//request.getRequestDispatcher("/view/postdetail.jsp").forward(request, response);
		
		request.getRequestDispatcher("/view/postreply.jsp").forward(request, response);
	}

}
