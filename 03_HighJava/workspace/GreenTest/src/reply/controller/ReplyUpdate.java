package reply.controller;

import java.io.IOException;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.mybatis.config.StreamData;
import reply.service.IReplyService;
import reply.service.ReplyServiceImpl;
import reply.vo.ReplyVO;

/**
 * Servlet implementation class ReplyUpdate
 */
@WebServlet("/replyUpdate.do")
public class ReplyUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		
		//전송 대이타 가져오기 
		 int rno =Integer.parseInt(request.getParameter("replyno"));
		 String rcont = request.getParameter("replycontent");
		
		
		//ReplyVo 에 저장 하기 
		ReplyVO rvo = new ReplyVO();
		rvo.setReply_no(rno);
		rvo.setReply_content(rcont);
		
		
		
		
		
		IReplyService service = ReplyServiceImpl.getInstance();
		
		int res = service.updateReply(rvo);
		
		request.setAttribute("result", res);
		
		request.getRequestDispatcher("/view/result.jsp").forward(request, response);
	}
}
