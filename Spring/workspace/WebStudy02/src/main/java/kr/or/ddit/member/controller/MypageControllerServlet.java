package kr.or.ddit.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet("/mypage")
public class MypageControllerServlet extends HttpServlet{
	private MemberService service = new MemberServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		if(session.isNew()) {
			resp.sendError(400, "현재 요청이 최초의 요청일 수 없음");
			return;
		}
		
		MemberVO member = (MemberVO) session.getAttribute("authMember");
		String viewName = null;
		
		if(member == null) {
			viewName = "redirect:/login/loginForm.jsp";
		}
		else {
			MemberVO mem = service.retrieveMember(member.getMemId());
			
			req.setAttribute("mem", mem);
			
			viewName = "/WEB-INF/views/member/mypage.jsp";
		}
		
		if(viewName.startsWith("redirect:")) {
			String location = viewName.replace("redirect:", req.getContextPath());
			resp.sendRedirect(location);
		}
		else {
			req.getRequestDispatcher(viewName).forward(req, resp);
		}
	}
}
