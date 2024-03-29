package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import blacklist.service.BlacklistService;
import blacklist.service.IBlacklistService;
import blacklist.vo.BlacklistVO;
import member.service.IMemberService;
import member.service.MemberService;
import member.vo.MemberVO;

/**
 * Servlet implementation class MemberOut
 */
@WebServlet("/memberOut.do")
public class MemberOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String mem_pass = request.getParameter("mem_pass");	
		
		HttpSession session = request.getSession();
		
		MemberVO memberVo =  (MemberVO)session.getAttribute("login");
		
		String mem_id = memberVo.getMem_id();
		
		MemberVO vo = new MemberVO();
		
		vo.setMem_id(mem_id);
		vo.setMem_pass(mem_pass);
		
		IMemberService service = MemberService.getInstance();
		
		int res = service.updateMemberLeave(vo);
			
		if(res>0) {
			session.invalidate();
			response.sendRedirect(request.getContextPath()+"/html/main.jsp");
		}else {
			response.sendRedirect(request.getContextPath()+"/html/fail.jsp");
		}
		
		
	}

}
