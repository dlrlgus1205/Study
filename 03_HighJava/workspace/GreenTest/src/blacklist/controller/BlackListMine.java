package blacklist.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import blacklist.service.BlacklistService;
import blacklist.service.IBlacklistService;
import blacklist.vo.BlacklistPageVO;
import blacklist.vo.BlacklistVO;
import member.vo.MemberVO;


@WebServlet("/blackListMine.do")
public class BlackListMine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		int currentPage = Integer.parseInt(request.getParameter("page"));
		
		HttpSession session = request.getSession();
		
		MemberVO memberVo =  (MemberVO)session.getAttribute("login");
		
		String mem_id = memberVo.getMem_id();
		
		IBlacklistService service = BlacklistService.getInstance();
		
		BlacklistPageVO vo =service.pageInfo(currentPage,mem_id);
		
		int totalPost = service.getTotalCount(mem_id);
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("start",vo.getStart());
		map.put("end",vo.getEnd());
		map.put("mem_id",mem_id);
		
		List<BlacklistVO> list = service.selctByPage(map);
		
		//결과값을 request에 저장
		request.setAttribute("list", list);
		request.setAttribute("start", vo.getStartPage());
		request.setAttribute("end", vo.getEndPage());
		request.setAttribute("total", vo.getTotalPage());
		request.setAttribute("totalPost", totalPost);
		
		
		
		//view페이지로 이동
		 request.getRequestDispatcher("/html/blacklistall.jsp").forward(request, response);
	}

}
