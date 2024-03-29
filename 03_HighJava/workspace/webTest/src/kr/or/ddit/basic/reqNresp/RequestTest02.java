package kr.or.ddit.basic.reqNresp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestTest02
 */
@WebServlet("/requestTest02.do")
public class RequestTest02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
		int n1 = Integer.parseInt(request.getParameter("n1"));
		int n2 = Integer.parseInt(request.getParameter("n2"));
		String op = request.getParameter("oper");
		double res = 0;
		boolean calcOk = true;
		
		switch (op) {
			case "+":
				res = n1 + n2;
				break;
			case "-":
				res = n1 - n2;
				break;
			case "*":
				res = n1 * n2;
				break;
			case "/":
				if(n2 != 0) {
					res = n1 / (double)n2;
				}
				else {
					calcOk = false;
				}
				break;
			case "%":
				if(n2 != 0) {
					res = n1 % (double)n2;
				}
				else {
					calcOk = false;
				}
				break;
			default:
				break;
		}
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head><meta charset = 'utf-8'><title>계산기 연습</title></head>");
		out.println("<body>");
		out.println("<h1>계산 결과</h1>");
		out.println("<hr>");
//		out.println(n1 + op + n2 + " = " + res);
		out.print(n1 + op + n2 + " = ");
		if (calcOk == true) {
			out.println(res);
		}
		else {
			out.println("계산 불가 ~~~");
		}
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
