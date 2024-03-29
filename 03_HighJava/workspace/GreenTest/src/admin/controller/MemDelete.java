package admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.service.AdminServiceImpl;

@WebServlet("/memDelete.do")
public class MemDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		AdminServiceImpl service = AdminServiceImpl.getInstance();
		
		String memId = request.getParameter("mem_id");
		System.out.println("id값 : "+memId);
		int res = 0;
		
		res = service.memDelete(memId);
		
		PrintWriter out = response.getWriter();
		
		String jsonData = "{\"result\" : " + res+"}";
		
		out.write(jsonData);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
