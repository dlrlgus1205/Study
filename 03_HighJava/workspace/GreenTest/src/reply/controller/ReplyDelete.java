package reply.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reply.service.IReplyService;
import reply.service.ReplyServiceImpl;

/**
 * Servlet implementation class ReplyDelete
 */
@WebServlet("/replyDelete.do")
public class ReplyDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rnum = Integer.parseInt(request.getParameter("replyno"));
		
		IReplyService service = ReplyServiceImpl.getInstance();
		
		int res = service.deleteReply(rnum);
		
		request.setAttribute("result", res);
		
		request.getRequestDispatcher("/view/result.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
