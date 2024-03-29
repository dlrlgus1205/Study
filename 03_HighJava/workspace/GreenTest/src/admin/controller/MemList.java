package admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import admin.service.AdminServiceImpl;
import admin.vo.PageVo;
import member.vo.MemberVO;

@WebServlet("/memList.do")
public class MemList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		AdminServiceImpl service = AdminServiceImpl.getInstance();
		
		int res = 0;
		
		//회원 총원 구하기
		res = service.memCount();
		
		//회원 총 인원 보내기
		request.setAttribute("memCount", res);
		request.getRequestDispatcher("/admin/memList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
