	package notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.service.INoticeService;
import notice.service.NoticeServiceImpl;
import notice.vo.NoticeVO;

/**
 * Servlet implementation class NoticeList
 */
@WebServlet("/noticeList.do")
public class NoticeList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
		
		INoticeService service = NoticeServiceImpl.getInstance();
		List<NoticeVO> noticeList = service.getAllNotice();
		System.out.print("noticeList ============>" + noticeList);
		
		request.setAttribute("noticeList", noticeList);
		System.out.print("noticeList ============>" + noticeList);
		
		
		request.getRequestDispatcher("/view/notice.jsp")
		.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
