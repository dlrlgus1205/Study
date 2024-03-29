package post.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import post.service.IPostService;
import post.service.PostServiceImpl;
import post.vo.PostVO;


@WebServlet("/postdetail.do")
public class Postdetail2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
		int num = Integer.parseInt(request.getParameter("no"));
		
		
		IPostService service = PostServiceImpl.getInstance();
		
		
		PostVO vo = service.detailPost(num);
		
		request.setAttribute("post", vo);
		
		request.getRequestDispatcher("/view/postdetail.jsp")
		.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
