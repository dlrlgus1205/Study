package mypost.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import member.vo.MemberVO;
import mypost.service.IMyPostService;
import mypost.service.MyPostService;
import mypost.vo.MyPostPageVO;
import mypost.vo.MyPostVO;


@WebServlet("/myPost.do")
public class MyPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		
		int currentPage = Integer.parseInt(request.getParameter("page"));
		
		int category_no = Integer.parseInt(request.getParameter("category"));
		System.out.println("category_no : "+category_no);
		
		String stype = request.getParameter("stype");
		
		String sword = request.getParameter("sword");
		
		if("제목".equals(stype)) {
			stype="post_title";
		}else if("내용".equals(stype)) {
			stype="post_content";
		}else if("아이디".equals(stype)) {
			stype="mem_id";
		}else {
			stype="";
		}
		
		System.out.println("stype : " +stype);
		System.out.println("sword : " +sword);
		
		HttpSession session = request.getSession();
		
		MemberVO memberVo =  (MemberVO)session.getAttribute("login");
		
		String mem_id = memberVo.getMem_id();
		
		IMyPostService service = MyPostService.getInstance();
		
		MyPostPageVO pvo = service.pageInfo(currentPage, board_no, stype, sword, mem_id,category_no);
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("start",pvo.getStart());
		map.put("end",pvo.getEnd());
		map.put("stype",stype);
		map.put("sword",sword);
		map.put("mem_id",mem_id);
		map.put("board_no",board_no);
		map.put("category_no",category_no);
		
		List<MyPostVO> list = service.selctByPage(map);

		JsonObject obj = new JsonObject();
		obj.addProperty("sp", pvo.getStartPage());
		obj.addProperty("ep", pvo.getEndPage());
		obj.addProperty("tp", pvo.getTotalPage());
		obj.addProperty("totalPost", pvo.getTotalPost());

		Gson gson = new Gson();
		JsonElement jele = gson.toJsonTree(list);
		obj.add("datas", jele);
		
		response.setCharacterEncoding("utf-8");
		
		response.setContentType("application/json; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.print(obj);
		
		out.flush();
			    
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
