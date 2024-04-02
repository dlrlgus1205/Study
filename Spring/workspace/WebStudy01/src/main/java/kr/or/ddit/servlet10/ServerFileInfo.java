package kr.or.ddit.servlet10;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

//오른쪽 영역 라이트에어리어 접근
// 파일 li 태그 만 대상으로
// 클릭했을때 비동기 요청 /case2/fileInfo로 보낼겨
// param name is path
// 사이즈를 json 데이터로 서비스
// 파일 옆에 해당 파일의 사이즈 출력

@WebServlet("/case2/fileInfo")
public class ServerFileInfo extends HttpServlet{
	private ServletContext application;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		application = getServletContext();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getParameter("path");
		if(StringUtils.isBlank(path)) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		String realPath = application.getRealPath(path);
		File file = new File(realPath);
		if(!file.exists() || file.isDirectory()) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		long size = file.length();
		req.setAttribute("size", size);
		
		String viewName = "/jsonView.do";
		req.getRequestDispatcher(viewName).forward(req, resp);
	}
}