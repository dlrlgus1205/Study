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

@WebServlet("/wikiUpdate.do")
public class WikiUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int postno = Integer.parseInt(request.getParameter("post_no"));
		
		
		IPostService service = PostServiceImpl.getInstance();
		
		PostVO vo = service.wikiDetail(postno);
		
		
		request.setAttribute("PostVO", vo);
		request.getRequestDispatcher("/wiki/wikiUpdate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int post_no = Integer.parseInt(request.getParameter("post_no"));
		
		
		String title= request.getParameter("title");
		String content= request.getParameter("content");
		
		
		PostVO postVo = new PostVO();
		postVo.setPost_title(title);
		postVo.setPost_content(content);
		postVo.setPost_no(post_no);
		
		IPostService service = PostServiceImpl.getInstance();
		service.wikiUpdate(postVo);
		
		request.setAttribute("post_no", post_no);
		
		request.getRequestDispatcher("/wikiDetail.do").forward(request, response);
	}

}
