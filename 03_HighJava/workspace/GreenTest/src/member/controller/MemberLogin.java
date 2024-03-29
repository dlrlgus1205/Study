package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import member.service.IMemberService;
import member.service.MemberService;
import member.vo.MemberVO;

/**
 * Servlet implementation class memberLogin
 */
@WebServlet("/memberLogin.do")
public class MemberLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String id= request.getParameter("id");
		String pass= request.getParameter("pass");
		String check = request.getParameter("check");
		
		MemberVO vo = new MemberVO();
		
		vo.setMem_id(id);
		vo.setMem_pass(pass);
		
		IMemberService service = MemberService.getInstance();
		
		MemberVO memVo = service.selectMemberLogin(vo);
		
		HttpSession session = request.getSession();
		
		if(memVo!=null) {
			//로그인 성공시 Session에 로그인 정보 저장하기
			session.setAttribute("login", memVo);
		}
		
		if("check".equals(check)) {
			Cookie cookie = new Cookie("id",id);
			response.addCookie(cookie);
		}else{
			Cookie[] cookieArr = request.getCookies();
			for(Cookie cookie : cookieArr) {
				String name = cookie.getName();
				if("id".equals(name)) {
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
		}
		
		
		
		Gson gson = new Gson();
		
		if("admin".equals(id) && "1234".equals(pass)) {
			memVo = new MemberVO();
			memVo.setMem_id("admin");
		}
		
		String json = gson.toJson(memVo);
		
		response.setCharacterEncoding("utf-8");
		
		response.setContentType("application/json; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.write(json);
		
		response.flushBuffer();
		

		
	}

}
