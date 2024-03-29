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


@WebServlet("/postUpdate.do")
public class PostUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String postno =request.getParameter("post_no");
		
		IPostService service = PostServiceImpl.getInstance();
		
		PostVO postVo = service.detailPost(Integer.parseInt(postno));
		
		request.setAttribute("post", postVo);
		request.getRequestDispatcher("/view/postUpdateForm.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
		
	int post_no = Integer.parseInt(request.getParameter("post_no"));
	
	String post_title= request.getParameter("post_title");
	String post_content= request.getParameter("post_content");
	
	PostVO postVo = new PostVO();
	postVo.setPost_title(post_title);
	postVo.setPost_content(post_content);
	postVo.setPost_no(post_no);
	
	IPostService service = PostServiceImpl.getInstance();
	service.updatePost(postVo);
	
	response.sendRedirect(request.getContextPath()+"/postList.do");
	}

}
