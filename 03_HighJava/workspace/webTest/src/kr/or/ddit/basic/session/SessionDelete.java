package kr.or.ddit.basic.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionDelete
 */
@WebServlet("/sessionDelete.do")
public class SessionDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		// Session 삭제하기
		
		// 1. Session 객체 구하기
		HttpSession session = request.getSession();
		
		// 2. Session 데이터 삭제하기
		
		// 1) 개별적인 Session값 삭제하기 ==> removeAttribute()메서드 이용
		// 형식) Session 객체.removeAttribute("삭제할 key값");
//		session.removeAttribute("testSession");
		
		// 2) Session 객체 자체 삭제하기 ==> invalidate() 메서드 이용
		
		out.println("<html>");
		out.println("<head><meta charset = 'utf-8'><title>Session 삭제 연습</title></head>");
		out.println("<body>");
		out.println("<h1>Session 데이터 삭제하기</h1><hr>");
		out.println("<br><br><br>");
		out.println("<a href='" + request.getContextPath() + "/basic/session/sessionTest01.jsp'>시작 문서로 이동하기</a>");
		
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
