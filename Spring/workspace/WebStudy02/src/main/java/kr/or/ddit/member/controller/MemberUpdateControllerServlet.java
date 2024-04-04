package kr.or.ddit.member.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.mvc.ViewResolverComposite;
import kr.or.ddit.utils.ValidateUtils;
import kr.or.ddit.validate.groups.UpdateGroup;
import kr.or.ddit.vo.MemberVO;

/**
 * 1. 요청 접수, 분석
 * 2. 검증
 * 3. 로직 사용(model 확보)
 * 4. scope 를 이용해 model 공유
 * 5. view 결정
 * 6. view 로 이동(flow control)
 */

@WebServlet("/member/memberUpdate.do")
public class MemberUpdateControllerServlet extends HttpServlet{
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
			
			viewName = "/WEB-INF/views/member/memberForm.jsp";
		}
		if(viewName.startsWith("redirect:")) {
			String location = viewName.replace("redirect:", req.getContextPath());
			resp.sendRedirect(location);
		}
		else {
			req.getRequestDispatcher(viewName).forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		1. 요청 접수, 분석
		req.setCharacterEncoding("utf-8");
		MemberVO member = new MemberVO(); // command Object
		req.setAttribute("mem", member);
		Map<String, String[]> parameterMap = req.getParameterMap();
		
		try {
			BeanUtils.populate(member, parameterMap);
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException();
		}
		System.out.println(member);
//		2. 검증
		Map<String, List<String>> errors = new LinkedHashMap<>();
		req.setAttribute("errors", errors);
		// 콜 바이 레퍼런스
		boolean valid = ValidateUtils.validate(member, errors, UpdateGroup.class);
		String viewName = null;
		
		if(errors.isEmpty()) {
//		3. 로직 사용(model 확보)
			ServiceResult result = service.modifyMember(member);
			switch (result) {
			case INVALIDPASSWORD:
				req.setAttribute("message", "비밀번호 오류");
				viewName = "member/memberForm";
				break;
			case FAIL:
				req.setAttribute("message", "서버 오류");
				viewName = "member/memberForm";
				break;
			default:
				viewName = "redirect:/mypage";
				break;
			}
//		4. scope 를 이용해 model 공유
		}
		else {
			viewName = "member/memberForm";
		}
//		5. view 결정
//		6. view 로 이동(flow control)
		new ViewResolverComposite().resolveView(viewName, req, resp);
	}
}