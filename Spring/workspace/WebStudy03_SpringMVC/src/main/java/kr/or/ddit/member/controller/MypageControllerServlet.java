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
import kr.or.ddit.mvc.ViewResolverComposite;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.MemberVOWrapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet("/mypage")
public class MypageControllerServlet extends HttpServlet{
	private MemberService service = new MemberServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberVOWrapper principal = (MemberVOWrapper) req.getUserPrincipal();
		String viewName = null;
		
		MemberVO mem = service.retrieveMember(principal.getName());
		req.setAttribute("mem", mem);
		
		viewName = "member/mypage";
		new ViewResolverComposite().resolveView(viewName, req, resp);
	}
}
