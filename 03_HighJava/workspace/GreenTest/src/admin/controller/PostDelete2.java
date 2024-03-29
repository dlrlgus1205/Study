package admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.service.AdminServiceImpl;

@WebServlet("/postDelete2.do")
public class PostDelete2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		AdminServiceImpl service = AdminServiceImpl.getInstance();
		
		String postNo = request.getParameter("post_no");
		System.out.println("post값 : "+postNo);
		int res = 0;
		
		res = service.postDelete(postNo);
		
		PrintWriter out = response.getWriter();
		
		String jsonData = "{\"result\" : " + res+"}";
		
		out.write(jsonData);
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
