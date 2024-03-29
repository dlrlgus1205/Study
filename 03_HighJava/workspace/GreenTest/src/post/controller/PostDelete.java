package post.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import post.service.IPostService;
import post.service.PostServiceImpl;


@WebServlet("/postDelete.do")
public class PostDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int post_no = Integer.parseInt(request.getParameter("post_no"));
		
		IPostService service = PostServiceImpl.getInstance();
		
		service.deletePost(post_no);
		
		response.sendRedirect(request.getContextPath()+"/postList.do");

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
