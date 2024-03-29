package notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.mybatis.config.StreamData;
import notice.service.INoticeService;
import notice.service.NoticeServiceImpl;
import notice.vo.NoticeVO;
import post.service.IPostService;
import post.service.PostServiceImpl;
import post.vo.PostVO;

/**
 * Servlet implementation class NoticeWrite
 */
@WebServlet("/noticeWrite.do")
public class NoticeWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	request.setCharacterEncoding("UTF-8");
		
		//요청시 전송데이터 받기 - writer, subject, mail, password, content
		String reqdata = StreamData.dataChange(request);
		
		Gson gson = new Gson();
		NoticeVO vo = gson.fromJson(reqdata, NoticeVO.class); 
		
		//service 객체
		INoticeService service = NoticeServiceImpl.getInstance();
		
		//메소드 호출
		int res = service.insertNotice(vo);
		
		//request에 저장
		request.setAttribute("result", res);
		
		//view 페이지로 이동
		request.getRequestDispatcher("/view/result.jsp").forward(request, response);
	
	}

}
