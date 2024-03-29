package blacklist.controller;

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
import member.vo.MemberVO;

/**
 * Servlet implementation class BlackListCancel
 */
@WebServlet("/blackListCancel.do")
public class BlackListCancel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("blacklist_id");	
		
		BlacklistVO vo = new BlacklistVO();
		
		vo.setBlacklist_id(id);
		
		HttpSession session = request.getSession();
		
		MemberVO memberVo =  (MemberVO)session.getAttribute("login");
		
		String mem_id = memberVo.getMem_id();
		
		vo.setMem_id(mem_id);
		
		IBlacklistService service = BlacklistService.getInstance();
		
		int res = service.deleteBlacklist(vo);
		String result = "";
		
		if(res>0) {
			result = "차단 해제 되었습니다.";
		}else {
			result = "차단 해제에 실패했습니다.";
		}
		
		Gson gson = new Gson();
		
		String json = gson.toJson(result);
		
		response.setCharacterEncoding("utf-8");
		
		response.setContentType("application/json; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.write(json);
		
		response.flushBuffer();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
