package notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.service.INoticeService;
import notice.service.NoticeServiceImpl;
import notice.vo.NoticeVO;

/**
 * Servlet implementation class NoticeDetail
 */
@WebServlet("/noticeDetail.do")
public class NoticeDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
		int num = Integer.parseInt(request.getParameter("no"));
		System.out.println("noticeDetailnum=====================>>" +num);
		
		
		INoticeService service = NoticeServiceImpl.getInstance();
		
		
		NoticeVO vo = service.detailNotice(num);
		System.out.println("vo 값===================>" + vo);
		request.setAttribute("notice", vo);
		
		request.getRequestDispatcher("/view/noticedetail.jsp")
		.forward(request, response);
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
