package post.controller;

import java.io.IOException;

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

@WebServlet("/wikiDetail.do")
public class WikiDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		PostVO list = new PostVO();
		IPostService service1 = PostServiceImpl.getInstance();
		ImgServiceImpl service2 = ImgServiceImpl.getInstance();
		int no = Integer.parseInt(request.getParameter("post_no"));
		ImgVO vo = new ImgVO();
		//조회수 증가 메소드
		service1.wikiCount(no);
		
		//게시판 정보 가져오기 메소드
		list = service1.wikiDetail(no);
		
		//게시판 썸네일 가져오기 메소드
		vo = service2.imgSelect(no);
		
		//게시판 정보 보내기
		request.setAttribute("list", list);
		request.setAttribute("ImgVO", vo);
		
		request.getRequestDispatcher("/wiki/wikiDetail2.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
