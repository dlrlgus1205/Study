package kr.or.ddit.member.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.mvc.ViewResolverComposite;
import kr.or.ddit.vo.MemberVO;

/**
 * 1. 요청 접수, 분석
 * 2. 검증
 * 3. 로직 사용(model 확보)
 * 4. scope 를 이용해 model 공유
 * 5. view 결정
 * 6. view 로 이동(flow control)
 */

@WebServlet("/member/memberUpdate_my.do")
public class MemberUpdateControllerServlet_my extends HttpServlet{
	private MemberService service = new MemberServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String memId = req.getParameter("who");
		MemberVO mem = service.retrieveMember(memId);
		req.setAttribute("mem", mem);
		
		String viewName = "member/memberUpdate";

		new ViewResolverComposite().resolveView(viewName, req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		1. 요청 접수, 분석
		req.setCharacterEncoding("utf-8");
		String viewName = null;
		MemberVO member = new MemberVO();
		req.setAttribute("mem", member);
		
		Map<String, String[]> parameterMap = req.getParameterMap();
		
		try {
			BeanUtils.populate(member, parameterMap);
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException();
		}
		
		if(member == null) {
			resp.sendError(500);
		}
		else {
			ServiceResult result = service.modifyMember(member);
			if(result == ServiceResult.FAIL) {
				req.setAttribute("message", "서버 오류");
				viewName = "/WEB-INF/views/member/memberUpdate.jsp";
			}
			else {
				req.getSession().setAttribute("lastCreated", member);
				viewName = "redirect:/member/memberList.do";
			}
		}
		
		new ViewResolverComposite().resolveView(viewName, req, resp);
	}
}
