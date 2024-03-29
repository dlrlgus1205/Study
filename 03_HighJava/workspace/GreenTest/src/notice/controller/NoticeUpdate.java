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
import post.service.IPostService;
import post.service.PostServiceImpl;
import post.vo.PostVO;

/**
 * Servlet implementation class NoticeUpdate
 */
@WebServlet("/noticeUpdate.do")
public class NoticeUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
		
		String noticeno =request.getParameter("notice_no");
		
		INoticeService service = NoticeServiceImpl.getInstance();
		
		NoticeVO noticeVo = service.detailNotice(Integer.parseInt(noticeno));
		
		request.setAttribute("notice", noticeVo);
		request.getRequestDispatcher("/view/noticeUpdateForm.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int notice_no = Integer.parseInt(request.getParameter("notice_no"));
		
		String notice_title= request.getParameter("notice_title");
		String notice_content= request.getParameter("notice_content");
		
		NoticeVO noticeVo = new NoticeVO();
		noticeVo.setNotice_title(notice_title);
		noticeVo.setNotice_content(notice_content);
		noticeVo.setNotice_no(notice_no);
		
		INoticeService service = NoticeServiceImpl.getInstance();
		service.updateNotice(noticeVo);
		
		response.sendRedirect(request.getContextPath()+"/noticeList.do");
		}

	
	

}
