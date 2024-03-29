package post.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import post.service.IPostService;
import post.service.PostServiceImpl;
import post.vo.PostVO;

@WebServlet("/wikiSearch.do")
public class WikiSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		IPostService service = PostServiceImpl.getInstance();
		Map<String,Object> list = new HashMap<String, Object>();
		List<PostVO> list2 = new ArrayList<PostVO>();
		
		
		int no = 1;
		String str = "식물";
		
		list.put("board_no", no);
		list.put("param", str);
		
		list2 = service.wikiSearch(list);
		
		request.setAttribute("list", list2);
		
		request.getRequestDispatcher("WEB-INF/view/wikiList.jsp").forward(request, response);
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
