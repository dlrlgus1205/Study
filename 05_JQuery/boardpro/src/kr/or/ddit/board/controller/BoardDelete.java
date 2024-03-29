package kr.or.ddit.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;

/**
 * Servlet implementation class BoardDelete
 */
@WebServlet("/boardDelete.do")
public class BoardDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전송 데이터 받기 - num
		int num = Integer.parseInt(request.getParameter("num"));
		
		// service 객체 얻기
		BoardServiceImpl service = BoardServiceImpl.getInstance();
		
		// service 메서드 호출 - int 결과
		int res = service.deleteBoard(num);
		
		// 결과를 저장
		request.setAttribute("result", res);
		
		// vieiw 페이지로 이동 -  result.jsp
		request.getRequestDispatcher("/boardview/result.jsp").forward(request, response);
	}

}
