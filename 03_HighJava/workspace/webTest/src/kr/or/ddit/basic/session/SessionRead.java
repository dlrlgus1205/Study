package kr.or.ddit.basic.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionRead
 */
@WebServlet("/sessionRead.do")
public class SessionRead extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		// 저장된 Session 읽어오기

		// 1. Session 객체 구하기
		HttpSession session = request.getSession();
		
		out.println("<html>");
		out.println("<head><meta charset = 'utf-8'><title>Session 삭제 연습</title></head>");
		out.println("<body>");
		out.println("<h1>저장된 Session 값 확인하기</h1><hr>");
		out.println("<h2>세션 데이터 1개 확인하기</h2>");
		
		// 2. Session 객체의 getAttribute() 메서드를 이용하여 Session 값 구하기
		// 형식) Session객체.getAttribute("key값");
		//		==> 'key값'이 없으면 null을 반환한다.
		String sessionValue = (String) session.getAttribute("testSession");
		if(sessionValue != null) {
			out.println("testSession의 세션값 ==> " + sessionValue);
		}
		else {
			out.println("현재 세션에는 'testSession' key값이 없습니다 ...");
		}
		out.println("<br><hr><br>");
		out.println("<h3>전체 세션 데이터 확인하기</h3>");
		// Session에 저장된 모든 key값들 구하기
		Enumeration<String> sessionKey = session.getAttributeNames();
		
		// key값들의 개수가 저장될 변수
		int cnt = 0;
		
		out.println("<ul>");
		while(sessionKey.hasMoreElements()) {
			cnt++;
			// 1개의 key값 구하기
			String key = sessionKey.nextElement();
			String value = (String) session.getAttribute(key);
			
			out.println("<li>" + key + " : " + value + "</li>");
		}
		
		if(cnt == 0) {
			out.println("<li>Session에 저장된 데이터가 하나도 없습니다.</li>");
		}
		out.println("</ul>");
		
		out.println("<br><hr><br>");
		// 세션 ID ==> 세션을 구분하기 위한 고유한 값
		out.println("세션 ID : " + session.getId() + "<br>");
		
		// 생성 시간 ==> 1970년 1월1일부터 경과한 시간(밀리세컨드 단위)
		out.println("세션 생성 시간 : " + session.getCreationTime() + "<br>");
		// 가장 최근 접근 시간 ==> 1970년 1월1일부터 경과한 시간(밀리세컨드 단위)
		out.println("세션 최근 접근 시간 : " + session.getLastAccessedTime() + "<br>");
		
		// 세션 유효 시간 ==> (초 단위)
		// 유효시간 설정하는 메서드 => session.getMaxInactiveInterval(시간)
		out.println("세션 유효 시간 : " + session.getMaxInactiveInterval() + "<br>");
		out.println("<br><hr><br>");
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
