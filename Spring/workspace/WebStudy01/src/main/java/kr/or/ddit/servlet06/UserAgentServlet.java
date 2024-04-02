package kr.or.ddit.servlet06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/07/userAgent.do")
public class UserAgentServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String uA = req.getHeader("User-Agent");
		String accept = req.getHeader("accept");
		String contentType = null;
		String content = null;
	
		if(accept.contains("json")) {
			contentType = "application/json; charset=utf-8";
			content = "{\"result\":\"처리 성공\"}";
		}
		else {
			contentType = "text/html; charset=utf-8";
			if(uA.contains("Edg")) {
				content = "<html><body><h4>당신의 브라우저는 [엣지]입니다</h4></body></html>";
			}
			else if(uA.contains("Whale")) {
				content = "<html><body><h4>당신의 브라우저는 [웨일]입니다</h4></body></html>";
			}
			else if(uA.contains("Chrome")) {
				content = "<html><body><h4>당신의 브라우저는 [크롬]입니다</h4></body></html>";
			}
			else if(uA.contains("Safari")) {
				content = "<html><body><h4>당신의 브라우저는 [사파리]입니다</h4></body></html>";
			}
			else {
				content = "<html><body><h4>당신의 브라우저는 [기타]입니다</h4></body></html>";
			}
		}
		resp.setContentType(contentType);
		try(
			PrintWriter out = resp.getWriter();
		){
			out.print(content);
		}
	}
}
