package kr.or.ddit.servlet08;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.enumpkg.BrowserInfo;

@WebServlet("/calculate.do")
public class CalculateForm extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		
		// 파라미터 받아오기
		String leftOp = req.getParameter("leftOp");
		String rightOp = req.getParameter("rightOp");
		String operator = req.getParameter("operator");
		
		// 받아온 파라미터 형변환
		double lo = Double.parseDouble(leftOp);
		double ro = Double.parseDouble(rightOp);

		// 결과값 변수 선언 및 초기화
		double result = 0;
		
		// enum에서 사칙연산 받아오기
		Calculate calculate = Calculate.findOper(operator);
		
		// 결과값에 대입
		result = calculate.calc(lo, ro);
		
		// 출력할 문구 포맷으로 생성
		String message = String.format("%f %s %f = %f", lo, calculate.getSymbol(), ro, result);
		
		try(
				PrintWriter out = resp.getWriter();
			){
				out.print(message);
			}
		
//		req.getRequestDispatcher("/08/calculateForm.jsp").forward(req, resp);
	}
}
