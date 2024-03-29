package kr.or.ddit.sessionlogin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.sessionlogin.service.IMemberService;
import kr.or.ddit.sessionlogin.service.MemberServiceImpl;
import kr.or.ddit.sessionlogin.vo.MemberVo;

/**
 * Servlet implementation class SessionDBLogin
 */
@WebServlet("/sessionDBLogin.do")
public class SessionDBLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// id와 패스워드 구하기
		String userId = request.getParameter("userid");
		String userPass = request.getParameter("userpass");
		
		// id와 패스워드를 MemberVo객체에 저장한다.
		MemberVo paramMemVo = new MemberVo();
		paramMemVo.setMem_id(userId);
		paramMemVo.setMem_pass(userPass);
		
		// Service 객체를 생성한 후 Login 처리를 하는 메서드를 호출하여 반환값을 받아온다.
		IMemberService service = MemberServiceImpl.getInstance();
		MemberVo memVo = service.getLoginMember(paramMemVo);
		
		HttpSession session = request.getSession();
		
		// 로그인 성공 여부를 검사한다.
		if(memVo != null) {
			// 로그인 성공 시 Session에 로그인 정보 저장하기
			session.setAttribute("LoginMember", memVo);
		}
		response.sendRedirect(request.getContextPath() + "/basic/sessionDB/sessionDBLogin.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
