package admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/memPage.do")
public class MemPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		int page = Integer.parseInt(request.getParameter("page"));
		System.out.println(page);
		String stype = request.getParameter("stype");
		System.out.println("stype : "+stype);
		String sword = request.getParameter("sword");
		System.out.println("sword : "+sword);
		
		if("전체".equals(stype)) {
			stype = "";
		}else if("이름".equals(stype)) {
			stype = "mem_name";
		}else if("아이디".equals(stype)) {
			stype = "mem_id";
		}else if("닉네임".equals(stype)) {
			stype = "mem_nickname";
		}
		
		AdminServiceImpl service = AdminServiceImpl.getInstance();

		List<MemberVO> list = new ArrayList();
		//페이지정보 구하기 전체글갯수, 총페이지수, 1~3글번호, 1~2페이지번호
		PageVo pvo = service.pageInfo(page,stype,sword);
		//start, end, startPage, endPage, totalPage
		
		//해당 페이지의 글 목록 가져오기
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("start", pvo.getStart());
		map.put("end", pvo.getEnd());
		map.put("stype", stype);
		map.put("sword", sword);
		
		//검색된 회원 리스트 가져오는 메소드
		list = service.memList(map);
		
		
		JsonObject obj = new JsonObject();
		obj.addProperty("sp", pvo.getStartPage());
		obj.addProperty("ep", pvo.getEndPage());
		obj.addProperty("tp", pvo.getTotalPage());
		
		Gson gson = new Gson();
//		String result = gson.toJson(list);
		JsonElement jele = gson.toJsonTree(list);
		obj.add("datas", jele);
		
		PrintWriter out = response.getWriter();
		out.print(obj);
		out.flush();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
