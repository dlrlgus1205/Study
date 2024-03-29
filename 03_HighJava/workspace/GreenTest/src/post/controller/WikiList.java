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

@WebServlet("/wikiList.do")
public class WikiList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		List<PostVO> list = null;
		IPostService service = PostServiceImpl.getInstance();
		ImgServiceImpl service2 = ImgServiceImpl.getInstance();
		ImgVO vo = new ImgVO();
		
		//식물위키 카테고리 번호
		int no = 1;
		list = service.wikiListAll(no);
		
		//게시판 썸네일 가져오기 메소드
		vo = service2.imgSelect(no);
		
		request.setAttribute("list", list);
		request.setAttribute("ImgVO", vo);
		
		request.getRequestDispatcher("/wiki/wiki.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
