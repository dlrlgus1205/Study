package post.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import img.service.ImgServiceImpl;
import img.vo.ImgVO;
import post.service.IPostService;
import post.service.PostServiceImpl;
import post.vo.PostVO;

/**
 * Servlet implementation class StarList
 */
@WebServlet("/starList.do")
public class StarList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int boNo = Integer.parseInt(request.getParameter("bono"));
		
		IPostService service1 = PostServiceImpl.getInstance();
		ImgServiceImpl service2 = ImgServiceImpl.getInstance();
		
		List<PostVO> starList = service1.starListAll(boNo);
		ImgVO vo = new ImgVO();
		
		vo = service2.imgSelect(boNo);
		
		request.setAttribute("starList", starList);
		request.setAttribute("ImgVO", vo);
		
		request.getRequestDispatcher("/html/stargram.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
