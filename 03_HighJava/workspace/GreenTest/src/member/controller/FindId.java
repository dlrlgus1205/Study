package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import member.service.IMemberService;
import member.service.MemberService;
import member.vo.MemberVO;

/**
 * Servlet implementation class findId
 */
@WebServlet("/findId.do")
public class FindId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		

		String mem_name = request.getParameter("mem_name");		
		
		String mem_mail = request.getParameter("mem_mail");
		
		MemberVO vo = new MemberVO();
		
		vo.setMem_name(mem_name);
		
		vo.setMem_mail(mem_mail);
		
		IMemberService service = MemberService.getInstance();
		
		MemberVO memberVo = service.selectMemberFineId(vo);
			
		Gson gson = new Gson();
		
		String json = gson.toJson(memberVo);
		
		System.out.println(memberVo);
		
		response.setCharacterEncoding("utf-8");
		
		response.setContentType("application/json; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.write(json);
		
		response.flushBuffer();

	}

}