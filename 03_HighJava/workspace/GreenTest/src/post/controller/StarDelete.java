package post.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import post.service.IPostService;
import post.service.PostServiceImpl;
import post.vo.PostVO;

/**
 * Servlet implementation class StarDelete
 */
@WebServlet("/starDelete.do")
public class StarDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int no = Integer.parseInt(request.getParameter("post_no"));
		
		//예시 회원 아이디
		String name = "test";
		
		IPostService service = PostServiceImpl.getInstance();
		
		PostVO vo = new PostVO();
		
		vo.setMem_id(name);
		vo.setPost_no(no);
		
		int res = service.wikiDelete(vo);
		
	
		//ajax에 반환값을 주기 위한 메소드
		String jsonData = "{\"result\" : " + res+"}";
		
		response.setCharacterEncoding("utf-8");
		
		response.setContentType("application/json; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.write(jsonData);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
