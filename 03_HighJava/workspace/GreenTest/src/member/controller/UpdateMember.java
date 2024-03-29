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


@WebServlet("/updateMember.do")
public class UpdateMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String mem_pass = request.getParameter("pass");	
		String mem_nickname = request.getParameter("nick");	
		String mem_mail = request.getParameter("mail");	
		String mem_tel = request.getParameter("phone");	

		
		MemberVO vo = new MemberVO();
		
		vo.setMem_pass(mem_pass);
		vo.setMem_nickname(mem_nickname);
		vo.setMem_mail(mem_mail);
		vo.setMem_tel(mem_tel);
		
		HttpSession session = request.getSession();
		
		MemberVO memberVo =  (MemberVO)session.getAttribute("login");
		
		String mem_id = memberVo.getMem_id();
		
		vo.setMem_id(mem_id);
		
		IMemberService service = MemberService.getInstance();
		
		int res = service.updateMemberOne(vo);
		
		String result = "";
		
		if(res>0) {
			result = "회원 정보를 수정하였습니다.";
		}else {
			result = "회원 정보 수정에 실패했습니다.";
		}
		
		Gson gson = new Gson();
		
		String json = gson.toJson(result);
		
		response.setCharacterEncoding("utf-8");
		
		response.setContentType("application/json; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.write(json);
		
		response.flushBuffer();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
