package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.IMemberService;
import member.service.MemberService;
import member.vo.MemberVO;
import user.service.IUserService;
import user.service.UserService;
import user.vo.UserVO;


@WebServlet("/memberSignup.do")
public class MemberSignup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String nick = request.getParameter("nick");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String birth = request.getParameter("birth");
		
		MemberVO vo = new MemberVO();
		
		vo.setMem_id(id);
		vo.setMem_pass(pass);
		vo.setMem_name(name);
		vo.setMem_nickname(nick);
		vo.setMem_mail(email);
		vo.setMem_tel(phone);
		vo.setMem_bir(birth);

		IMemberService service = MemberService.getInstance();
		
		int res = service.insertMember(vo);
		
		if(res>0) {
			UserVO userVo = new UserVO();
			userVo.setMem_id(id);
			IUserService service2 = UserService.getInstance();
			service2.insertUser(userVo);
			
			response.sendRedirect(request.getContextPath()+"/html/singUpok.jsp");
		}else {
			response.sendRedirect(request.getContextPath()+"/html/fail.jsp");
		}
		
	}

}
