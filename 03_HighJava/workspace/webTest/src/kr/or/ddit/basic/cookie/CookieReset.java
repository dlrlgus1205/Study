package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieReset
 */
@WebServlet("/cookieReset.do")
public class CookieReset extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Cookie[] cookieArr = request.getCookies();
		
		if(cookieArr != null) {
			for (Cookie cookie : cookieArr) {
				String name = cookie.getName();
				if("count".equals(name)) {
					cookie.setMaxAge(0);
					
					response.addCookie(cookie);
				}
			}
		}
		
		out.println("<html>");
		out.println("<head><meta charset = 'utf-8'><title>Cookie 삭제 연습</title></head>");
		out.println("<body>");
		out.println("<h1>Count가 초기화 됐습니다</h1><br>");
		out.println("<hr>");
		out.println("<a href='" + request.getContextPath() + "/basic/cookie/cookieTest02.jsp'>시작 문서로 이동하기</a>");
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
