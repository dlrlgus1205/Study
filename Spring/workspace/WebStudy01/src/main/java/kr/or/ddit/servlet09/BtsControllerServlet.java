package kr.or.ddit.servlet09;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.exception.ResponseStatusException;

@WebServlet("/bts")
public class BtsControllerServlet extends HttpServlet{
	private ServletContext application;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		application = getServletContext();
		Map<String, String[]> btsMap = new LinkedHashMap<>();
		btsMap.put("B001", new String[] {"뷔", "bts/bui"});
		btsMap.put("B002", new String[] {"제이홉", "bts/jhop"});
		btsMap.put("B003", new String[] {"지민", "bts/jimin"});
		btsMap.put("B004", new String[] {"진", "bts/jin"});
		btsMap.put("B005", new String[] {"정국", "bts/jungkuk"});
		btsMap.put("B006", new String[] {"RM", "bts/rm"});
		btsMap.put("B007", new String[] {"슈가", "bts/suga"});
		application.setAttribute("btsMap", btsMap);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String viewName = "/WEB-INF/views/bts/btsForm.jsp";
		req.getRequestDispatcher(viewName).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, String[]> btsMap = (Map) application.getAttribute("btsMap");
//      디코딩설정
		req.setCharacterEncoding("UTF-8");
////      맴버 파라미터를 받기
//		try {
//			String member = Optional.ofNullable(req.getParameter("member")).filter(mp->!mp.isEmpty()).orElseThrow(()->new ResponseStatusException(400, "필수 파라미터 누락"));
//			if(!btsMap.containsKey(member)) {
////      파라미터 검증 누락: 400
//				throw new ResponseStatusException(400, String.format("%s 해당 멤버는 없음", member));
//			}
////      Map에 들어있는 데이터에서 entry에서 값을 가져와서[1]번째 content를 서비스
//			String value = null;
//			for(Entry<String, String[]> entry : btsMap.entrySet()){
//				if(member.equals(entry.getKey())) {
//					value = entry.getValue()[1];
//				}
//			}
//			String content = String.format("/WEB-INF/views/%s.jsp", value);
////      넘어갈 content의 mimetype을 설정
//			resp.setContentType("text/html");
//			req.setAttribute("content", content); 
////      base.jsp로 이동
//			String path = "/WEB-INF/views/bts/base.jsp";
//			req.getRequestDispatcher(path).forward(req, resp);
//		}
////      잘못 입력 되었을때의 경우 : 404
//		catch (ResponseStatusException e) {
//			resp.sendError(e.getStatus(), e.getMessage());
//		}
		String member = req.getParameter("member");
		int status = 200;
		if(StringUtils.isBlank(member)) {
			status = 400;
		}
		else if(!btsMap.containsKey(member)) {
			status = 404;
		}
		
		if(status == 200) {
			String[] btsData = btsMap.get(member);
			String path = btsData[1];
			String prefix = "/WEB-INF/views/";
			String suffix = ".jsp";
			
			req.setAttribute("content", prefix + path + suffix);
			req.getRequestDispatcher("/WEB-INF/views/bts/base.jsp").forward(req, resp);
		}
		else {
			resp.sendError(status);
		}
	}
}
