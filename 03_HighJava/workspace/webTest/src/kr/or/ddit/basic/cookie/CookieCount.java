package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieCount
 */
@WebServlet("/cookieCount.do")
public class CookieCount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Cookie[] cookieArr = request.getCookies();
		int cnt = 0;
		
		if(cookieArr != null) {
			for (Cookie cookie : cookieArr) {
				String name = cookie.getName();
				if(name.equals("count")) {
					cnt = Integer.parseInt(cookie.getValue());
				}
			}
		}
		cnt++;
		Cookie cntcookie = new Cookie("count", String.valueOf(cnt));
		response.addCookie(cntcookie);
		
		out.println("<html>");
		out.println("<head><meta charset = 'utf-8'><title>Cookie 증가 연습</title></head>");
		out.println("<body>");
		out.println("<h1>어서오세요 당신은" + cnt + "번째 방문입니다.</h1><br>");
		out.println("<a href='" + request.getContextPath() + "/cookieCount.do'>카운트 증가하기</a><br><br>");
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
