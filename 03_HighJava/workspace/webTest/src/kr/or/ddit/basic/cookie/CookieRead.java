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
 * Servlet implementation class CookieRead
 */
@WebServlet("/cookieRead.do")
public class CookieRead extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		/*
			- 저장된 Cookie 정보 읽어오기
			1. 전체 쿠키 정보를 Request 객체를 통해서 가져온다.
				==> 가져온 쿠키 정보들은 배열에 저장돼 반환된다.
			형식) Cookie[] 쿠키배열변수 = request.getCookies();
		*/
		Cookie[] cookieArr = request.getCookies();
		
		out.println("<html>");
		out.println("<head><meta charset = 'utf-8'><title>Cookie 읽기 연습</title></head>");
		out.println("<body>");
		out.println("<h1>저장된 Cookie 데이터 확인하기</h1><br>");
		
		if(cookieArr == null || cookieArr.length == 0) {
			out.println("<h2>저장된 쿠키가 하나도 없습니다</h2>");
		}
		else {
			// 2. 쿠키 배열에서 해당 쿠키 정보를 구해온다.
			for (Cookie cookie : cookieArr) {
				// '쿠키이름' 구하기
				String name = cookie.getName();
				// '쿠키 값' 구하기
				// 쿠키값이 한글로 저장된 데이터는 URLDecoder.decode() 메서드로 디코딩해서 사용한다.
				String value = URLDecoder.decode(cookie.getValue(), "utf-8");
				
				out.println("쿠키이름 : " + name + "<br>");
				out.println("쿠키값 : " + value + "<hr>");
			}
		}
		
		out.println("<hr>");
		out.println("<a href='" + request.getContextPath() + "/basic/cookie/cookieTest01.jsp'>시작 문서로 이동하기</a>");
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