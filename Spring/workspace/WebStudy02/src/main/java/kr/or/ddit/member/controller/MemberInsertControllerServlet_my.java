package kr.or.ddit.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.exception.ResponseStatusException;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/member/memberInsert_my.do")
public class MemberInsertControllerServlet_my extends HttpServlet{
	MemberService service = new MemberServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberVO member = new MemberVO();
		
		String memId = (String)req.getParameter("memId");
		String memPass = (String)req.getParameter("memPass");
		String memName = (String)req.getParameter("memName");
		String memRegno1 = (String)req.getParameter("memRegno1");
		String memRegno2 = (String)req.getParameter("memRegno2");
		String memBir = (String)req.getParameter("memBir");
		String memZip = (String)req.getParameter("memZip");
		String memAdd1 = (String)req.getParameter("memAdd1");
		String memAdd2 = (String)req.getParameter("memAdd2");
		String memHometel = (String)req.getParameter("memHometel");
		String memComtel = (String)req.getParameter("memComtel");
		String memHp = (String)req.getParameter("memHp");
		String memMail = (String)req.getParameter("memMail");
		String memJob = (String)req.getParameter("memJob");
		String memLike = (String)req.getParameter("memLike");
		String memMemorial = (String)req.getParameter("memMemorial");
		String memMemorialday = (String)req.getParameter("memMemorialday");
		Long memMileage = Long.valueOf(req.getParameter("memMileage"));
		String memDelete = (String)req.getParameter("memDelete");
		
		if(service.createMember(member) == ServiceResult.PKDUPLICATED) {
			throw new ResponseStatusException(500, "아이디 중복");
		}
		else if(service.createMember(member) == ServiceResult.FAIL) {
			throw new ResponseStatusException(500, "값 확인 필요");
		}
		else if(service.createMember(member) == ServiceResult.OK) {
			member.setMemId(memId);
			member.setMemPass(memPass);
			member.setMemName(memName);
			member.setMemRegno1(memRegno1);
			member.setMemRegno2(memRegno2);
			member.setMemBir(memBir);
			member.setMemZip(memZip);
			member.setMemAdd1(memAdd1);
			member.setMemAdd2(memAdd2);
			member.setMemHometel(memHometel);
			member.setMemComtel(memComtel);
			member.setMemHp(memHp);
			member.setMemMail(memMail);
			member.setMemJob(memJob);
			member.setMemLike(memLike);
			member.setMemMemorial(memMemorial);
			member.setMemMemorialday(memMemorialday);
			member.setMemMileage(memMileage);
			member.setMemDelete(memDelete);
		}
		
		String path = "/WEB-INF/views/member/memberForm.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}
}
