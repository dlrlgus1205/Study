package post.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.mybatis.config.StreamData;
import post.service.IPostService;
import post.service.PostServiceImpl;
import post.vo.PostVO;

/**
 * Servlet implementation class PostWrite
 */
@WebServlet("/postWrite.do")
public class PostWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//요청시 전송데이터 받기 - writer, subject, mail, password, content
		String reqdata = StreamData.dataChange(request);
		
		Gson gson = new Gson();
		PostVO vo = gson.fromJson(reqdata, PostVO.class); 
		
		//service 객체
		IPostService service = PostServiceImpl.getInstance();
		
		//메소드 호출
		int res = service.insertPost(vo);
		
		//request에 저장
		request.setAttribute("result", res);
		
		//view 페이지로 이동
		request.getRequestDispatcher("/view/result.jsp").forward(request, response);
	}

}
