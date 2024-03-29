package kr.or.ddit.basic.reqNresp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForwardMain
 */
@WebServlet("/forwardMain.do")
public class ForwardMain extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/*
		- forward 방식
			1) 특정 서블릿이나 JSP에 대한 요청을 다른 서블릿이나 JSP로 넘겨준다.
			(이 때 HttpServletRequest 객체와 HttpServletResponse 객체를 공유하기 때문에 파라미터를 넘길 수 있다.)
			
			2) URL 주소는 처음 요청할 때의 주소가 바뀌지 않는다.
			
			3) 서버 내부에서만 접근이 가능하다.
			
		- 데이터를 전달하는 방법
			이동되는 페이지로 데이터를 넘기려면 Request 객체의 setAttribute() 메서드를 이용하여
			데이터를 저장하여 보내고, 받는 쪽에서는 getAttribute() 메서드를 이용하여 데이터를 읽어온다.
			
		저장 형식) Request객체.setAttribute("key값", 저장할 데이터); 
		읽기 형식) Request객체.getAttribute("key값");
	*/	
		request.setAttribute("tel", "010-1111-111");
		
		// forward 방식으로 이동하기
		// 1) Request 객체의 getRequestDispatcher() 메서드에 이동할 서블릿이나 JSP를 지정해준다.
		// (이 때의 경로는 전체 URI 경로 중 ContextPath 이후의 경로를 지정해준다.)
		// 예) 이동할 전체 경로가 '/webTest/forwardTarget.do' 인 경우에는 '/forwardTarget.do/' 를 경로로 지정해준다.
		RequestDispatcher rd = request.getRequestDispatcher("/forwardTarget.do");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
