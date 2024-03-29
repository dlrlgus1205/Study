package post.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import blacklist.vo.BlacklistVO;
import member.vo.MemberVO;
import post.service.IPostService;
import post.service.PostServiceImpl;
import post.vo.PostVO;


@WebServlet("/postList.do")
public class PostList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		
		MemberVO memberVo =  (MemberVO)session.getAttribute("login");
		
		String mem_id = "";
		BlacklistVO vo = new BlacklistVO();
		
		if(memberVo!=null) {
			mem_id = memberVo.getMem_id();
			
			//로그인 아이디 
			vo.setMem_id(mem_id);
		}
		
		IPostService service = PostServiceImpl.getInstance();
		List<PostVO> postList = service.getAllPost(vo);
		
		request.setAttribute("postList", postList);
		
		request.getRequestDispatcher("/view/post.jsp").forward(request, response);
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
}


