package likes.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import likes.service.ILikesService;
import likes.service.LikesServiceImpl;
import member.vo.MemberVO;

@WebServlet("/wikiLike.do")
public class WikiLike extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		
		int postNo = Integer.parseInt(request.getParameter("post_no"));
		
		
		HttpSession session = request.getSession();
		
		MemberVO memberVo =  (MemberVO)session.getAttribute("login");
		
		String memId = memberVo.getMem_id();
		
		ILikesService service = LikesServiceImpl.getInstance();
		
		Map<String,Object> param = new HashMap();
		//좋아요 생성 메소드이전에 이미 존재하는지 확인
		param.put("post_no", postNo);
		param.put("mem_id", memId);
		int res = service.LikeSelect(param);
		
		PrintWriter out = response.getWriter();
		
		//0(존재하는 게시판 없음)이면 생성
		if(res == 0) {
			service.Likeinsert(param);
			String jsonData = "{\"result\" : " + res+"}";
			out.write(jsonData);
		}
		//1(이미 존재)이면 삭제
		if(res >= 1) {
			service.LikeDelete(param);
			String jsonData = "{\"result\" : " + res+"}";
			out.write(jsonData);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
