package reply.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.vo.MemberVO;
import post.service.IPostService;
import post.vo.PostVO;
import reply.service.IReplyService;
import reply.service.ReplyServiceImpl;
import reply.vo.ReplyVO;
import user.service.IUserService;
import user.service.UserService;
import user.vo.UserVO;


@WebServlet("/replyInsert.do")
@MultipartConfig
public class ReplyInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/view/postdetail.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int reply_no = Integer.parseInt(request.getParameter("replyno"));
		String reply_content = request.getParameter("replycontent");
		
	
		
		//String reply_write_date = request.getParameter("replywritedate");
		//String reply_update_date = request.getParameter("replyupdatedate");
		
		ReplyVO replyVo = new ReplyVO();
		//PostVO postVo= new PostVO();
		replyVo.setPost_no(reply_no);
		replyVo.setReply_content(reply_content);
		

		HttpSession session = request.getSession();
		
		MemberVO memVo = (MemberVO)session.getAttribute("login");
		
		
		String mem_id = null;
		if(memVo !=null) {
			mem_id = memVo.getMem_id();
		}
		
		IUserService service2 = UserService.getInstance();
		
		UserVO userVo = service2.selectUser(mem_id);
		
		replyVo.setUser_no(userVo.getUser_no());
		
		

		IReplyService service = ReplyServiceImpl.getInstance();
	
		int  a = service.insertReply(replyVo);
		
	  //result페이지로 forword
		request.setAttribute("result", a);
		
		request.getRequestDispatcher("/view/result.jsp").forward(request, response);
	}

}
